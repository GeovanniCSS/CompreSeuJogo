package compreseujogo.teste;

import java.util.Date;

import compreseujogo.model.bo.ClienteBo;
import compreseujogo.model.entity.Cliente;
import compreseujogo.model.entity.Sexo;


public class ClienteTeste {

	public static void main(String[] args) {
		ClienteBo clienteBo = new ClienteBo();
		/*
		Cliente cliente = new Cliente(0, "Rafael", "Renan dos Santos", "rafaelS@gmail.com.b", "1234", Date.from(null),
				"Rua Maria Beatriz Rotta", "(41) 98960-1582", "82520-770", "557.619.439-34", true,null, null, Sexo.Masculino, null, null);
*/
		try {
			//System.out.println(clienteBo.newUser(cliente, Cliente.class));
			// clienteBo.list("", cliente).forEach(System.out::println);
			// clienteBo.list("", null).forEach(System.out::println);
			// System.out.println(clienteBo.login(cliente));
			// clienteBo.list("email", cliente, Cliente.class).forEach(System.out::println);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
