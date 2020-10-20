package compreseujogo.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import compreseujogo.model.entity.Administrador;
import compreseujogo.util.Fabrica;

public class AdministradorDao {

	public List<Administrador> list(String parameter, Administrador cliente) throws Exception {
		EntityManager em = Fabrica.getEntityManager();
		Query q = null;

		return q.getResultList();
	}

}
