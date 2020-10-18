package compreseujogo.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_plataforma")
public class Plataforma extends Tipo {

	private static final long serialVersionUID = 1L;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "plataforma")
	private List<Produto> produto;

	public Plataforma(int id, String nome, boolean ativo) {
		super(id, nome, ativo);
		produto = new ArrayList<Produto>();
	}

	public Plataforma() {
		super();
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto.add(produto);
	}

	@Override
	public String toString() {
		return "Plataforma [getId()=" + getId() + ", getNome()=" + getNome() + ", isAtivo()=" + isAtivo() + "]";
	}

}
