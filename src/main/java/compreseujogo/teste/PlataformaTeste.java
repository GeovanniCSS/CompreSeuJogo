package compreseujogo.teste;

import compreseujogo.model.bo.PlataformaBo;
import compreseujogo.model.entity.Plataforma;

public class PlataformaTeste {

	public static void main(String[] args) {
		PlataformaBo pBo = new PlataformaBo();
		Plataforma plataforma = new Plataforma();
		
		plataforma.setCodigoSku("asdadsadd");
		plataforma.setNome("PS4");
		;
		

		try {
			System.out.println(plataforma.getCodigoSku());
			//System.out.println(pBo.nova(plataforma, Plataforma.class));
			// System.out.println(pBo.desativarAtivar(plataforma));
			System.out.println(pBo.saveOrUpdate(plataforma));
			//pBo.listar("novo", plataforma).forEach(System.out::println);
			;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
