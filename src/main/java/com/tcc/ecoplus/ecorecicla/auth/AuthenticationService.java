package com.tcc.ecoplus.ecorecicla.auth;


import com.tcc.ecoplus.ecorecicla.config.JwtService;
import com.tcc.ecoplus.ecorecicla.exceptions.BadRequest;
import com.tcc.ecoplus.ecorecicla.model.entity.Usuario;
import com.tcc.ecoplus.ecorecicla.model.repository.UsuarioRepository;
import com.tcc.ecoplus.ecorecicla.model.token.Token;
import com.tcc.ecoplus.ecorecicla.model.token.TokenRepository;
import com.tcc.ecoplus.ecorecicla.model.token.TokenType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UsuarioRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UsuarioRepository repository, TokenRepository tokenRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.tokenRepository = tokenRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(RegisterRequest request) {
        String nomeClasse = String.valueOf(request.getRole());


        char primeiroCharMaisculo = Character.toUpperCase(nomeClasse.charAt(0));
        nomeClasse = nomeClasse.substring(1);
        nomeClasse = primeiroCharMaisculo + nomeClasse;



        try{
         Class<?> clazz = Class.forName( "com.tcc.ecoplus.ecorecicla.model.entity." + nomeClasse);
         Usuario usuario = (Usuario) clazz.newInstance();
         usuario.setCodStatus(true);
            usuario.setNome(request.getNome());
            usuario.setEmail(request.getEmail());
            usuario.setPassword(passwordEncoder.encode(request.getPassword()));
            usuario.setRole(request.getRole());
            var usuarioDb = repository.findByEmail(request.getEmail());
            if (usuarioDb.isPresent()) {
                throw new BadRequest("Ja existe esse email cadastrado em nosso bano de dados");
            }
         var savedUser = repository.save(usuario);
         var jwtToken = jwtService.generateToken(usuario);
         var refreshToken = jwtService.generateRefreshToken(usuario);
        savedUserToken(savedUser, jwtToken);
        return new AuthenticationResponse(jwtToken, refreshToken);

        }catch (ClassNotFoundException | InstantiationException | IllegalAccessException e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());

        }


    }

    private void savedUserToken(Usuario usuario, String jwtToken) {
        var token = new Token();
        token.setUsuario(usuario);
        token.setToken(jwtToken);
        token.setTokenType(TokenType.BEARER);
        token.setExpired(false);
        token.setRevoked(false);
        tokenRepository.save(token);
    }

}
