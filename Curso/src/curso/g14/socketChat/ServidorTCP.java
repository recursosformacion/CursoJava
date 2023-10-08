package curso.g14.socketChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServidorTCP {
	public static final String SALUDO = "Servidor esperando en puerto ";
	public static final String SOLICITUD = "Enviar(Indique q o Q para Quit):";
	public static final int PUERTO = 6000;

	public static void main(String argv[]) throws Exception {

		String fromclient;
		String toclient;
		BufferedReader consola = null;
		Socket connected = null ;

		ServerSocket Server = new ServerSocket(PUERTO);
		System.out.println(SALUDO + PUERTO);

		try {
			connected = Server.accept();
			System.out.println(" Cliente" + " " + connected.getInetAddress() + 
					                              ":" + connected.getPort() + " conectado ");
			consola = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader bfSocket = new BufferedReader(new InputStreamReader(connected.getInputStream()));
			PrintWriter prSocket = new PrintWriter(connected.getOutputStream(), true);

			while (true) {

				/* pedir datos para enviar */
				System.out.println(SOLICITUD);
				toclient = consola.readLine();
				prSocket.println(toclient);
				if (toclient.equals("q") || toclient.equals("Q")) {
					break;
				}

				/*** recibir datos por red y presentarlos **/
				fromclient = bfSocket.readLine();
				if (fromclient.equals("q") || fromclient.equals("Q")) {
					break;
				}
				System.out.println("Recibido:" + fromclient);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				connected.close();
				consola.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
