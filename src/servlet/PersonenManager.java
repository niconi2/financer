package servlet;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import help.Person;

@ManagedBean
@SessionScoped
public class PersonenManager {
	
	
	private String vorname;
	private String nachname;
	private int personalNummer;
	private String auswahl;
	
	private ArrayList<Person> personenListe = new ArrayList<Person>();
	
	
	public String anzeige(){
		
		
		//Person anlegen und die Werte aus den Parametern anlegen.
		Person p = new Person();
		
		p.setNachname(nachname);
		p.setPersonalNummer(personalNummer);
		p.setVorname(vorname);
		
		personenListe.add(p);
		
		//Variablen leeren
		
		vorname="";
		nachname="";
		personalNummer++;
		
		if (auswahl.equals("Tabelle")) {
			return "Tabelle";
		}else {
			return "Zusammenfassung";
		}
		
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
	public int getPersonalnummer() {
		return personalNummer;
	}
	public void setPersonalnummer(int personalnummer) {
		this.personalNummer = personalnummer;
	}
	public String getAuswahl() {
		return auswahl;
	}
	public void setAuswahl(String auswahl) {
		this.auswahl = auswahl;
	}




	public int getPersonalNummer() {
		return personalNummer;
	}




	public void setPersonalNummer(int personalNummer) {
		this.personalNummer = personalNummer;
	}




	public ArrayList<Person> getPersonenListe() {
		return personenListe;
	}




	public void setPersonenListe(ArrayList<Person> personenListe) {
		this.personenListe = personenListe;
	}
	
	
	
	

}
