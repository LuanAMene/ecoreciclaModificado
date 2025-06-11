package com.tcc.ecoplus.ecorecicla.auth;

import com.tcc.ecoplus.ecorecicla.config.JwtService;
import com.tcc.ecoplus.ecorecicla.exceptions.BadRequest;
import com.tcc.ecoplus.ecorecicla.exceptions.Unauthorized;
import com.tcc.ecoplus.ecorecicla.model.entity.Usuario;
import com.tcc.ecoplus.ecorecicla.model.repository.UsuarioRepository;
import com.tcc.ecoplus.ecorecicla.model.services.UsuarioService;
import com.tcc.ecoplus.ecorecicla.model.token.Token;
import com.tcc.ecoplus.ecorecicla.model.token.TokenRepository;
import com.tcc.ecoplus.ecorecicla.model.token.TokenType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UsuarioRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UsuarioService usuarioService;

    public AuthenticationService(UsuarioRepository repository, TokenRepository tokenRepository,
                                 PasswordEncoder passwordEncoder, JwtService jwtService,
                                 AuthenticationManager authenticationManager, UsuarioService usuarioService) {
        this.repository = repository;
        this.tokenRepository = tokenRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.usuarioService = usuarioService;
    }

    public AuthenticationResponse register(RegisterRequest request) {
        String nomeClasse = String.valueOf(request.getRole()).toLowerCase();

        if ("representantedestinadora".equals(nomeClasse)) {
            nomeClasse = "RepresentanteDestinadora";
        } else if ("representantecoletora".equals(nomeClasse)) {
            nomeClasse = "RepresentanteColetora";
        } else {
            nomeClasse = Character.toUpperCase(nomeClasse.charAt(0)) + nomeClasse.substring(1);
        }

        System.out.println(nomeClasse);

        try {
            Class<?> clazz = Class.forName("com.tcc.ecoplus.ecorecicla.model.entity." + nomeClasse);
            Usuario usuario = (Usuario) clazz.getDeclaredConstructor().newInstance();
            usuario.setCodStatus(true);
            usuario.setNome(request.getNome());
            usuario.setEmail(request.getEmail());
            usuario.setPassword(passwordEncoder.encode(request.getPassword()));
            usuario.setRole(request.getRole());

            var usuarioDb = repository.findByEmail(request.getEmail());
            if (usuarioDb.isPresent()) {
                throw new BadRequest("Já existe esse email cadastrado em nosso banco de dados.");
            }

            var savedUser = repository.save(usuario);
            var jwtToken = jwtService.generateToken(usuario);
            var refreshToken = jwtService.generateRefreshToken(usuario);
            saveUserToken(savedUser, jwtToken);

            return new AuthenticationResponse(jwtToken, refreshToken);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | java.lang.reflect.InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    private void saveUserToken(Usuario usuario, String jwtToken) {
        Token token = new Token();
        token.setUsuario(usuario);
        token.setToken(jwtToken);
        token.setTokenType(TokenType.BEARER);
        token.setExpired(false);
        token.setRevoked(false);
        tokenRepository.save(token);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );
        } catch (Exception e) {
            throw new BadRequest("Email ou senha incorretos.");
        }

        var usuario = usuarioService.findByEmail(request.getEmail());
        if (!usuario.isCodStatus()) {
            throw new Unauthorized("Conta inativa. Por favor, entre em contato com o administrador da conta.");
        }

        var jwtToken = jwtService.generateToken(usuario);
        var refreshToken = jwtService.generateRefreshToken(usuario);
        saveUserToken(usuario, jwtToken);

        return new AuthenticationResponse(jwtToken, refreshToken);
    }
}
