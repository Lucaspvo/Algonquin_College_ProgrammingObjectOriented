/*
* File Name: ValidationException.java
*	Course Name: Object-Oriented Programming
*	Lab	Section: 302
*	Student	Name: Lucas Pazelo Vargas de Oliveira (040799663)
*	Date: 10/11/2014
*(Stanley	Pieda	(2014)	personal	communication)
*/
package filesJavadocSingleton;

//Class of exceptions
@SuppressWarnings("serial")
public class ValidationException extends Exception{
	//Constructor of ValidationException without parameters
	public ValidationException(){
		super("Data not in valid format");
	}
	
	//Constructor of ValidationException without one parameters
	public ValidationException(String message){
		super(message);
	}
	
	//Constructor of ValidationException without two parameters
	public ValidationException(String message, Throwable throwable){
		super(message, throwable);
	}
	
	//Constructor of ValidationException without one parameters
	public ValidationException(Throwable throwable){
		super(throwable);
	}
}
