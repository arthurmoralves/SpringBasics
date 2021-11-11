package br.com.estudo.api.cinema.estudo.service;

import br.com.estudo.api.cinema.estudo.dto.SalaDto;
import br.com.estudo.api.cinema.estudo.entity.SalaEntity;
import br.com.estudo.api.cinema.estudo.repository.SalaRepository;
import br.com.estudo.api.cinema.estudo.util.CinemaFactoryTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class )
public class SalaServiceTest {

    @InjectMocks
    SalaService salaService;

    @Mock
    SalaRepository salaRepository;

    CinemaFactoryTest cinemaFactoryTest = new CinemaFactoryTest();

    @Test
    public void deveTestarConsultaDeSalas(){
        List<SalaEntity> salas = new ArrayList<>();
        List<SalaDto> salasDto = new ArrayList<>();

        var sala1 = cinemaFactoryTest.mockSalaEntity();
        var sala2 = cinemaFactoryTest.mockSalaEntity();
        var salaDto1 = cinemaFactoryTest.mockSalaDto();
        var salaDto2 = cinemaFactoryTest.mockSalaDto();

        salas.add(sala1);
        salas.add(sala2);
        salasDto.add(salaDto1);
        salasDto.add(salaDto2);

        when(salaRepository.findAll()).thenReturn(salas);

        List<SalaDto> salaReturn = salaService.consultarSalas();

        assertEquals(salasDto, salaReturn);
    }

    //TODO - Entender qual exception precisa ser testada
}
