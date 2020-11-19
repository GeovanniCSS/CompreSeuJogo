package compreseujogo.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import compreseujogo.model.entity.Venda;
import compreseujogo.util.Fabrica;

public class VendaDao {

	private static EntityManager em = Fabrica.getEntityManager();

	public List<Venda> list(String parameter, Venda venda) {
     Query q = null;
		 if (parameter.equals("Cliente")) {
			    q = em.createQuery("SELECT v FROM Venda v WHERE v.cliente.id = :cliente ORDER BY v.dataCadastro");
			    q.setParameter("cliente", venda.getCliente().getId());
          }
		return q.getResultList();
    }

}
