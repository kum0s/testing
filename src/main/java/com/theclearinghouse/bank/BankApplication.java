package com.theclearinghouse.bank;

import java.util.List;
import java.util.Scanner;

public class BankApplication {
	private final static String CSV_FILE = "src/main/resources/the-clearing-house.csv";
	private BankServices bankServices;
	
	static public void main(final String[] argv) {
		//Pass CSV file on command line or it will use one from resources dir
		BankApplication bankApp = new BankApplication(argv);
		bankApp.handleUserQueries();
	}

	BankApplication(final String[] argv){
		bankServices = new BankServices();
		if(argv.length > 0) {
			bankServices.loadBanks(argv[0]);
		} else {
			bankServices.loadBanks(CSV_FILE);	
		}
	}
	
	public int getUserSearchSelection() {
		Scanner in = new Scanner(System.in);
		int input;
		 while(true) {
			System.out.println("1) Search by Bank Name\n"
					+ "2) Search by Bank type\n"
					+ "3) Search by Bank City\n"
					+ "4) Search by Bank State\n"
					+ "5) Search by Bank ZipCode\n"
					+ "6) Search by Bank City and State\n"
					+ "0) Exit\n"
					);
			System.out.print("Selection: ");	
			if(in.hasNextInt()) {
				input = in.nextInt();
				break;	
			}
			in.next();
		} 
		return input;
	}

	public void handleUserQueries() {
		Scanner in = new Scanner(System.in);
		boolean leave = false;
		List<Bank> banks;
		while(!leave) {
			int input = getUserSearchSelection();

			switch (input) {
			case 1: //name
				System.out.print("Enter Bank name:");
				banks = bankServices.getBankByName(in.nextLine());
				banks.stream().forEach(bank -> System.out.println(bank.toString()));
				break;

			case 2: //type
				System.out.print("Enter Bank type(ATM, Branch):");
				banks = bankServices.getBankByType(in.nextLine());
				banks.stream().forEach(bank -> System.out.println(bank.toString()));
				break;

			case 3: //city
				System.out.print("Enter Bank City:");
				banks = bankServices.getBankByCity(in.nextLine());
				banks.stream().forEach(bank -> System.out.println(bank.toString()));
				break;

			case 4: //state
				System.out.print("Enter Bank State:");
				banks = bankServices.getBankByState(in.nextLine());
				banks.stream().forEach(bank -> System.out.println(bank.toString()));
				break;

			case 5: //zipcode
				System.out.print("Enter Bank ZipCode:");
				banks = bankServices.getBankByZipCode(in.nextLine());
				banks.stream().forEach(bank -> System.out.println(bank.toString()));
				break;

			case 6: //city,state
				System.out.print("Enter Bank City:");
			    String city = in.nextLine();
			    
				System.out.print("Enter Bank State:");
			    String state = in.nextLine();
			    
				banks = bankServices.getBankByCityAndState(city, state);
				banks.stream().forEach(bank -> System.out.println(bank.toString()));
				break;
				
			case 0: //exit
				leave=true;
				break;
			default:
				break;
			}	
		}
	}
}
