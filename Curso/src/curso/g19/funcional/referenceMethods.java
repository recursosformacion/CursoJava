package curso.g19.funcional;


	import java.util.function.Consumer;

	public class referenceMethods {
		
		public static void main(String[] args) {
			
			// utilizaremos en la interface Consumer que tiene un unico metodo denominado accept
			// el cual recibe un parametro y no devuelve nada
			Consumer<String> consumidor = x -> System.out.println(x);
			consumidor.accept("Bienvenido");
			
			procesar(x -> System.out.println(x), "Bienvenido2");
			
			// Pasamos como referencia una funcion que se encuentra en nuestro propio programa
			procesar(referenceMethods::saludar, "Bienvenido3");
		}
		/**
		 * Ejecuta esta funcion, pasando como expresion primero un SYSO, y luego el metodo saludar
		 * Cuenta que en la linea 12 ha implementado la funcion
		 * @param <T>
		 * @param expresion
		 * @param mensaje
		 */
		public static <T> void procesar(Consumer<T> expresion, T mensaje) {
			expresion.accept(mensaje);
		}
		
		// Disponemos de otro metodo en la misma clase que cumple con el patron 
		// de la expresion lambda (reciba un parametro y no devuelva nada)
		public static void saludar(String saludo) {
			System.out.println("*****************************");
			System.out.println(saludo);
			System.out.println("*****************************");
		}
	}

