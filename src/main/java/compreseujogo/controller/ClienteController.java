package compreseujogo.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import compreseujogo.model.entity.Cliente;

@SessionScoped
@ManagedBean(name = "clienteBean")
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

}
