package problem1;

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI1 {
	// create instance of SecureRandom class
	public static SecureRandom rand = new SecureRandom();
	
	//scanner
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		quiz();
        

	}
	
	public static void quiz(){
		//generate random numbers
		
		int rand_num1 = rand.nextInt(10);
        int rand_num2 = rand.nextInt(10);
        
        //indicator for while loop
        int whileIndicator=0;
        
        //ask question
        askQuestion(rand_num1,rand_num2);
        
        //loop until answer is correct
        while(whileIndicator == 0) {
        //get response from user
        int response = readResponse();
        
        
        //if answer is correct
        if(isAnswerCorrect(rand_num1,rand_num2,response) == 1) {
        displayCorrectResponse();
        whileIndicator =1;
        }else {
        // if answer is not correct
        displayIncorrectResponse();
        }
        }
		
	}
	
	public static void askQuestion(int num1, int num2) {
		//print question with passed in values
		System.out.println("How much is "+ num1 + " times " + num2 +"?");
		
	}
	
	public static int readResponse() {
		int ans;
		ans =scanner.nextInt();
		
		return ans;
	}
	
	public static int isAnswerCorrect(int num1,int num2,int response) {
		int correctAnswer = num1 * num2;
		if(response == correctAnswer) {
			return 1;
		}else {
			return 0;
		}
		
		
	}
	
	public static void displayCorrectResponse() {
		System.out.println("Correct");
	}
	
	public static void displayIncorrectResponse() {
		System.out.println("Incorrect");
		
	}

}
