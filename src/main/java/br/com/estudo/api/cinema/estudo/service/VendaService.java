package br.com.estudo.api.cinema.estudo.service;

import br.com.estudo.api.cinema.estudo.entity.ClienteEntity;
import br.com.estudo.api.cinema.estudo.entity.SalaEntity;
import br.com.estudo.api.cinema.estudo.entity.SessaoEntity;
import br.com.estudo.api.cinema.estudo.entity.VendaEntity;
import br.com.estudo.api.cinema.estudo.mapper.VendaMapper;
import br.com.estudo.api.cinema.estudo.model.Venda;
import br.com.estudo.api.cinema.estudo.repository.ClienteRepository;
import br.com.estudo.api.cinema.estudo.repository.SalaRepository;
import br.com.estudo.api.cinema.estudo.repository.SessaoRepository;
import br.com.estudo.api.cinema.estudo.repository.VendaRepository;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VendaService {

    @Autowired
    VendaRepository vendaRepository;

    @Autowired
    private SalaRepository salaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private SessaoRepository sessaoRepository;

    public List<Venda> consultarVendas(){
        List<VendaEntity> listaVendas = vendaRepository.findAll();
        return converter(listaVendas);
    }

    private List<Venda> converter(List<VendaEntity> vendaEntity){
        return vendaEntity.stream().map(Venda::new).collect(Collectors.toList());
    }

    public Venda cadastrarVenda(Venda venda) {

        try{
            var sala = salaRepository.findById(venda.getSala()).get();
            ClienteEntity cliente = clienteRepository.findByNome(venda.getCliente());
            SessaoEntity sessao = sessaoRepository.findByTitulo(venda.getTitulo());

            VendaEntity vendaEntity = new VendaEntity(cliente, sessao, sala);

            var vendaReturn = vendaRepository.save(vendaEntity);

            return Venda.builder().titulo(vendaReturn.getSessao().getTitulo())
                    .cliente(vendaReturn.getCliente().getNome())
                    .sala(vendaReturn.getSala().getId())
                    .build();

        } catch(Exception e){
            log.info("Não foi possível cadastrar a venda.", e);
            throw new InvalidParameterException();
        }
    }
}
