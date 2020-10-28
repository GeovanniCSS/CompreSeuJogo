package compreseujogo.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import compreseujogo.facade.Facade;
import compreseujogo.model.bo.ProdutoBo;
import compreseujogo.model.dao.GenericDao;
import compreseujogo.model.entity.Plataforma;
import compreseujogo.model.entity.Produto;

public class ProdutoTest {

	
	@Test
	public void novoProduto() throws Exception {
		GenericDao<Plataforma> gDao = new GenericDao<Plataforma>(); 
		Facade facade = new Facade();
		Plataforma plataforma = gDao.findById(Plataforma.class, 3);
		Produto produto = new Produto(0, "Rico", "Deve ser apagado", 150.0, 125, 1502, "", true, 1,
				null, null, plataforma, null, null, null);
		facade.salvarProduto(produto);
		boolean teste = false;
		if(produto.getId()>0) {
			teste = true;
		}
		assertEquals(true, teste);
	}
	/*
	@Test
	public void lista() throws Exception {
		ProdutoBo bo = new ProdutoBo();
		Produto produto = new Produto();
		Plataforma plataforma = new Plataforma();
		plataforma.setId(1);
		produto.setPlataforma(plataforma);
		bo.list("Plataforma", produto).forEach(System.out::println);
		int i = bo.list("Plataforma", produto).size();
		System.out.println("Tamanho: "+i);
	}
	*/
}
