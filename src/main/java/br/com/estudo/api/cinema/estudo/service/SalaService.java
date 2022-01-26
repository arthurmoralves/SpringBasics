package br.com.estudo.api.cinema.estudo.service;

import br.com.estudo.api.cinema.estudo.dto.SalaDto;
import br.com.estudo.api.cinema.estudo.entity.SalaEntity;
import br.com.estudo.api.cinema.estudo.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    public Page<SalaDto> consultarSalas(Pageable page){
        var salas = salaRepository.findAll(page);
        return converter(salas);
    }

    private Page<SalaDto> converter(Page<SalaEntity> salaEntityList) {
        return salaEntityList.map(SalaDto::new);
    }
}
