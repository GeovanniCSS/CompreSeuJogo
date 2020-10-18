package compreseujogo.teste;

import compreseujogo.model.bo.AvaliacaoBo;
import compreseujogo.model.entity.Avaliacao;
import compreseujogo.model.entity.Cliente;
import compreseujogo.model.entity.Produto;

public class AvaliacaoTeste {

	public static void main(String[] args) {
		AvaliacaoBo avaliacaoBo = new AvaliacaoBo();
		
		Cliente cliente = new Cliente();
		cliente.setId(1);
		Produto produto = new Produto();
		produto.setId(1);
		
		Avaliacao avaliacao = new Avaliacao(0,4,"Puta jogo","Joguei bastante e me diverti muito", cliente,produto);
		
		try {
			System.out.println(avaliacaoBo.saveOrUpdate(avaliacao));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
