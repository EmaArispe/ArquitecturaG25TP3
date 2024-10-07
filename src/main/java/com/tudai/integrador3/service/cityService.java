package com.tudai.integrador3.service;

import com.tudai.integrador3.entity.City;
import com.tudai.integrador3.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class cityService {

    @Autowired
    private CityRepository repository;


    public Optional<City> getCity(@PathVariable(value = "id") Long id){
        Optional<City> oCity = repository.findById(id.longValue());
        return oCity;
    }

    public Optional<List<City>> getAll (){
        Optional<List<City>> listOptional = Optional.of(repository.findAll());
        return listOptional;
    }

    public City addCity(City newCity){
        return repository.save(newCity);
    }
}
