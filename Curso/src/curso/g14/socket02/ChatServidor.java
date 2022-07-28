package curso.g14.socket02;

import java.net.*;
import java.io.*;

public class ChatServidor {
	private Socket socket = null;
	private ServerSocket server = null;
	private DataInputStream streamIn = null;

	public ChatServidor(int port) {
		try {
			System.out.println("Binding to port " + port + ", please wait  ...");
			server = new ServerSocket(port);
			System.out.println("Iniciando servidor en: " + server);
			System.out.println("Rsperando al cliente ...");
			socket = server.accept();
			System.out.println("Cliente aceptado: " + socket);
			open();
			boolean done = false;
			while (!done) {
				try {
					String line = streamIn.readUTF();
					System.out.println("en servidor:" + line);
					done = line.equals(".bye");
				} catch (IOException ioe) {
					done = true;
				}
			}
			close();
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
	}

	public void open() throws IOException {
		streamIn = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
	}

	public void close() throws IOException {
		if (socket != null)
			socket.close();
		if (streamIn != null)
			streamIn.close();
	}

	public static void main(String args[]) {
		ChatServidor server = null;

		server = new ChatServidor(6000);
	}
}