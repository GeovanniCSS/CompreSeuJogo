package compreseujogo.teste;

import org.junit.jupiter.api.Test;

import compreseujogo.facade.Facade;
import compreseujogo.model.entity.Cliente;
import compreseujogo.model.entity.Venda;

public class VendaTest {

	/*
	@Test
	public void novaVenda() {
		Facade facade = new Facade();
		Venda venda = new Venda();

		GenericDao<ItemCarrinho> iDao = new GenericDao<ItemCarrinho>();
		ItemCarrinho item = iDao.findById(ItemCarrinho.class, 1);
		ItemCarrinho item2 = iDao.findById(ItemCarrinho.class, 2);

		GenericDao<Cliente> cDao = new GenericDao<Cliente>();
		Cliente cliente = cDao.findById(Cliente.class, 1);

		GenericDao<Transporte> tDao = new GenericDao<Transporte>();
		Transporte transporte = tDao.findById(Transporte.class, 3);

		venda.setTransporte(transporte);
		venda.setCliente(cliente);
		venda.setVendedor(null);
		System.out.println(venda);
		try {
			facade.novaVenda(venda);
			System.out.println(venda);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(1, venda.getId());
	}
	*/
	@Test
	public void lista() {
		Facade facade = new Facade();
		Venda venda = new Venda();
		Cliente cliente = new Cliente();
		cliente.setId(1);
		facade.listaVenda("", venda).forEach(System.out::println);
		
	}

}
