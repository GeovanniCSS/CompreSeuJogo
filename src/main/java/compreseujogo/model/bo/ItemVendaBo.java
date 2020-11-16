package compreseujogo.model.bo;

import compreseujogo.model.dao.ItemVendaDao;
import compreseujogo.model.entity.ItemCarrinho;
import compreseujogo.model.entity.ItemVenda;
import compreseujogo.model.entity.Venda;

public class ItemVendaBo extends ItemBo<ItemVenda> {

	private ItemVendaDao dao;

	public void novaVenda(Venda venda) throws Exception {
		for (ItemCarrinho itemCarrinho : venda.getCliente().getCarrinho().getItem()) {
			ItemVenda item = new ItemVenda(0, venda.getDataCadastro(), itemCarrinho.getValor(), itemCarrinho.getQuantidade(),
					itemCarrinho.getProduto(), venda);
			try {
				saveOrUpdate(item);
			} catch (Exception e) {
				throw new Exception("Erro ao salvar na venda ao salvar o produto: "+item.getProduto());
			}
		}

	}

}
