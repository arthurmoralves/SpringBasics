package br.com.estudo.api.cinema.estudo.service;

import br.com.estudo.api.cinema.estudo.model.User;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean validaLogin(User user) {
        if(user.getUsername().equals("root") && user.getPassword().equals("root")){
            return true;
        } else {
            return false;
        }
    }
}
