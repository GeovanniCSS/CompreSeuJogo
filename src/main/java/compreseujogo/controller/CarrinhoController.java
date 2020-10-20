package compreseujogo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import compreseujogo.model.entity.Carrinho;

@RequestScoped
@ManagedBean(name = "carrinhoBean")
public class CarrinhoController {

	private Carrinho carrinho;
	private List<Carrinho> lista;

	public CarrinhoController() {
		this.carrinho = new Carrinho();
		this.lista = new ArrayList<Carrinho>();
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public List<Carrinho> getLista() {
		return lista;
	}

	public void setLista(List<Carrinho> lista) {
		this.lista = lista;
	}

}
