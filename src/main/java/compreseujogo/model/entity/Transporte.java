package compreseujogo.model.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_transporte")
public class Transporte extends Empresa {

	private static final long serialVersionUID = 1L;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "transporte")
	List<Venda> venda;

	public Transporte(int id, String nome, String cnpj, String email, String endereco, String cep, String estado,
			String telefone, String url, Boolean ativo) {
		super(id, nome, cnpj, email, endereco, cep, estado, telefone, url, ativo);
		venda = new ArrayList<Venda>();
	}

	public Transporte() {
		super();
	}

	public List<Venda> getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda.add(venda);
	}

	@Override
	public String toString() {
		return "Transporte [getId()=" + getId() + ", getNome()=" + getNome() + ", getCnpj()=" + getCnpj()
				+ ", getEmail()=" + getEmail() + ", getEndereco()=" + getEndereco() + ", getCep()=" + getCep()
				+ ", getEstado()=" + getEstado() + ", getTelefone()=" + getTelefone() + ", getUrl()=" + getUrl()
				+ ", getAtivo()=" + getAtivo() + "]";
	}

}