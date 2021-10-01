package br.com.estudo.api.cinema.estudo.mapper;

import br.com.estudo.api.cinema.estudo.entity.VendaEntity;
import br.com.estudo.api.cinema.estudo.model.Venda;
import org.modelmapper.ModelMapper;
import org.springframework.ui.ModelMap;

public class VendaMapper {


    public static ModelMapper modelMapper = new ModelMapper();

    public static Venda marshall(VendaEntity vendaEntity){
       return modelMapper.map(vendaEntity, Venda.class);
    }

    public static VendaEntity unmarshall(Venda venda){
        return modelMapper.map(venda, VendaEntity.class);
    }

}
