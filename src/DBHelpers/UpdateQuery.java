package DBHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import model.Prieteni;

public class UpdateQuery {
	
	private Connection conn;
	private int id;
	
	public UpdateQuery(int id) {
		 
		this.id = id;
		 
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
	
	public void doUpdate (Prieteni prieten) {
		
		String query = "UPDATE ListaContacte SET nume = ?, prenume = ?, email = ?, nrTel = ?, varsta = ? WHERE id = ?";
		
		
		try {
			PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, prieten.getNume());
				ps.setString(2, prieten.getPrenume());
				ps.setString(3, prieten.getEmail());
				ps.setString(4, prieten.getNrTel());
				ps.setInt(5, prieten.getVarsta());
				ps.setInt(6, id);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
