package compreseujogo.facade;

import java.util.ArrayList;
import java.util.List;

import compreseujogo.model.bo.AdministradorBo;
import compreseujogo.model.bo.AvaliacaoBo;
import compreseujogo.model.bo.CarrinhoBo;
import compreseujogo.model.bo.CategoriaBo;
import compreseujogo.model.bo.ClienteBo;
import compreseujogo.model.bo.ComissaoBo;
import compreseujogo.model.bo.EmpresaBo;
import compreseujogo.model.bo.FornecedorBo;
import compreseujogo.model.bo.ItemBo;
import compreseujogo.model.bo.ItemCarrinhoBo;
import compreseujogo.model.bo.ItemDesejoBo;
import compreseujogo.model.bo.ItemVendaBo;
import compreseujogo.model.bo.ListaDesejoBo;
import compreseujogo.model.bo.LojaBo;
import compreseujogo.model.bo.MarcaBo;
import compreseujogo.model.bo.PessoaBo;
import compreseujogo.model.bo.PlataformaBo;
import compreseujogo.model.bo.ProdutoBo;
import compreseujogo.model.bo.TipoBo;
import compreseujogo.model.bo.TransporteBo;
import compreseujogo.model.bo.VendaBo;
import compreseujogo.model.bo.VendedorBo;
import compreseujogo.model.entity.Administrador;
import compreseujogo.model.entity.Carrinho;
import compreseujogo.model.entity.Categoria;
import compreseujogo.model.entity.Cliente;
import compreseujogo.model.entity.Empresa;
import compreseujogo.model.entity.Fornecedor;
import compreseujogo.model.entity.ItemCarrinho;
import compreseujogo.model.entity.Loja;
import compreseujogo.model.entity.Marca;
import compreseujogo.model.entity.Pessoa;
import compreseujogo.model.entity.Plataforma;
import compreseujogo.model.entity.Produto;
import compreseujogo.model.entity.Tipo;
import compreseujogo.model.entity.Transporte;
import compreseujogo.model.entity.Venda;
import compreseujogo.model.entity.Vendedor;

public class Facade {

	private AdministradorBo administradorBo;
	private AvaliacaoBo avaliacaoBo;
	private CarrinhoBo carrinhoBo;
	private CategoriaBo categoriaBo;
	private ClienteBo clienteBo;
	private ComissaoBo comissaoBo;
	private EmpresaBo empresaBo;
	private FornecedorBo fornecedorBo;
	private ItemBo itemBo;
	private ItemCarrinhoBo itemCarrinhoBo;
	private ItemDesejoBo itemDesejoBo;
	private ItemVendaBo itemVendaBo;
	private ListaDesejoBo listaDesejoBo;
	private LojaBo lojaBo;
	private MarcaBo marcaBo;
	private PlataformaBo plataformaBo;
	private ProdutoBo produtoBo;
	private TipoBo tipoBo;
	private TransporteBo transporteBo;
	private VendaBo vendaBo;
	private VendedorBo vendedorBo;

	public Facade() {
		administradorBo = new AdministradorBo();
		avaliacaoBo = new AvaliacaoBo();
		carrinhoBo = new CarrinhoBo();
		categoriaBo = new CategoriaBo();
		clienteBo = new ClienteBo();
		comissaoBo = new ComissaoBo();
		empresaBo = new EmpresaBo();
		fornecedorBo = new FornecedorBo();
		itemBo = new ItemBo();
		itemCarrinhoBo = new ItemCarrinhoBo();
		itemDesejoBo = new ItemDesejoBo();
		itemVendaBo = new ItemVendaBo();
		listaDesejoBo = new ListaDesejoBo();
		lojaBo = new LojaBo();
		marcaBo = new MarcaBo();
		plataformaBo = new PlataformaBo();
		produtoBo = new ProdutoBo();
		tipoBo = new TipoBo();
		transporteBo = new TransporteBo();
		vendaBo = new VendaBo();
		vendedorBo = new VendedorBo();
	}

	public String novaVenda(Venda venda) throws Exception {
		itemCarrinhoBo.validarQuantidade(venda.getCliente().getCarrinho().getItem());
		vendaBo.novaVenda(venda);
		itemVendaBo.novaVenda(venda);
		carrinhoBo.zerar(venda.getCliente().getCarrinho());
		produtoBo.dimuirQuantidade(venda.getCliente().getCarrinho().getItem());
		itemCarrinhoBo.apagarItems(venda.getCliente().getCarrinho().getItem());
		return "vendido";
	}

	public Administrador loginAdminstrador(Administrador administrador) throws Exception {
		return (Administrador) administradorBo.login(administrador, Administrador.class);
	}

	public Vendedor loginVendedor(Vendedor vendedor) throws Exception {
		return (Vendedor) vendedorBo.login(vendedor, Vendedor.class);

	}

	public String salvarAdministrador(Administrador administrador) throws Exception {
		return administradorBo.salvar(administrador, (Loja) lojaBo.list("", null, Loja.class).get(0));
	}

	public String salvarVendedor(Vendedor vendedor) throws Exception {
		vendedorBo.novaPessoa(vendedor, Vendedor.class);
		return vendedorBo.createDepency(vendedor);
	}
	
	public String atualizarVendedor(Vendedor vendedor) throws Exception {
		return vendedorBo.desativarAtivar(vendedor);
	}
	
	public String atualizarCliente(Cliente cliente) throws Exception {
		return clienteBo.desativarAtivar(cliente);
	}
	
	public String atualizarTransporte(Transporte transporte) throws Exception {
		return transporteBo.desativarAtivar(transporte);
	}

	public String salvarCliente(Cliente cliente) throws Exception {
		clienteBo.novaPessoa(cliente, Cliente.class);
		return clienteBo.saveOrUpdate(cliente);
	}

	public String salvarCategoria(Categoria categoria) throws Exception {
		return categoriaBo.salvar(categoria);
	}

	public String salvarPlataforma(Plataforma plataforma) throws Exception {
		return plataformaBo.salvar(plataforma);
	}

	public String salvarProduto(Produto produto) throws Exception {
		produto.setPlataforma(plataformaBo.encontrar(produto.getPlataforma()));
		produto.setLoja((Loja) lojaBo.list("organizada", null, Loja.class).get(0));
		return produtoBo.salvar(produto);
	}

	public String salvarMarca(Marca marca) throws Exception {
		return marcaBo.salvar(marca);
	}

	public String salvarFornecedor(Fornecedor fornecedor) throws Exception {
		return fornecedorBo.novaEmpresa(fornecedor, Fornecedor.class);
	}

	public String salvarTransporte(Transporte transporte) throws Exception {
		  transporteBo.novaEmpresa(transporte, Transporte.class);
		  return transporteBo.saveOrUpdate(transporte);
	}

	public String adicionarItemCarrinho(ItemCarrinho item, Carrinho carrinho) throws Exception {
		itemCarrinhoBo.novo(item);
		carrinhoBo.aumentorValor(item, carrinho);
		return "";
	}

	public List<Marca> listaMarca(Marca marca) throws Exception {
		ArrayList<Marca> lista = new ArrayList<Marca>();
		for (Tipo tipo : marcaBo.list("organizada", marca, Marca.class)) {
			lista.add((Marca) tipo);
		}
		return lista;
	}
	
	public List<Vendedor> listaVendedor(Vendedor vendedor) throws Exception {
		ArrayList<Vendedor> lista = new ArrayList<Vendedor>();
		for (Pessoa pessoa : vendedorBo.list("organizada", vendedor, Vendedor.class)) {
			lista.add((Vendedor) pessoa);
		}
		return lista;
	}
	
	public List<Cliente> listaCliente(Cliente cliente) throws Exception {
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		for (Pessoa pessoa : clienteBo.list("organizada", cliente, Cliente.class)) {
			lista.add((Cliente) pessoa);
		}
		return lista;
	}
	
	public List<Transporte> listaTransporte(Transporte transporte) throws Exception {
		ArrayList<Transporte> lista = new ArrayList<Transporte>();
		for (Empresa empresa : transporteBo.list("organizada", transporte, Transporte.class)) {
			lista.add((Transporte) empresa);
		}
		return lista;
	}

	public List<Plataforma> listaPlataforma(Plataforma plataforma) throws Exception {
		ArrayList<Plataforma> lista = new ArrayList<Plataforma>();
		for (Tipo tipo : plataformaBo.list("organizada", plataforma, Plataforma.class)) {
			lista.add((Plataforma) tipo);
		}
		return lista;
	}

	public List<Categoria> listaCategoria(Categoria categoria) throws Exception {
		ArrayList<Categoria> lista = new ArrayList<Categoria>();
		for (Tipo tipo : categoriaBo.list("organizada", categoria, Categoria.class)) {
			lista.add((Categoria) tipo);
		}
		return lista;
	}

	public List<Fornecedor> listarFornecedorNome(Fornecedor fornecedor) throws Exception {
		ArrayList<Fornecedor> lista = new ArrayList<Fornecedor>();

		for (Empresa empresa : fornecedorBo.list("organizada", fornecedor, Fornecedor.class)) {
			lista.add((Fornecedor) empresa);
		}
		return lista;
	}

	public List<Produto> listaProduto(String parameter, Produto produto) throws Exception {
		return produtoBo.list(parameter, produto);
	}
}
