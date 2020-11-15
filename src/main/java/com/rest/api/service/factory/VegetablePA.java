package com.rest.api.service.factory;

import lombok.Data;

@Data
public class VegetablePA extends BaseVegetable implements Vegetable {

    private double price;

    public VegetablePA(String name, double price) {
        super(name, "PA");
        this.price = price;
    }
}
