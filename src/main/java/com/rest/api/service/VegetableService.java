package com.rest.api.service;

import com.rest.api.service.factory.Vegetable;

import java.util.List;

public interface VegetableService {

    List<Vegetable> findAll();

    Vegetable findByName(final String vegetableName, String state);
}
