package br.com.estudo.api.cinema.estudo.validation.security;

import br.com.estudo.api.cinema.estudo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var usuario = usuarioRepository.findByUsername(email);
        if(usuario.isPresent()){
            return usuario.get();
        } else {
            throw new UsernameNotFoundException("Dados inválidos");
        }
    }
}
