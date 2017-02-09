package DBHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DeleteQuery {

	private Connection conn;
	
	public DeleteQuery() {
		
		Properties properties = new Properties();
		InputStream in = getClass().getResourceAsStream("dbConnection.properties");
		try {
			properties.load(in);
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String driver = properties.getProperty("driver.name");
		String url = properties.getProperty("server.name");
		String username = properties.getProperty("user.name");
		String password = properties.getProperty("user.password");
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void doDelete(int id) {
		
		String query = "DELETE FROM ListaContacte WHERE id = ?";
		
		
		try {
			PreparedStatement ps;
			
			ps = conn.prepareStatement(query);
				ps.setInt(1, id);
				
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
