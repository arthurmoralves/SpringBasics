package br.com.estudo.api.cinema.estudo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

import br.com.estudo.api.cinema.estudo.entity.ClienteEntity;
import br.com.estudo.api.cinema.estudo.mapper.ClienteMapper;
import br.com.estudo.api.cinema.estudo.repository.ClienteRepository;
import br.com.estudo.api.cinema.estudo.util.CinemaFactoryTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class ClienteServiceTest {

    @InjectMocks
    ClienteService clienteService;

    @Mock
    ClienteMapper clienteMapper;

    @Mock
    ClienteRepository clienteRepository;

    CinemaFactoryTest cinemaFactoryTest = new CinemaFactoryTest();

    @Test
    public void testeCadastroDeveRetornarUsuarioCadastradoComSucesso(){
        var cliente = cinemaFactoryTest.mockClienteDto();
        var clienteEntity = cinemaFactoryTest.mockClienteEntity();

        when(clienteMapper.unmarshall(cliente)).thenReturn(clienteEntity);
        when(clienteRepository.save(any(ClienteEntity.class))).thenReturn(clienteEntity);
        when(clienteMapper.marshall(clienteEntity)).thenReturn(cliente);

        var clienteReturn = clienteService.cadastrar(cliente);

        assertEquals(clienteReturn, cliente);
    }

}
