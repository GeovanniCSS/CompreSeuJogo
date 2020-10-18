package compreseujogo.teste;

import compreseujogo.model.bo.CategoriaBo;
import compreseujogo.model.entity.Categoria;

public class CategoriaTeste {
	public static void main(String[] args) {
		CategoriaBo bo = new CategoriaBo();
		Categoria categoria = new Categoria(0, "RPG", true);
		System.out.println("TESTE");

		try {

			System.out.println(bo.nova(categoria, Categoria.class));
			// Categoria.class).forEach(System.out::println);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
