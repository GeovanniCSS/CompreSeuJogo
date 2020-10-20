package compreseujogo.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import compreseujogo.model.entity.Avaliacao;
import compreseujogo.util.Fabrica;

public class AvaliacaoDao {

	private static EntityManager em = Fabrica.getEntityManager();

	public List<Avaliacao> list(String parameter, Avaliacao avaliacao) {
		Query q = null;
		if (parameter.equals("Produto")) {
			q = em.createQuery("SELECT a FROM Avaliacao a WHERE a.produto.id = :produto");
			q.setParameter("produto", avaliacao.getProduto().getId());
		}
		return q.getResultList();
	}

}
