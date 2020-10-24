package compreseujogo.teste;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailTeste {

	public static void main(String[] args) {
		try {

			final String emailP = "ander.lemos.jr@gmail.com";
			final String emailI = "java.compreseujogo@gmail.com";
			final String senha = "geovann!1";

			SimpleEmail email = new SimpleEmail();
			// Utilize o hostname do seu provedor de email
			System.out.println("alterando hostname...");
			email.setDebug(true);
			email.setHostName("smtp.gmail.com");

			// Quando a porta utilizada não é a padrão (gmail = 465)
			email.setSmtpPort(465);

			// Para autenticar no servidor é necessário chamar os dois métodos abaixo
			System.out.println("autenticando...");
			email.setSSL(true);
			email.setTLS(true);
			email.setAuthentication(emailI, senha);
			System.out.println("+ Informações");
			// Adicione os destinatários
			email.addTo(emailP);

			// Configure o seu email do qual enviará
			email.setFrom(emailI);

			// Adicione um assunto
			email.setSubject("O meu e-mail está funcionando");

			// Adicione a mensagem do email
			email.setMsg("Teste- Integrador");
			System.out.println("enviando...");
			email.send();
			System.out.println("Email enviado!");
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
