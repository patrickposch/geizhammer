package model;

public class Benutzer {

	public Benutzer(int binID, String vorname, String nachname, String email, int fKstand) {
		super();
		this.binID = binID;
		this.vorname = vorname;
		this.nachname = nachname;
		this.email = email;
		FKstand = fKstand;
	}

	private int binID;
	private String vorname;
	private String nachname;
	private String email;
	private int FKstand;

	public int getBinID() {
		return binID;
	}

	public void setBinID(int binID) {
		this.binID = binID;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getFKstand() {
		return FKstand;
	}

	public void setFKstand(int fKstand) {
		FKstand = fKstand;
	}

}
