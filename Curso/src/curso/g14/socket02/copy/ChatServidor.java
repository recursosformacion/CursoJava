package curso.g14.socket02.copy;
import java.net.*;
import java.io.*;

public class ChatServidor {
	private static Socket socket = null;
	private static ServerSocket server = null;
	private static DataInputStream streamIn = null;

	public static void main(String args[]) throws IOException {
		int port=6000;
	
		server = new ServerSocket(port);			
		socket = server.accept();			
		streamIn = new DataInputStream(new BufferedInputStream(socket.getInputStream()));		
		String line = streamIn.readUTF();
		System.out.println(line);					
		if (socket != null)	socket.close();
		if (streamIn != null) streamIn.close();

	}
	
}