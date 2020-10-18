package compreseujogo.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import compreseujogo.model.entity.Plataforma;

@RequestScoped
@ManagedBean(name ="plataformaBean")
public class PlataformaController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Plataforma plataforma;
	private List<Plataforma> lista;
	
	public PlataformaController() {
		this.plataforma = new Plataforma();
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
