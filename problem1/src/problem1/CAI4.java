package problem1;

import java.security.SecureRandom;
import java.util.Scanner;
 


public class CAI4 {
	
	// create instance of SecureRandom class
	public static SecureRandom rand = new SecureRandom();
	
	//scanner
	public static Scanner scanner = new Scanner(System.in);
	public static int rand_num1=0;
	public static int rand_num2=0;

	public static void main(String[] args) {
		
		quiz();
        

	}
	
	public static void quiz(){
		// variables to count correct/incorrect responses
		int correctResponse =0;
		int incorrectResponse =0;
		int difficulty;
		 rand_num1=0;
		 rand_num2=0;
		
		//ask for difficulty
		System.out.println("What difficulty would you like (1-4)");
		difficulty =readDifficulty();
		//loop for 10 different questions
		for(int i =0 ; i<10 ;i++) {
			
		//generate questions
		generateQuestionArgument(difficulty);
		
		
        
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
		if(askNewProblemSet()==1) {
			quiz();
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
	public static int readDifficulty() {
		int indicator=0;
		//check for valid response
		while(indicator ==0) {
		int difficulty =scanner.nextInt();
		if(difficulty == 1 ||difficulty == 2 ||difficulty == 3 ||difficulty == 4 ) {
			return difficulty;
			
		}else {
			System.out.println("That is not a valid reponse");
		}
		}
		
		
		return 1;
		
	}
	public static int askNewProblemSet() {
		int ans;
		int whileIndicator=0;
		System.out.println("Would you like a new problem set (Answer 1 for yes and 0 for no)");
		while(whileIndicator == 0) {
		ans = readResponse();
			if(ans == 0 || ans == 1) {
				return ans;
			}
		}
		return 0;
	}
	public static void generateQuestionArgument(int difficulty) {
		//generate random numbers
				if(difficulty ==1) {
					 rand_num1 = rand.nextInt(10);
					 rand_num2 = rand.nextInt(10);
				}else if(difficulty ==2) {
					 rand_num1 = rand.nextInt(100);
					 rand_num2 = rand.nextInt(100);
				}else if(difficulty ==3) {
					 rand_num1 = rand.nextInt(1000);
					 rand_num2 = rand.nextInt(1000);
				}else if(difficulty == 4) {
					 rand_num1 = rand.nextInt(10000);
					 rand_num2 = rand.nextInt(10000);
				}
		
	}

}
