package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.City;
import com.example.demo.entity.Product;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

	List<City> findByCity(String city);
	
}
