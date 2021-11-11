package br.com.estudo.api.cinema.estudo.service;

import br.com.estudo.api.cinema.estudo.entity.ClienteEntity;
import br.com.estudo.api.cinema.estudo.mapper.ClienteMapper;
import br.com.estudo.api.cinema.estudo.repository.ClienteRepository;
import br.com.estudo.api.cinema.estudo.util.CinemaFactoryTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class ClienteServiceTest {

    @InjectMocks
    ClienteService clienteService;

    @Spy
    ClienteMapper clienteMapper;

    @Mock
    ClienteRepository clienteRepository;

    CinemaFactoryTest cinemaFactoryTest = new CinemaFactoryTest();

    @Test
    public void testeCadastroDeveRetornarUsuarioCadastradoComSucesso(){
        var cliente = cinemaFactoryTest.mockClienteDto();
        var clienteEntity = cinemaFactoryTest.mockClienteEntity();

        when(clienteRepository.save(any(ClienteEntity.class))).thenReturn(clienteEntity);

        var clienteReturn = clienteService.cadastrar(cliente);

        assertEquals(clienteReturn, cliente);
    }
}
