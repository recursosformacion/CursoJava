package bean;

import java.sql.*;

public class LoginDao {

	public static boolean validate(LoginBean bean) {
		boolean status = false;
		System.out.println("Entrando**************************************************************");
		try {
			Connection con = ConnectionProviderX.getCon();

			PreparedStatement ps = con.prepareStatement("select * from members where email=? and pass=?");

			ps.setString(1, bean.getEmail());
			ps.setString(2, bean.getPass());

			ResultSet rs = ps.executeQuery();
			System.out.println(ps.toString());
			status = rs.next();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;

	}
}
