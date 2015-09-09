package com.journaldev.prime.faces.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.google.common.collect.Lists;
import com.journaldev.java.util.Encripcion;
import com.journaldev.jpa.data.Login;
import com.journaldev.jpa.data.Usuario;
import com.journaldev.spring.service.LoginService;
import com.journaldev.spring.service.UsuarioService;

@ManagedBean
@SessionScoped
public class LoginManagedBean {
	
	
	private String email,password;

	private List<Login> logins = new ArrayList<Login>();
	
	private Login selecLogin = new Login();
	
	private List<Login> valido = new ArrayList<Login>();
	
	private Login login = new Login();
	
	private List<Login>  valilogin =new ArrayList<Login>();
	/*private List<Login>  valilogin =new ArrayList<Login>();*/
	// usuarios
	private Session session;
	private Transaction transacion;
	
	private List<Usuario> usuarios= new ArrayList<Usuario>();

	private Usuario selecUsuario= new Usuario();
	
	private Usuario usuario= new Usuario();
	
	private Usuario usuario1= new Usuario();
	
	private String nombrecompleto="";
	
	private String pass="";
	
	private String repass="";
	@ManagedProperty(value = "#{loginService}")
	private LoginService loginService;
	
	@ManagedProperty(value = "#{usuarioService}")
	private UsuarioService usuarioService;
	
	@PostConstruct
	public void init() throws Exception{
		logins = Lists.newArrayList(
				loginService.getLoginRepository().findAll());

	}

	public List<Login> getLogins() {
		logins = Lists.newArrayList(
				loginService.getLoginRepository().findAll());
		return logins;
	}

	
	public void setLogins(List<Login> logins) {
		this.logins = logins;
	}

	public Login getSelecLogin() {
		return selecLogin;
	}

	public void setSelecLogin(Login selecLogin) {
		this.selecLogin = selecLogin;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public LoginManagedBean()
	{

			HttpSession misession=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			misession.setMaxInactiveInterval(600);
		
		
	}
	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Transaction getTransacion() {
		return transacion;
	}

	public void setTransacion(Transaction transacion) {
		this.transacion = transacion;
	}

	public String login(){
		this.session=null;
		this.transacion=null;
		
		{
			HttpSession misession=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		}
		
		return email;
		
	}
	
	public String  validar() throws Exception {
		// TODO Auto-generated method stub
        String encriptado = Encripcion.Encriptar(usuario.getD_password());
		
		valido = loginService.
				getLoginRepository().findbyEmailandPassword(login.getEmail(), encriptado);

		
		if (valido==null || valido.isEmpty()) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					"Usuario y/o Contraseña incorrectos"
					));
			
			return "/logueo.xhtml";
		}else {
			usuarios=usuarioService.getUsuarioRepository().findbyUser(login.getEmail());
			usuario1=usuarios.get(0);
			nombrecompleto=usuario1.getA_firstname() + " " + usuario1.getB_lastname(); 
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					"Bienvenido " +nombrecompleto + " actualizado"
					));
			return "/welcome.xhtml?faces-redirect=true";
		}
	}

	
	public String  unlock() {
		// TODO Auto-generated method stub
		email=usuario1.getC_email();
        String encriptado = Encripcion.Encriptar(password);
		valido = loginService.
				getLoginRepository().findbyEmailandPassword(email, encriptado);

		
		
		if (valido==null || valido.isEmpty()) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					"ingresa password correcto"
					));
			
			return "/login_out.xhtml";
		}else {

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					"Bienvenido " +nombrecompleto + " actualizado"
					));
			return "/welcome.xhtml?faces-redirect=true";
		}
	}
	
	public String  cambiarpass() {
		if(pass.length()>0 && repass.length()>0){
			if(pass.equals(repass)){
				usuario1.setD_password(pass);
				usuarioService.getUsuarioRepository().save(usuario1);
				loginService.getLoginRepository().update(usuario1.getId(),usuario1.getD_password(),usuario1.getC_email());
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage(
						"Password de " + usuario1.getC_email()+ " actualizado"
						));
			}else{
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage(
						"Los password no coinciden ,ingresar un password valido"
						));
			}	
		}else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					"Ingresar un password valido"
					));
		}
		
		
		
		return null;
	}
	
	
	public List<Login> getValido() {
		return valido;
	}

	public void setValido(List<Login> valido) {
		this.valido = valido;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getSelecUsuario() {
		return selecUsuario;
	}

	public void setSelecUsuario(Usuario selecUsuario) {
		this.selecUsuario = selecUsuario;
	}



	public Usuario getUsuario1() {
		return usuario1;
	}

	public void setUsuario1(Usuario usuario1) {
		this.usuario1 = usuario1;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public String getNombrecompleto() {
		return nombrecompleto;
	}

	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRepass() {
		return repass;
	}

	public void setRepass(String repass) {
		this.repass = repass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Login> getValilogin() {
		return valilogin;
	}

	public void setValilogin(List<Login> valilogin) {
		this.valilogin = valilogin;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	

	
	
	
}
