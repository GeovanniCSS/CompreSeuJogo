package compreseujogo.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.pie.PieChartDataSet;
import org.primefaces.model.charts.pie.PieChartModel;

import compreseujogo.facade.Facade;
import compreseujogo.model.entity.Venda;

@RequestScoped
@ManagedBean(name = "graficoBean")
public class GraficoController implements Serializable {

	private static final long serialVersionUID = 1L;

	private PieChartModel pieModel;
	
	@PostConstruct
    public void init() {
        createPieModel();
    }

	private void createPieModel() {
		pieModel = new PieChartModel();
		ChartData data = new ChartData();
		Facade facade = new Facade();
		List<Venda> venda = new Facade().listaVenda("", null);
		PieChartDataSet dataSet = new PieChartDataSet();
		List<Number> values = new ArrayList<>();
		values.add(venda.stream().filter(V -> V.getVendedor().equals(null)).count());
		values.add(venda.stream().filter(V -> !V.getVendedor().equals(null)).count());
		//values.add(100);
		dataSet.setData(values);

		List<String> bgColors = new ArrayList<>();
		bgColors.add("rgb(232, 30, 30)");
		bgColors.add("rgb(54, 162, 235)");
		//bgColors.add("rgb(255, 205, 86)");
		dataSet.setBackgroundColor(bgColors);

		data.addChartDataSet(dataSet);
		List<String> labels = new ArrayList<>();
		labels.add("Online");
		labels.add("Fisica");
		//labels.add("Yellow");
		data.setLabels(labels);

		pieModel.setData(data);
	}

	public PieChartModel getPieModel() {
		return pieModel;
	}

	public void setPieModel(PieChartModel pieModel) {
		this.pieModel = pieModel;
	}

}
