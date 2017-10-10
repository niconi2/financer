package servlet;

import java.sql.*;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import help.Person;
import help.SendMail;
import help.Datenbank;


@ManagedBean
@SessionScoped
public class PersonenManager {
	
	
	private String vorname;
	private String nachname;
	private int userID;
	private String emailadresse;
	private String waehrungskuerzel;
	private String pin;
	private String auswahl;
	


	private ArrayList<Person> personenListe = new ArrayList<Person>();

	
	public String speichern(){
		
		//Datenbank initialisieren
		Datenbank db = new Datenbank();
		
		//Person anlegen und die Werte aus den Parametern anlegen.
		Person p = new Person();
		


		p.setNachname(nachname);
		p.setVorname(vorname);
		p.setEmailadresse(emailadresse);
		
		ResultSet rs = db.empfangen("SELECT MAX(userID) FROM user");
		try {
			rs.next();
			p.setUserID(Integer.parseInt(rs.getString("MAX(UserID)"))+1);
			System.out.println(p.getUserID());
			
		}  catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		
		p.setWaehrungskuerzel(waehrungskuerzel);
		
		String pers = String.valueOf(p.getUserID());
		
		System.out.println("Position1 "+pers);
		
		
		//versendeWillkommensEmail();
		
	
		
		speichereInDb(db);
		
		rs = db.empfangen("SELECT * FROM user;");
		
		
		
		
		
		try {
			while (rs.next()) {
				System.out.println(rs.getString("Nachname"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		personenListe.add(p);
		
		//Variablen leeren
		
		vorname="";
		nachname="";
		userID++;

		
		if (auswahl.equals("Tabelle")) {
			return "Tabelle";
		}else {
			return "Zusammenfassung";
		}
		
}






	private void speichereInDb(Datenbank db) {
		String befehl = "INSERT INTO user (UserID, Vorname, Nachname, EMailAdresse, WaehrungsKuerzel) VALUES ("
				+ "NULL"
				+ ", '"
				+ vorname
				+ "', '"
				+ nachname
				+ "', '"
				+ emailadresse
				+ "', '"
				+ waehrungskuerzel
				+ "');";;
		
		db.senden(befehl);
	}






	private void versendeWillkommensEmail() {
		SendMail mail = new SendMail();
		
		String sub = "Willkommen "+vorname;
		String text = "Herzlich Willkommen "+vorname+" "+nachname+"!"
				+ "\n\n Sch�n das du dich bei Financer2020 angemeldet hast!";
		
		
		mail.send(getEmailadresse(), sub, text);
	}
	




	
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getAuswahl() {
		return auswahl;
	}
	public void setAuswahl(String auswahl) {
		this.auswahl = auswahl;
	}
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}


	public String getEmailadresse() {
		return emailadresse;
	}

	public void setEmailadresse(String emailadresse) {
		this.emailadresse = emailadresse;
	}

	public String getWaehrungskuerzel() {
		return waehrungskuerzel;
	}


	public void setWaehrungskuerzel(String waehrungskuerzel) {
		this.waehrungskuerzel = waehrungskuerzel;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}









	public ArrayList<Person> getPersonenListe() {
		return personenListe;
	}




	public void setPersonenListe(ArrayList<Person> personenListe) {
		this.personenListe = personenListe;
	}
	


}
