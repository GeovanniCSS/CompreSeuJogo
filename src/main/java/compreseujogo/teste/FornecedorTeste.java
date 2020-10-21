package compreseujogo.teste;

import compreseujogo.facade.Facade;
import compreseujogo.model.bo.FornecedorBo;
import compreseujogo.model.entity.Fornecedor;

public class FornecedorTeste {

	public static void main(String[] args) {
		FornecedorBo fornecedorBo = new FornecedorBo();
		Facade facade = new Facade();
		Fornecedor fornecedor = new Fornecedor(0, "Catatau jogos", "28.833.271/0001-47", "catataujogos@gmail.com.br",
				"Jardinete Roberto", "81330-432", "PR", "(41) 95445-9459", "catatau", true);
		
		
		try {	
			//System.out.println(fornecedorBo.saveOrUpdate(fornecedor));
			//fornecedorBo.list("", fornecedor).forEach(System.out::println);
			//facade.listarFornecedorNome(fornecedor).forEach(System.out::println);
			facade.inserirFornecedor(fornecedor);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
