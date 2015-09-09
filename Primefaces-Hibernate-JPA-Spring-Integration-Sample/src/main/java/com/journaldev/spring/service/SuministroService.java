package com.journaldev.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.journaldev.spring.repository.SuministroRepository;


@Component
public class SuministroService {
	
	@Autowired
	private SuministroRepository suministroRepository;

	public SuministroRepository getSuministroRepository() {
		return suministroRepository;
	}

	public void setSuministroRepository(SuministroRepository suministroRepository) {
		this.suministroRepository = suministroRepository;
	}


}
