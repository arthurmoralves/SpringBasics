package br.com.estudo.api.cinema.estudo.service;

import br.com.estudo.api.cinema.estudo.entity.ClienteEntity;
import br.com.estudo.api.cinema.estudo.entity.SalaEntity;
import br.com.estudo.api.cinema.estudo.entity.SessaoEntity;
import br.com.estudo.api.cinema.estudo.entity.VendaEntity;
import br.com.estudo.api.cinema.estudo.dto.VendaDto;
import br.com.estudo.api.cinema.estudo.exception.NaoHaAssentosDisponiveisParaSessaoException;
import br.com.estudo.api.cinema.estudo.repository.ClienteRepository;
import br.com.estudo.api.cinema.estudo.repository.SalaRepository;
import br.com.estudo.api.cinema.estudo.repository.SessaoRepository;
import br.com.estudo.api.cinema.estudo.repository.VendaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private SalaRepository salaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private SessaoRepository sessaoRepository;

    public List<VendaDto> consultarVendas(){
        var listaVendas = vendaRepository.findAll();
        return converter(listaVendas);
    }

    private List<VendaDto> converter(List<VendaEntity> vendaEntity){
        return vendaEntity.stream().map(VendaDto::new).collect(Collectors.toList());
    }

//    public VendaDto cadastrarVenda(VendaDto vendaDto) {
//
//        try{
////            TODO
//            var sala = salaRepository.findById(vendaDto.getTitulo());
//
//            verificaDisponibilidadeAssento(sala);
//
//            var cliente = clienteRepository.findByCPF(vendaDto.getCliente());
//            var sessao = sessaoRepository.findByTitulo(vendaDto.getTitulo());
//
//            var vendaEntity = new VendaEntity(cliente, sessao);
//
//            var vendaReturn = vendaRepository.save(vendaEntity);
//
//            return VendaDto.builder().titulo(vendaReturn.getSessao().getTitulo())
//                    .cliente(vendaReturn.getCliente().getNome())
//                    .build();
//
//        } catch(Exception e){
//            log.info("Não foi possível cadastrar a venda.", e);
//            throw new InvalidParameterException();
//        }
//    }

//    private boolean verificaDisponibilidadeAssento(SalaEntity sala){
//        var ocupados = vendaRepository.countBySessaoId();
//
//        if(ocupados < sala.getCapacidade()){
//            return true;
//        } else{
//            throw new NaoHaAssentosDisponiveisParaSessaoException("Não há mais assentos disponíveis para a sessão solicitada");
//        }
//    }
}
