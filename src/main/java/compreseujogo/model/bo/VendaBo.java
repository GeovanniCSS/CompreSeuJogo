package compreseujogo.model.bo;

import java.time.LocalDate;

import compreseujogo.model.dao.GenericDao;
import compreseujogo.model.entity.Venda;

public class VendaBo {

	public String saveOrUpdate(Venda venda) throws Exception {
		validarDados(venda);
		GenericDao<Venda> tcDao = new GenericDao<Venda>();
		try {
			return tcDao.saveOrUpdate(venda);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String remove(Venda venda) throws Exception {
		GenericDao<Venda> tcDao = new GenericDao<Venda>();
		try {
			return tcDao.remove(Venda.class, venda.getId());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	private void validarDados(Venda venda) throws Exception {
		if (venda.getId() < 0) {
			throw new Exception("Id n�o pode ser negativo!");
		} else if (venda.getValor() < 0) {
			throw new Exception("O valor total n�o pode ser negativo");
		}
	}
	public void novaVenda(Venda venda) throws Exception {
		venda.setDataCadastro(LocalDate.now());
		saveOrUpdate(venda);
	}
}
