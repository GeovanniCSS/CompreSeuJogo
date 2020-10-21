package compreseujogo.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import compreseujogo.model.entity.Tipo;
import compreseujogo.util.Fabrica;

public class TipoDao<T extends Tipo> {

	private static EntityManager em = Fabrica.getEntityManager();

	public List<Tipo> list(String parameter, Tipo tipo, Class<T> classe) {

		Query q = null;
		if (parameter.equals("organizada")) {
			q = em.createQuery("SELECT t FROM "+ classe.getSimpleName().toString()+" t ORDER BY t.nome");
		} else if (parameter.equals("novo")) {
			q = em.createQuery("SELECT t FROM  "+ classe.getSimpleName().toString()+" t WHERE t.nome = :nome");
			q.setParameter("nome", tipo.getNome());
		}
		return q.getResultList();
	}

}