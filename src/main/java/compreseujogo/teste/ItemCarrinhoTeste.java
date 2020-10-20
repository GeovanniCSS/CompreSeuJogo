package compreseujogo.teste;

import compreseujogo.model.bo.ItemCarrinhoBo;
import compreseujogo.model.dao.GenericDao;
import compreseujogo.model.entity.Carrinho;
import compreseujogo.model.entity.ItemCarrinho;
import compreseujogo.model.entity.Produto;

public class ItemCarrinhoTeste {

	public static void main(String[] args) {
		ItemCarrinhoBo bo = new ItemCarrinhoBo();
		GenericDao<Produto> genericP = new GenericDao<Produto>();
		Produto produto = genericP.findById(Produto.class, 1);
		GenericDao<Carrinho> genericC = new GenericDao<Carrinho>();
		Carrinho carrinho = genericC.findById(Carrinho.class, 1);

		ItemCarrinho item = new ItemCarrinho();

		try {
			// System.out.println(bo.novo(itemCarrinho));
			// System.out.println(bo.saveOrUpdate(itemCarrinho));
			bo.listar("Carrinho", item).forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
