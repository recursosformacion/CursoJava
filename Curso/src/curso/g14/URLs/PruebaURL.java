package curso.g14.URLs;

import java.net.MalformedURLException;
import java.net.URL;

public class PruebaURL {

	public static void main(String[] args) throws MalformedURLException {
		URL aURL =
				new URL("http://www.recursosformacion.com:80"+
		                "/wordpress/2015/06/java-un-resumen-organizado-o-no?id=1#Referencias");

		System.out.println("protocol = " + aURL.getProtocol());
		System.out.println("authority = " + aURL.getAuthority());
		System.out.println("host = " + aURL.getHost());
		System.out.println("port = " + aURL.getPort());
		System.out.println("path = " + aURL.getPath());
		System.out.println("query = " + aURL.getQuery());
		System.out.println("filename = " + aURL.getFile());
		System.out.println("ref = " + aURL.getRef());
		System.out.println("userInfo = " + aURL.getUserInfo());


	}

}
