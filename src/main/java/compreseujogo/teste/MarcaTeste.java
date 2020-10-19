package compreseujogo.teste;

import java.util.ArrayList;

import compreseujogo.facade.Facade;
import compreseujogo.model.bo.MarcaBo;
import compreseujogo.model.entity.Marca;
import compreseujogo.model.entity.Tipo;

public class MarcaTeste {
	public static void main(String[] args) {
		MarcaBo bo = new MarcaBo();
		Marca marca = new Marca(0, "Ubisoft", true);
		Facade facade = new Facade();
		ArrayList <Marca> lista = new ArrayList<Marca>();
		try {
			//System.out.println(marcaBo.nova(marca, Marca.class));
			//facade.listaMarca(marca).forEach(System.out::println);
			//bo.list("organizada", marca, Marca.class).forEach(System.out::println);
			facade.listaMarca(marca).forEach(System.out::println);
			/*for(Tipo tipo :facade.listaMarca(marca)) {
				lista.add((Marca) tipo);
			}
			lista.forEach(System.out::println);
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
