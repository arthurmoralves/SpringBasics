package br.com.estudo.api.cinema.estudo.service;

import br.com.estudo.api.cinema.estudo.mapper.ClienteMapper;
import br.com.estudo.api.cinema.estudo.model.Cliente;
import br.com.estudo.api.cinema.estudo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public Cliente cadastrar(Cliente cliente){
        var clienteEntity = ClienteMapper.unmarshall(cliente);
        return ClienteMapper.marshall(clienteRepository.save(clienteEntity));
    }
}
