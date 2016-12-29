/*
* File Name: MathProblem.java
*	Course Name: Object-Oriented Programming
*	Lab	Section: 302
*	Student	Name: Lucas Pazelo Vargas de Oliveira (040799663)
*	Date: 10/04/2014
*(Stanley	Pieda	(2014)	personal	communication)
*/
package mathPractice;

/*
 * Abstract class responsible to save all the necessary information and all the necessary 
 * methods for its sub-classes be able to do their function 
 */
abstract class MathProblem {
	private int operand1; // Random number
	private int operand2; // Random number
	private int userAnswer; // user answer to a question
	
	//Initialize two of the three local fields with random numbers
	public MathProblem(){
		operand1 = RandomUtil.nextInt(100) + 1;
		operand2 = RandomUtil.nextInt(100) + 1;
	}
	
	//Return an integer
	public int getOperand1(){
		return operand1;
	}
	
	//Receive an integer as parameter and save it in operand1 field
	public void setOperand1(int operand1){
		this.operand1 = operand1;
	}
	
	//Return an integer
	public int getOperand2(){
		return operand2;
	}
	
	//Receive an integer as parameter and save it in operand2 field
	public void setOperand2(int operand2){
		this.operand2 = operand2;
	}
	
	//Class necessary to be coded in sub-classes
	abstract int getAnswer();
	
	//Return the user answer (an integer)
	public int getUserAnswer(){
		return userAnswer;
	}
	
	//Receive an integer as parameter and save it in the userAnswer field
	public void setUserAnswer(int userAnswer){
		this.userAnswer = userAnswer;
	}
	
	//Class necessary to be coded in sub-classes
	abstract String getQuestionText();
	
	//Class necessary to be coded in sub-classes
	abstract String getQuestionTextWithFeedback();	
}
