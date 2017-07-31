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
	
	private int personalNummer;
	

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

	public int getPersonalNummer() {
		return personalNummer;
	}

	public void setPersonalNummer(int personalNummer) {
		this.personalNummer = personalNummer;
	}

}


