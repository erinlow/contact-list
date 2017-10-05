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
			case 0:
				quit = true;
				break;
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
	
	// Removes an existing contact from the MobilePhone contact list.
	// Check to see if name is in the contact list and, if it returns true, calls the mobilePhone.removeContact()
	// and outputs a success message. If mobilePhone.onFile() methods returns false, outputs a message 
	// informing the user that the contact does not exist.
	private static void removeContact() {
		System.out.print("Enter the name of the contact you'd like to remove: ");
		String name = keyboard.nextLine();
		if(mobilePhone.onFile(name)) {
			mobilePhone.removeContact(name);
			
		}
		else {
			System.out.println("That contact does not exist");
		}
		
	}
	
	// Method to update an existing contact in the contact list.
	// Calls the mobilePhone.queryContacts() method and returns Contact. If it returns null, 
	// an error message will be output onto the console. If not null, mobilePhone.queryContacts() returns
	// oldContact. Then the user will be asked to input what s/he wants to update: name, number, or both. 
	// Updated information will be used to create Contact newContact. mobilePhone.updateContact() method is called
	// with Contact oldContact and Contact newContact as parameters. 
	private static void updateContact() {
		System.out.print("Enter the name of the contact you would like to update: ");
		String name = keyboard.nextLine();
		
		Contact oldContact = mobilePhone.queryContacts(name);
		if(oldContact !=null) {
			System.out.print("What information do you want to update [name/number/both]? ");
			String choice = keyboard.nextLine();
			
			Contact newContact = Contact.createContact(oldContact.getName(), oldContact.getPhoneNumber());
			
			if(choice.equals("name")) {
				System.out.print("Enter the new name: ");
				String newName = keyboard.nextLine();
				newContact.setName(newName);
			}
			else if(choice.equals("number")) {
				System.out.print("Enter the new number: ");
				String newNumber = keyboard.nextLine();
				newContact.setPhoneNumber(newNumber);
			}
			else {
				System.out.print("Enter the new name");
				String newName = keyboard.nextLine();
				System.out.print("Enter the new number: ");
				String newNumber = keyboard.nextLine();
				newContact.setName(newName);
				newContact.setPhoneNumber(newNumber);
			}
			
			mobilePhone.updateContact(oldContact, newContact);
		}
		else {
			System.out.println("Contact does not exist.");
		}
		
	}
	
	// Adds a new contact to MobilePhone contact list. 
	// 1 - checks to see if name is in the contact list and, if it is, outputs the associated number.
	// 2 - If the name is unique, mobilephone.addContact() is called and if it returns true, outputs a success
	// message and it it returns false, outputs a failure message.
	private static void addContact() {
		System.out.print("Enter the new contact name: ");
		String name = keyboard.nextLine();
		
		if(mobilePhone.onFile(name)) {
			Contact existingContact = mobilePhone.getAssociatedNum(name);
			System.out.println("That name already has a phone number associated with it.");
			System.out.println("It is: "+ existingContact.getPhoneNumber());
		}
		else {
			System.out.print("Enter " + name + "'s number: ");
			String number = keyboard.nextLine();
			
			Contact contact = Contact.createContact(name, number);
			if(mobilePhone.addContact(contact)) {
				System.out.println("Addition was successful.");
			}
			else {
				System.out.println("The addition failed.");
			}
		}
		
	}
	
	private static void printMenu() {
		System.out.println("Menu");
		System.out.println("Press:\n" +
				"0 - shut down\n" +
				"1 - print contact list\n" +
				"2 - add a new contact\n" +
				"3 - update an existing contact\n" +
				"4 - remove an existing contact\n" +
				"5 - search for a contact\n" +
				"6 - print menu\n");
	}
	private static void startPhone() {
		System.out.println("Starting phone...");
	}
	
	private static void shutDown() {
		System.out.println("Shutting down...");
	}

}
