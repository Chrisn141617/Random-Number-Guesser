/*
 * Class: CMSC203 34974
 * Instructor: Farnaz Eivazi
 * Description: 
Build an application that will receive a guess and report if your guess is the random number that was generated.  
Your application will narrow down the choices according to your previous guesses 
and continue to prompt you to enter a guess until you guess correctly.  
Notice the user can guess at most 7 times. 
You will use the utility class RNG.java. 
 * Due: 02/22/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Christopher Newman
*/
import java.util.Scanner;
/**
 * 
 * @author chris
 *
 */
public class RandomNumberGuesserDriver {
	/**
	 * 
	 * @param agrs
	 */
	public static void main(String[] agrs) 
	{
		/**
		 * This is used as another user input at the bottom
		 */
		String another;
		/**
		 * I used a do-while loop do when I ask if the user wants to try again
		 * it can loop back to the start
		 */
		do {
		Scanner sc = new Scanner(System.in);
		/**
		 * These were called from RNG.java so I could use the random number function
		 */
		RNG.rand();
		int lowGuess = 0;
		int highGuess = 100;
		int nextGuess; //I declared this variable so I could use to make it easier to write the code
		int randNumber = RNG.rand();
		
		/**
		 * I stringed these sentences to make it look nicer
		 */
		String low = "Your guess it too low";
		String high = "Your guess is too high";
		String numOfGuesses = "Number of guesses is: ";
		
		System.out.println("This application generates a random integer"
				+ "between 1 and 100\n and asks the user to guess repeatedly until they guess correctly\n");
		
		/**
		 * this is the start of the code
		 * it ask for the users first number then adds 1 to the count/guesses 
		 * then prints the number of guesses the user made
		 */
		System.out.println("Enter your first guess:");
		nextGuess = sc.nextInt();
		RNG.getCount();
		RNG.incrementCount();
		System.out.println(numOfGuesses + RNG.getCount());
		//I am not sure why I have to have this here but without it
		//it adds one to the first one but not the second one but it will add one after the second one with no problem
		RNG.incrementCount();
		
		/**
		 * the if-else statement says if the users guess is larger or smaller 
		 * than the random number then it will print accordingly
		 */
		if(nextGuess > randNumber) 
		{
			System.out.println(high);
			highGuess = nextGuess;
		}
			else if (nextGuess < randNumber) 
			{
				System.out.println(low);
				lowGuess = nextGuess;
			}
			/**
			 * This while statement will loop the if-else statements as long as
			 * the user does not enter the correct number
			 */
		while(nextGuess != randNumber) 
		{
			/**
			 * this if statement says if the guess count goes above 7
			 * then it will print that sentence and then it will
			 * terminate the code
			 */
			if(RNG.getCount() > RNG.getMaxGuessCount()) {
				System.out.println("\nYou have exceeded the maxium number of guesses, 7. Try again");
				System.exit(0);
			}
			System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
			nextGuess = sc.nextInt();
			System.out.println(numOfGuesses + RNG.getCount());
			RNG.inputValidation(nextGuess, lowGuess, highGuess);
			/**
			 * this if-else statement narrows the guessing process down,
			 * Example: 0-100 Guess:50
			 * 50-100 guess: 75
			 * 75-100
			 * and goes until 7 guesses is reached or the user guesses right
			 */
			if(nextGuess > randNumber && nextGuess < highGuess) 
			{
				System.out.println(high);
				highGuess = nextGuess;
			}
			else if(nextGuess < randNumber && nextGuess > lowGuess) 
			{
				System.out.println(low);
				lowGuess = nextGuess;
			}
			/**
			 * this adds 1 to the guess count
			 */
			RNG.incrementCount();
			RNG.getCount();
			
		}
		/**
		 * I made a new input for the user
		 * This is when the user guesses right and then it asks if they would like to try again.
		 * then asks for the input from the user
		 */
		Scanner kb = new Scanner(System.in);
		System.out.println("Congratulations, you guessed correctly!!!");
		System.out.println("Try again? (yes or no)");
		another = kb.nextLine();
		/**
		 * So I am not sure why the resetCount has to be there, 
		 * I tired to put it in the if-else statement below but it doesn't reset if they answer yes
		 */
		RNG.resetCount();
		
		/**
		 * This if-else statement is if the user says yes then it will loop again and reset the guess count
		 * and if no then it will print the sentence and terminate
		 */
		if(kb.equals("yes") || kb.equals("Yes")) 
		{
			RNG.resetCount();
		}
		else if(kb.equals("No") || kb.equals("no")) 
		{
			System.out.println("Thank you for playing Random Number Guesser!!");
			
		}
		/**
		 * this is the end of the do-while loop, for some reason when the while loop equals "no"
		 * it will print the sentence when the user says yes. 
		 */
		}while(another.equals("yes"));
		System.out.println("Thank you for playing Random Number Guesser!!");
		
		/**
		 * I am going to come in to office hours and ask why they do this because I do not know why it does this.
		 */
		}
	}
