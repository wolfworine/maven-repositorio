package com.journaldev.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.journaldev.spring.repository.DetalleRepository;

@Component
public class DetalleService {

	
	@Autowired
	private DetalleRepository detalleRepository;

	public DetalleRepository getDetalleRepository() {
		return detalleRepository;
	}

	public void setDetalleRepository(DetalleRepository detalleRepository) {
		this.detalleRepository = detalleRepository;
	}


}
