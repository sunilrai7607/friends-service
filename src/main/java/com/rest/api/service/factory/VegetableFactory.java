package com.rest.api.service.factory;

public class VegetableFactory {

    public Vegetable createVegetable(String state) {
        switch (state) {
            case "PA":
                return new VegetablePA("Potato", 4.03);
            case "NJ":
                return new VegetableNJ("Potato", 3.13);
            default:
                return null;
        }
    }
}
