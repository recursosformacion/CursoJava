package conversor;

public class recep2 {

	public static void main(String[] args) {
		
		String salida="", salida2="";
		for(String valor:args){
			salida=salida +valor + " ";
		}
		System.out.println(salida);
		
		char delim = salida.charAt(0);
		int lon=1;
		while (salida.charAt(lon)!=delim) lon++;
		
		for (int a=1;a<=lon-1;a++)
			salida2+=salida.charAt(a);
		System.out.println(salida2);
		
		
	}

}
