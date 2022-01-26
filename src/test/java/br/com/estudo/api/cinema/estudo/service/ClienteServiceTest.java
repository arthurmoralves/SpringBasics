package br.com.estudo.api.cinema.estudo.service;

import br.com.estudo.api.cinema.estudo.mapper.ClienteMapper;
import br.com.estudo.api.cinema.estudo.repository.ClienteRepository;
import br.com.estudo.api.cinema.estudo.util.CinemaTestClassBuilder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.verify;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;

    @Spy
    private ClienteMapper clienteMapper;

    @Mock
    private ClienteRepository clienteRepository;

    private CinemaTestClassBuilder cinemaTestClassBuilder = new CinemaTestClassBuilder();

    @Test
    public void testeCadastroDeveRetornarUsuarioCadastradoComSucesso() {
        var cliente = cinemaTestClassBuilder.mockClienteDto();
        var clienteEntity = cinemaTestClassBuilder.mockClienteEntity();

        when(clienteMapper.unmarshall(cliente)).thenReturn(clienteEntity);
        when(clienteRepository.save(clienteEntity)).thenReturn(clienteEntity);
        when(clienteMapper.marshall(clienteEntity)).thenReturn(cliente);

        var clienteReturn = clienteService.cadastrar(cliente);

        verify(clienteMapper).unmarshall(cliente);
        verify(clienteRepository).save(clienteEntity);
        verify(clienteMapper).marshall(clienteEntity);

        Assertions.assertThat(clienteReturn).isEqualTo(cliente);
    }
}
