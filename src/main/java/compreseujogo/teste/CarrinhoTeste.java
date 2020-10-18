package compreseujogo.teste;

import compreseujogo.model.bo.CarrinhoBo;
import compreseujogo.model.entity.Carrinho;
import compreseujogo.viacep.WebServiceCep;

public class CarrinhoTeste {

	public static void main(String[] args) {
		CarrinhoBo carrinhoBo = new CarrinhoBo();
		Carrinho carrinho = new Carrinho();
		WebServiceCep c = WebServiceCep.searchCep("83701-030");
;		/*try {
			carrinhoBo.list("", carrinho).forEach(System.out::println);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}

}
