package curso.g05b.condicionalesybucles.Adivina;

import curso.utilidades.Consola;

public class Adivina2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int topeSup=100;
		int topeInf=0;
		int miNum=0;
		String respuesta="";
		miNum=(int)(Math.random()*100 +1);
		do{
			System.out.println("Numero:"+ miNum + "(M)ayor, Me(n)or, (F)in");
			respuesta=Consola.cadena();
			if (respuesta.equalsIgnoreCase("M"))
				topeInf=miNum;
			else
				topeSup=miNum;
			miNum=(int)((topeSup+topeInf)/2);
		} while (!respuesta.equalsIgnoreCase("F"));
		
				
	}

}
