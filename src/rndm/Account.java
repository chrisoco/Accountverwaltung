package rndm;

import java.util.Scanner;

public class Account {
	private String Nachname;
	private String Vorname;
	private String Adresse;
	private String PLZ;
	private String Stadt;
	
	public Account(String Nachname, String Vorname, String Adresse, String PLZ, String Stadt) {
		this.Nachname = Nachname;
		this.Vorname  = Vorname;
		this.Adresse  = Adresse;
		this.PLZ      = PLZ;
		this.Stadt    = Stadt;
	}

	public static Account create() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nachname = ");
		String Nachname = sc.nextLine();
		System.out.print("Vorname = ");
		String Vorname  = sc.nextLine();
		System.out.print("Adresse = ");
		String Adresse  = sc.nextLine();
		System.out.print("PLZ = ");
		String PLZ      = sc.nextLine();
		System.out.print("Stadt = ");
		String Stadt    = sc.nextLine();
		
		return new Account(Nachname, Vorname, Adresse, PLZ, Stadt);
	}
	
	@Override
	public String toString() {
		return this.Nachname + "\n" + this.Vorname + "\n" + this.Adresse + "\n" + this.PLZ + "\n" + this.Stadt + "\n";
	}
	
	public String toFile() {
		return this.Nachname + "," + this.Vorname + "," + this.Adresse + "," + this.PLZ + "," + this.Stadt + "\r\n";
	}
	
// Getter & Setters
	
	public String getNachname() {
		return Nachname;
	}
	public void setNachname(String nachname) {
		Nachname = nachname;
	}
	public String getVorname() {
		return Vorname;
	}
	public void setVorname(String vorname) {
		Vorname = vorname;
	}
	public String getAdresse() {
		return Adresse;
	}
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	public String getPLZ() {
		return PLZ;
	}
	public void setPLZ(String plz) {
		PLZ = plz;
	}
	public String getStadt() {
		return Stadt;
	}
	public void setStadt(String stadt) {
		Stadt = stadt;
	}
	
}
