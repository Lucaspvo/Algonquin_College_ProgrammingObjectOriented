/*
* File Name: ContactManager.java
*	Course Name: Object-Oriented Programming
*	Lab	Section: 302
*	Student	Name: Lucas Pazelo Vargas de Oliveira (040799663)
*	Date: 10/11/2014
*(Stanley	Pieda	(2014)	personal	communication)
*/
package exceptions;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager {

	private static final int ADD_CONTACT = 1; //Field to add a contact
	private static final int REMOVE_CONTACT = 2; //Field to remove a contact
	private static final int SORT_FIRST_NAME = 3;	//Field to sort first name
	private static final int SORT_FIRST_NAME_DESC = 4;	//Field to sort first name descending
	private static final int SORT_LAST_NAME = 5; //Field to sort last name
	private static final int SORT_LAST_NAME_DESC = 6; //Field to sort last name descending
	private static final int VIEW_CONTACTS = 7; //Field to view contacts
	private static final int EDIT = 8; //Field to edit a contact
	private static final int EXIT = 9; //Field to exit the program
	private static final int EDIT_FIRST_NAME = 10; //Field to edit first name
	private static final int EDIT_LAST_NAME = 11;	//Field to edit last name
	private static final int EDIT_PHONE_NUMBER = 12; //Field to edit phone number
	private static final int EXIT_EDIT = 13; //Field to return to the main loop
	List<Contact> contacts; //List of Contacts
	Scanner input; //Variable used to receive data from the user
	
	//Constructor of Contact Manager without parameters
	public ContactManager(){
		contacts = new ArrayList<Contact>();
		input = new Scanner(System.in); 
	}
	
	//Method used to call the menu for the user
	public void runContactManager() throws ValidationException{
		showMenu();
	}
	
	//Method that interact with the user through a menu
	private void showMenu() throws ValidationException{
		System.out.println("1 Add contact\n2 Remove contact\n3 Sort by first name\n4 Sort by first name descending\n5 Sort by last name\n6 Sort by last name descending\n7 View contacts\n8 Edit\n9 Exit program");
		int option;
		try{
			option = Integer.parseInt(input.next());
			switch(option){
				case ADD_CONTACT: addContact();
					break;
				case REMOVE_CONTACT: removeContact();
					break;
				case SORT_FIRST_NAME: sortFirstName();
					break;
				case SORT_FIRST_NAME_DESC: sortFirstNameDescending();
					break;
				case SORT_LAST_NAME: sortLastName();
					break;
				case SORT_LAST_NAME_DESC: sortLastNameDescending();
					break;
				case VIEW_CONTACTS: viewContacts();
					break;
				case EDIT: editContacts();
					break;
				case EXIT: System.exit(1);
			}
		}
		catch(NumberFormatException ex){
			System.out.println("Please enter only numbers");
		}
		while(true){
			System.out.println("1 Add contact\n2 Remove contact\n3 Sort by first name\n4 Sort by first name descending\n5 Sort by last name\n6 Sort by last name descending\n7 View contacts\n8 Edit\n9 Exit program");
			try{
				option = Integer.parseInt(input.next());
				switch(option){
					case ADD_CONTACT: addContact();
						break;
					case REMOVE_CONTACT: removeContact();
						break;
					case SORT_FIRST_NAME: sortFirstName();
						break;
					case SORT_FIRST_NAME_DESC: sortFirstNameDescending();
						break;
					case SORT_LAST_NAME: sortLastName();
						break;
					case SORT_LAST_NAME_DESC: sortLastNameDescending();
						break;
					case VIEW_CONTACTS: viewContacts();
						break;
					case EDIT: editContacts();
						break;
					case EXIT: System.exit(1);
				}
			}
			catch(NumberFormatException ex){
				System.out.println("Please enter only numbers");
			}
		}		
	}
	
	//Method created to add a contact in the arraylist
	private void addContact() throws ValidationException{
		try{	
			input.nextLine(); //Used to discard the rest of the line
			System.out.println("Please enter first name");
			String firstName = input.nextLine();
			System.out.println("Please enter last name");
			String lastName = input.nextLine();
			System.out.println("Please enter phone number");
			String phoneNumber = input.nextLine();
			contacts.add(new Contact(firstName, lastName, phoneNumber));
		}
		catch(ValidationException	ex){
			System.out.println(ex.getMessage());
		}
	}
	
	//Method created to remove a contact in the arraylist
	private void removeContact(){
		if(contacts.isEmpty()){
			System.out.println("Nothing to remove, contacts list is empty");
			return;
		}
		System.out.println("Enter index of contact to remove");
		int index = input.nextInt();
		if(index > contacts.size()){
			System.out.println("Invalid index number");
			return;
		}
		contacts.remove(index);
	}
	
	//Method created to sort the contacts in the arraylist by their first name
	private void sortFirstName(){
		if(contacts.isEmpty()){
			System.out.println("Nothing to sort");
			return;
		}
		ContactFirstNameComparator firstFieldComparator = new ContactFirstNameComparator();
		Collections.sort(contacts, firstFieldComparator);
	}
	
	//Method created to sort the contacts descending in the arraylist by their first name
	private void sortFirstNameDescending(){
		if(contacts.isEmpty()){
			System.out.println("Nothing to sort");
			return;
		}
		ContactFirstNameComparatorDescending firstFieldComparator = new ContactFirstNameComparatorDescending();
		Collections.sort(contacts, firstFieldComparator);
	}
	
	//Method created to sort the contacts in the arraylist by their last name
	private void sortLastName(){
		if(contacts.isEmpty()){
			System.out.println("Nothing to sort");
			return;
		}
		ContactLastNameComparator lastFieldComparator = new ContactLastNameComparator();
		Collections.sort(contacts, lastFieldComparator);
	}
	
	//Method created to sort the contacts descending in the arraylist by their last name
	private void sortLastNameDescending(){
		if(contacts.isEmpty()){
			System.out.println("Nothing to sort");
			return;
		}
		ContactLastNameComparatorDescending lastFieldComparator = new ContactLastNameComparatorDescending();
		Collections.sort(contacts, lastFieldComparator);
	}
	
	//Method used to view the contacts in the arraylist
	private void viewContacts(){
		if(contacts.isEmpty()){
			System.out.println("No contacts to display");
			return;
		}
		for(int i = 0; i < contacts.size(); i++)
			System.out.println("Index: " + i + " Contact: " + contacts.get(i).toString());
	}
	
	//Method used to edit the contacts selected by the user when an index is passed to the program
	private void editContacts(){
		if(contacts.isEmpty()){
			System.out.println("No contacts to edit");
			return;
		}
		System.out.println("Enter index of contact to edit");
		int index = input.nextInt();
		if(index > contacts.size()){
			System.out.println("Invalid index number");
			return;
		}
		System.out.println("10. Edit First Name\n11. Edit Last Name\n12. Edit Phone Number\n13. Exit Edit");
		int option = input.nextInt();
		try {
			switch(option){
			 case EDIT_FIRST_NAME:{
				 System.out.println("New first name: ");
				 contacts.get(index).setFirstName(input.next());
				 break;
			 }
			 case EDIT_LAST_NAME:{
				 System.out.println("New last name: ");
				 contacts.get(index).setLastName(input.next());
				 break;
			 }
			 case EDIT_PHONE_NUMBER:{
				 System.out.println("New phone number: ");
				 contacts.get(index).setPhoneNumber(input.next());
				 break;
			 }
			 case EXIT_EDIT: return;
			}
		} catch (ValidationException e) {
			e.printStackTrace();
		}
		while(true){
			System.out.println("10. Edit First Name\n11. Edit Last Name\n12. Edit Phone Number\n13. Exit Edit");
			option = input.nextInt();
			try{
				switch(option){
				 case EDIT_FIRST_NAME:{
					 System.out.println("New first name: ");
					 contacts.get(index).setFirstName(input.next());
					 break;
				 }
				 case EDIT_LAST_NAME:{
					 System.out.println("New last name: ");
					 contacts.get(index).setLastName(input.next());
					 break;
				 }
				 case EDIT_PHONE_NUMBER:{
					 System.out.println("New phone number: ");
					 contacts.get(index).setPhoneNumber(input.next());
					 break;
				 }
				 case EXIT_EDIT: return;
				}
			} catch (ValidationException e) {
				e.printStackTrace();
			}
		}
	}
}



























