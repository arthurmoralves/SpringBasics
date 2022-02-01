package br.com.estudo.api.cinema.estudo.service;

import br.com.estudo.api.cinema.estudo.dto.SessaoDto;
import br.com.estudo.api.cinema.estudo.entity.SessaoEntity;
import br.com.estudo.api.cinema.estudo.mapper.SessaoMapper;
import br.com.estudo.api.cinema.estudo.repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SessaoService {

    @Autowired
    private SessaoRepository sessaoRepository;

    @Autowired
    private SessaoMapper sessaoMapper;

    public SessaoDto cadastrar(SessaoDto sessaoDto){
        var sessaoEntity = sessaoMapper.unmarshall(sessaoDto);
        return sessaoMapper.marshall(sessaoRepository.save(sessaoEntity));
    }

    public Page<SessaoDto> consultar(Pageable page) {
        var listaSessao = sessaoRepository.findAll(page);
        return sessaoMapper.converter(listaSessao);
    }

    public Optional<SessaoEntity> consultarPorTitulo(String titulo) {
        return sessaoRepository.findByTitulo(titulo);
    }

    public Optional<SessaoEntity> consultarPorId(Long id){
        return sessaoRepository.findById(id);
    }
}
