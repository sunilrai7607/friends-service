package com.rest.api.service.factory;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
// @Builder
public class VegetableNJ extends BaseVegetable implements Vegetable {

    private double price;

    protected double NJTax;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected String stateNJDescription;

    public VegetableNJ(String name, double price) {
        super(name, "NJ");
        this.price = price;
    }
}
