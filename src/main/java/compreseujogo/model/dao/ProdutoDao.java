package compreseujogo.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import compreseujogo.model.entity.Produto;
import compreseujogo.util.Fabrica;

public class ProdutoDao {

	private static EntityManager em = Fabrica.getEntityManager();

	public List<Produto> list(String parametro, Produto produto) throws Exception {
		Query q = null;
		if (parametro.equals("Categoria")) {
			q = em.createQuery("SELECT p FROM Produto p WHERE p.categoria.id = :id");
			q.setParameter("id", produto.getCategoria().getId());
		} else if (parametro.equals("Plataforma")) {
			q = em.createQuery("SELECT p FROM Produto p WHERE p.plataforma.id = :id");
			q.setParameter("id", produto.getPlataforma().getId());
		} else if (parametro.equals("Marca")) {
			q = em.createQuery("SELECT p FROM Produto p WHERE p.marca.id = :id");
			q.setParameter("id", produto.getMarca().getId());
		} else if (parametro.equals("nome")) {
			q = em.createQuery("SELECT p FROM Produto p WHERE p.nome = :id");
			q.setParameter("id", produto.getNome());
		} else if (parametro.equals("SKU")) {
			q = em.createQuery("SELECT p FROM Produto p WHERE p.sku = :id");
			q.setParameter("id", produto.getSku());
		} else if (parametro.equals("EAN")) {
			q = em.createQuery("SELECT p FROM Produto p WHERE p.EAN = :id");
			q.setParameter("id", produto.getEAN());
		} else if (parametro.equals("listaIndex")) {
			q = em.createQuery("SELECT p FROM Produto p WHERE p.categoria.ativo = true AND p.plataforma.ativo = true AND "+
					   "p.marca.ativo = true AND p.imagem != null AND p.ativo = true AND p.quantEstoque > 0");
		} 
		return q.getResultList();
	}
	public List<Produto> listSearch(String parameter, String filter) throws Exception {
		Query q = null;
		if (filter.equals("")) {
			q = em.createQuery("SELECT p FROM Produto p WHERE p.categoria.ativo = true AND p.plataforma.ativo = true AND "+
					   "p.marca.ativo = true AND p.imagem != null AND p.ativo = true AND p.quantEstoque > 0");
		} else if (!filter.equals("")) {
			q = em.createQuery("SELECT p FROM Produto p WHERE p.categoria.ativo = true AND p.plataforma.ativo = true AND "+
					   "p.marca.ativo = true AND p.imagem != null AND p.ativo = true AND p.quantEstoque > 0 AND "+
					  "(produto.categoria.nome LIKE :filtro OR produto.plataforma.nome LIKE :filtro OR produto.marca.nome LIKE :filtro "+
					   "OR p.nome LIKE :filtro OR p.fornecedor.nome LIKE)");
			q.setParameter("filtro","%"+filter+"%");
		}   
		return q.getResultList();
	}
}
