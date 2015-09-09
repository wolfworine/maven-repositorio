package com.journaldev.prime.faces.beans;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.google.common.collect.Lists;
import com.journaldev.jpa.data.Aplicacion;
import com.journaldev.jpa.data.Area;
import com.journaldev.jpa.data.Atributo;
import com.journaldev.spring.service.AtributoService;

@ManagedBean
@SessionScoped
public class ReporteManagedBean{

	private List<String> cargos=new ArrayList<String>();

	private Area selecArea = new Area();
	
	private Area busqueda = new Area();
	
	private Area area = new Area();
	
	private Aplicacion aplicacion= new Aplicacion();
	
	private List<Atributo>  atributos= new ArrayList<Atributo>  ();
	
	@ManagedProperty(value = "#{atributoService}")
	private AtributoService atributoService;

	@PostConstruct
	public void init(){
		atributos = Lists.newArrayList(
				atributoService.getAtributoRepository().findAll());
	}
	
	
	public String reporte() {
		// TODO Auto-generated method stub
		
		atributos=atributoService.getAtributoRepository().findAppArea(aplicacion.getCodigo(),area.getCodigo());
		return "/paginas/reportes/vista.xhtml?faces-redirect=true";
	}
	
    public void save(ActionEvent actionEvent) {
        addMessage("Data saved");
    }
     
    public void update(ActionEvent actionEvent) {
        addMessage("Data updated");
    }
     
    public void delete(ActionEvent actionEvent) {
        addMessage("Data deleted");
    }
 
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	public List<String> getCargos() {
		return cargos;
	}



	public void setCargos(List<String> cargos) {
		this.cargos = cargos;
	}

	public Area getSelecArea() {
		return selecArea;
	}



	public void setSelecArea(Area selecArea) {
		this.selecArea = selecArea;
	}



	public Area getBusqueda() {
		return busqueda;
	}



	public void setBusqueda(Area busqueda) {
		this.busqueda = busqueda;
	}



	public Area getArea() {
		return area;
	}



	public void setArea(Area area) {
		this.area = area;
	}



	public Aplicacion getAplicacion() {
		return aplicacion;
	}



	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}



	public List<Atributo> getAtributos() {
		return atributos;
	}



	public void setAtributos(List<Atributo> atributos) {
		this.atributos = atributos;
	}



	public AtributoService getAtributoService() {
		return atributoService;
	}



	public void setAtributoService(AtributoService atributoService) {
		this.atributoService = atributoService;
	}
	
/*	public String buscar() {
		filteredAreas =		areaService.getAreaRepository().
				findByCodigoOrArea(busqueda.getCodigo(), busqueda.getArea());
		return null;
	}*/
	
	

	
	
}
