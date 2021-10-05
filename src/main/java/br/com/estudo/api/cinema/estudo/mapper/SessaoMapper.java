package br.com.estudo.api.cinema.estudo.mapper;

import br.com.estudo.api.cinema.estudo.entity.SessaoEntity;
import br.com.estudo.api.cinema.estudo.dto.SessaoDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class SessaoMapper {

    private SessaoMapper(){ super(); }

    private ModelMapper modelMapper = new ModelMapper();

    public SessaoDto marshall(SessaoEntity sessaoEntity){
        return modelMapper.map(sessaoEntity, SessaoDto.class);
    }

    public SessaoEntity unmarshall(SessaoDto sessaoDto){
        return modelMapper.map(sessaoDto, SessaoEntity.class);
    }
}
