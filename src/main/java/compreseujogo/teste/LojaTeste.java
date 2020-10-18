package compreseujogo.teste;

import compreseujogo.model.bo.LojaBo;
import compreseujogo.model.entity.Loja;

public class LojaTeste {

	public static void main(String[] args) {
		LojaBo bo = new LojaBo();
		Loja loja = new Loja(0, "Compre Seu Jogo", "28.833.271/0001-47", "compreseujogo@gmail.com.br",
				"Jardinete Roberto Kosop", "81330-105", "PR", "(41) 95445-9452", "compreseujogo", true);

		try {
			System.out.println(bo.saveOrUpdate(loja));
			//bo.list("", loja).forEach(System.out::println);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
