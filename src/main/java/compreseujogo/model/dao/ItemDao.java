package compreseujogo.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import compreseujogo.model.entity.Item;
import compreseujogo.util.Fabrica;

public class ItemDao<T extends Item> {

	private static EntityManager em = Fabrica.getEntityManager();

	public List<Item> listar(String parametro, Item item) throws Exception {

		Query q = null;
		if (parametro.equals("")) {

		}
		return q.getResultList();
	}
}
