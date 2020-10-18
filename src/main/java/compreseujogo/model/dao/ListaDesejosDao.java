package compreseujogo.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import compreseujogo.model.entity.ListaDesejos;

public class ListaDesejosDao {

	private static EntityManager em = Fabrica.getEntityManager();

	public List<ListaDesejos> list(String parameter, ListaDesejos lista) {

		Query a = em.createQuery("select l from ListaDesejos l");

		return a.getResultList();
	}

}
