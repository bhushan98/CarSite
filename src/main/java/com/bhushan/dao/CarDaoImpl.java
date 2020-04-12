package com.bhushan.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bhushan.entity.Car;
import com.bhushan.exception.CarNotFoundException;

@Repository
public class CarDaoImpl implements CarDao {
	
	@Autowired
	private EntityManager mgr;

	@Override
	public List<Car> listAllCars() {
		return mgr.createNamedQuery("getAll").getResultList();
	}

	@Override
	public List<Car> listByPriceRange(double min, double max) {
		return mgr.createNamedQuery("byPrice").setParameter("min", min).setParameter("max", max).getResultList();
	}

	@Override
	public List<Car> listByName(String name) {
		return mgr.createNamedQuery("byName").setParameter("name", name).getResultList();
	}

	@Override
	public Car listById(int id) throws CarNotFoundException {
		Car car = mgr.find(Car.class, id);
		if(car == null)
			throw new CarNotFoundException("Car with ID : " + id + " Not Found !!");
		return car;
	}

	@Override
	public List<Car> listByModelNumber(String modelNumber) {
		return mgr.createNamedQuery("byModelNumber").setParameter("modelNumber", modelNumber).getResultList();
	}

	@Override
	public List<Car> listByRating(double rating) {
		return mgr.createNamedQuery("byRating").setParameter("rating", rating).getResultList();
	}

	@Override
	public Car addCar(Car car) {
		mgr.persist(car);
		return car;
	}

	@Override
	public Car updateCar(Car car) {
		return mgr.merge(car);
	}

	@Override
	public boolean removeCar(int id) throws CarNotFoundException {
		Car c = mgr.find(Car.class, id);
		if(c == null) 
			throw new CarNotFoundException("Car with ID : " + id + " Not Found !");
		mgr.remove(c);
		return true;
	}

}
