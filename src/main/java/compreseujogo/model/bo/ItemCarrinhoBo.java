package compreseujogo.model.bo;

import java.util.List;

import compreseujogo.model.dao.GenericDao;
import compreseujogo.model.dao.ItemCarrinhoDao;
import compreseujogo.model.entity.ItemCarrinho;



public class ItemCarrinhoBo extends ItemBo {
	
	private ItemCarrinhoDao dao;

	public List<ItemCarrinho> listar(String parameter, ItemCarrinho itemCarrinho) throws Exception {
		try {
			if (parameter.equals("")) {
				GenericDao<ItemCarrinho> itemDao = new GenericDao<ItemCarrinho>();
				return itemDao.list(ItemCarrinho.class);
			} else {
				ItemCarrinhoDao itemDao = new ItemCarrinhoDao();
				return itemDao.listar(parameter, itemCarrinho);
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());

		}
	}

	public String novo(ItemCarrinho item) throws Exception {
		if(item.getProduto().getQuantEstoque() < item.getQuantidade()) {
			throw new Exception("No momento não temos esse quantidade do produto em estoque");
		}
		return saveOrUpdate(item);
	}

}
