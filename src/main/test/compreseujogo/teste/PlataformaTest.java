package compreseujogo.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import compreseujogo.facade.Facade;
import compreseujogo.model.entity.Plataforma;

public class PlataformaTest {
	
	@Test
	public void inserirPlataforma() throws Exception {
		Plataforma plataforma = new Plataforma(0, "Playstation", true,"PS4");
		Facade facade = new Facade();
		facade.inserirPlataforma(plataforma);
		int i = plataforma.getId();
		boolean teste = false;
		if(i > 0 ) {
			teste = true;
		}
		assertEquals(true, teste);
	}
	
	@Test
	public void listar() throws Exception {
		Plataforma plataforma = new Plataforma(0, "Corrida", true,"");
		Facade facade = new Facade();
		facade.listaPlataforma(plataforma).forEach(System.out::println);;
	}
}
