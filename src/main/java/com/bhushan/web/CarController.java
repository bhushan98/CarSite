package com.bhushan.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhushan.entity.Car;
import com.bhushan.exception.CarNotFoundException;
import com.bhushan.service.CarService;

@RestController
@RequestMapping("/car")
public class CarController {
	
	@Autowired
	private CarService service;
	
	@GetMapping(value = "/list/all", produces = "application/json")
	public List<Car> listAllCars(){
		return service.listAllCars();
	}
	
	@GetMapping(value = "/list/price/{min}/{max}", produces = "application/json")
	public List<Car> listByPrice(@PathVariable double min, @PathVariable double max){
		return service.listByPrice(min, max);
	}
	
	@GetMapping(value = "/list/name/{name}", produces = "application/json")
	public List<Car> listByName(@PathVariable String name){
		return service.listByName(name);
	}
	
	@GetMapping(value = "/list/id/{id}", produces = "application/json")
	public Car getById(@PathVariable int id) throws CarNotFoundException {
		return service.getById(id);
	}
	
	@GetMapping(value = "/list/model/{model}", produces = "application/json")
	public List<Car> getByModel(@PathVariable String model){
		return service.listByModel(model);
	}
	
	@GetMapping(value = "/list/rating/{rating}", produces = "application/json")
	public List<Car> getByRating(@PathVariable double rating){
		return service.listByRating(rating);
	}
	
	@PostMapping(value = "/add", produces = "application/json", consumes = "application/json")
	public Car addCar(@RequestBody Car car) {
		return service.addCar(car);
	}
	
	@PutMapping(value = "/edit", produces = "application/json", consumes = "application/json")
	public Car updataCar(@RequestBody Car car) {
		return service.updateCar(car);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public boolean deleteCar(@PathVariable int id) throws CarNotFoundException {
		return service.removeCar(id);
	}
}
