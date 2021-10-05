package br.com.estudo.api.cinema.estudo.service;

import br.com.estudo.api.cinema.estudo.entity.SessaoEntity;
import br.com.estudo.api.cinema.estudo.mapper.SessaoMapper;
import br.com.estudo.api.cinema.estudo.dto.SessaoDto;
import br.com.estudo.api.cinema.estudo.repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<SessaoDto> consultar() {
        List<SessaoEntity> listaSessao = sessaoRepository.findAll();
        return converter(listaSessao);

    }

    private List<SessaoDto> converter(List<SessaoEntity> sessoesEntity){
        return sessoesEntity.stream().map(SessaoDto::new).collect(Collectors.toList());
    }

    public SessaoDto consultarPorTitulo(String titulo) {
        return sessaoMapper.marshall(sessaoRepository.findByTitulo(titulo));
    }
}
