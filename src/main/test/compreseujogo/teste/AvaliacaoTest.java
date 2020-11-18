package compreseujogo.teste;

import org.junit.jupiter.api.Test;

import compreseujogo.facade.Facade;
import compreseujogo.model.entity.Avaliacao;
import compreseujogo.model.entity.Produto;

public class AvaliacaoTest {
	
	@Test
	public void list() throws Exception {
		Facade facade = new Facade();
		Avaliacao avaliacao= new Avaliacao();
		Produto produto = new Produto();
		produto.setId(2);
		avaliacao.setProduto(produto);
		facade.listaAvaliacao("Produto", avaliacao).forEach(System.out::println);;
	}

}
