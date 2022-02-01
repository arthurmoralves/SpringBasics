package br.com.estudo.api.cinema.estudo.mapper;

import br.com.estudo.api.cinema.estudo.entity.VendaEntity;
import br.com.estudo.api.cinema.estudo.dto.VendaDto;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class VendaMapper {

    public ModelMapper modelMapper = new ModelMapper();

    public VendaDto marshall(VendaEntity vendaEntity){
       return modelMapper.map(vendaEntity, VendaDto.class);
    }

    public VendaEntity unmarshall(VendaDto vendaDto){
        return modelMapper.map(vendaDto, VendaEntity.class);
    }

    public Page<VendaDto> converter(Page<VendaEntity> vendasEntity){
        return vendasEntity.map(vendaEntity -> marshall(vendaEntity));
    }
}
