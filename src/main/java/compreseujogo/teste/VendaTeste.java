package compreseujogo.teste;

import java.time.LocalDate;

import compreseujogo.model.bo.VendaBo;
import compreseujogo.model.entity.Transporte;
import compreseujogo.model.entity.Venda;



public class VendaTeste {

	public static void main(String[] args) {
		VendaBo bo = new VendaBo();
		
		Transporte transporte = new Transporte();
		transporte.setId(3);
		
		
		Venda venda = new Venda();
		venda.setDataCadastro(LocalDate.now());
		
		try {
			System.out.println(bo.saveOrUpdate(venda));
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
