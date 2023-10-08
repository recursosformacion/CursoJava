package curso.g14.socket02.copy;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatCliente {

	private static Socket socket = null;
	private DataInputStream console = null;
	private static DataOutputStream streamOut = null;


	public static void main(String args[]) throws UnknownHostException, IOException    {
		socket = new Socket("localhost", 6000);
		streamOut = new DataOutputStream(socket.getOutputStream());	
		streamOut.writeUTF("Este mensaje viene de cliente");
		
			
			if (streamOut != null)
				streamOut.close();
			if (socket != null)
				socket.close();
		
	}
}
/*
 * cd D:\Documentos\cursos\Google Drive\workspaceJAVA\Curso\bin java
 * curso.g14.socket01.Servidor
 * 
 */