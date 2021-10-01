package br.com.estudo.api.cinema.estudo.mapper;

import br.com.estudo.api.cinema.estudo.entity.ClienteEntity;
import br.com.estudo.api.cinema.estudo.model.Cliente;
import org.modelmapper.ModelMapper;

public class ClienteMapper {

    private ClienteMapper(){ super(); }

    private static ModelMapper modelMapper = new ModelMapper();

    public static Cliente marshall(ClienteEntity clienteEntity){
        return modelMapper.map(clienteEntity, Cliente.class);
    }

    public static ClienteEntity unmarshall(Cliente cliente){
        return modelMapper.map(cliente, ClienteEntity.class);
    }
}
