package br.com.estudo.api.cinema.estudo.service;

import br.com.estudo.api.cinema.estudo.dto.SalaDto;
import br.com.estudo.api.cinema.estudo.entity.SalaEntity;
import br.com.estudo.api.cinema.estudo.repository.SalaRepository;
import br.com.estudo.api.cinema.estudo.util.CinemaTestClassBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    CinemaTestClassBuilder cinemaTestClassBuilder = new CinemaTestClassBuilder();

    @Test
    public void deveTestarConsultaDeSalas(){
        List<SalaEntity> salas = new ArrayList<>();
        List<SalaDto> salasDto = new ArrayList<>();
        Pageable page = PageRequest.of(1, 1);

        var sala1 = cinemaTestClassBuilder.mockSalaEntity();
        var sala2 = cinemaTestClassBuilder.mockSalaEntity();
        var salaDto1 = cinemaTestClassBuilder.mockSalaDto();
        var salaDto2 = cinemaTestClassBuilder.mockSalaDto();

        salas.add(sala1);
        salas.add(sala2);
        salasDto.add(salaDto1);
        salasDto.add(salaDto2);

        var salasEntityPage = new PageImpl<>(salas);
        var salasDtoPage = new PageImpl<>(salasDto);

        when(salaRepository.findAll(page)).thenReturn(salasEntityPage);

        Page<SalaDto> salaReturn = salaService.consultarSalas(page);

        assertEquals(salasDtoPage, salaReturn);
    }

    //TODO - Entender qual exception precisa ser testada
}
