package compreseujogo.teste;

import java.time.LocalDate;

import compreseujogo.model.bo.CarrinhoBo;
import compreseujogo.model.entity.Carrinho;


public class testeMain {

	public static void main(String[] args) {

		//ABASTECER BANCO DE DADOS
		
		/*------------------------------------------------------------------------*/
		//CLIENTE
		/*Cliente c = new Cliente();
		ClienteBo cbo = new ClienteBo();
		
		c.setId(1);
		c.setNome("Alcione");
		c.setCep("83701030");
		c.setCpf("464478456");
		c.setEmail("alcionepires@gmail.com");
		c.setEndereco("Rua Rio Grande do Sul");
		c.setSenha("1234");
		c.setSobrenome("Souza");
		c.setTelefone("41-36427878");
		c.setDataNascimento(LocalDate.now());
		
		try {
			cbo.saveOrUpdate(c);
			//cbo.listar(c).forEach(System.out::println);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*------------------------------------------------------------------------*/
	    //EMPRESA
		/*Empresa e = new Empresa();
		EmpresaBo ebo = new EmpresaBo();
		
		e.setId(1);
		e.setCep("83701030");
		e.setCnpj("4564564");
		e.setEmail("compreseujogo@gmail.com");
		e.setEndereco("Rua archelau");
		e.setEstado("Paran�");
		e.setNome("Compre Seu Jogo");
		e.setSenha("456789");
		e.setTelefone("546456465");
		e.setUrl("compreseujogo.com.br");
		
		try {
			ebo.Salvar(e);
		} catch (Exception a) {
			// TODO Auto-generated catch block
			a.printStackTrace();
		}
		
		/*------------------------------------------------------------------------*/
		//CATEGORIA
		/*Categoria c2 = new Categoria();
		CategoriaBo cBo1 = new CategoriaBo();
		c2.setId(1);
		c2.setTipoCategoria("Esporte");
		
		try {
			cBo1.Salvar(c2);
		} catch (Exception a) {
			// TODO Auto-generated catch block
			a.printStackTrace();
		}
		
		/*------------------------------------------------------------------------*/
		//PLATAFORMA
		/*Plataforma plat = new Plataforma();
		PlataformaBo platBo = new PlataformaBo();
		plat.setId(1);
		plat.setTipo("PS4");
		
	    try {
		platBo.Salvar(plat);
			} catch (Exception a) {
		// TODO Auto-generated catch block
		a.printStackTrace();
		}
	    
	    /*------------------------------------------------------------------------*/
		//PRODUTO
	    /*Produto p = new Produto();
		ProdutoBo pbo = new ProdutoBo();
		
		p.setId(1);
		p.setNome("Fifa 20");
		p.setEAN(503094312);
		p.setQuantidade(200);
		p.setSku("PS4-001");
		p.setValor(20.50);
		p.setCategoria(c2);
		p.setPlataforma(plat);
		
		try {
		pbo.Salvar(p);
		//pbo.listar(p).forEach(System.out::println);
			} catch (Exception a) {
		// TODO Auto-generated catch block
		a.printStackTrace();
		}
	    
		/*----------------------------------------------------------------------*/
		//ADMIN
	    /*Administrador a1 = new Administrador();
	    AdministradorBo aBo = new AdministradorBo();
	    
	    a1.setCargo("Gerente");
	    a1.setCep("83701030");
	    a1.setCpf("06504784566");
	    a1.setDataNascimento(LocalDate.now());
	    a1.setEmail("leonardopires@gmail.com");
	    a1.setEndereco("Nahum Pedro Saliba");
	    a1.setId(1);
	    a1.setNome("Leonardo");
	    a1.setSenha("1234");
	    a1.setSobrenome("Pires");
	    a1.setTelefone("0000000000");
	    //a1.setVendedor(v1);
	    
	    try {
		 aBo.saveOrUpdate(a1);
		} catch (Exception a) {
		// TODO Auto-generated catch block
		a.printStackTrace();
		}
	    
	    /*--------------------------------------------------------*/
	    //VENDEDOR
	    /*Vendedor v1 = new Vendedor();
	    VendedorBo vBo = new VendedorBo();
	    
	    v1.setAdministrador(a1);
	    v1.setCep("83701030");
	    v1.setCpf("06504784566");
	    v1.setDataNascimento(LocalDate.now());
	    v1.setEmail("catarina@gmail.com");
	    v1.setEndereco("Nahum Pedro Saliba");
	    v1.setId(1);
	    v1.setNome("Catarina");
	    v1.setProduto(p);
	    v1.setSenha("1234");
	    v1.setSobrenome("Pires");
	    v1.setTelefone("1111111111");
	    
	    try {
		 vBo.saveOrUpdate(v1);
		} catch (Exception a) {
		// TODO Auto-generated catch block
		a.printStackTrace();
		}
	    
	    
	    /*----------------------------------------------------------------------*/

		//CARRINHO
	    Carrinho c1 = new Carrinho();
		CarrinhoBo cBo = new CarrinhoBo();
		c1.setId(2);
		//c1.setCliente(c);
		//c1.setProduto(p);
		//c1.setValor(20.00);
		
		try {
		 //cBo.Salvar(c1);
		 cBo.remove(c1);
		} catch (Exception a) {
		// TODO Auto-generated catch block
		a.printStackTrace();
		}
		
		/*--------------------------------------------*/
		//TRANSPORTE
		/*Transporte t1 = new Transporte();
		TransporteBo tBo = new TransporteBo();
		
		t1.setId(1);
		t1.setEmail("nascar@gmail.com");
		t1.setNome("Nascar Transporte");
		t1.setTelefone("44444444444");
		t1.setUrl("nascar.com.br");
		
		try {
			tBo.Salvar(t1);
		} catch (Exception a) {
		// TODO Auto-generated catch block
		a.printStackTrace();
	    }
		
		/*----------------------------------*/
		
		
	}

}