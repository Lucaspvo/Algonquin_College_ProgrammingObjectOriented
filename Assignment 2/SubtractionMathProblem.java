/*
* File Name: SubtractionMathProblem.java
*	Course Name: Object-Oriented Programming
*	Lab	Section: 302
*	Student	Name: Lucas Pazelo Vargas de Oliveira (040799663)
*	Date: 10/04/2014
*(Stanley	Pieda	(2014)	personal	communication)
*/
package mathPractice;

//Class responsible to do a subtraction of two integers
public class SubtractionMathProblem extends MathProblem{
	//Returns an integer resulted from the subtraction
	public int getAnswer(){
		return getOperand1() - getOperand2();
	}
	
	//Returns a string giving both operands and a question asking their subtraction
	public String getQuestionText(){
		return new StringBuilder().append(getOperand1()).append(" - ").append(getOperand2()).append(" is ?").toString();
	}
	
	//Returns a string giving the user and computer's answers with some feed back about the users answer
	public String getQuestionTextWithFeedback(){
		StringBuilder sb = new StringBuilder().append(getQuestionText()).append(" ").append(getAnswer()).append(" Your Answer: ").append(getUserAnswer());
		if (getAnswer() == getUserAnswer())
			sb.append(" is correct!");
		else
			sb.append(" is not correct!");
		return sb.toString();
	}
}
