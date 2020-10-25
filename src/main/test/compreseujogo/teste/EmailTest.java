package compreseujogo.teste;

import org.junit.jupiter.api.Test;

import compreseujogo.model.bo.EmailBo;

public class EmailTest {
	
	@Test
	public void novaVenda() throws Exception {
		EmailBo bo = new EmailBo();
		String mensagem ="Teste para o envio através da bo do email com Junit 5";
		System.out.println(bo.novaVenda("Teste do Junit", mensagem, "yasmine9836@uorak.com", "jaye9112@uorak.com"));
	}
}
