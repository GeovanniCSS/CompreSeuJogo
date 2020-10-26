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
import compreseujogo.model.bo.ClienteBo;
import compreseujogo.model.bo.VendedorBo;
import compreseujogo.model.entity.Cliente;
import compreseujogo.model.entity.Estado;
import compreseujogo.model.entity.Sexo;


@ManagedBean(name = "clienteBean")
@RequestScoped
public class ClienteController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Cliente cliente;
	private List<Cliente> lista;

	public ClienteController() {
		super();
		this.cliente = new Cliente();
		this.lista = new ArrayList<Cliente>();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getLista() {
		return lista;
	}

	public void setLista(List<Cliente> lista) {
		this.lista = lista;
	}

	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		
				
		
;
		try {
			Facade facade = new Facade();
			facade.inserirCliente(this.cliente);
				
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
				e.getMessage(),""));
			return "vendedor";
		}	
		
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
			"Atendimento salvo com sucesso!", "SUCESSO"));		
		return "sucesso";
	}
	
	public Sexo[] getSexo() {
		return Sexo.values();
	}

	public Estado[] getEstado() {
		return Estado.values();
	}
}
