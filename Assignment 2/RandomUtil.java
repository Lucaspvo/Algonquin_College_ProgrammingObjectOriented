/*
* Author: Pieda (2014)
* File Name: RandomUtil.java
*	Course Name: Object-Oriented Programming
*	Lab	Section: 302
*	Student	Name: Lucas Pazelo Vargas de Oliveira (040799663)
*	Date: 10/04/2014
*(Stanley	Pieda	(2014)	personal	communication)
*/
package mathPractice;
import java.util.Random;

//RandomUtil will return a random number
public class RandomUtil {
	private static final Random	random =	new Random();
	
	private RandomUtil(){}
	
	public static int nextInt(int max){
					return random.nextInt(max);
	}
}
