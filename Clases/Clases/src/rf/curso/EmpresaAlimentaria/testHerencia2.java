package rf.curso.EmpresaAlimentaria;

import javax.swing.SingleSelectionModel;

import es.rf.tienda.util.Rutinas;

public class testHerencia2 {

	public static void main(String[] args) {
		ProductosFrescos pf1 = new ProductosFrescos();
		pf1.setFechaCaducidad(Rutinas.convierteACalendar("10/12/2020"));
		pf1.setFechaEnvasado(Rutinas.convierteACalendar("10/06/2016"));
		pf1.setNumeroLote("L-002");
		pf1.setPaisOrigen("España");
		
		ProductosFrescos pf2 = new ProductosFrescos(Rutinas.convierteACalendar("10/06/2016"),"Alemania");
		
		pf1.setFechaCaducidad(Rutinas.convierteACalendar("10/12/2020"));
		pf1.setFechaEnvasado(Rutinas.convierteACalendar("10/06/2016"));
		pf1.setNumeroLote("L-002");
		pf1.setPaisOrigen("España");
		
		ProductosRefrigerados pr1 = new ProductosRefrigerados();
		pr1.setCodigoOrganismoSupervisor("CSalud");
		pr1.setFechaCaducidad(Rutinas.convierteACalendar("11/12/2020"));
		pr1.setNumeroLote("L-023");
		
		CongeladosAgua ca1 = new CongeladosAgua();
		ca1.setSalinidad(27.3);
		ca1.setFechaCaducidad(Rutinas.convierteACalendar("12/12/2020"));
		ca1.setNumeroLote("L-032");
		
		CongeladosAire cr1 = new CongeladosAire();
		cr1.setPorCo2(10.3);
		cr1.setPorN2(20);
		cr1.setPorO2o(50.7);
		cr1.setFechaCaducidad(Rutinas.convierteACalendar("13/12/2020"));
		cr1.setNumeroLote("L-200");
		
		CongeladosNitrogeno cn1 = new CongeladosNitrogeno();
		cn1.setMetodoCongelacion("inmersion");
		cn1.setTemperaturaRecomendada(-45);
		cn1.setFechaCaducidad(Rutinas.convierteACalendar("14/12/2020"));
		cn1.setNumeroLote("L-230");

		System.out.println(pf1.toString());
		System.out.println(pf2.toString());
		System.out.println(pr1.toString());
		System.out.println(ca1.toString());
		System.out.println(cr1.toString());
		System.out.println(cn1.toString());
		
	}

}
