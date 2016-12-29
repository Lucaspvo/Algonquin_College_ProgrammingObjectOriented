/*
*File Name: ContactManager.java
*Author: Lucas Pazelo Vargas de Oliveira
*Course: CST8132 - OOP
*Assignment: 4
*Date:
*Professor: Rex Woolard
*Purpose: This Class will compare two contacts' last name
*(Stanley	Pieda	(2014)	personal	communication)
*/

package filesJavadocSingleton;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFrame;

/*
 * This Class manages the Contacts in an arraylist
 * @author Lucas Pazelo Vargas de Oliveira
 * @version 2.0
 * @see filesJavadocSingleton, java.util.Collections
 * @since 1.8
 */
@SuppressWarnings("serial")
public class ContactManager extends JFrame{

	private static final int ADD_CONTACT = 1; /*Field to add a contact*/
	private static final int REMOVE_CONTACT = 2; /*Field to remove a contact*/
	private static final int SORT_FIRST_NAME = 3;	/*Field to sort first name*/
	private static final int SORT_FIRST_NAME_DESC = 4;	/*Field to sort first name descending*/
	private static final int SORT_LAST_NAME = 5; /*Field to sort last name*/
	private static final int SORT_LAST_NAME_DESC = 6; /*Field to sort last name descending*/
	private static final int VIEW_CONTACTS = 7; /*Field to view contacts*/
	private static final int EDIT = 8; /*Field to edit a contact*/
	private static final int EXIT = 11; /*Field to exit the program*/
	private static final int SAVE_CONTACTS = 9; /*Field to save contacts in a .txt file*/
	private static final int LOAD_CONTACTS = 10; /*Field to load contacts from a .txt to an arraylist*/
	List<Contact> contacts; /*List of Contacts*/
	Scanner input; /*Variable used to receive data from the user*/
	
	/* Constructor of Contact Manager without parameters */
	public ContactManager(){
		contacts = new ArrayList<Contact>();
		input = new Scanner(System.in);
	}
	
	/*
	 * Method used to call the menu for the user
	 * @throws ValidationException Check for type errors from users input
	 */
	public void runContactManager() throws ValidationException{
		showMenu();
	}
	
	/*
	 * Method that interact with the user through a menu
	 * @throws ValidationException Check for type errors from users input
	 */
	private void showMenu() throws ValidationException{
		int option;
		/* @loop This loop will interact with the user to manage the Contacts list and validate the users input */
		while(true){
			System.out.println("1 Add contact\n2 Remove contact\n3 Sort by first name\n4 Sort by first name descending\n5 Sort by last name\n6 Sort by last name descending\n7 View contacts\n8 Edit\n9 Save Contacts\n10 Load Contacts\n11 Exit program");
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
					case SAVE_CONTACTS: saveContacts();
						break;
					case LOAD_CONTACTS: loadContacts();
						break;
					case EXIT: System.exit(1);
				}
			}
			catch(NumberFormatException ex){
				System.out.println("Please enter only numbers");
			}
		} /* end loop to validate and act on user menu selection input	*/
	}
	
	/*
	 * Method created to add a contact in the arraylist
	 * @throws ValidationException Check for type errors from users input
	 */
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
	
	/* Method created to remove a contact in the arraylist */
	private void removeContact(){
		if(contacts.isEmpty()){
			System.out.println("Nothing to remove, contacts list is empty");
			return;
		}
		System.out.println("Enter index of contact to remove");
		int index = input.nextInt();
		if(index+1 > contacts.size() || index < 0){
			System.out.println("Invalid index number");
			return;
		}
		contacts.remove(index);
	}
	
	/*Method created to sort the contacts in the arraylist by their first name*/
	private void sortFirstName(){
		if(contacts.isEmpty()){
			System.out.println("Nothing to sort");
			return;
		}
		ContactFirstNameComparator firstFieldComparator = ContactFirstNameComparator.instance();
		Collections.sort(contacts, firstFieldComparator);
	}
	
	/*Method created to sort the contacts descending in the arraylist by their first name*/
	private void sortFirstNameDescending(){
		if(contacts.isEmpty()){
			System.out.println("Nothing to sort");
			return;
		}
		ContactFirstNameComparatorDescending firstFieldComparator = ContactFirstNameComparatorDescending.instance();
		Collections.sort(contacts, firstFieldComparator);
	}
	
	/*Method created to sort the contacts in the arraylist by their last name*/
	private void sortLastName(){
		if(contacts.isEmpty()){
			System.out.println("Nothing to sort");
			return;
		}
		ContactLastNameComparator lastFieldComparator = ContactLastNameComparator.instance();
		Collections.sort(contacts, lastFieldComparator);
	}
	
	/*Method created to sort the contacts descending in the arraylist by their last name*/
	private void sortLastNameDescending(){
		if(contacts.isEmpty()){
			System.out.println("Nothing to sort");
			return;
		}
		ContactLastNameComparatorDescending lastFieldComparator = ContactLastNameComparatorDescending.instance();
		Collections.sort(contacts, lastFieldComparator);
	}
	
	/*Method used to view the contacts in the arraylist*/
	private void viewContacts(){
		if(contacts.isEmpty()){
			System.out.println("No contacts to display");
			return;
		}
		int index = 0;
		for(Contact contact : contacts){
			System.out.printf("Index: %d Contact: %s", ++index, contact);
			System.out.println();
		}
	}
	
	/*Method used to edit the contacts selected by the user when an index is passed to the program*/
	private void editContacts(){
		try {
			if(contacts.isEmpty()){
				System.out.println("No contacts to edit");
				return;
			}
			System.out.println("Enter index of contact to edit");
			int index = input.nextInt();
			if(index+1 > contacts.size() || index < 0){
				System.out.println("Invalid index number");
				return;
			}
			System.out.println("Edit Contact: ");
			System.out.println("New first name: ");
			contacts.get(index).setFirstName(input.next());
			System.out.println("New last name: ");
			contacts.get(index).setLastName(input.next());
			System.out.println("New phone number: ");
			contacts.get(index).setPhoneNumber(input.next());
		} catch (ValidationException e) {
			e.printStackTrace();
		}
	}
	
	/*Method used to save the arraylist into a file*/
	private void saveContacts(){
		File file = null;
    
    JFileChooser save = new JFileChooser();
    FileFilter filter = new FileNameExtensionFilter("c files", "c");
    save.addChoosableFileFilter(filter);
    
    int r = save.showOpenDialog(new JFrame());
    
    if (r == JFileChooser.APPROVE_OPTION)
    	file = save.getSelectedFile();
    
		try(ObjectOutputStream	output =	
				new ObjectOutputStream(new FileOutputStream(file))){
        output.writeObject(contacts);
        output.flush();
    }
    catch(IOException ex){
        System.out.println("Problem with writing file\n" 
            + ex.getMessage());
    } 
	}
	
	/*Method used to load the content of a file creating an arraylist*/
	@SuppressWarnings("unchecked")
	private void loadContacts(){
		File file = null;
    
    JFileChooser load = new JFileChooser();
    FileFilter filter = new FileNameExtensionFilter("c files", "c");
    load.addChoosableFileFilter(filter);

    int r = load.showOpenDialog(new JFrame());
    
    if (r == JFileChooser.APPROVE_OPTION)
			file = load.getSelectedFile();
		
		try(ObjectInputStream	input =	
				new ObjectInputStream(new FileInputStream(file))){
        contacts = (List<Contact>) input.readObject();
    }
		catch(ClassNotFoundException ex){
      System.out.println("File not found\n" 
          + ex.getMessage());
		}
    catch(FileNotFoundException ex){
        System.out.println("File not found for input\n" 
            + ex.getMessage());
    }
    catch(ClassCastException ex){
        System.out.println("Could not cast retrieved class\n" 
            + ex.getMessage());
    }
    catch(IOException ex){
        System.out.println("Problem with reading file\n" 
            + ex.getMessage());
    } 
	}
}



























