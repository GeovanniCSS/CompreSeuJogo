package compreseujogo.teste;

import java.time.LocalDate;
import java.util.Date;

import compreseujogo.model.bo.PessoaBo;
import compreseujogo.model.entity.Administrador;
import compreseujogo.model.entity.Cliente;
import compreseujogo.model.entity.Loja;
import compreseujogo.model.entity.Sexo;



public class PessoaTeste {

	public static void main(String[] args) {
		PessoaBo pessoaBo = new PessoaBo();
		Loja loja = new Loja();
		loja.setId(1);
		/*
		Cliente cliente = new Cliente(0, "Geovanni", "Silva", "geoa@gmail.com.br", "1234", Date.from(null),
				"Rua do Jo�o", "(12) 95454-5555", "54555-132", "123.450.100-50", true, null, null, null, null, null);

		Administrador administrador = new Administrador(0, "Geovanni ", " Souza", "geoa@gmail.com.br", "1234",
				Date.from(null), "Rua", "84", "85", "123.454.888-50", true, null, null, Sexo.Masculino, loja);
*/
		try {
			// System.out.println(pessoaBo.newUser(administrador, Administrador.class));
			//System.out.println(pessoaBo.login(cliente, Cliente.class));
			// System.out.println(pessoaBo.newUser(cliente, Cliente.class));
			// System.out.println(cliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
