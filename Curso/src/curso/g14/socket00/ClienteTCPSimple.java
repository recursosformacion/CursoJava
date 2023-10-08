package curso.g14.socket00;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClienteTCPSimple {
	
	public static final int PUERTO = 6000;
	public static final String DIRECCION = "localhost";
	
	public static void main(String[] args) {

		try {
			Socket client = new Socket(DIRECCION, PUERTO);
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
