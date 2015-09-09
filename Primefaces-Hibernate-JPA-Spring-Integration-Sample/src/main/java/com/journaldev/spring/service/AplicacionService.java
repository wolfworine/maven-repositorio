package com.journaldev.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.journaldev.spring.repository.AplicacionRepository;

@Component
public class AplicacionService {
	
	@Autowired
	private AplicacionRepository aplicacionRepository ;

	public AplicacionRepository getAplicacionRepository() {
		return aplicacionRepository;
	}

	public void setAplicacionRepository(AplicacionRepository aplicacionRepository) {
		this.aplicacionRepository = aplicacionRepository;
	}





}
