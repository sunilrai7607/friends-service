package com.rest.api.service.impl;

import com.rest.api.common.exception.ResourceNotFoundException;
import com.rest.api.domain.VegetableDto;
import com.rest.api.mapper.VegetableDtoMapper;
import com.rest.api.service.VegetableService;
import com.rest.api.service.factory.Vegetable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class VegetableServiceImpl implements VegetableService {
    @Override
    public List<Vegetable> findAll() {
        return Arrays.asList(VegetableDtoMapper.INSTANCE.map(new VegetableDto("PA")), VegetableDtoMapper.INSTANCE.map(new VegetableDto("NJ")));
    }

    @Override
    public Vegetable findByName(String vegetableName, String state) {
        return Optional.ofNullable(VegetableDtoMapper.INSTANCE.map(new VegetableDto(vegetableName, state)))
                .orElseThrow(() -> new ResourceNotFoundException("No vegetable found"));
    }
}
