package compreseujogo.teste;

import java.time.LocalDate;

import compreseujogo.facade.Facade;
import compreseujogo.model.bo.VendaBo;
import compreseujogo.model.dao.GenericDao;
import compreseujogo.model.entity.Carrinho;
import compreseujogo.model.entity.Transporte;
import compreseujogo.model.entity.Venda;



public class VendaTeste {

	public static void main(String[] args) {
		VendaBo bo = new VendaBo();
		Venda venda = new Venda();
		Facade facade = new Facade();
		Transporte transporte = new Transporte();
		GenericDao<Carrinho> gDao = new GenericDao<Carrinho>();
		Carrinho carrinho = gDao.findById(Carrinho.class, 1);
		transporte.setId(3);
		venda.setDataEntrega(LocalDate.now());
		venda.setTransporte(transporte);
		venda.setCliente(carrinho.getCliente());
		venda.setValor(carrinho.getValor());
		
		
		try {
			//System.out.println(bo.saveOrUpdate(venda));
			System.out.println(facade.novaVenda(venda, carrinho.getItem()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
