package com.bhushan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bhushan.dao.CarDao;
import com.bhushan.entity.Car;
import com.bhushan.exception.CarNotFoundException;

@Service
@Transactional(rollbackFor = ClassNotFoundException.class)
public class CarServiceImpl implements CarService {
	
	@Autowired
	private CarDao dao;
	
	@Override
	public List<Car> listAllCars() {
		return dao.listAllCars();
	}

	@Override
	public List<Car> listByPrice(double min, double max) {
		return dao.listByPriceRange(min, max);
	}

	@Override
	public List<Car> listByName(String name) {
		return dao.listByName(name);
	}

	@Override
	public Car getById(int id) throws CarNotFoundException {
		return dao.listById(id);
	}

	@Override
	public List<Car> listByModel(String model) {
		return dao.listByModelNumber(model);
	}

	@Override
	public List<Car> listByRating(double rating) {
		return dao.listByRating(rating);
	}

	@Override
	public Car addCar(Car car) {
		return dao.addCar(car);
	}

	@Override
	public Car updateCar(Car car) {
		return dao.updateCar(car);
	}

	@Override
	public boolean removeCar(int id) throws CarNotFoundException {
		return dao.removeCar(id);
	}

}
