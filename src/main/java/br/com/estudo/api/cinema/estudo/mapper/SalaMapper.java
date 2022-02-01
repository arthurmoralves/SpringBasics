package br.com.estudo.api.cinema.estudo.mapper;

import br.com.estudo.api.cinema.estudo.dto.SalaDto;
import br.com.estudo.api.cinema.estudo.entity.SalaEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class SalaMapper {

    public Page<SalaDto> converter(Page<SalaEntity> salaEntityList) {
        return salaEntityList.map(SalaDto::new);
    }
}
