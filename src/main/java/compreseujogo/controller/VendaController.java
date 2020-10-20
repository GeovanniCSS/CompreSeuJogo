package compreseujogo.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import compreseujogo.model.entity.Venda;

@RequestScoped
@ManagedBean(name = "vendaBean")
public class VendaController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Venda venda;
	private List<Venda> lista;

	public VendaController() {
		super();
		this.venda = new Venda();
		this.lista = new ArrayList<Venda>();
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
}
