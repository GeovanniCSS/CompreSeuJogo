package compreseujogo.model.bo;

import java.util.List;

import compreseujogo.model.dao.CategoriaDao;
import compreseujogo.model.dao.GenericDao;
import compreseujogo.model.entity.Categoria;
import compreseujogo.model.entity.Produto;


public class CategoriaBo extends TipoBo<Categoria> {

	public List<Categoria> listar(String parametro, Categoria categoria) throws Exception {
		try {
			if (parametro.equals("")) {
				GenericDao<Categoria> pDao = new GenericDao<Categoria>();
				return pDao.list(Categoria.class);
			} else {
				CategoriaDao categoriaDao = new CategoriaDao();
				return categoriaDao.listar(parametro, categoria);
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());

		}
	}

	public String apagar(Categoria categoria) throws Exception {
		ProdutoBo produtoBo = new ProdutoBo();
		Produto produto = new Produto();
		produto.setCategoria(categoria);
		if (produtoBo.list("Categoria", produto).size() >= 1) {
			throw new Exception("J� existem jogos cadastrados nessa categoria: " + categoria.getNome());
		} else {
			return remove(categoria);
		}
	}

}