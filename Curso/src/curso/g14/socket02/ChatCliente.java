package curso.g14.socket02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatCliente {

	private Socket socket = null;
	private DataInputStream console = null;
	private DataOutputStream streamOut = null;

	@SuppressWarnings("deprecation")
	public ChatCliente(String serverName, int serverPort) {
		System.out.println("Cl-Estableciendo conexion, por favor, espere ...");
		try {
			socket = new Socket(serverName, serverPort);
			System.out.println("Cl-Connected: " + socket);
			start();
		} catch (UnknownHostException uhe) {
			System.out.println("Cl-Host desconocido: " + uhe.getMessage());
		} catch (IOException ioe) {
			System.out.println("Cl-Unexpected exception: " + ioe.getMessage());
			stop();
			return;
		}
		String line = "";
		while (!line.equals(".bye")) {
			try {
				System.out.print("Cl-entrada");
				line = console.readLine();
				streamOut.writeUTF(line);
				streamOut.flush();
			} catch (IOException ioe) {
				System.out.println("Cl-Error enviando: " + ioe.getMessage());
			}
		}
	}

	public void start() throws IOException {
		console = new DataInputStream(System.in);
		streamOut = new DataOutputStream(socket.getOutputStream());
	}

	public void stop() {
		try {
			if (console != null)
				console.close();
			if (streamOut != null)
				streamOut.close();
			if (socket != null)
				socket.close();
		} catch (IOException ioe) {
			System.out.println("Error cerrando ...");
		}
	}

	public static void main(String args[]) {
		ChatCliente client = null;
		if (args.length != 2)
			System.out.println("Uso: host port");
		else
			client = new ChatCliente(args[0], Integer.parseInt(args[1]));
	}
}
/*
 * cd D:\AreaTrabajo\workspaceCurso\Curso\bin 
 * java curso.g14.socket01.Servidor
 * 
 */