package curso.g05.condicionales.p01a;

public class Vuelta {

	public static void main(String[] args) {
		String entrada="";
		int lg=args.length;
		for(int a=0;a<lg;a++){
			entrada+=args[a]+" ";
		}
		System.out.println("fase-1-"+entrada);

		int longitud = entrada.length();
		int a;
		for(a=longitud-1;a>=0;a--)
			System.out.print(entrada.charAt(a));
		System.out.println();
		
		
		String salida="";
		for(a=longitud-1;a>=0;a--)
			salida +=entrada.charAt(a);
		System.out.println("fase-2-" + salida);
		
		
		String salida1="";
		for(a=longitud-1;a>=0;a--)
			switch(entrada.charAt(a)){
			case 'a':
				salida1 +=4;
				break;
			case 'e':
				salida1 +=3;
				break;
			case 'i':
				salida1 +=1;
				break;
			case 'o':
				salida1 +=0;
				break;
			case 'u':
				salida1 +=9;
				break;
			default:
				salida1 +=entrada.charAt(a);				
			}
			
		System.out.println("fase-3-" + salida1);
		
		
		System.out.print("fase 4-");
		entrada="/"+entrada+"/";
		
		char bus=entrada.charAt(0);		
		for(a=0;a<entrada.length() && entrada.charAt(a)!=bus ;a++)
			System.out.print(entrada.charAt(a));
		System.out.println();

	}

}
