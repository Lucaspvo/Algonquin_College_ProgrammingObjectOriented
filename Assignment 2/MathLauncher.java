/*
* Author: Pieda (2014)
* File Name: MathLauncher.java
*	Course Name: Object-Oriented Programming
*	Lab	Section: 302
*	Student	Name: Lucas Pazelo Vargas de Oliveira (040799663)
*	Date: 10/04/2014
*(Stanley	Pieda	(2014)	personal	communication)
*/
package mathPractice;

//Class will be loaded to memory and will start the program by instantiating the MathTeacher Class
public class MathLauncher {
	public static void main(String[]	args)	{
	MathTeacher	teacher =	new MathTeacher();
	teacher.runMenu();
	}
}
