package rndm;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException{
		
		String choice;
		AccountVerwaltung accountverwaltung = AccountVerwaltung.load();
		
		do {
			System.out.println("\n1) Alle auflisten\n2) Eine Adresse Anzeigen\n3) Adresse Erfassen\n4) " +
							   "Adresse Löschen\n5) Alle Löschen\n6) Adresse verändern\n7) Speichern\n8) Neue Datei\nx) Beenden");
            System.out.println("Aktuelle Grösse Adressbuch: " + accountverwaltung.getAccounts().size() + "\n");
            choice = getChoice();
            
            switch (choice) {
            case "1": if(accountverwaltung.getAccounts().isEmpty()) {System.out.println("AccountVerwaltung ist leer."); break;} accountverwaltung.pList();         break;
            case "2": if(accountverwaltung.getAccounts().isEmpty()) {System.out.println("AccountVerwaltung ist leer."); break;} accountverwaltung.printAccount();  break;
            case "3":    accountverwaltung.getAccounts().add(Account.create()); break;
            case "4": if(accountverwaltung.getAccounts().isEmpty()) {System.out.println("AccountVerwaltung ist leer."); break;} accountverwaltung.delAccount();    break;
            case "5":    accountverwaltung.getAccounts().clear();               break;
            case "6": if(accountverwaltung.getAccounts().isEmpty()) {System.out.println("AccountVerwaltung ist leer."); break;} accountverwaltung.updateAccount(); break;
            case "7":    accountverwaltung.save();                              break;
            case "8":    accountverwaltung.getAccounts().clear(); AccountVerwaltung.FileName = ""; AccountVerwaltung.load(); break;
            case "x": System.out.println("BYE!");
            }
			
		} while(!choice.equals("x"));

	}
	
	private static String getChoice() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String choice;
		do {
			System.out.print("Ihre Wahl: ");
			choice = sc.next();
		}while(!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") && !choice.equals("5") 
			&& !choice.equals("6") && !choice.equals("7") && !choice.equals("8") && !choice.equals("x"));
		return choice;
	}

}
