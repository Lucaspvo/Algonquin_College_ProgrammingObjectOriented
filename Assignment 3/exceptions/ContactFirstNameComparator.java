/*
* Author: Pieda (2014)
* File Name: ContactFirstNameComparator.java
*	Course Name: Object-Oriented Programming
*	Lab	Section: 302
*	Student	Name: Lucas Pazelo Vargas de Oliveira (040799663)
*	Date: 10/11/2014
*(Stanley	Pieda	(2014)	personal	communication)
*/
package exceptions;
import java.util.Comparator;

//Class used to compare two strings
public class ContactFirstNameComparator	implements Comparator<Contact>	{
	
	//Compare two string ascending
	@Override
	public int compare(Contact	arg0,	Contact	arg1)	{
		return arg0.getFirstName().compareTo(arg1.getFirstName());
	
	}
}
