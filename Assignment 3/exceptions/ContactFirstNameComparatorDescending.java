/*
* File Name: ContactFirstNameComparatorDescending.java
*	Course Name: Object-Oriented Programming
*	Lab	Section: 302
*	Student	Name: Lucas Pazelo Vargas de Oliveira (040799663)
*	Date: 10/11/2014
*(Stanley	Pieda	(2014)	personal	communication)
*/
package exceptions;

import java.util.Comparator;

//Class used to compare two strings
public class ContactFirstNameComparatorDescending implements Comparator<Contact>{
	
	//Compare two string descending
	@Override
	public int compare(Contact	arg0,	Contact	arg1)	{
		return arg1.getFirstName().compareTo(arg0.getFirstName());
	
	}
}
