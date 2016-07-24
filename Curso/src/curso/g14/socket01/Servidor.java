package curso.g14.socket01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Servidor  extends Thread {
	private ServerSocket serverSocket;
	   
	   public  Servidor(int port) throws IOException
	   {
	      serverSocket = new ServerSocket(port);
	      serverSocket.setSoTimeout(10000);
	   }

	   public void run()
	   {
	      while(true)
	      {
	         try
	         {
	            System.out.println("Esperando conexion en puerto " +
	            serverSocket.getLocalPort() + "...");
	            Socket server = serverSocket.accept();
	            System.out.println("Conexion desde " + server.getRemoteSocketAddress());
	            DataInputStream in = new DataInputStream(server.getInputStream());
	            System.out.println(in.readUTF());
	            DataOutputStream out = new DataOutputStream(server.getOutputStream());
	            out.writeUTF("Gracias por conectarte a " + server.getLocalSocketAddress() + "\nAdiosito!");
	            server.close();
	         }catch(SocketTimeoutException s)
	         {
	            System.out.println("Socket timed out!");
	            break;
	         }catch(IOException e)
	         {
	            e.printStackTrace();
	            break;
	         }
	      }
	   }
	   public static void main(String [] args)
	   {
	      int port = 6000;		//Integer.parseInt(args[0]);
	      try
	      {
	         Thread t = new Servidor(port);
	         t.start();
	      }catch(IOException e)
	      {
	         e.printStackTrace();
	      }
	   }
	}

