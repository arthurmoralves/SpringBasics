package br.com.estudo.api.cinema.estudo.service;

import br.com.estudo.api.cinema.estudo.dto.UsuarioDto;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean validaLogin(UsuarioDto usuarioDto) {
        return (usuarioDto.getUsername().equals("root") && usuarioDto.getPassword().equals("root") ? true : false);
    }
}
