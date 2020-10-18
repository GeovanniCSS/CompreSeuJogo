package compreseujogo.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import compreseujogo.model.entity.EntityBase;
import compreseujogo.model.entity.Fornecedor;

public class FornecedorDao {
	
	private static EntityManager em = Fabrica.getEntityManager();

	public List <Fornecedor> list(String parameter, EntityBase obj) {
		Fornecedor fornecedor = (Fornecedor) obj;
		Query q= null;
		
		
		return q.getResultList();
	}
	
	
}
