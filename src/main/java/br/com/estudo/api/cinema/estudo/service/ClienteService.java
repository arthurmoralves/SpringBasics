package br.com.estudo.api.cinema.estudo.service;

import br.com.estudo.api.cinema.estudo.mapper.ClienteMapper;
import br.com.estudo.api.cinema.estudo.dto.ClienteDto;
import br.com.estudo.api.cinema.estudo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    public ClienteDto cadastrar(ClienteDto clienteDto){
        var clienteEntity = clienteMapper.unmarshall(clienteDto);
        return clienteMapper.marshall(clienteRepository.save(clienteEntity));
    }
}
