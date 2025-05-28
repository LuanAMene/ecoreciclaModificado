package com.tcc.ecoplus.ecorecicla.auth;


import com.tcc.ecoplus.ecorecicla.config.JwtService;
import com.tcc.ecoplus.ecorecicla.exceptions.BadRequest;
import com.tcc.ecoplus.ecorecicla.model.entity.Usuario;
import com.tcc.ecoplus.ecorecicla.model.repository.UsuarioRepository;
import com.tcc.ecoplus.ecorecicla.model.token.TokenRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UsuarioRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthenticationService(UsuarioRepository repository, TokenRepository tokenRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationService authenticationService) {
        this.repository = repository;
        this.tokenRepository = tokenRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    public AuthenticationResponse register(RegisterRequest request) {
        String nomeClasse = String.valueOf(request.getNome());


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

        }catch (ClassNotFoundException | InstantiationException | IllegalAccessException e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());

        }



        return null;
    }

}
