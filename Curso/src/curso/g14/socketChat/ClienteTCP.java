package curso.g14.socketChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteTCP {
	public static final String HOST = "localhost";
	public static final String SOLICITUD = "Enviar(Indique q o Q para Quit):";
	public static final int PUERTO = 6000;

	public static void main(String argv[]) {

		String recibido;
		String aEnviar;
		Socket clientSocket = null;
		BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));

		try {
			/******
			 * Abrir Socket a servidor y preparar BufferReader y PrintWriter
			 */
			clientSocket = new Socket(HOST, PUERTO);
			PrintWriter prSocket = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader deSocket = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			while (true) {
				/**** recoger mensaje de linea y displayar en consola ***/
				recibido = deSocket.readLine();
				if (recibido.equals("q") || recibido.equals("Q")) {
					break;
				}
				System.out.println("Recibido:" + recibido);

				/**** recoger mensaje para enviar ***/
				System.out.println(SOLICITUD);
				aEnviar = consola.readLine();
				prSocket.println(aEnviar);
				if (aEnviar.equals("Q") || aEnviar.equals("q")) {
					break;
				}

			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				clientSocket.close();
				consola.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
