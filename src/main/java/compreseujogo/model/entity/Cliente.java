package compreseujogo.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cliente")
public class Cliente extends Pessoa {

	private static final long serialVersionUID = 1L;

	@OneToOne
	private Carrinho carrinho;

	@OneToOne
	private ListaDesejos listaDesejos;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
	private List<Avaliacao> avaliacao;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
	private List<Venda> venda;

	public Cliente(int id, String nome, String sobrenome, String email, String senha, Date dataNascimento,
			Date dataCadastro, String endereco, String telefone, String cep, String cpf, boolean ativo, String estado,
			String cidade, String bairro, Sexo sexo, Carrinho carrinho, ListaDesejos listaDesejos,
			List<Avaliacao> avaliacao, List<Venda> venda) {
		super(id, nome, sobrenome, email, senha, dataNascimento, dataCadastro, endereco, telefone, cep, cpf, ativo,
				estado, cidade, bairro, sexo);
		this.carrinho = carrinho;
		this.listaDesejos = listaDesejos;
		this.avaliacao = avaliacao;
		this.venda = venda;
	}

	public Cliente() {
		super();
	}

	public List<Avaliacao> getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao.add(avaliacao);
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public List<Venda> getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda.add(venda);
	}

	public ListaDesejos getListaDesejos() {
		return listaDesejos;
	}

	public void setListaDesejos(ListaDesejos listaDesejos) {
		this.listaDesejos = listaDesejos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((carrinho == null) ? 0 : carrinho.hashCode());
		result = prime * result + ((listaDesejos == null) ? 0 : listaDesejos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (carrinho == null) {
			if (other.carrinho != null)
				return false;
		} else if (!carrinho.equals(other.carrinho))
			return false;
		if (listaDesejos == null) {
			if (other.listaDesejos != null)
				return false;
		} else if (!listaDesejos.equals(other.listaDesejos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [carrinho=" + carrinho.getId() + ", listaDesejos=" + listaDesejos + ", getId()=" + getId()
				+ ", getNome()=" + getNome() + ", getSobrenome()=" + getSobrenome() + ", getEmail()=" + getEmail()
				+ ", getSenha()=" + getSenha() + ", getDataNascimento()=" + getDataNascimento() + ", getDataCadastro()="
				+ getDataCadastro() + ", getEndereco()=" + getEndereco() + ", getTelefone()=" + getTelefone()
				+ ", getCep()=" + getCep() + ", getCpf()=" + getCpf() + ", isAtivo()=" + isAtivo() + "]";
	}

}