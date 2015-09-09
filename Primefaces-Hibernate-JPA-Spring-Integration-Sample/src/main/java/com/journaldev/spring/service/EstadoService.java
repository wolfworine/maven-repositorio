package com.journaldev.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.journaldev.spring.repository.EstadoRepository;

@Component
public class EstadoService {
	
	@Autowired
	private EstadoRepository estadoRepository ;

	public EstadoRepository getEstadoRepository() {
		return estadoRepository;
	}

	public void setEstadoRepository(EstadoRepository estadoRepository) {
		this.estadoRepository = estadoRepository;
	}





}
