package com.journaldev.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.journaldev.spring.repository.AtributoRepository;


@Component
public class AtributoService {
	
	@Autowired
	private AtributoRepository atributoRepository;

	public AtributoRepository getAtributoRepository() {
		return atributoRepository;
	}

	public void setAtributoRepository(AtributoRepository atributoRepository) {
		this.atributoRepository = atributoRepository;
	}



}
