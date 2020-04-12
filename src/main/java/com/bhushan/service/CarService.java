package com.bhushan.service;

import java.util.List;

import com.bhushan.entity.Car;
import com.bhushan.exception.CarNotFoundException;

public interface CarService {
	
	List<Car> listAllCars();
	
	List<Car> listByPrice(double min, double max);
	
	List<Car> listByName(String name);
	
	Car getById(int id) throws CarNotFoundException;
	
	List<Car> listByModel(String model);
	
	List<Car> listByRating(double rating);
	
	Car addCar(Car car);
	
	Car updateCar(Car car);
	
	boolean removeCar(int id) throws CarNotFoundException;
}
