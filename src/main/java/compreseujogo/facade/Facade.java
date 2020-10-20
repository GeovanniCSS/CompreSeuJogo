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
import compreseujogo.model.entity.Empresa;
import compreseujogo.model.entity.Fornecedor;
import compreseujogo.model.entity.ItemCarrinho;
import compreseujogo.model.entity.Marca;
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
	private PessoaBo pessoaBo;
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
		pessoaBo = new PessoaBo();
		plataformaBo = new PlataformaBo();
		produtoBo = new ProdutoBo();
		tipoBo = new TipoBo();
		transporteBo = new TransporteBo();
		vendaBo = new VendaBo();
		vendedorBo = new VendedorBo();
	}

	public String novaVenda(Venda venda, List<ItemCarrinho> lista) throws Exception {
		itemCarrinhoBo.validarQuantidade(lista);
		vendaBo.novaVenda(venda);
		itemVendaBo.novaVenda(venda, lista);
		return "vendido";

	}

	public String loginAdminstrador(Administrador administrador) throws Exception {
		return administradorBo.login(administrador, Administrador.class);
	}

	public void inserirVendedor(Vendedor vendedor) throws Exception {
		vendedorBo = new VendedorBo();
		vendedorBo.saveOrUpdate(vendedor);
	}

	public String inserirCategoria(Categoria categoria) throws Exception {
		return categoriaBo.nova(categoria, Categoria.class);
	}

	public String inserirPlataforma(Plataforma plataforma) throws Exception {
		return plataformaBo.nova(plataforma, Plataforma.class);
	}

	public String inserirProduto(Produto produto) throws Exception {
		return produtoBo.novo(produto);
	}

	public String inserirMarca(Marca marca) throws Exception {
		return marcaBo.nova(marca, Marca.class);
	}

	public String inserirFornecedor(Fornecedor fornecedor) throws Exception {
		return fornecedorBo.novaEmpresa(fornecedor, Fornecedor.class);
	}

	public void inserirTransporte(Transporte transporte) throws Exception {
		transporteBo = new TransporteBo();
		transporteBo.saveOrUpdate(transporte);
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

		try {
			for (Empresa empresa : fornecedorBo.list("organizada", fornecedor, Fornecedor.class)) {
				lista.add((Fornecedor) empresa);
			}
		} catch (Exception e) {
			throw new Exception("Falha ao listar os fornecedores");

		}
		return lista;
	}
}
