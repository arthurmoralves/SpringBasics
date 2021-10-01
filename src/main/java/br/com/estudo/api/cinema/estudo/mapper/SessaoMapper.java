package br.com.estudo.api.cinema.estudo.mapper;

import br.com.estudo.api.cinema.estudo.entity.SessaoEntity;
import br.com.estudo.api.cinema.estudo.model.Sessao;
import org.modelmapper.ModelMapper;

public class SessaoMapper {

    private SessaoMapper(){ super(); }

    private static ModelMapper modelMapper = new ModelMapper();

    public static Sessao marshall(SessaoEntity sessaoEntity){
        return modelMapper.map(sessaoEntity, Sessao.class);
    }

    public static SessaoEntity unmarshall(Sessao sessao){
        return modelMapper.map(sessao, SessaoEntity.class);
    }
}
