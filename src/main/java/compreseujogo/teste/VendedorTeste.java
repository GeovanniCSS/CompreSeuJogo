package compreseujogo.teste;

import compreseujogo.model.bo.VendedorBo;
import compreseujogo.model.entity.Sexo;
import compreseujogo.model.entity.Vendedor;

public class VendedorTeste {

	public static void main(String[] args) {
		VendedorBo bo = new VendedorBo();
		Vendedor vendedor = new Vendedor(0, "Jennifer", "Luciana Isabela Duarte",
				"jjenniferlucianaisabeladuarte@vnews.com.br", "1234", null, "Praça General Osório 45",
				"(41) 99108-8676", "80020-930", "296.416.029-50", true, "PR", "Curitiba", "Centro", Sexo.Masculino,
				null, null);

		try {
			System.out.println(bo.newUser(vendedor, Vendedor.class));
		} catch (Exception e) {

		}
	}
}
