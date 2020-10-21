package compreseujogo.model.bo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import compreseujogo.model.dao.GenericDao;
import compreseujogo.model.dao.PessoaDao;
import compreseujogo.model.entity.Administrador;
import compreseujogo.model.entity.Cliente;
import compreseujogo.model.entity.EntityBase;
import compreseujogo.model.entity.Pessoa;
import compreseujogo.model.entity.Vendedor;

public class PessoaBo<T extends Pessoa> {

	public String saveOrUpdate(EntityBase obj) throws Exception {
		validarDados((Pessoa) obj);
		GenericDao<Pessoa> tcDao = new GenericDao<Pessoa>();
		try {
			return tcDao.saveOrUpdate((Pessoa) obj);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String remove(EntityBase obj) throws Exception {
		GenericDao<Pessoa> tcDao = new GenericDao<Pessoa>();
		try {
			return tcDao.remove(Pessoa.class, obj.getId());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public List<Pessoa> list(String parameter, EntityBase obj, Class<T> classe) throws Exception {
		Pessoa pessoa = (Pessoa) obj;
		try {
			if (parameter.equals("")) {
				GenericDao<Pessoa> pDao = new GenericDao<Pessoa>();
				return pDao.list(Pessoa.class);
			} else {
				PessoaDao pessoaDao = new PessoaDao();
				return pessoaDao.list(parameter, pessoa, classe);
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());

		}
	}

	public String desativarAtivar(EntityBase obj) throws Exception {
		Pessoa pessoa = (Pessoa) obj;
		if (pessoa.isAtivo()) {
			pessoa.setAtivo(false);
			saveOrUpdate(pessoa);
			return "Foi desativada a conta do e-mail" + pessoa.getEmail();
		} else {
			pessoa.setAtivo(true);
			saveOrUpdate(pessoa);
			return "Foi ativada a conta do e-mail" + pessoa.getEmail();
		}
	}

	private void validarDados(Pessoa pessoa) throws Exception {
		if (pessoa.getId() < 0) {
			throw new Exception("Id n�o pode ser negativo!");
		} else if (pessoa.getNome().equals("")) {
		} else if (pessoa.getNome().equals("")) {
			throw new Exception("O nome n�o pode ficar em branco!");
		} else if (pessoa.getSobrenome().equals("")) {
			throw new Exception("O sobrenome n�o pode ficar em branco!");
		} else if (pessoa.getEmail().equals("")) {
			throw new Exception("O e-mail n�o pode ficar em branco!");
		} else if (pessoa.getSenha().equals("")) {
			throw new Exception("A senha n�o pode ficar em branco!");
		} else if (pessoa.getEndereco().equals("")) {
			throw new Exception("O endere�o n�o pode ficar em branco!");
		} else if (pessoa.getTelefone().equals("")) {
			throw new Exception("O telefone n�o pode ficar em branco!");
		} else if (pessoa.getCep().equals("")) {
			throw new Exception("O cep n�o pode ficar em branco!");
		} else if (pessoa.getCpf().equals("")) {
			throw new Exception("O cpf n�o pode ficar em branco!");
		}
		/*
		 * } else if (pessoa.getDataNascimento().isAfter(LocalDate.now())) { throw new
		 * Exception("A data de nascimento est� incorreta!"); }
		 */
	}

	public String newUser(Pessoa pessoa, Class<T> classe) throws Exception {
		if (list("email", pessoa, classe).size() >= 1) {
			throw new Exception("Esse e-mail já está registrado!");
		} else if (list("cpf", pessoa, classe).size() >= 1) {
			throw new Exception("Esse cpf já está registrado!");
		} else {
			pessoa.setDataCadastro(LocalDate.now());
			return saveOrUpdate(pessoa);
		}

	}

	public String createDependency(Pessoa pessoa, Class<T> classe) throws Exception {
		if (classe.equals(Cliente.class)) {
			ClienteBo bo = new ClienteBo();
			return bo.createDepency((Cliente) pessoa);
		} else if (classe.equals(Vendedor.class)) {
			VendedorBo bo = new VendedorBo();
			return bo.createDepency((Vendedor) pessoa);
		} else if (classe.equals(Administrador.class)) {
			AdministradorBo bo = new AdministradorBo();
			return bo.createDepency((Administrador) pessoa);
		}
		return "ErroSalvar";
	}

	public String login(Pessoa pessoa, Class<T> classe) throws Exception {
		if (list("login", pessoa, classe).size() == 1) {
		    pessoa = list("login", pessoa, classe).get(0);
			return "Olá "+ pessoa.getNome();
		} else {
			throw new Exception("E-mail ou senha está incorreto");
		}
	}

}
