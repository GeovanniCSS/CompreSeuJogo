package compreseujogo.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import compreseujogo.model.entity.Avaliacao;


@RequestScoped
@ManagedBean(name = "avaliacaoBean")
public class AvaliacaoController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Avaliacao avaliacao;
	private List<Avaliacao> lista;

	public AvaliacaoController() {
		this.avaliacao = new Avaliacao();
		this.lista = new ArrayList<Avaliacao>();
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	public List<Avaliacao> getLista() {
		return lista;
	}

	public void setLista(List<Avaliacao> lista) {
		this.lista = lista;
	}
}
