package compreseujogo.teste;


import compreseujogo.model.bo.ItemBo;
import compreseujogo.model.entity.Categoria;
import compreseujogo.model.entity.Cliente;
import compreseujogo.model.entity.Fornecedor;
import compreseujogo.model.entity.Item;
import compreseujogo.model.entity.ItemVenda;
import compreseujogo.model.entity.Marca;
import compreseujogo.model.entity.Plataforma;
import compreseujogo.model.entity.Produto;


public class ItemTeste {

	public static void main(String[] args) {
		ItemBo itemBo = new ItemBo();
		Item item = new ItemVenda();

		Categoria categoria = new Categoria(2, "RPG", true);
		Plataforma plataforma = new Plataforma(1, "Playstation",true,"PS4-");
		Marca marca = new Marca (1 ,"A",true);
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setId(1);
		Produto produto = new Produto();
		produto.setId(1);

		Cliente cliente = new Cliente();

		try {
			itemBo.listar("", item).forEach(System.out::println);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
