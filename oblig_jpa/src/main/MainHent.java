package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainHent {

	static final String JDBC_DRIVER = "org.postgresql.DRIVER";
	
	static final String DB_URL = "jdbc::postgresql://ider-database.westeurope.cloudapp.azure.com:5432/h591327";
	static final String USER = "h591327";
	static final String PASS = "pass";
			
			
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql = "SELECT ansatt_id, navn FROM oblig_jpa.ansatt";
			//tabell som har rader og kolonner
			ResultSet rs = stmt.executeQuery(sql);
			
			
			System.out.println("Halla!");
			
			while(rs.next()) {
				int ansatt_id = rs.getInt("ansatt_id");
				String navn = rs.getString("navn");
				
				// Display values
				System.out.println("ID: " + ansatt_id);
				System.out.println(", Navn: " + navn);
			}
			
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
		}
		
		System.out.println("Ferdig!");
		}

	}


