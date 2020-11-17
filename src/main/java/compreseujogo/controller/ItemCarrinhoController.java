package compreseujogo.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import compreseujogo.facade.Facade;
import compreseujogo.model.entity.Cliente;
import compreseujogo.model.entity.ItemCarrinho;
import compreseujogo.model.entity.Produto;

@RequestScoped
@ManagedBean(name = "itemCarrinhoBean")
public class ItemCarrinhoController implements Serializable {

	private static final long serialVersionUID = 1L;

	private ItemCarrinho item;
	private List<ItemCarrinho> lista;

	public ItemCarrinhoController() {
		super();
		this.item = new ItemCarrinho();
		item.setProduto(new Produto());
		this.lista = new ArrayList<ItemCarrinho>();
	}

	public String salvar(Produto produto, Cliente cliente) {
		FacesContext context = FacesContext.getCurrentInstance();
		Facade facade = new Facade();
		if (cliente.equals(null)) {
			return "index.xhtml?faces-redirect=true";
		}
		try {
			item.setCarrinho(cliente.getCarrinho());
			item.setProduto(produto);
			item.getProduto();
			context.addMessage(null, new FacesMessage(facade.adicionarItemCarrinho(item), FacesMessage.FACES_MESSAGES));
			return "index.xhtml?faces-redirect=true";
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		return "visualizarProduto.xhtml?id=" + produto.getId() + "&faces-redirect=true";
	}

	private String retornoIndex(Cliente cliente) {
		if (cliente.equals(null)) {
			return "index.xhtml?faces-redirect=true";
		} else {
			return null;
		}

	}

	public ItemCarrinho getItem() {
		return item;
	}

	public void setItem(ItemCarrinho item) {
		this.item = item;
	}

	public List<ItemCarrinho> getLista() {
		return lista;
	}

	public void setLista(List<ItemCarrinho> lista) {
		this.lista = lista;
	}
}
