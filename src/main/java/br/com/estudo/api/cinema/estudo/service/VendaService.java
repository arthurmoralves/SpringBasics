package br.com.estudo.api.cinema.estudo.service;

import br.com.estudo.api.cinema.estudo.entity.VendaEntity;
import br.com.estudo.api.cinema.estudo.mapper.VendaMapper;
import br.com.estudo.api.cinema.estudo.model.Venda;
import br.com.estudo.api.cinema.estudo.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendaService {

    @Autowired
    VendaRepository vendaRepository;

    public List<Venda> consultarVendas(){
        List<VendaEntity> listaVendas = vendaRepository.findAll();
        return converter(listaVendas);
    }

    private List<Venda> converter(List<VendaEntity> vendaEntity){
        return vendaEntity.stream().map(Venda::new).collect(Collectors.toList());
    }

    public Venda cadastrarVenda(Venda venda) {
        VendaEntity vendaEntity = VendaMapper.unmarshall(venda);
        return VendaMapper.marshall(vendaRepository.save(vendaEntity));
    }
}
