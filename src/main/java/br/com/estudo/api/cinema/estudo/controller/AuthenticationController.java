package br.com.estudo.api.cinema.estudo.controller;

import br.com.estudo.api.cinema.estudo.dto.TokenDto;
import br.com.estudo.api.cinema.estudo.dto.UsuarioDto;
import br.com.estudo.api.cinema.estudo.validation.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenDto> autenticar(@RequestBody UsuarioDto usuarioDto){
        UsernamePasswordAuthenticationToken dadosLogin = usuarioDto.converter();
        try{
            var auth = authManager.authenticate(dadosLogin);
            var token = tokenService.gerarToken(auth);
            return ResponseEntity.ok(new TokenDto(token, "Bearer"));
        } catch (AuthenticationException e){
            return ResponseEntity.badRequest().build();
        }
    }
}
