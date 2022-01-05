package br.com.estudo.api.cinema.estudo.util;

import br.com.estudo.api.cinema.estudo.dto.*;
import br.com.estudo.api.cinema.estudo.entity.ClienteEntity;
import br.com.estudo.api.cinema.estudo.entity.SalaEntity;
import br.com.estudo.api.cinema.estudo.entity.SessaoEntity;
//import br.com.estudo.api.cinema.estudo.entity.;
import br.com.estudo.api.cinema.estudo.mapper.ClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.math.BigDecimal;

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

    public SalaEntity mockSalaEntity(){
        return SalaEntity.builder()
                .capacidade(250)
                .id(1L)
                .build();
    }

    public SalaDto mockSalaDto(){
        return SalaDto.builder()
                .capacidade(250)
                .id(1L)
                .build();
    }

    public SessaoDto mockSessaoDto(){
        return SessaoDto.builder()
                .titulo("TRES PORQUINHOS")
                .valor(new BigDecimal((25.00)))
                .build();
    }

    public SessaoEntity mockSessaoEntity(){
        return SessaoEntity.builder()
                .titulo("TRES PORQUINHOS")
                .valor(new BigDecimal((25.00)))
                .build();
    }

//    public VendaEntity mockVendaEntity(){
//
//        return VendaEntity.builder()
//                .cliente(mockClienteEntity())
//                .id(1L)
//                .sala(mockSalaEntity())
//                .sessao(mockSessaoEntity())
//                .build();
//    }
//
//    public VendaDto mockVendaDto(){
//
//        var clienteDto = mockClienteDto();
//        var salaDto = mockSalaDto();
//        var sessaoDto = mockSessaoDto();
//
//        return VendaDto.builder()
//                .cliente(clienteDto.getNome())
//                .sala(salaDto.getId())
//                .titulo(sessaoDto.getTitulo())
//                .build();
//    }
}
