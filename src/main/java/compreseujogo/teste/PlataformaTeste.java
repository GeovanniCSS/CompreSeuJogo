package compreseujogo.teste;

import compreseujogo.model.bo.PlataformaBo;
import compreseujogo.model.entity.Plataforma;
import compreseujogo.viacep.WebServiceCep;

public class PlataformaTeste {

	public static void main(String[] args) {
		PlataformaBo pBo = new PlataformaBo();
		Plataforma plataforma = new Plataforma(0,"Xbox",true,"");
		WebServiceCep w = WebServiceCep.searchCep("83701030");
		
		w.getCidade();
		
		System.out.println(w.getCidade());

		/*try {
			System.out.println(pBo.nova(plataforma, Plataforma.class));
			// System.out.println(pBo.desativarAtivar(plataforma));
			//pBo.listar("novo", plataforma).forEach(System.out::println);
			;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
