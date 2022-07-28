package curso.g14.socket03Inet;


	import java.net.InetAddress;
	import java.net.NetworkInterface;
	import java.net.ServerSocket;
	import java.net.Socket;
	import java.util.Enumeration;

	public class LeerIp {
	  static public void main(String args[]) throws Exception {
	    int port = 80;

	    NetworkInterface ni = NetworkInterface.getByName("eth0");
	    Enumeration<InetAddress> e = ni.getInetAddresses();
	    if (!e.hasMoreElements())
	      return;
	    InetAddress ia = (InetAddress) e.nextElement();
System.out.println("IP:"+ia.toString());
	    ServerSocket ss = new ServerSocket(port, 20, ia);
	    System.out.println("Listening");
	    Socket s = ss.accept();
	    System.out.println(s);
	  }
	}

