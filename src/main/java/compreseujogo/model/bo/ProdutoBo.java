package compreseujogo.model.bo;

import java.util.List;

import compreseujogo.model.dao.GenericDao;
import compreseujogo.model.dao.ProdutoDao;
import compreseujogo.model.entity.Produto;



public class ProdutoBo {

	public String saveOrUpdate(Produto produto) throws Exception {
		validarDados(produto);
		GenericDao<Produto> tcDao = new GenericDao<Produto>();
		try {
			return tcDao.saveOrUpdate(produto);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String deletar(Produto produto) throws Exception {
		GenericDao<Produto> tcDao = new GenericDao<Produto>();
		try {
			return tcDao.remove(Produto.class, produto.getId());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public List<Produto> list(String parameter, Produto produto) throws Exception {
		try {
			if (parameter.equals("")) {
				GenericDao<Produto> tcDao = new GenericDao<Produto>();
				return tcDao.list(Produto.class);
			} else {
				ProdutoDao produtoDao = new ProdutoDao();
				return produtoDao.list(parameter, produto);
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	private void validarDados(Produto produto) throws Exception {
		if (produto.getId() < 0) {
			throw new Exception("Id n�o pode ser negativo!");
		} else if (produto.getNome().equals("")) {
			throw new Exception("O nome n�o pode ficar em branco!");
		} else if (produto.getQuantEstoque() < 0) {
			throw new Exception("A quantidade de estoque n�o pode ser negativa!");
		} else if (produto.getValor() < 0) {
			throw new Exception("O valor n�o pode ser negativo!");
		} else if (produto.getSku().equals("")) {
			throw new Exception("O SKU n�o pode ficar em branco!");
		} else if (produto.getEAN() < 0) {
			throw new Exception("O EAN n�o pode ser negativo!");
		}
	}

	public void dimuirQuantidade(Produto produto) throws Exception {
		if (produto.getQuantEstoque() >= 1) {
			produto.setQuantEstoque(produto.getQuantEstoque() - 1);
		} else {
			throw new Exception("N�o � possivel essa a��o no " + produto.getNome());
		}

	}

	public String desativarAtivar(Produto produto) throws Exception {
		if (produto.isAtivo()) {
			produto.setAtivo(false);
			saveOrUpdate(produto);
			return "Foi desativado o produto: " + produto.getNome();
		} else {
			produto.setAtivo(true);
			saveOrUpdate(produto);
			return "Foi ativado o produto: " + produto.getNome();
		}
	}

	public String novo(Produto produto) throws Exception {
		if (list("nome", produto).size() > 0) {
			throw new Exception("J� existe um produto cadastrado com esse nome!");
		} else if (list("SKU", produto).size() > 0) {
			throw new Exception("J� existe um produto cadastrado com esse SKU!");
		} else if (list("EAN", produto).size() > 0) {
			throw new Exception("J� existe um produto cadastrado com esse EAN!");
		} else {
			return saveOrUpdate(produto);
		}

	}
}
