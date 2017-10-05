import java.util.ArrayList;

public class MobilePhone {
	private ArrayList<Contact> contactList;
	
	public MobilePhone() {
		this.contactList = new ArrayList<Contact>();
	}
	
	// Method to add a new contact
	public void addContact(Contact contact) {
		if(search(contact) >= 0) {
			System.out.println("Contact already exists");
		}
		else {
			this.contactList.add(contact);
			System.out.println("Contact was succefully added");
		}
	}
	
	// Method to update an existing contact
	public void updateContact(Contact oldContact, Contact newContact) {
		int index = search(oldContact);
		if(index < 0) {
			System.out.println("Contact does not exist");
		}
		else {
			this.contactList.set(index, newContact);
			System.out.println("Update succesful");
		}
	}
	
	// Method to remove an existing contact
	public void removeContact(String name) {
		if(search(name) >=0 ) {
			this.contactList.remove(search(name));
			System.out.print("Contact was removed");
		}
		else {
			System.out.println("Contact does not exist.");
		}
		
	}
	
	// Method to search for an existing name
	public void queryContacts(String name) {
		int index = search(name);
		if(index >=0 ) {
			Contact contact = this.contactList.get(index);
			System.out.println("The phone number is: " + contact.getPhoneNumber());
		}
		else {
			System.out.println("Contact does not exist.");
		}
	}
	
	// Method to print contact list 
	public void printContacts() {
		if(this.contactList.size() >0) {
			System.out.println("Contact List:");
			for(int i=0; i<this.contactList.size(); i++) {
				Contact contact = this.contactList.get(i);
				System.out.println(contact.getName() + " --> " + contact.getPhoneNumber());
			}	
		}
		else {
			System.out.println("You have no contacts in your contact list.");
		}
	}

	// Search method that takes in Contact
	private int search(Contact contact) {
		return this.contactList.indexOf(contact);
	}
	
	// Search method that takes in a String
	private int search(String name) {
		for(int i=0; i<this.contactList.size(); i++) {
			Contact contact = this.contactList.get(i);
			if(contact.getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}


	
}
