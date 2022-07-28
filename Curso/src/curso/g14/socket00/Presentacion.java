package curso.g14.socket00;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;

public class Presentacion {

	public static void main(String[] args) throws IOException {
//		if (false) {
		System.out.println("Fase uno****************************************");
		Socket socket = new Socket("recursosformacion.com", 80);
		OutputStream out = socket.getOutputStream();

		out.write("cosas".getBytes());
		out.flush();
		out.close();

		socket.close();
		System.out.println("Fase dos******************************************");
		Socket socketi = new Socket("recursosformacion.com", 80);
		InputStream in = socketi.getInputStream();

		int data = in.read();
		// ... leer...

		in.close();
		socketi.close();
		System.out.println("Fase tres***********************************************");
//		ServerSocket serverSocket = new ServerSocket(9000);
//
//		boolean isStopped = true;
//		while (!isStopped) {
//			Socket clientSocket = serverSocket.accept();
//
//			// do something with clientSocket
//		}
//		serverSocket.close();
//		}
		System.out.println("Fase cuatro***********************************************");
		String url = "https://recursosformacion.com/";

		URLConnection urlConnection = new URL(url).openConnection();
		urlConnection.addRequestProperty("User-Agent", "Mozilla");
		urlConnection.setReadTimeout(5000);
		urlConnection.setConnectTimeout(5000);

		String inputLine;
		try (InputStream is = urlConnection.getInputStream(); // new URL(url).openStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

			while ((inputLine = br.readLine()) != null) {

				System.out.println(inputLine);
			}

		}

	}

}
