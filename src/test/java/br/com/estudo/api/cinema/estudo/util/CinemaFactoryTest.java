package br.com.estudo.api.cinema.estudo.util;

import br.com.estudo.api.cinema.estudo.dto.ClienteDto;
import br.com.estudo.api.cinema.estudo.dto.UsuarioDto;
import br.com.estudo.api.cinema.estudo.entity.ClienteEntity;
import br.com.estudo.api.cinema.estudo.mapper.ClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class CinemaFactoryTest {

    @Autowired
    ClienteMapper clienteMapper;

    public UsuarioDto mockUsuarioDto(){
        return UsuarioDto.builder()
                .username("teste")
                .password("teste123")
                .build();
    }

    public UsernamePasswordAuthenticationToken mockUserAuthToken(){
        var user = mockUsuarioDto();
        return user.converter();
    }

    public ClienteDto mockClienteDto(){
        return ClienteDto.builder()
                .CPF("72766120661")
                .dataNasc("08/10/1997")
                .nome("Jurandir Filho")
                .build();
    }

    public ClienteEntity mockClienteEntity() {
        return ClienteEntity.builder()
                .CPF("72766120661")
                .dataNasc("08/10/1997")
                .nome("Jurandir Filho")
                .build();
    }
}
