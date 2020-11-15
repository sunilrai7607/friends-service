package com.rest.api.service.factory;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VegetableNJ extends BaseVegetable implements Vegetable {

    private double price;

    public VegetableNJ(String name, double price) {
        super(name, "NJ");
        this.price = price;
    }
}
