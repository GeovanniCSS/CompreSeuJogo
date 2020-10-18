package compreseujogo.model.bo;

import java.util.List;

import compreseujogo.model.dao.AdministradorDao;
import compreseujogo.model.dao.GenericDao;
import compreseujogo.model.entity.Administrador;




public class AdministradorBo extends PessoaBo<Administrador> {

	public List<Administrador> list(String parameter, Administrador administrador) throws Exception {
		try {
			if (parameter.equals("")) {
				GenericDao<Administrador> genericDao = new GenericDao<Administrador>();
				return genericDao.list(Administrador.class);
			} else {
				AdministradorDao administradorDao = new AdministradorDao();
				return administradorDao.list(parameter, administrador);
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());

		}
	}

	public String createDepency(Administrador administrador) throws Exception {
		LojaBo bo = new LojaBo();
		administrador.setLoja(bo.list("", null).get(0));
		try {
			return saveOrUpdate(administrador) + "_administrador";
		} catch (Exception e) {
			throw new Exception("Erro ao vincular a loja ao " + administrador.getNome());
		}
	}
}
