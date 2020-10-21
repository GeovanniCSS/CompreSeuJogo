package compreseujogo.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import compreseujogo.facade.Facade;
import compreseujogo.model.entity.Administrador;

@SessionScoped
@ManagedBean(name = "administradorBean")
public class AdministradorController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Administrador administrador;
	private List<Administrador> lista;

	public AdministradorController() {
		super();
		this.administrador = new Administrador();
		this.lista = new ArrayList<Administrador>();
	}
	
	public String login() {
		FacesContext context = FacesContext.getCurrentInstance();
		Facade facade = new Facade();
		try {
			context.addMessage(null, new FacesMessage(facade.loginAdminstrador(administrador), FacesMessage.FACES_MESSAGES));
			return "cadastroProduto.xhtml?faces-redirect=true";
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
		return null;
	}
	public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/home.xhtml?faces-redirect=true";
    }
	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public List<Administrador> getLista() {
		return lista;
	}

	public void setLista(List<Administrador> lista) {
		this.lista = lista;
	}

}
