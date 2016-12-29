/*
*File Name: Contact.java
*Author: Lucas Pazelo Vargas de Oliveira
*Course: CST8132 - OOP
*Assignment: 4
*Date:
*Professor: Rex Woolard
*Purpose: This Class represents a person in a contact list
*(Stanley	Pieda	(2014)	personal	communication)
*/

package filesJavadocSingleton;
import java.io.Serializable;

/*
 * This Class represents a person in a contact list
 * @author Lucas Pazelo Vargas de Oliveira
 * @version 2.0
 * @see filesJavadocSingleton
 * @since 1.8
 */
@SuppressWarnings("serial")
public class Contact implements Serializable{

		private String firstName; //Person's first name
		private String lastName; //Person's last name
		private String phoneNumber; //Person's phone number
		
		/*
		 * Constructor of Contact with 3 parameters
		 * @param firstName First Name of the Contact
		 * @param lastName Last Name of the Contact
		 * @param phoneNumber Phone Number of the contact
		 * @throws ValidationException Check for type errors in firstName, lastName and phoneNumber
		 */
		public Contact(String firstName, String lastName, String phoneNumber) throws ValidationException{
			validateString("First Name", firstName, firstName.length());
			validateString("Last Name", lastName, lastName.length());
			validateString("Phone Number", phoneNumber, phoneNumber.length());
			this.firstName = firstName;
			this.lastName = lastName;
			this.phoneNumber = phoneNumber;
		}
		
		/* Constructor of Contact with no parameters */
		public Contact(){
			firstName = "unknown";
			lastName = "unknown";
			phoneNumber = "unknown";
		}
		
		/*
		 * Return first name of a contact
		 * @return String Returns the first name
		 */
		public String getFirstName(){
			return firstName;
		}
		
		/*
		 * Receive and set first name in a contact
		 * @param firstName Person's first name
		 * @throws ValidationException Check for type errors in firstName
		 */
		public void setFirstName(String firstName) throws ValidationException{
			validateString("First Name", firstName, firstName.length());
			this.firstName = firstName;
		}
		
		/*
		 * Return last name of a contact
		 * @return String Returns the last name
		 */
		public String getLastName(){
			return lastName;
		}
		
		/*
		 * Receive and set last name in a contact
		 * @param lastName Person's last name
		 * @throws ValidationException Check for type errors in lastName
		 */
		public void setLastName(String lastName) throws ValidationException{
			validateString("Last Name", lastName, lastName.length());
			this.lastName = lastName;
		}
		
		/*
		 * Return phone number of a contact
		 * @return String Returns the phone number
		 */
		public String getPhoneNumber(){
			return phoneNumber;
		}
		
		/*
		 * Receive and set phone number in a contact
		 * @param phoneNumber Person's phone number
		 * @throws ValidationException Check for type errors in phoneNumber
		 */
		public void setPhoneNumber(String phoneNumber) throws ValidationException{
			validateString("Phone Number", phoneNumber, phoneNumber.length());
			this.phoneNumber = phoneNumber;
		}
		
		/*
		 * Return the info of a contact
		 * @return String Returns a String
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString(){
			return new StringBuilder().append(firstName).append(",").append(lastName).append(",").append(phoneNumber).toString();
		}
		
		/*
		 * Method to validate some data passed to contact
		 * @param value Is a string that represents one of the fields from a Contact
		 * @param fieldName Is the whole name of a Contact
		 * @param maxLength The length of a Contacts' field
		 * @throws ValidationException Check for type errors in firstName, lastName and phoneNumber
		 */
		private static void validateString(String value, String fieldName, int maxLength) throws ValidationException{
			if(fieldName == null)
				throw new ValidationException(value + " cannot be null");
			if(maxLength == 0)
				throw new ValidationException(value + " cannot have a length of zero");
			if(fieldName.trim().length() == 0)
				throw new ValidationException(value + " cannot consist of only white spaces");
			if(maxLength > 25)
				throw new ValidationException(value + " cannot have a length exceeding 25 characters");
			if(fieldName.contains(","))
				throw new ValidationException(value + " cannot conatin a comma");
			return;
		}
}
