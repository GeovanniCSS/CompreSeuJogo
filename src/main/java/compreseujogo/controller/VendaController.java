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
import compreseujogo.model.entity.Cliente;
import compreseujogo.model.entity.Transporte;
import compreseujogo.model.entity.Venda;

@RequestScoped
@ManagedBean(name = "vendaBean")
public class VendaController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Venda venda;
	private List<Venda> lista;
	private List<Transporte> transporte;
	
	public VendaController() {
		super();
		this.venda = new Venda();
		this.lista = new ArrayList<Venda>();
		this.transporte = new ArrayList<Transporte>();
	}
	
	public void salvar(Cliente cliente) {
		FacesContext context = FacesContext.getCurrentInstance();
		Facade facade = new Facade();
		venda.setCliente(cliente);
		try {
			context.addMessage(null, new FacesMessage(facade.novaVenda(venda), FacesMessage.FACES_MESSAGES));
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}
	
	public String selecionar(Venda venda){
		return "";
	}
	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public List<Venda> getLista() {
		return lista;
	}

	public void setLista(List<Venda> lista) {
		this.lista = lista;
	}
		
	public List<Transporte> getTransporte() {
		return transporte;
	}

	public void setTransporte(List<Transporte> transporte) {
		this.transporte = transporte;
	}

	@PostConstruct
	public void carregarLista() {
		FacesContext context = FacesContext.getCurrentInstance();
		Facade facade = new Facade();
		try {
			transporte = facade.listaTransporte(null);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}
}
