package br.com.estudo.api.cinema.estudo.service;

import br.com.estudo.api.cinema.estudo.dto.ClienteDto;
import br.com.estudo.api.cinema.estudo.dto.SessaoDto;
import br.com.estudo.api.cinema.estudo.dto.VendaDto;
import br.com.estudo.api.cinema.estudo.entity.SessaoEntity;
import br.com.estudo.api.cinema.estudo.entity.VendaEntity;
import br.com.estudo.api.cinema.estudo.exception.NaoHaAssentosDisponiveisParaSessaoException;
import br.com.estudo.api.cinema.estudo.mapper.SessaoMapper;
import br.com.estudo.api.cinema.estudo.mapper.VendaMapper;
import br.com.estudo.api.cinema.estudo.repository.ClienteRepository;
import br.com.estudo.api.cinema.estudo.repository.SalaRepository;
import br.com.estudo.api.cinema.estudo.repository.SessaoRepository;
import br.com.estudo.api.cinema.estudo.repository.VendaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private SessaoRepository sessaoRepository;

    @Autowired
    private VendaMapper vendaMapper;

    public List<VendaDto> consultarVendas(){
        var listaVendas = vendaRepository.findAll();
        return converter(listaVendas);
    }

    private List<VendaDto> converter(List<VendaEntity> vendasEntity){
        return vendasEntity.stream().map(vendaEntity -> vendaMapper.marshall(vendaEntity)).collect(Collectors.toList());
    }

    public VendaDto cadastrarVenda(VendaDto vendaDto) {

        try{

            var listIdSessoes = vendaDto.getSessoes().stream().map(SessaoDto::getId).collect(Collectors.toList());

            List<SessaoEntity> listSessaoEntity = new ArrayList<>();

            for (SessaoDto sessao:vendaDto.getSessoes()) {
                var sessaoEntity = sessaoRepository.findById(sessao.getId());
                verificaDisponibilidadeAssento(sessaoEntity.get());
                listSessaoEntity.add(sessaoEntity.get());
            }

            var cliente = clienteRepository.findByCPF(vendaDto.getCliente().getCPF());

            var vendaEntity = new VendaEntity(cliente, listSessaoEntity);

            var vendaReturn = vendaRepository.save(vendaEntity);

            return vendaMapper.marshall(vendaReturn);


        } catch(Exception e){
            log.info("Não foi possível cadastrar a venda.", e);
            throw new InvalidParameterException();
        }
    }

    private void verificaDisponibilidadeAssento(SessaoEntity sessaoEntity) {
        var ocupados = vendaRepository.countBySessaoId(sessaoEntity.getId());

        if (ocupados >= sessaoEntity.getSala().getCapacidade())
            throw new NaoHaAssentosDisponiveisParaSessaoException("Não há mais assentos disponíveis para a sessão solicitada");
    }

}
