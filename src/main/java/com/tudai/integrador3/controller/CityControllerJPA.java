package com.tudai.integrador3.controller;

import com.tudai.integrador3.entity.City;
import com.tudai.integrador3.service.cityService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cities")
public class CityControllerJPA {

    @Autowired
    private cityService service;

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<?> getCity(@PathVariable(value = "id") Long id){
        Optional<City> oCity = service.getCity(id.longValue());
        return (!oCity.isPresent())? ResponseEntity.notFound().build() : ResponseEntity.ok(oCity);
    }

    @GetMapping("/")
    public @ResponseBody ResponseEntity<?> getAll(){
        Optional<List<City>> listOptional = service.getAll();
        return (!listOptional.isPresent()) ? ResponseEntity.notFound().build() : ResponseEntity.ok(listOptional);
    }

    /* Json {"name": "Tandil"} */


    @PostMapping()
    public @ResponseBody ResponseEntity<?> addCity(@RequestBody City newCity) {
        service.addCity(newCity);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addCity(newCity));
    }

}
