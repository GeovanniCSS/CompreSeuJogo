package compreseujogo.model.bo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import compreseujogo.model.dao.GenericDao;
import compreseujogo.model.dao.VendaDao;
import compreseujogo.model.entity.Venda;

public class VendaBo {
	
	private VendaDao dao;
	private GenericDao<Venda> gDao;
	
	
	public VendaBo() {
		super();
		this.dao = new VendaDao();
		this.gDao = new GenericDao<Venda>();
	}

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
		venda.setValor(venda.getCliente().getCarrinho().getValor());
		try {
			saveOrUpdate(venda);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void salvarVenda(String parameter, Venda venda) throws Exception {
		if (parameter.equals("online")) {
			venda.setVendedor(null);
			venda.setTransporte(null);
			novaVenda(venda);
		} else {
			novaVenda(venda);
		}
	}

	public List<String> mensagemVenda(Venda venda) {
		ArrayList<String> email = new ArrayList<String>();
		String tituto = "Nova venda - " + venda.getCliente();
		String mensagem = "<h3>Detalhes da venda</h3> <br>";
		email.add(tituto);
		email.add(mensagem);
		return email;
	}

	public List<Venda> listVenda(String parameter, Venda venda) {
		if(parameter.equals("")) {
			return gDao.list(Venda.class);
		} else {
			return dao.list(parameter, venda);
		}
	}

	public Venda encontrar(int id) {
		return gDao.findById(Venda.class, id);
	}
}
