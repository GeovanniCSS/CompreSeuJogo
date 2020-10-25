package compreseujogo.controller;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import compreseujogo.facade.Facade;
import compreseujogo.model.bo.VendedorBo;
import compreseujogo.model.entity.Estado;
import compreseujogo.model.entity.Sexo;
import compreseujogo.model.entity.Vendedor;
import compreseujogo.viacep.WebServiceCep;


@ManagedBean(name="vendedorBean")
@RequestScoped
public class VendedorController implements Serializable {
	
	private Vendedor vendedor;

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
	public VendedorController(){
		vendedor = new Vendedor();
	}
	
	public void buscaCep() {
		WebServiceCep w = WebServiceCep.searchCep(vendedor.getCep());
				
		vendedor.setCidade(w.getCidade());
		vendedor.setEndereco(w.getLogradouro());
		//vendedor.setEstado(w.getUf());
		vendedor.setBairro(w.getBairro());
		
		System.out.println(w.getCidade());
	}

	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		

		try {
			Facade facade = new Facade();
			facade.inserirVendedor(this.vendedor);
				
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
				e.getMessage(),""));
			return "vendedor";
		}	
		
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
			"Atendimento salvo com sucesso!", "SUCESSO"));		
		return "sucesso";
	}
	
	public Sexo[] getSexo() {
		return Sexo.values();
	}
	
	public Estado[] getEstado() {
		return Estado.values();
	}
}
