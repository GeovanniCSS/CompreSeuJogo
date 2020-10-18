package compreseujogo.model.bo;

import java.util.List;

import compreseujogo.model.dao.GenericDao;
import compreseujogo.model.dao.PlataformaDao;
import compreseujogo.model.entity.Marca;
import compreseujogo.model.entity.Plataforma;
import compreseujogo.model.entity.Produto;

public class MarcaBo extends TipoBo<Marca> {

	public List<Plataforma> listar(String parameter, Plataforma plataforma) throws Exception {
		try {
			if (parameter.equals("")) {
				GenericDao<Plataforma> tcDao = new GenericDao<Plataforma>();
				return tcDao.list(Plataforma.class);
			} else {
				PlataformaDao plataformaDao = new PlataformaDao();
				return plataformaDao.ListaPlataforma(parameter, plataforma);
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String apagar(Marca marca) throws Exception {
		ProdutoBo produtoBo = new ProdutoBo();
		Produto produto = new Produto();
		produto.setMarca(marca);
		if (produtoBo.list("Marca", produto).size() >= 1) {
			throw new Exception("J� existem jogos cadastrados nessa marca: " + marca.getNome());
		} else {
			return remove(marca);
		}
	}

}
