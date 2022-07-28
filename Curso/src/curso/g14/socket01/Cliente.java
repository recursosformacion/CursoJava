package curso.g14.socket01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Cliente {
	public static void main(String[] args) {
		String serverName = "localhost";		// args[0];
		int port = 6000;						//Integer.parseInt(args[1]);
		try {
			System.out.println("Conectando a " + serverName + " por puerto " + port);
			Socket client = new Socket(serverName, port);
			System.out.println("conectado a " + client.getRemoteSocketAddress());
			OutputStream outToServer = client.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
			out.writeUTF("Saluditos desde " + client.getLocalSocketAddress());
			InputStream inFromServer = client.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);
			System.out.println("Me han contestado " + in.readUTF());
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
/*
cd D:\AreaTrabajo\WorkspaceCurso\Curso\bin
java curso.g14.socket01.Servidor

*/