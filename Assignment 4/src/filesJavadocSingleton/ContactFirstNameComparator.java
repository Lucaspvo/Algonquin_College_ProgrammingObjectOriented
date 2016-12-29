/*
*File Name: ContactFirstNameComparator.java
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
public class ContactFirstNameComparator	implements Comparator<Contact>	{
	private static ContactFirstNameComparator contactFirstName = new ContactFirstNameComparator(); /*Field that contains the reference to this class object*/
	
	/*Private constructor for this class*/
	private ContactFirstNameComparator(){}
	
	/*
	 * Returns the reference for the object of this class
	 * @return ContactFirstNameComparator Reference for the ContactFirstNameComparator object 
	 */
	public static ContactFirstNameComparator instance(){ return contactFirstName; }
	
	/*
	 * Compare two strings ascending
	 * @param arg0 A Contact
	 * @param arg1 A Contact
	 * @return int Returns an integer depending on which contact should be first
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Contact	arg0,	Contact	arg1)	{
		return arg0.getFirstName().compareToIgnoreCase(arg1.getFirstName());
	}
}
