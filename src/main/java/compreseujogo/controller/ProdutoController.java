package compreseujogo.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

import compreseujogo.facade.Facade;
import compreseujogo.model.entity.Categoria;
import compreseujogo.model.entity.Fornecedor;
import compreseujogo.model.entity.Loja;
import compreseujogo.model.entity.Marca;
import compreseujogo.model.entity.Plataforma;
import compreseujogo.model.entity.Produto;

@RequestScoped
@ManagedBean(name = "produtoBean")
public class ProdutoController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Produto produto;
	private List<Produto> lista;
	private List<Categoria> categorias;
	private List<Fornecedor> fornecedores;
	private List<Marca> marcas;
	private List<Plataforma> plataformas;
	private UploadedFile file;

	public ProdutoController() {
		this.produto = new Produto();
		this.produto.setCategoria(new Categoria());
		this.produto.setFornecedor(new Fornecedor());
		this.produto.setLoja(new Loja());
		this.produto.setMarca(new Marca());
		this.produto.setPlataforma(new Plataforma());
		this.lista = new ArrayList<Produto>();
		this.categorias = new ArrayList<Categoria>();
		this.fornecedores = new ArrayList<Fornecedor>();
		this.marcas = new ArrayList<Marca>();
		this.plataformas = new ArrayList<Plataforma>();
	}

	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		Facade facade = new Facade();
		System.out.println(produto);
		try {
			context.addMessage(null, new FacesMessage(facade.salvarProduto(produto), FacesMessage.FACES_MESSAGES));
			return "listaProduto?faces-redirect=true";
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		return null;
	}

	public String crud() {
		return "listaProduto?faces-redirect=true";
	}

	public String alterar(Produto produto) {
		System.out.println("Produto"+produto);
		this.produto = produto;
		return "cadastroProduto.xhtml";
	}

	public void excluir(Produto produto) {
		this.produto = produto;
	}

	public void upload(FileUploadEvent event) {
		String nome = file.getFileName();
		System.out.println(file.getFileName());
		System.out.println(nome);
		produto.setImagem(nome);
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getLista() {
		FacesContext context = FacesContext.getCurrentInstance();
		Facade facade = new Facade();
		try {
			lista = facade.listaProduto("", produto);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		return lista;
	}

	public void setLista(List<Produto> lista) {
		this.lista = lista;
	}

	public List<Categoria> getCategorias() {
		FacesContext context = FacesContext.getCurrentInstance();
		Facade facade = new Facade();
		try {
			categorias = facade.listaCategoria(null);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public List<Fornecedor> getFornecedores() {
		FacesContext context = FacesContext.getCurrentInstance();
		Facade facade = new Facade();
		try {
			fornecedores = facade.listarFornecedorNome(null);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public List<Marca> getMarcas() {
		FacesContext context = FacesContext.getCurrentInstance();
		Facade facade = new Facade();
		try {
			marcas = facade.listaMarca(null);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		return marcas;
	}

	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}

	public List<Plataforma> getPlataformas() {
		FacesContext context = FacesContext.getCurrentInstance();
		Facade facade = new Facade();
		try {
			plataformas = facade.listaPlataforma(null);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		return plataformas;
	}

	public void setPlataformas(List<Plataforma> plataformas) {
		this.plataformas = plataformas;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}
}
