package curso.g14.socketChat10;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Servidor para el chat.
 * 
 * @author Ivan Salas Corrales <http://programandoointentandolo.com>
 */
 
public class ServidorChat {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        
        
        int puerto = 1234;
        int maximoConexiones = 10; // Maximo de conexiones simultaneas
        ServerSocket servidor = null; 
        Socket socket = null;
        MensajesChat mensajes = new MensajesChat();
        
        try {
            // Se crea el serverSocket
            servidor = new ServerSocket(puerto, maximoConexiones);
            
            // Bucle infinito para esperar conexiones
            while (true) {
               
                socket = servidor.accept();
                System.out.println("Cliente con la IP " + socket.getInetAddress().getHostName() + " conectado.");
                
                ConexionCliente cc = new ConexionCliente(socket, mensajes);
                cc.start();
                
            }
        } catch (IOException ex) {
        	System.out.println("Error: " + ex.getMessage());
        } finally{
            try {
                socket.close();
                servidor.close();
            } catch (IOException ex) {
            	System.out.println("Error al cerrar el servidor: " + ex.getMessage());
            }
        }
    }
}
