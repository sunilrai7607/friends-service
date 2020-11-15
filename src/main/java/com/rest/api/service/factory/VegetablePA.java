package com.rest.api.service.factory;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

@Data
// @Builder
public class VegetablePA extends BaseVegetable implements Vegetable {

    private double price;

    protected double PATax;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected String statePADescription;

    public VegetablePA(String name, double price) {
        super(name, "PA");
        this.price = price;
    }
}
