import java.util.ArrayList;

public class MobilePhone {
	private ArrayList<Contact> contactList;
	
	public MobilePhone() {
		this.contactList = new ArrayList<Contact>();
	}
	
	public ArrayList<Contact> getContactList() {
		return contactList;
	}

	// Method to add a new contact
	public boolean addContact(Contact contact) {
		if(search(contact.getName()) >= 0) {
			return false;
		}
		else {
			this.contactList.add(contact);
			return true;
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
			System.out.println("Contact was removed.");
		}
	}
	
	// Method to search for an existing name
	public Contact queryContacts(String name) {
		int index = search(name);
		if(index >=0 ) {
			return this.contactList.get(index);
		}
		else {
			return null;
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
	
	public Contact getAssociatedNum(String name) {
		Contact existingContact = this.contactList.get(search(name));
		return existingContact;
	}
	
	public boolean onFile(String name) {
		int index = search(name);
		if(index >=0) {
			return true;
		}
		else {
			return false;
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
