package help;


import servlet.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Daten zu einer Person.
 */
public class Person {
	
	private String nachname;
	
	private String vorname;
	
	private int userID;
	
	private String emailadresse;
	
	private String waehrungskuerzel;
	
	private String pin;
	

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

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getVorname() {
		return vorname;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

}


