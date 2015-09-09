package com.journaldev.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.journaldev.spring.repository.CargoRepository;

@Component
public class CargoService {
	
	@Autowired
	private CargoRepository cargoRepository;

	public CargoRepository getCargoRepository() {
		return cargoRepository;
	}

	public void setCargoRepository(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}
	
}
