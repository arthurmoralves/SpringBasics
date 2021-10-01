package br.com.estudo.api.cinema.estudo.service;

import br.com.estudo.api.cinema.estudo.entity.SalaEntity;
import br.com.estudo.api.cinema.estudo.model.Sala;
import br.com.estudo.api.cinema.estudo.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    public List<Sala> consultarSalas(){
        List<SalaEntity> salas = salaRepository.findAll();
        return converter(salas);
    }

    private List<Sala> converter(List<SalaEntity> salaEntityList) {
        return salaEntityList.stream().map(Sala::new).collect(Collectors.toList());
    }
}
