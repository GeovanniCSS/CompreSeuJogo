package compreseujogo.teste;

import compreseujogo.model.bo.EmpresaBo;
import compreseujogo.model.entity.Loja;

public class EmpresaTeste {

	public static void main(String[] args) {
		EmpresaBo empresaBo = new EmpresaBo();
		Loja loja = new Loja();
		
		try {
			System.out.println(empresaBo.saveOrUpdate(loja));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
