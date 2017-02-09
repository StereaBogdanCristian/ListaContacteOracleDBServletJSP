package DBHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadJDBC {
	
	public void read() {
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		
		
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "Campulung");
			Statement statement = conn.createStatement();
			String sql = "select * from ListaContacte";
			ResultSet rs = statement.executeQuery(sql);
		
			while (rs.next()) {
				System.out.println(rs.getInt("id") + " " + rs.getString("nume") + " " + rs.getString("prenume"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
