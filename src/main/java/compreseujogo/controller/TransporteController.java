package compreseujogo.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import compreseujogo.facade.Facade;
import compreseujogo.model.bo.TransporteBo;
import compreseujogo.model.entity.Estado;
import compreseujogo.model.entity.Transporte;



@ManagedBean(name="transporteBean")
@RequestScoped
public class TransporteController implements Serializable {
	
	private Transporte transporte;

	public Transporte getTransporte() {
		return transporte;
	}

	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}

	public TransporteController() {
		transporte = new Transporte();
	}
	

	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {

			Facade facade = new Facade();
			facade.salvarTransporte(this.transporte);
				
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
				e.getMessage(),""));
			//return "transporte";
		}	
		
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
			"Atendimento salvo com sucesso!", "SUCESSO"));		
		//return "sucesso";
	}
	
	public Estado[] getEstado() {
		return Estado.values();
	}

}
