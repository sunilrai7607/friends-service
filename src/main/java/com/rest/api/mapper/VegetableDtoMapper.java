package com.rest.api.mapper;

import com.rest.api.domain.VegetableDto;
import com.rest.api.service.factory.Vegetable;
import com.rest.api.service.factory.VegetableFactory;
import com.rest.api.service.factory.VegetablePA;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = VegetableFactory.class)
public interface VegetableDtoMapper {

    VegetableDtoMapper INSTANCE = Mappers.getMapper(VegetableDtoMapper.class);

    @BeanMapping(resultType = VegetablePA.class)
    default Vegetable map(VegetableDto vegetableDto) {
        return new VegetableFactory().createVegetable(vegetableDto.getState());
    }

}
