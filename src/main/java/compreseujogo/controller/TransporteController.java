package compreseujogo.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import compreseujogo.facade.Facade;
import compreseujogo.model.entity.Cliente;
import compreseujogo.model.entity.Estado;
import compreseujogo.model.entity.Transporte;
import compreseujogo.model.entity.Vendedor;



@ManagedBean(name="transporteBean")
@SessionScoped
public class TransporteController implements Serializable {
	
	private Transporte transporte;
	private List<Transporte> lista;
	
	

	public List<Transporte> getLista() throws Exception {
		Facade facade = new Facade();
		lista = facade.listaTransporte(transporte);
		return lista;
	}

	public void setLista(List<Transporte> lista) {
		this.lista = lista;
	}

	public Transporte getTransporte() {
		return transporte;
	}

	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}

	public TransporteController() {
		transporte = new Transporte();
		this.lista = new ArrayList<Transporte>();
	}
	

	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		Facade facade = new Facade();		
		try {
			context.addMessage(null,
					new FacesMessage(facade.salvarTransporte(this.transporte),FacesMessage.FACES_MESSAGES));
			transporte = new Transporte();
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}		
		
		transporte = new Transporte();
	}
	
	public Estado[] getEstado() {
		return Estado.values();
	}
	
	public List<Transporte> carregarLista() {
		FacesContext context = FacesContext.getCurrentInstance();
		Facade facade = new Facade();
		try {
			return facade.listaTransporte(transporte);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		return lista;
	}
	
	public String alterar(Transporte t) {
		this.transporte = t;
		return "alterarTransportadora.xhtml";
	}
	
	public String atualizarStatus() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		Facade facade = new Facade();
		try {
			context.addMessage(null,
					new FacesMessage(facade.atualizarTransporte(this.transporte), FacesMessage.FACES_MESSAGES));
			transporte = new Transporte();
			
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		
		return "listaTransportadora.xhtml";
	}


}
