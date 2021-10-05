package br.com.estudo.api.cinema.estudo.service;

import br.com.estudo.api.cinema.estudo.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean validaLogin(UserDto userDto) {
        return (userDto.getUsername().equals("root") && userDto.getPassword().equals("root") ? true : false);
    }
}
