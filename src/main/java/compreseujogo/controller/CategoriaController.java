package compreseujogo.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import compreseujogo.model.entity.Categoria;

@RequestScoped
@ManagedBean(name = "categoriaBean")
public class CategoriaController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Categoria categoria;
	private List<Categoria> lista;

	public CategoriaController(Categoria categoria) {
		this.categoria = new Categoria();
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getLista() {
		return lista;
	}

	public void setLista(List<Categoria> lista) {
		this.lista = lista;
	}
}
