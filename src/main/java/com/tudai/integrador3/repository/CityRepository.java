package com.tudai.integrador3.repository;

import com.tudai.integrador3.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {

}
