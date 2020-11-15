package com.rest.api.domain;

import lombok.Data;

@Data
public class VegetableDto {

    private String name;

    private String state;

    public VegetableDto(String name, String state) {
        this.name = name;
        this.state = state;
    }

    public VegetableDto(String state) {
        this.state = state;
    }
}
