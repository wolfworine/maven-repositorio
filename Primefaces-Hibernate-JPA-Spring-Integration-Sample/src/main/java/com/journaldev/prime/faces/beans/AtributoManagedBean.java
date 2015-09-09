package com.journaldev.prime.faces.beans;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.google.common.collect.Lists;
import com.journaldev.jpa.data.Atributo;
import com.journaldev.spring.service.AtributoService;

@ManagedBean
@SessionScoped
public class AtributoManagedBean{
	
	private List<Atributo> atributos= new ArrayList<Atributo>();
	private Atributo selectAtributo= new Atributo();
	private Atributo atributo=new Atributo();
	
	@ManagedProperty(value = "#{atributoService}")
	private AtributoService atributoService;
	
	@PostConstruct
	public void init(){
		atributos  = Lists.newArrayList(
				atributoService.getAtributoRepository().findAll());
	}

	public List<Atributo> getAtributos() {
		atributos  = Lists.newArrayList(
				atributoService.getAtributoRepository().findAll());
		return atributos;
	}

	public void setAtributos(List<Atributo> atributos) {
		this.atributos = atributos;
	}

	public Atributo getSelectAtributo() {
		return selectAtributo;
	}

	public void setSelectAtributo(Atributo selectAtributo) {
		this.selectAtributo = selectAtributo;
	}

	public Atributo getAtributo() {
		return atributo;
	}

	public void setAtributo(Atributo atributo) {
		this.atributo = atributo;
	}

	public AtributoService getAtributoService() {
		return atributoService;
	}

	public void setAtributoService(AtributoService atributoService) {
		this.atributoService = atributoService;
	}
	
}
