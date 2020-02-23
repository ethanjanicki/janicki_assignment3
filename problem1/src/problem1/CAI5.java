package problem1;

import java.security.SecureRandom;
import java.util.Scanner;
 


public class CAI5 {
	
	// create instance of SecureRandom class
	public static SecureRandom rand = new SecureRandom();
	
	//scanner
	public static Scanner scanner = new Scanner(System.in);
	public static int rand_num1=0;
	public static int rand_num2=0;
	public static int divisionIndicator=0;

	public static void main(String[] args) {
		quiz();
        

	}
	
	public static void quiz(){
		// variables to count correct/incorrect responses
		int correctResponse =0;
		int incorrectResponse =0;
		int type;
		int randomTypeIndicator=0;
		
		
		int difficulty;
		 rand_num1=0;
		 rand_num2=0;
		
		//ask type
		System.out.println("What type of problems would you like");
		type = readProblemType();
		//ask for difficulty
		System.out.println("What difficulty would you like (1-4)");
		difficulty =readDifficulty();
		
		//loop for 10 different questions
		for(int i =0 ; i<10 ;i++) {
			if(type == 5) {
				type = rand.nextInt(5);
				randomTypeIndicator=1;
				}
			if(type ==0) {
				type++;
			}
			if(type == 4) {
				divisionIndicator=1;
			}else {
				divisionIndicator=0;
			}
				
				
		
		//generate random numbers
			generateQuestionArgument(difficulty);
        
        //ask question
        askQuestion(rand_num1,rand_num2,type);
        
        
        
        //get response from user
        /*if(divisionIndicator==1) {
        	double response = readResponseDouble();
        }else {
        int response = readResponse();
        }
        */
        int response = readResponse();
        
        //if answer is correct
        if(isAnswerCorrect(rand_num1,rand_num2,response,type) == 1) {
        displayCorrectResponse();
        correctResponse ++;
       
        }else {
        // if answer is not correct
        displayIncorrectResponse();
        incorrectResponse ++;
        
        }
        if(randomTypeIndicator==1) {
        type = rand.nextInt(5);
        }
	}
		displayCompletionMessage(correctResponse);
		if(askNewProblemSet()==1) {
			quiz();
		}
		
	}
	
	public static void askQuestion(int num1, int num2,int type) {
		
		if(type == 5) {
			type = rand.nextInt(5);
			if(type == 0) {
				type++;
			}
			
		}
		switch(type) {
		case 1:
			System.out.println("How much is "+ num1 + " plus " + num2 +"?");
			break;
		
		case 2: 
			System.out.println("How much is "+ num1 + " times " + num2 +"?");
			break;
			
		case 3:
			System.out.println("How much is "+ num1 + " minus " + num2 +"?");
			break;
		
		case 4:
			System.out.println("How much is "+ num1 + " divided by " + num2 +"?");
		break;
			
		}
		
		
	}
	
	public static int readResponse() {
		int ans;
		ans =scanner.nextInt();
		
		return ans;
	}
	public static double readResponseDouble() {
		Double ans;
		ans =scanner.nextDouble();
		
		return ans;
	}
	
	public static int isAnswerCorrect(double num1,double num2,double response,int type) {
		
		double correctAnswer=0;
		
		
		switch(type) {
		case 1:
			correctAnswer = num1 + num2;
			break;
		
		case 2: 
			correctAnswer = num1 * num2;
			break;
			
		case 3:
			correctAnswer = num1 - num2;
			break;
		
		case 4:
		if(divisionCheck(num1,num2,response) == 1) {
			return 1;
		}else {
			return 0;
		}
		
			
		}
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
	public static int readProblemType() {
		int ans;
		int indicator =0;
		
		while(indicator ==0) {
			ans = readResponse();
			if(ans == 1 ||ans == 2 ||ans == 3 ||ans == 4 ||ans == 5 ) {
				return ans;
			}else {
				System.out.print("That is not a valid response, please input a value between 1-5");
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
public static int divisionCheck(double num1, double num2, double response) {
	double ans = num1 / num2;
	if(response == ans || (response <= ans + 0.1 && response >= ans - 0.1)) {
		return 1;
	}else {
		return 0;
	}
	
}
public static void setDivisionIndicator(int indicator) {
	if(indicator == 1) {
		divisionIndicator =1;
	}else if(indicator == 0) {
		divisionIndicator =0;
	}
}



}
