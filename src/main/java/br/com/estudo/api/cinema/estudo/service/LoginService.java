package br.com.estudo.api.cinema.estudo.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean validaLogin(String username, String password) {
        if(username.equals("root") && password.equals("root")){
            return true;
        } else {
            return false;
        }
    }
}
