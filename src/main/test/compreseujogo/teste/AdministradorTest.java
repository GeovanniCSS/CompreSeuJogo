package compreseujogo.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import compreseujogo.facade.Facade;
import compreseujogo.model.entity.Administrador;

public class AdministradorTest {

	@Test
	public void login() throws Exception {
		Facade facade = new Facade();
		Administrador administrador = new Administrador();
		administrador.setEmail("geovannis@gmail.com.br");
		administrador.setSenha("1234");
		facade.loginAdminstrador(administrador);
		boolean teste = false;
		if(administrador.getId() > 0) {
			teste = true;
		}
		assertEquals(true, teste);
	}
}
