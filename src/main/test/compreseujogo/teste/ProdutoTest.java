package compreseujogo.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import compreseujogo.facade.Facade;
import compreseujogo.model.entity.Plataforma;
import compreseujogo.model.entity.Produto;

public class ProdutoTest {

	
	@Test
	public void novoProduto() throws Exception {
		Facade facade = new Facade();
		
		Produto produto = new Produto(0, "Teste", "Deve ser apagado", null, 150.0, 15, 0, "", true, 0,
				LocalDate.now(), null, null, null, null, null);
		facade.inserirProduto(produto);
		boolean teste = false;
		if(produto.getId()>0) {
			teste = true;
		}
		assertEquals(true, teste);
	}
}
