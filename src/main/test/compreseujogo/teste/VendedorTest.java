package compreseujogo.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import compreseujogo.facade.Facade;
import compreseujogo.model.entity.Sexo;
import compreseujogo.model.entity.Vendedor;

public class VendedorTest {

	@Test
	public void novoVendedor() throws Exception {
		Facade facade = new Facade();
		Vendedor vendedor = new Vendedor(0, "Jennifer", "Luciana Isabela Duarte",
				"jjenniferlucianaisabeladuarte@vnews.com.br", "1234", null, "Praça General Osório 45", "(41) 99108-8676", "80020-930",
				"296.416.029-50", true, "PR", "Curitiba", "Centro", Sexo.Masculino, null, null);
		facade.inserirVendedor(vendedor);
		boolean teste = false;
		if(vendedor.getId()>0) {
			teste = true;
		}
		assertEquals(true, teste);
	}
}
