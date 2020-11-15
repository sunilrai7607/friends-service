package com.rest.api.service.factory;

public class VegetableFactory {

    public Vegetable createVegetable(String state) {
        switch (state) {
            case "PA":
                VegetablePA pa = new VegetablePA("Potato", 4.03);
                pa.setStatePADescription("PA State Descrition attributes");
                pa.setPATax(0.07);
                return pa;
            case "NJ":
                VegetableNJ nj = new VegetableNJ("Potato", 3.13);
                nj.setNJTax(0.05);
                return nj;
            default:
                return null;
        }
    }
}
