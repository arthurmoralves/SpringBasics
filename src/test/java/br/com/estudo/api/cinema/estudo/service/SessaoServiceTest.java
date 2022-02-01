package br.com.estudo.api.cinema.estudo.service;

import br.com.estudo.api.cinema.estudo.dto.SessaoDto;
import br.com.estudo.api.cinema.estudo.entity.SessaoEntity;
import br.com.estudo.api.cinema.estudo.mapper.SessaoMapper;
import br.com.estudo.api.cinema.estudo.repository.SessaoRepository;
import br.com.estudo.api.cinema.estudo.util.CinemaTestClassBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class SessaoServiceTest {

    @InjectMocks
    SessaoService sessaoService;

    @Spy
    SessaoMapper sessaoMapper;

    @Mock
    SessaoRepository sessaoRepository;

    CinemaTestClassBuilder cinemaTestClassBuilder = new CinemaTestClassBuilder();

    @Test
    public void deveTestarCadastroComSucesso(){
        var sessaoDto = cinemaTestClassBuilder.mockSessaoDto();
        var sessaoEntity = cinemaTestClassBuilder.mockSessaoEntity();

        when(sessaoRepository.save(sessaoEntity)).thenReturn(sessaoEntity);

        var sessaoReturn = sessaoService.cadastrar(sessaoDto);

        assertEquals(sessaoReturn, sessaoDto);
    }

    @Test
    public void deveTestarConsultarSessao(){
        var sessaoDto = cinemaTestClassBuilder.mockSessaoDto();
        var sessaoEntity = cinemaTestClassBuilder.mockSessaoEntity();
        Pageable page = PageRequest.of(1, 1);

        List<SessaoEntity> sessoesEntity = new ArrayList<>();
        sessoesEntity.add(sessaoEntity);

        List<SessaoDto> sessoesDto = new ArrayList<>();
        sessoesDto.add(sessaoDto);

        Page<SessaoEntity> sessoesEntityPage = new PageImpl<>(sessoesEntity);
        Page<SessaoDto> sessoesDtoPage = new PageImpl<>(sessoesDto);

        when(sessaoRepository.findAll(page)).thenReturn(sessoesEntityPage);

        var sessaoReturn = sessaoService.consultar(page);

        assertEquals(sessaoReturn, sessoesDtoPage);
    }

//    @Test
//    public void deveTestarConsultarPorTitulo(){
//        var sessaoDto = cinemaFactoryTest.mockSessaoDto();
//        sessaoDto.setTitulo("A BRANCA DE NEVE");
//        var sessaoEntity = cinemaFactoryTest.mockSessaoEntity();
//        sessaoEntity.setTitulo("A BRANCA DE NEVE");
//
//        when(sessaoRepository.findByTitulo(anyString())).thenReturn(sessaoEntity);
//
//        var sessaoReturn = sessaoService.consultarPorTitulo(anyString());
//
//        assertEquals(sessaoDto, sessaoReturn);
//    }

}
