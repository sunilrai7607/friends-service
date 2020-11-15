package com.rest.api.service.factory;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaseVegetable {

    private String name;

    private String state;

    public BaseVegetable(String name, String state) {
        this.name = name;
        this.state = state;
    }
}
