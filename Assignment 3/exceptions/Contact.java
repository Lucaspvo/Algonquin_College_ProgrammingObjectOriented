/*
* File Name: Contact.java
*	Course Name: Object-Oriented Programming
*	Lab	Section: 302
*	Student	Name: Lucas Pazelo Vargas de Oliveira (040799663)
*	Date: 10/11/2014
*(Stanley	Pieda	(2014)	personal	communication)
*/
package exceptions;

public class Contact{

		private String firstName; //Person's first name
		private String lastName; //Person's last name
		private String phoneNumber; //Person's phone number
		
		//Constructor of Contact with 3 parameters
		public Contact(String firstName, String lastName, String phoneNumber) throws ValidationException{
			this.firstName = firstName;
			this.lastName = lastName;
			this.phoneNumber = phoneNumber;
			validateString("First Name", firstName, firstName.length());
			validateString("Last Name", lastName, lastName.length());
			validateString("Phone Number", phoneNumber, phoneNumber.length());
		}
		
		//Constructor of Contact with no parameters
		public Contact(){
			firstName = "unknown";
			lastName = "unknown";
			phoneNumber = "unknown";
		}
		
		//Return first name of a contact
		public String getFirstName(){
			return firstName;
		}
		
		//Receive and set first name in a contact
		public void setFirstName(String firstName) throws ValidationException{
			validateString("First Name", firstName, firstName.length());
			this.firstName = firstName;
		}
		
		//Return last name of a contact
		public String getLastName(){
			return lastName;
		}
		
		//Receive and set last name in a contact
		public void setLastName(String lastName) throws ValidationException{
			validateString("Last Name", lastName, lastName.length());
			this.lastName = lastName;
		}
		
		//Return phone number of a contact
		public String getPhoneNumber(){
			return phoneNumber;
		}
		
		//Receive and set phone number in a contact
		public void setPhoneNumber(String phoneNumber) throws ValidationException{
			validateString("Phone Number", phoneNumber, phoneNumber.length());
			this.phoneNumber = phoneNumber;
		}
		
		//Return the info of a contact
		@Override
		public String toString(){
			return new StringBuilder().append(firstName).append(" ").append(lastName).append(" ").append(phoneNumber).toString();
		}
		
		//Method to validate some data passed to contact
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
