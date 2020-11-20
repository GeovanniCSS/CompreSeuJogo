package compreseujogo.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import compreseujogo.facade.Facade;
import compreseujogo.model.bo.ItemCarrinhoBo;
import compreseujogo.model.dao.GenericDao;
import compreseujogo.model.entity.Cliente;
import compreseujogo.model.entity.ItemCarrinho;
import compreseujogo.model.entity.Produto;

public class ItemCarrinhoTest {

	public MockitoRule mockitoRule = MockitoJUnit.rule();

	private ItemCarrinho item;

	/*
	@Test
	public void novo() {
		Produto produto = new GenericDao<Produto>().findById(Produto.class, 2);
		Cliente cliente = new GenericDao<Cliente>().findById(Cliente.class, 1);
		item = new ItemCarrinho();
		item.setCarrinho(cliente.getCarrinho());
		item.setProduto(produto);
		item.setDataAdicionado(LocalDate.now());
		item.setQuantidade(2);
		try {
			new Facade().adicionarItemCarrinho(item);

			boolean teste = false;
			if (item.getId() > 0) {
				teste = true;
			}
			new Facade().removerItemCarrinho(item);
			System.out.println(item);
			assertEquals(true, teste);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/

	@Test
	public void removerV() throws Exception {
		List<ItemCarrinho> itens = new ArrayList<ItemCarrinho>();
		for (int i = 11; i == 13; i++) {
			itens.add(new GenericDao<ItemCarrinho>().findById(ItemCarrinho.class, 11));
			itens.forEach(item -> System.out.println(item.getProduto().getNome()));
		}
		itens.forEach(item -> System.out.println(item.getProduto().getNome()));
		new ItemCarrinhoBo().apagarItens(itens);
		assertEquals(0, itens.size());
		itens.forEach(item -> System.out.println(item.getProduto().getNome()));
		System.out.println("oi");
	}
	@Test
	public void remove() {
		
	}
}
