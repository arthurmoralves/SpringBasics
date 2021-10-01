package br.com.estudo.api.cinema.estudo.service;

import br.com.estudo.api.cinema.estudo.entity.SessaoEntity;
import br.com.estudo.api.cinema.estudo.mapper.SessaoMapper;
import br.com.estudo.api.cinema.estudo.model.Sessao;
import br.com.estudo.api.cinema.estudo.repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SessaoService {

    @Autowired
    SessaoRepository sessaoRepository;

    public Sessao cadastrar(Sessao sessao){
        var sessaoEntity = SessaoMapper.unmarshall(sessao);
        return SessaoMapper.marshall(sessaoRepository.save(sessaoEntity));
    }

    public List<Sessao> consultar() {
        List<SessaoEntity> listaSessao = sessaoRepository.findAll();
        return converter(listaSessao);

    }

    private List<Sessao> converter(List<SessaoEntity> sessoesEntity){
        return sessoesEntity.stream().map(Sessao::new).collect(Collectors.toList());
    }

    public Sessao consultarPorTitulo(String titulo) {
        return sessaoRepository.findByTitulo(titulo);
    }
}
