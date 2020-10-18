package compreseujogo.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import compreseujogo.model.entity.Fornecedor;

@RequestScoped
@ManagedBean(name = "fornecedorBean")
public class FornecedorController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Fornecedor fornecedor;
	private List<Fornecedor> lista;
	
	public FornecedorController() {
		this.fornecedor = new Fornecedor();
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Fornecedor> getLista() {
		return lista;
	}

	public void setLista(List<Fornecedor> lista) {
		this.lista = lista;
	}
}
