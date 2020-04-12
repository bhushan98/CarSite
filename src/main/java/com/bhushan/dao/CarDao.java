package com.bhushan.dao;

import java.util.List;

import com.bhushan.entity.Car;
import com.bhushan.exception.CarNotFoundException;

public interface CarDao {
	
	List<Car> listAllCars();
	
	List<Car> listByPriceRange(double min, double max);
	
	List<Car> listByName(String name);
	
	Car listById(int id) throws CarNotFoundException;
	
	List<Car> listByModelNumber(String modelNumber);
	
	List<Car> listByRating(double rating);
	
	Car addCar(Car car);
	
	Car updateCar(Car car);
	
	boolean removeCar(int id) throws CarNotFoundException;
	
}
