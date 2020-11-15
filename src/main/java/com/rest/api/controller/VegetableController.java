package com.rest.api.controller;

import com.rest.api.service.VegetableService;
import com.rest.api.service.factory.Vegetable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "api/v1/vegetables", produces = MediaType.APPLICATION_JSON_VALUE)
public class VegetableController {

    private final VegetableService vegetableService;

    @Autowired
    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }


    @GetMapping
    public ResponseEntity<List<Vegetable>> getVegetables() {
        return ResponseEntity.ok(vegetableService.findAll());
    }

    @GetMapping("/{vegetableName}")
    public ResponseEntity<Vegetable> getFriendById(@PathVariable(value = "vegetableName") String vegetableName, @RequestParam(value = "state", required = true) String state) {
        return ResponseEntity.ok(vegetableService.findByName(vegetableName, state));
    }
}
