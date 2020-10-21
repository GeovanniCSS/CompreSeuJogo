package compreseujogo.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import compreseujogo.facade.Facade;
import compreseujogo.model.entity.Plataforma;

@RequestScoped
@ManagedBean(name ="plataformaBean")
public class PlataformaController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Plataforma plataforma;
	private List<Plataforma> lista;
	
	public PlataformaController() {
		this.plataforma = new Plataforma();
		this.lista = new ArrayList<Plataforma>();
	}
	
	@PostConstruct
	public void carregarLista() {
		FacesContext context = FacesContext.getCurrentInstance();
		Facade facade = new Facade();
		try {
			lista = facade.listaPlataforma(plataforma);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}
	
	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		Facade facade = new Facade();
		
		try {
			context.addMessage(null, new FacesMessage(facade.inserirPlataforma(plataforma),FacesMessage.FACES_MESSAGES));
			return "";
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		return null;
	}

	public Plataforma getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}

	public List<Plataforma> getLista() {
		return lista;
	}

	public void setLista(List<Plataforma> lista) {
		this.lista = lista;
	}
	
}
