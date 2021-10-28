package br.com.estudo.api.cinema.estudo.validation.security;

import br.com.estudo.api.cinema.estudo.entity.UsuarioEntity;
import br.com.estudo.api.cinema.estudo.repository.UsuarioRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${cinema.jwt.expiration}")
    private String expiration;

    @Value("${cinema.jwt.secret}")
    private String secret;

    private UsuarioRepository usuarioRepository;

    public String gerarToken(Authentication authentication){
        UsuarioEntity logado = (UsuarioEntity) authentication.getPrincipal();
        Date hoje = new Date();
        Date expirationDate = new Date(hoje.getTime()+ Long.parseLong(expiration));

        return Jwts.builder()
                .setIssuer("API GERENCIAMENTO DE CINEMA")
                .setSubject(logado.getId().toString())
                .setIssuedAt(hoje)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();

    }

    public boolean isTokenValido(String token) {
        try{
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public Long getIdUsuario(String token) {
        var claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }
}
