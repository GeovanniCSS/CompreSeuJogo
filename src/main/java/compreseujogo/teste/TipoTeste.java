package compreseujogo.teste;

import compreseujogo.model.bo.CategoriaBo;
import compreseujogo.model.bo.TipoBo;
import compreseujogo.model.entity.Categoria;

public class TipoTeste {
	public static void main(String[] args) {
		CategoriaBo cBo = new CategoriaBo();
		Categoria categoria = new Categoria(3, "HAHA", true);
		TipoBo tipoBo = new TipoBo();

		try {
			//System.out.println(cBo.novaCategoria(categoria));
		    //System.out.println(cBo.apagar(categoria));
			//System.out.println(cBo.saveOrUpdate(categoria));
			//System.out.println(cBo.desativarAtivar(categoria));
			//cBo.listar("", categoria).forEach(System.out::println);
			//System.out.println(tipoBo.saveOrUpdate(categoria));
			tipoBo.list("novo", categoria, Categoria.class).forEach(System.out::println);
			
			System.out.println("Passou aqui");
		
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
