package curso.g9910.MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("No existe el Driver");
			e.printStackTrace();
		}

		Connection conexion;
		try {
			conexion = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/gestion", "root", "garcia1"); 
		} catch (SQLException e) {
			System.out.println("Error en la operacion" + e.getMessage());
		}
	}

}
