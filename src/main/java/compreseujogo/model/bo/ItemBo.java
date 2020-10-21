package compreseujogo.model.bo;

import java.util.List;

import compreseujogo.model.dao.GenericDao;
import compreseujogo.model.dao.ItemDao;
import compreseujogo.model.entity.Cliente;
import compreseujogo.model.entity.EntityBase;
import compreseujogo.model.entity.Item;
import compreseujogo.model.entity.Produto;

public class ItemBo<T extends Item> {

	private void validarDados(Item item) throws Exception {
		if (item.getId() < 0) {
			throw new Exception("Id n�o pode ser negativo!");
		} else if (item.getQuantidade() < 1) {
			throw new Exception("A quantidade m�nima � 1");
		}

	}

	public List<Item> listar(String parameter, Item item) throws Exception {
		try {
			if (parameter.equals("")) {
				GenericDao<Item> pDao = new GenericDao<Item>();
				return pDao.list(Item.class);
			} else {
				ItemDao itemDao = new ItemDao();
				return itemDao.listar(parameter, item);
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());

		}
	}

	public String saveOrUpdate(EntityBase obj) throws Exception {
		Item item = (Item) obj;
		validarDados(item);
		GenericDao<Item> tcDao = new GenericDao<Item>();
		try {
			return tcDao.saveOrUpdate(item);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String remove(EntityBase obj) throws Exception {
		Item item = (Item) obj;
		GenericDao<Item> tcDao = new GenericDao<Item>();
		try {
			return tcDao.remove(Item.class, item.getId());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}