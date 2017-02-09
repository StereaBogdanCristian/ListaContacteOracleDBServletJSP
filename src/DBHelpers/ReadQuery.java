package DBHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import model.Prieteni;

import java.io.IOException;
import java.io.InputStream;


public class ReadQuery {
	
	private Connection conn;
	private ResultSet result;
	
	public ReadQuery() {
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
	
	
	public void doRead() {
		
		String query = "select * from ListaContacte";
		
		try {
			Statement statement = conn.createStatement();
			this.result = statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public String getHTMLTable() {
		
		String table = "";
		
		table += "<table border=1>";
		
			table += "<tr>";
		
			table += "<td>";
				table += "ID";
			table += "</td>";
		
			table += "<td>";
				table += "Nume";
			table += "</td>";
	
			table += "<td>";
				table += "Prenume";
			table += "</td>";
	
			table += "<td>";
				table += "Email";
			table += "</td>";
		
			table += "<td>";
				table += "Nr tel";
			table += "</td>";
		
			table += "<td>";
				table += "Varsta";
			table += "</td>";
		
			table += "<td>";
				table += "Optiuni gestionate date";			
			table += "</td>";

			table += "</tr>";
		
			try {
				while (this.result.next()) {
					
					Prieteni prieten = new Prieteni();
					prieten.setId(this.result.getInt("id"));
					prieten.setNume(this.result.getString("nume"));
					prieten.setPrenume(this.result.getString("prenume"));
					prieten.setEmail(this.result.getString("email"));
					prieten.setNrTel(this.result.getString("nrtel"));
					prieten.setVarsta(this.result.getInt("varsta"));
					
					table += "<tr>";
					
						table += "<td>";
							table += prieten.getId();
						table += "</td>";
						
						table += "<td>";
							table += prieten.getNume();
						table += "</td>";
					
						table += "<td>";
							table += prieten.getPrenume();
						table += "</td>";
					
						table += "<td>";
							table += prieten.getEmail();
						table += "</td>";
						
						table += "<td>";
							table += prieten.getNrTel();
						table += "</td>";
						
						table += "<td>";
							table += prieten.getVarsta();
						table += "</td>";
						
						table += "<td>";
							table += "<a href=update?id=" + prieten.getId() + "> Modifica    </a> <a href=delete?id=" + prieten.getId() + ">  Sterge </a>";			
						table += "</td>";
				
					table += "</tr>";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		table += "</table>";
		
		return table;
	}
}
