package compreseujogo.teste;


import java.time.LocalDate;
import java.util.Date;

import compreseujogo.model.bo.VendedorBo;
import compreseujogo.model.entity.Sexo;
import compreseujogo.model.entity.Vendedor;


public class VendedorTeste {

	public static void main(String[] args) {
		VendedorBo bo = new VendedorBo();
		Vendedor vendedor = new Vendedor();

		try {
			System.out.println(bo.newUser(vendedor, Vendedor.class));
		} catch (Exception e) {
			// TODO Auto-generated catch block

		//Vendedor vendedor = new Vendedor();
		
		vendedor.setNome("Pegapega");
		vendedor.setCpf("565656565");
	
		
		
		try {
			System.out.println(bo.saveOrUpdate(vendedor));
		} catch (Exception i) {

			e.printStackTrace();
		}

	 }
	}
}


