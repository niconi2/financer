package help;

import java.sql.*;

public class Test {

	public static void main(String[] args) {
		
		Datenbank db = new Datenbank();
		
		//Connection con = db.getCon();
		
		int pers = 0;
		String nachname = "Mustermann";
		String vorname = "Max";
		
			
			try{
			
			//Statement stmt = con.createStatement();
				
			//druckeNachname(stmt);
			
			String befehl = "INSERT INTO person (Personalnummer, Vorname, Nachname) VALUES ("
					+ pers
					+ ", '"
					+ vorname
					+ "', '"
					+ nachname
					+ "');";;
				
					db.senden(befehl);
			

			//PreparedStatement ps = con.prepareStatement(befehl);
			
			//ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		

			}

	private static void druckeNachname(Statement stmt) throws SQLException {
		ResultSet datenmenge;
		
		datenmenge = stmt.executeQuery("SELECT * FROM person;");
		
		while (datenmenge.next()) {
			System.out.println(datenmenge.getString("Nachname"));
			
		}
	}
	}
