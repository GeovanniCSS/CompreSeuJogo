package compreseujogo.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import compreseujogo.model.entity.Cliente;
import compreseujogo.util.Fabrica;

public class ClienteDao {

	public List<Cliente> list(String parameter, Cliente cliente) throws Exception {
		EntityManager em = Fabrica.getEntityManager();
		Query q = null;

		return q.getResultList();
	}
}
