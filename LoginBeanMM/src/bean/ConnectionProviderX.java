package bean;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
 

public class ConnectionProviderX {
	private static Connection con = null;
	private static Context env ;
	
	static {
		try {
			
			Context initCtx = new InitialContext();
			env = (Context) initCtx.lookup("java:comp/env");

		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Class.forName((String) env.lookup("DRIVER"));
			con = DriverManager.getConnection((String) env.lookup("CONNECTION_URL"),
					(String) env.lookup("USERNAME"),
					(String) env.lookup("PASSWORD"));
		} catch (Exception e) {
		}
	}

	public static Connection getCon() {
		return con;
	}

}
