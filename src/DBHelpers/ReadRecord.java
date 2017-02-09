package DBHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import model.Prieteni;

public class ReadRecord {
	
	private Connection conn; 
	private ResultSet result;
	
	Prieteni prieten = new Prieteni();
	int id;
	
	public ReadRecord (int id) {
		
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
		
		this.id = id;
		
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
	
	public void doRead() {
		
		String query = "SELECT * FROM ListaContacte WHERE id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(query);
				ps.setInt(1, id);
			
			result = ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		try {
			result.next();
				prieten.setId(result.getInt("id"));
				prieten.setNume(result.getString("nume"));
				prieten.setPrenume(result.getString("prenume"));
				prieten.setEmail(result.getString("email"));
				prieten.setNrTel(result.getString("nrtel"));
				prieten.setVarsta(result.getInt("varsta"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Prieteni getPrieten() {
		return prieten;
	}

}
