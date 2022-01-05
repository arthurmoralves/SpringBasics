package br.com.estudo.api.cinema.estudo.mapper;

import br.com.estudo.api.cinema.estudo.entity.ClienteEntity;
import br.com.estudo.api.cinema.estudo.dto.ClienteDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ClienteMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public ClienteDto marshall(ClienteEntity clienteEntity){
        return modelMapper.map(clienteEntity, ClienteDto.class);
    }

    public ClienteEntity unmarshall(ClienteDto clienteDto){
        return modelMapper.map(clienteDto, ClienteEntity.class);
    }
}