/*
* File Name: MathTeacher.java
*	Course Name: Object-Oriented Programming
*	Lab	Section: 302
*	Student	Name: Lucas Pazelo Vargas de Oliveira (040799663)
*	Date: 10/04/2014
*(Stanley	Pieda	(2014)	personal	communication)
*/
package mathPractice;
import java.util.Scanner;

/*
 * Class responsible to interact with the user, initialize the problems[] array and print all questions
 * with answers and feed back to the user
 */
public class MathTeacher {
	private final static int PRACTICE = 1; //field used to call practiceMath
	private final static int REPORT = 2; //field used to call printReport
	private final static int EXIT = 0; //field used to exit program
	private final static int MAX_SIZE = 10; //field used to limit the problems[] array size
	private MathProblem[] problems; //field used to initialize the MathProblem[] array
	
	/*
	 * Interact with the user, giving three choices. Has an infinite loop that
	 * will only be stopped when the user choose the option 0 (EXIT)
	 */
	public void runMenu(){
		System.out.println("Please make a selection from the menu\n1 Practice Test\n2 Print Report\n0 Exit Program\n");
		Scanner input = new Scanner(System.in);
		int option = input.nextInt();
		if(option > REPORT)
			System.out.println("Unrecognized command\n");
		else{
			switch(option){
				case PRACTICE: practiceMath();
					break;
				case REPORT: System.out.println("No test taken yet\n");
					break;
				case EXIT: {
					System.out.println("Program will exit\n");
					input.close();
					return;
				}
			}
		}
		while(true){
			System.out.println("Please make a selection from the menu\n1 Practice Test\n2 Print Report\n0 Exit Program\n");
			option = input.nextInt();
			if(option > REPORT)
				System.out.println("Unrecognized command\n");
			else{
				switch(option){
					case PRACTICE: practiceMath();
						break;
					case REPORT: printReport();
						break;
					case EXIT: {
						System.out.println("Program will exit\n");
						input.close();
						return;
					}
				}
			}
		}
	}
	
	//Initialize the MathProblem[] array referencing each index to a MathProblem sub-classes object chosen randomly
	private void initializeProblems(){
		problems = new MathProblem[MAX_SIZE];
		int question = 0;
		while(question < MAX_SIZE){
			switch(RandomUtil.nextInt(3)){
				case 0: {
					problems[question] = new AdditionMathProblem();
					question++;
					break;
				}
				case 1:{
					problems[question] = new SubtractionMathProblem();
					question++;
					break;
				}
				case 2: {
					problems[question] = new MultiplicationMathProblem();
					question++;
					break;
				}
			}
		}
	}
	
	//Interact with the user printing a question and saving the answer
	private void practiceMath(){
		initializeProblems();
		@SuppressWarnings("resource")
		Scanner recv = new Scanner(System.in);// ASK
		for(int question = 0; question < MAX_SIZE; question++){
			System.out.println(problems[question].getQuestionText());
			int answer = recv.nextInt();
			problems[question].setUserAnswer(answer);
		}
	}
	
	//Print all questions with user and computer's answers as well as a feedback to the user
	private void printReport(){
		for(int i = 0; i < MAX_SIZE; i++)
			System.out.println(problems[i].getQuestionTextWithFeedback());
	}
	
}
