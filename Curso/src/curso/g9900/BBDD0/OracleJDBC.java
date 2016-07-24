package curso.g9900.BBDD0;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class OracleJDBC {
	private static Connection conn;
	private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";  
	private final static String URL ="jdbc:oracle:thin:@localhost:1521:xe";
	private final static String DATABASE =  "";
	private final static String USUARIO="SYSTEM";
	private final static String PASSWORD="Curso201601";
	private final static String SQL_USE = "USE  ";
	private final static String SQL_CREATE = "CREATE DATABASE ";

	public static void main(String[] argv) {

		System.out.println("-------- Oracle JDBC Connection Testing ------");

		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return;
		}

		System.out.println("Oracle JDBC Driver Registered!");
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL+DATABASE,USUARIO,PASSWORD);
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}
}
