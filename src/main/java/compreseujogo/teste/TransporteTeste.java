package compreseujogo.teste;

import compreseujogo.model.bo.TransporteBo;
import compreseujogo.model.entity.Transporte;

public class TransporteTeste {

	public static void main(String[] args) {
		TransporteBo bo = new TransporteBo();
		Transporte transporte = new Transporte(0, "Sedex", "28.833.271/0001-47", "",
				"Jardinete Kosop", "81230-105", "PR", "(41) 95445-9458", "sedex", "sdadad", "asdadadad", true);
		try {
			System.out.println(bo.saveOrUpdate(transporte));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
