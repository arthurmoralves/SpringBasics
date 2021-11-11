package br.com.estudo.api.cinema.estudo.service;

import br.com.estudo.api.cinema.estudo.dto.VendaDto;
import br.com.estudo.api.cinema.estudo.entity.VendaEntity;
import br.com.estudo.api.cinema.estudo.mapper.VendaMapper;
import br.com.estudo.api.cinema.estudo.repository.ClienteRepository;
import br.com.estudo.api.cinema.estudo.repository.SalaRepository;
import br.com.estudo.api.cinema.estudo.repository.SessaoRepository;
import br.com.estudo.api.cinema.estudo.repository.VendaRepository;
import br.com.estudo.api.cinema.estudo.util.CinemaFactoryTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class VendaServiceTest {

    @InjectMocks
    VendaService vendaService;

    @Mock
    VendaRepository vendaRepository;

    @Mock
    SalaRepository salaRepository;

    @Mock
    ClienteRepository clienteRepository;

    @Mock
    SessaoRepository sessaoRepository;

    CinemaFactoryTest cinemaFactoryTest = new CinemaFactoryTest();

    @Test
    public void DeveTestarConsultarVenda(){
        var vendaDto = cinemaFactoryTest.mockVendaDto();
        var vendaEntity = cinemaFactoryTest.mockVendaEntity();

        List<VendaDto> listVendaDto = new ArrayList<>();
        listVendaDto.add(vendaDto);

        List<VendaEntity> listVendaEntity = new ArrayList<>();
        listVendaEntity.add(vendaEntity);

        when(vendaRepository.findAll()).thenReturn(listVendaEntity);

        var vendasReturn = vendaService.consultarVendas();

        assertEquals(vendasReturn, listVendaDto);
    }

    @Test
    public void DeveCadastrarVendaComSucesso(){
        var salaEntity = cinemaFactoryTest.mockSalaEntity();
        var clienteEntity = cinemaFactoryTest.mockClienteEntity();
        var sessaoEntity = cinemaFactoryTest.mockSessaoEntity();
        var vendaEntity = cinemaFactoryTest.mockVendaEntity();
        var vendaDto = cinemaFactoryTest.mockVendaDto();

        when(salaRepository.findById(anyLong())).thenReturn(Optional.of(salaEntity));
        when(clienteRepository.findByNome(anyString())).thenReturn(clienteEntity);
        when(sessaoRepository.findByTitulo(anyString())).thenReturn(sessaoEntity);
        when(vendaRepository.save(any())).thenReturn(vendaEntity);

        var vendaReturn = vendaService.cadastrarVenda(vendaDto);

        assertEquals(vendaReturn, vendaDto);
    }

//    @Test
//    public void DeveCadastrarVendaComErroParametroInvalido(){
//
//    }
}
