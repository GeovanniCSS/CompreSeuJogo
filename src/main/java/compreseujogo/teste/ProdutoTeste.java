package compreseujogo.teste;

import java.time.LocalDate;

import compreseujogo.model.bo.ProdutoBo;
import compreseujogo.model.entity.Categoria;
import compreseujogo.model.entity.Fornecedor;
import compreseujogo.model.entity.Loja;
import compreseujogo.model.entity.Marca;
import compreseujogo.model.entity.Plataforma;
import compreseujogo.model.entity.Produto;



public class ProdutoTeste {

	public static void main(String[] args) {
		ProdutoBo bo = new ProdutoBo();

		Categoria categoria = new Categoria();
		categoria.setId(2);
		Plataforma plataforma = new Plataforma();
		plataforma.setId(3);
		Marca marca = new Marca();
		marca.setId(1);
		Loja loja = new Loja();
		loja.setId(2);
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setId(1);

		Produto produto = new Produto(1, "Cod", "Jogo dublado em portugu�s", 150.0, 15, 55465465, "Xbox-001", true, 0,
				null, categoria, plataforma, marca, fornecedor, loja);

		try {
			//System.out.println(produtoBo.novo(produto));
			//bo.saveOrUpdate(produto);
			// produtoBo.listar("Categoria", null, 1).forEach(System.out::println);
			bo.list("", produto).forEach(System.out::println);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
