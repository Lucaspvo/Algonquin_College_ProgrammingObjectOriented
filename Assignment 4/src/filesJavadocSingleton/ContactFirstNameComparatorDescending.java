/*
*File Name: ContactFirstNameComparatorDescending.java
*Author: Lucas Pazelo Vargas de Oliveira
*Course: CST8132 - OOP
*Assignment: 4
*Date:
*Professor: Rex Woolard
*Purpose: This Class will compare two contacts' first name
*(Stanley	Pieda	(2014)	personal	communication)
*/

package filesJavadocSingleton;
import java.util.Comparator;

/*
 * Class used to compare two strings
 * @author Lucas Pazelo Vargas de Oliveira
 * @version 2.0
 * @see filesJavadocSingleton, java.util.Comparator
 * @since 1.8
 */
public class ContactFirstNameComparatorDescending implements Comparator<Contact>{
	private static ContactFirstNameComparatorDescending contactFirstNameDescending = new ContactFirstNameComparatorDescending(); /*Field that contains the reference to this class object*/
	
	/*Private constructor for this class*/
	private ContactFirstNameComparatorDescending(){}
	
	/*
	 * Returns the reference for the object of this class
	 * @return ContactFirstNameComparatorDescending Reference for the ContactFirstNameComparatorDescending object 
	 */
	public static ContactFirstNameComparatorDescending instance(){ return contactFirstNameDescending; }
	
	/*
	 * Compare two strings descending
	 * @param arg0 A Contact
	 * @param arg1 A Contact
	 * @return int Returns an integer depending on which contact should be first
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Contact	arg0,	Contact	arg1)	{
		if(arg0 == null)
			arg0 = new Contact();
		if(arg1 == null)
			arg1 = new Contact();
		return arg1.getFirstName().compareToIgnoreCase(arg0.getFirstName());
	
	}
}
