import java.util.Scanner;

public class Main {

	private static Scanner keyboard = new Scanner(System.in);
	static MobilePhone mobilePhone = new MobilePhone();
	public static void main(String[] args) {
		boolean quit = false;
		startPhone();
		printMenu();
		
		while(!quit) {
			System.out.print("What would you like to do [6 to show menu]: ");
			int option = keyboard.nextInt();
			keyboard.nextLine();
			
			switch(option) {
			case 1: 
				mobilePhone.printContacts();
				break;
			case 2:
				addContact();
				break;
			case 3:
				updateContact();
				break;
			case 4:
				removeContact();
				break;
			case 5:
				queryContact();
				break;
			case 6: 
				printMenu();
				break;
			}
		}
		shutDown();
	}
	private static void queryContact() {
		// TODO Auto-generated method stub
		
	}
	private static void removeContact() {
		// TODO Auto-generated method stub
		
	}
	private static void updateContact() {
		// TODO Auto-generated method stub
		
	}
	private static void addContact() {
		// TODO Auto-generated method stub
		
	}
	private static void printMenu() {
		System.out.println("Menu\n");
		System.out.println("Press:\n" +
				"0 - shut down\n" +
				"1 - print contact list\n" +
				"2 - add a new contact\n" +
				"3 - update an existing contact\n" +
				"4 - remove an existing contact\n" +
				"5 - search for a contact" +
				"6 - print menu");
	}
	private static void startPhone() {
		System.out.println("Starting phone...");
	}
	
	private static void shutDown() {
		System.out.println("Shutting down...");
	}

}
