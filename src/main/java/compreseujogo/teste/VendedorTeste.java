package compreseujogo.teste;

import compreseujogo.model.bo.VendedorBo;
import compreseujogo.model.entity.Sexo;
import compreseujogo.model.entity.Vendedor;

public class VendedorTeste {

	public static void main(String[] args) {
		VendedorBo bo = new VendedorBo();
		Vendedor vendedor = new Vendedor(0,"Vendedor","Vendas","vendedor@gmail.com","1234",null,"Rua vendedor"
				,"95858585","45465456","152",true,"PR","Curitiba","Portão",Sexo.Masculino,null,null);

		try {
			System.out.println(bo.newUser(vendedor, Vendedor.class));
		} catch (Exception e) {

		}
	}
}
