package compreseujogo.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import compreseujogo.model.entity.Produto;

@RequestScoped
@ManagedBean(name = "produtoBean")
public class ProdutoController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Produto produto;
	private List<Produto> lista;
	
	public ProdutoController() {
		this.produto = new Produto();
		this.lista = new ArrayList<Produto>();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getLista() {
		return lista;
	}

	public void setLista(List<Produto> lista) {
		this.lista = lista;
	}
}
