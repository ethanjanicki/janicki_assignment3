package problem1;

import java.security.SecureRandom;
import java.util.Scanner;
 


public class CAI3 {
	
	// create instance of SecureRandom class
	public static SecureRandom rand = new SecureRandom();
	
	//scanner
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		quiz();
        

	}
	
	public static void quiz(){
		// variables to count correct/incorrect responses
		int correctResponse =0;
		int incorrectResponse =0;
		//loop for 10 different questions
		for(int i =0 ; i<10 ;i++) {
		
		//generate random numbers
		int rand_num1 = rand.nextInt(10);
        int rand_num2 = rand.nextInt(10);
       
        
        //ask question
        askQuestion(rand_num1,rand_num2);
        
        
        
        //get response from user
        int response = readResponse();
        
        
        //if answer is correct
        if(isAnswerCorrect(rand_num1,rand_num2,response) == 1) {
        displayCorrectResponse();
        correctResponse ++;
       
        }else {
        // if answer is not correct
        displayIncorrectResponse();
        incorrectResponse ++;
        
        }
	}
		displayCompletionMessage(correctResponse);
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
		int x =0;
		while(x == 0) {
		 x = rand.nextInt(5) ;
		}
		switch(x) {
		case 1:
			System.out.println("Very good!");
			break;
		
		case 2:
			System.out.println("Excellent!");
			break;
			
		case 3:
			System.out.println("Nice work!");
			break;
			
		case 4:	
			System.out.println("Keep up the good work!");
			break;
			
		default:
			System.out.println("Error with random num generation");
			
		}
		
	}
	
	public static void displayIncorrectResponse() {
		int x =0;
		while(x == 0) {
		 x = rand.nextInt(5) ;
		}
		switch(x) {
		case 1:
			System.out.println("No. Please try again.");
			break;
		
		case 2:
			System.out.println("Wrong. Try once more.");
			break;
			
		case 3:
			System.out.println("Don’t give up!");
			break;
			
		case 4:	
			System.out.println("No. Keep trying.");
			break;
			
		default:
			System.out.println("Error with random num generation");
			
		}
		
	}
	
	public static void displayCompletionMessage(int correct) {
		double score = correct/10.0 * 100;
		System.out.println("Your score is " + score + "%.");
		if(score>=75) {
			System.out.println("Congratulations, you are ready to go to the next level!");
		}else {
			System.out.println("Please ask your teacher for extra help.");
		}
	}

}
