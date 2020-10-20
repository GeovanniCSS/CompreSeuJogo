package compreseujogo.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import compreseujogo.model.entity.Comissao;
import compreseujogo.util.Fabrica;

public class ComissaoDao {

	private static EntityManager em = Fabrica.getEntityManager();

	public List<Comissao> list(String parameter, Comissao comissao) {
		Query a = em.createQuery("select c from Comissao c");

		return a.getResultList();
	}

}
