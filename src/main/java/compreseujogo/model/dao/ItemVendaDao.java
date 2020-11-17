package compreseujogo.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import compreseujogo.model.entity.ItemVenda;
import compreseujogo.util.Fabrica;

public class ItemVendaDao {
  
  private static EntityManager em = Fabrica.getEntityManager();

	public List<ItemVenda> list(String parameter, ItemVenda Item) {
     Query q = null;
		 if (parameter.equals("Nota")) {
			    q = em.createQuery("SELECT item FROM ItemVenda item WHERE item.venda.cliente.id = :cliente AND item.produto.id = :produto");
			    q.setParameter("cliente", item.getVenda().getCliente().getId());
          q.setParameter("produto", item.getProduto().getId());
          }
		return q.getResultList();
    }
}
