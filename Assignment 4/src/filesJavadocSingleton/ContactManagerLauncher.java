/*
* Author: Pieda (2014)
* File Name: ContactManagerLauncher.java
*	Course Name: Object-Oriented Programming
*	Lab	Section: 302
*	Student	Name: Lucas Pazelo Vargas de Oliveira (040799663)
*	Date: 10/11/2014
*(Stanley	Pieda	(2014)	personal	communication)
*/
package filesJavadocSingleton;

//Main class which will instantiate and initialize the program
public class ContactManagerLauncher {
	public static void main(String[]	args) throws ValidationException	{
			ContactManager	manager =	new ContactManager();
			manager.runContactManager();
	}
}
