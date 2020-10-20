package compreseujogo.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import compreseujogo.model.entity.Transporte;
import compreseujogo.util.Fabrica;

public class TransporteDao {

	private static EntityManager em = Fabrica.getEntityManager();

	public List<Transporte> list(String parameter, Transporte transporte) {

		return null;
	}

}
