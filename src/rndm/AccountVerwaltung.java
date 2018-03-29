package rndm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class AccountVerwaltung {
	static String FileName = "";
	
	private ArrayList<Account> accounts = new ArrayList<>();
	
	private AccountVerwaltung(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}
	
	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	
	void pList() {
		int i = 0;
		for (Account account : this.accounts) {
			System.out.println("ID = " + i);
			System.out.println(account.toString());
			i++;
		}
	}
	
	private int getID() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int ID;
		
		do {
			System.out.print("ID (0-n) = ");
			while (!sc.hasNextInt()) {
				System.out.println("No Valid Input!");
				sc.next();
			}
			ID = sc.nextInt();
		} while (ID >= this.accounts.size());
		
		return ID;
	}
	
	void delAccount() {
		this.accounts.remove(getID());
	}

	void printAccount() {
		System.out.println(this.accounts.get(getID()));
	}
	
	void updateAccount() {
		this.accounts.set(getID(), Account.create());
	}
	
	private static void showActiveDirectory() {
		File   folder      = new File("./SAVES/");
		File[] listOfFiles = folder.listFiles();
		
		System.out.println(folder + ":<");
		
		for (File Files : listOfFiles) {
			if (Files.isFile()) {
				System.out.println("   File : " + Files.getName());
			} else if (Files.isDirectory()) {
				System.out.println("   Dir  : " + Files.getName());
			}
		}
		System.out.println("\n");
	}
	
	static void CheckFileNameEnd() {
		if(FileName.contains(".txt")) {
			FileName = FileName.substring(0, FileName.length() - 4);
		}
		
	}
	// HOW TO WRITE AND READ FROM FILE (OBJECTS)
	void save() throws IOException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		if (FileName.equals("")) {
			System.out.print("Please Enter File Name: ");
			FileName = sc.nextLine();
		}
		CheckFileNameEnd();
		File output = new File("./SAVES/" + FileName + ".txt");
		System.out.println("Created File: ./SAVES/" + FileName + ".txt\n");
		
		try(FileWriter fw = new FileWriter(output)){
			for (Account account : this.accounts) {
				fw.write(account.toFile());
			}
			System.out.println("Successfully Saved Data to File: ./SAVES/" + FileName + ".txt");
			fw.close();
		}
	}
	
	public static ArrayList<Account> InsertData() throws IOException {
		ArrayList<Account> result = new ArrayList<Account>();
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(new File("./SAVES/" + FileName + ".txt"));
		
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			String[] lineArray = line.split(",");
			result.add(new Account(lineArray[0], lineArray[1], lineArray[2], lineArray[3], lineArray[4]));
		}
		return result;
	}
	
	static AccountVerwaltung load() throws IOException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		showActiveDirectory();
		
		System.out.print("Neu Erstellen (x)\nDateiname: ");
		FileName = sc.nextLine();
		CheckFileNameEnd();
		
		if ("x".equals(FileName) || "".equals(FileName)) {
			System.out.println("Creating new temp. File.");
		} else {
			try {
				ArrayList<Account> result = new ArrayList<Account>();

				@SuppressWarnings("resource")
				Scanner scs = new Scanner(new File("./SAVES/" + FileName + ".txt"));
				
				while (scs.hasNextLine()) {
					String   line      = scs.nextLine();
					String[] lineArray = line.split(",");
					
					result.add(new Account(lineArray[0], lineArray[1], lineArray[2], lineArray[3], lineArray[4]));
				}
				return new AccountVerwaltung(result);
			} catch(FileNotFoundException e) {
				System.out.println("File not Found.. Creating new temp. File: " + FileName + ".txt");	
			}
		}
		return new AccountVerwaltung(new ArrayList<>());
	}
	
}























