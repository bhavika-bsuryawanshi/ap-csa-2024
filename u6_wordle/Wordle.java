/*
 * File: Wordle.java
 * -----------------
 * This module is the starter file for the Wordle assignment.
 * Author: Bhavika Suryawanshi <3
 *
*/

// import necessary JDK libraries
import java.awt.Color;
import java.util.Random;

// import Wordle Components
import edu.willamette.cs1.wordle.WordleDictionary;
import edu.willamette.cs1.wordle.WordleGWindow;

public class Wordle 
{
	// reference to the Wordle game window object
	private WordleGWindow gw;

	// stores the solution word for the current game
	private String solution;
    
	// stores the current game state
	private boolean gameOver;
   
   	// checks to see if max rows used
	private boolean maxRowsUsed;
   
   	// checks if the scoreboard should be displayed
	private boolean scoreDisplay;
   
   	// stores the number of wins by attempt 
	private int[] rowWins = new int[6];

	// set up the game
	public void run() 
	{
		gw = new WordleGWindow();
		gw.addEnterListener((s) -> enterAction(s));
		System.out.println("Wordle started at UTC: " +  java.time.LocalDateTime.now() + ". Open desktop to view.");
        
		/* MILESTONE 1:
       		 * 1) pick a random word from the WordleGWindow.FIVE_LETTER_WORDS array
		 * 2) store it in the solution instance variable
 		 */
       
	       // set arrayLength equal to the length of the wordle dictionary
	       int arrayLength = WordleDictionary.FIVE_LETTER_WORDS.length;
	       
	       // set randomNumber to be a random number from 0 to the end (aka. length) of the array
	       int randomNumber = (int) ((Math.random()*arrayLength));
       
	       // set solution to be the word associated with the randomNumber index
	       solution = WordleDictionary.FIVE_LETTER_WORDS[randomNumber];
       
	       // print solution to console for debugging purposes
	       // System.out.println(solution);
	}


	/* ENTERACTION FUNCTION:
    	 * this function is called when the user hits the RETURN key or clicks the ENTER button,
	 * passing in the string of characters on the current row.
	 */
   
	public void enterAction(String guess) 
	{
		// if gameOver is true and scoreDisplay is true, show the scoreboard
      		if (gameOver && scoreDisplay)
      		{
         		// reset the guess rows
         		for (int i = 0; i < 6; i++) 
         		{
				for (int j = 0; j < 5; j++) 
            			{
					gw.setSquareLetter(i, j, "");
					gw.setSquareColor(i, j, java.awt.Color.WHITE);
				}
			}
         
		        // show the scoreboard (left: green numbers)
		        gw.setSquareColor(0, 0, WordleGWindow.CORRECT_COLOR);
		        gw.setSquareLetter(0, 0, "1");
		        gw.setSquareColor(1, 0, WordleGWindow.CORRECT_COLOR);
		        gw.setSquareLetter(1, 0, "2");
		        gw.setSquareColor(2, 0, WordleGWindow.CORRECT_COLOR);
		        gw.setSquareLetter(2, 0, "3");
		        gw.setSquareColor(3, 0, WordleGWindow.CORRECT_COLOR);
		        gw.setSquareLetter(3, 0, "4");
		        gw.setSquareColor(4, 0, WordleGWindow.CORRECT_COLOR);
		        gw.setSquareLetter(4, 0, "5");
		        gw.setSquareColor(5, 0, WordleGWindow.CORRECT_COLOR);
		        gw.setSquareLetter(5, 0, "6");
         
		        // helpful article on casting int to string: https://stackoverflow.com/questions/5071040/java-convert-integer-to-string
		        // helpful article on how to seperate digits, since i forgot: https://stackoverflow.com/questions/3389264/how-to-get-the-separate-digits-of-an-int-number
		        // show the scoreboard (right: scores)

         		for (int i = 0; i < rowWins.length; i++)
         		{
            			// check to see if the number is a two-digit number
            			if (rowWins[i] > 9)
            			{
			               // set the first digit by integer division
			               int firstDigit = rowWins[i] / 10;
			               // set the string value of first digit
			               gw.setSquareLetter(i, 3, String.valueOf(firstDigit));
			               // set the second digit by modulo division
			               int secondDigit = rowWins[i] % 10;
			               // set the string value of first digit
			               gw.setSquareLetter(i, 4, String.valueOf(secondDigit));
            			}
            			else
            			{
               				// set the string value of the value at index i
               				gw.setSquareLetter(i, 4, String.valueOf(rowWins[i]));
            			}
         		}

			// reset the keyboard
			for (int i = 65; i <= 90; i++) 
         		{
				gw.setKeyColor(Character.toString((char)i), new Color(0xDDDDDD));
			}
         
			// set gameOver to true so it can run the seperate clearing function
			gameOver = true;
         
		        // set scoreDisplay to false
		        scoreDisplay = false;
      		}
      
      		// else if gameOver is true but scoreDisplay is not, a new game starts
		else if (gameOver && scoreDisplay == false) 
      		{
			// reset the guess rows
         		for (int i = 0; i < 6; i++) 
         		{
				for (int j = 0; j < 5; j++) 
            			{
					gw.setSquareLetter(i, j, "");
					gw.setSquareColor(i, j, java.awt.Color.WHITE);
				}
			}
         
			// reset the keyboard
			for (int i = 65; i <= 90; i++) 
         		{
				gw.setKeyColor(Character.toString((char)i), new Color(0xDDDDDD));
			}
         
			// set gameOver to false so a new game can start
			gameOver = false;
         
		        // set arrayLength equal to the length of the wordle dictionary
		        int arrayLength = WordleDictionary.FIVE_LETTER_WORDS.length;
		       
		        // set randomNumber to be a random number from 0 to the end (aka. length) of the array
		        int randomNumber = (int) ((Math.random()*arrayLength));
		          
		        // set solution to be the word associated with the randomNumber index
		        solution = WordleDictionary.FIVE_LETTER_WORDS[randomNumber];
		          
		        // print solution to console for debugging purposes
		        // System.out.println(solution);

			// set the current row to the first one
			gw.setCurrentRow(0);
			
		} 
		else 
		{
			
	            	/* MILESTONE 2: When the enter key is pressed, the guessed word
	             	 * 1) when the enter key is pressed, the guessed word is passed to this this method as the "guess" parameter.
	                 * 2) you will need to check and see if the word that is passed in is a legitimate word in the WordleDicionary.FIVE_LETTER_WORDS array.
	                 * 3) if the word is not a valid word, show a message and have the user try again. do not count it as a turn.
	                 * 4) if the word is a vaild word, you'll check it against the solution word in the next milestone.
	                 */ 
             
             		// set wordPresent to false to begin
             		boolean wordPresent = false;
             
             		// loop through the array of five letter words
             		for (int i = 0; i < WordleDictionary.FIVE_LETTER_WORDS.length; i++)
             		{
               			// if the guess is a valid five letter word
               			if (guess.equals(WordleDictionary.FIVE_LETTER_WORDS[i].toUpperCase()))
               			{
                  			// set wordPresent to true and break the loop
                  			wordPresent = true;
                  			break; 
               			}
             		}
             
             		// if wordPresent is true, display encouraging message
             		if (wordPresent) 
             		{
               			gw.showMessage("Great! Keep going.");
             		}
             		// if wordPresent is false, then tell the user it's not valid
             		else 
             		{
               			gw.showMessage("That's not a word.");
               			return;
             		}
             
	            	/* MILESTONE 3: 
	                 * 1) color the boxes based on whether the letter is in the correct position, in the wrong position, or not in the word at all.
	                 */
             
	             	// array for storing current solution
	             	String[] currentAns = new String[5];
	             
	             	// array for storing current guess
	             	String[] currentGuess = new String[5];
	             
	             	// array for storing if a column in the solution has been colored or not; helps count for duplicates
	             	boolean[] coloredAns = new boolean[5];
	             
	             	// array for storing if a column in the guess has been colored or not; helps for coloring gray squares
	             	boolean[] coloredGuess = new boolean[5];
             
	             	// convert guess and solution into array
	             	for (int i = 0; i < 5; i++)
	             	{
	               		currentAns[i] = (solution.substring(i, i+1)).toUpperCase();
	               		currentGuess[i] = (guess.substring(i, i+1)).toUpperCase();
	             	}
             
             		// -------------------------------------------------------------------------------------------
             
             		// only evaluate while current row is less than 7, the word is present, and the guess is 5 characters
             		if (gw.getCurrentRow() < 6 && wordPresent && currentGuess.length == 5 && !maxRowsUsed)
             		{
               			// STEP 1: check to see if guess equals solution
               			if (guess.equals(solution.toUpperCase()))
               			{
                  			// gameOver set to false and congratulatory message displayed
                  			gameOver = true;
                  			gw.showMessage("YOU WIN! <3");
                  
                  			// set the row green
                  			gw.setSquareColor(gw.getCurrentRow(), 0, WordleGWindow.CORRECT_COLOR);
   			      		gw.setSquareColor(gw.getCurrentRow(), 1, WordleGWindow.CORRECT_COLOR);
   			      		gw.setSquareColor(gw.getCurrentRow(), 2, WordleGWindow.CORRECT_COLOR);
                  			gw.setSquareColor(gw.getCurrentRow(), 3, WordleGWindow.CORRECT_COLOR);
   			      		gw.setSquareColor(gw.getCurrentRow(), 4, WordleGWindow.CORRECT_COLOR);
                  
                  			// set the keyboard letters green
			                gw.setKeyColor(currentGuess[0].toUpperCase(), WordleGWindow.CORRECT_COLOR);
			                gw.setKeyColor(currentGuess[1].toUpperCase(), WordleGWindow.CORRECT_COLOR);
			                gw.setKeyColor(currentGuess[2].toUpperCase(), WordleGWindow.CORRECT_COLOR);
			                gw.setKeyColor(currentGuess[3].toUpperCase(), WordleGWindow.CORRECT_COLOR);
			                gw.setKeyColor(currentGuess[4].toUpperCase(), WordleGWindow.CORRECT_COLOR);
                  
			                // increase the amount in the rowWins array at the index of the current row
			                rowWins[gw.getCurrentRow()] += 1;
                  
			                gameOver = true;
			                scoreDisplay = true;
               			}
               			else
               			{
                  			// STEP 2A: assign green color to right column, right letter
                     
                  			// loop through all columns in guess
                  			for (int i = 0; i < 5; i++)
                  			{
                     				// if the letter at columns i in guess = letter at position i in solution
                     				if (currentGuess[i].equals(currentAns[i]))
                     				{
                        				// set the color to green
                        				gw.setSquareColor(gw.getCurrentRow(), i, WordleGWindow.CORRECT_COLOR);
                        
                        				// set the boolean value of the column to be true at index i, since it's colored
                        				coloredAns[i] = true;
                        				coloredGuess[i] = true;
                        
                        				// set the value of the green colored square to green on the virtual keyboard
                        				gw.setKeyColor(currentGuess[i].toUpperCase(), WordleGWindow.CORRECT_COLOR);
                     				}
                   			}
                   
                  			// STEP 2B: assign yellow color to wrong column, right letter 
                  			// citation for helpful videos and article that reminded me about nested for-loops: https://www.youtube.com/watch?v=1LCBssxhduU; https://www.youtube.com/watch?v=CwjSpUIFi7w; https://stackoverflow.com/questions/42305885/java-beginner-comparing-strings-in-nested-for-loop
                     
                  			// the i for-loop selects each letter of the guess each iteration
                  			for (int i = 0; i < 5; i++)
                  			{
                     				// if the selected column in guess is not already colored green (aka. set to true)
                     				if (!coloredGuess[i])
                     				{
                        				// the j for-loop compares each letter of the solution to the current selected letter of the guess
                        				for (int j = 0; j < 5; j++)
                        				{
                           					// if the letter at column i of the guess (uncolored/false) exists at any column j of the solution (uncolored/false) and its not the same column (since that was already checked for green)
                           					if (currentGuess[i].equals(currentAns[j]) && !coloredAns[j] && i != j)
                           					{
					                              // set column i of guess to yellow
					                              gw.setSquareColor(gw.getCurrentRow(), i, WordleGWindow.PRESENT_COLOR);
                              
					                              // set column j of solution to true, since that column is now used; same thing with i
					                              coloredAns[j] = true;
					                              coloredGuess[i] = true;
                              
					                              // set the value of the yellow colored square to yellow on the virtual keyboard
					                              if (gw.getKeyColor(currentGuess[i]) != WordleGWindow.CORRECT_COLOR)
					                              {
					                                 gw.setKeyColor(currentGuess[i].toUpperCase(), WordleGWindow.PRESENT_COLOR);
					                              }
                              
					                              // break the statement since column j is now used
					                              break; 
                           					}
                        				}
                     				}
                  			}
                  
                  			// STEP 2C: assign gray to wrong column, wrong letter
                     
			                // loop through all columns in guess
			                for (int i = 0; i < 5; i++)
			                {
						// if, at column i for the guess, is uncolored/false
						if (!coloredGuess[i])
                     				{
                        				// set the column i of guess to gray
                        				gw.setSquareColor(gw.getCurrentRow(), i, WordleGWindow.MISSING_COLOR);
                        
                        				// set the value of the gray colored square to gray on the virtual keyboard
                        				if (gw.getKeyColor(currentGuess[i]) != WordleGWindow.CORRECT_COLOR && gw.getKeyColor(currentGuess[i]) != WordleGWindow.PRESENT_COLOR)
                        				{
                           					gw.setKeyColor(currentGuess[i].toUpperCase(), WordleGWindow.MISSING_COLOR);
                        				}
                     				}
                  			}
               			}
               
		               // avoid out of bounds exception error and stay within 6 rows
		               if (gw.getCurrentRow() < 5) 
		               {
		                  gw.setCurrentRow(gw.getCurrentRow() + 1);
		               }
		               else
		               {
		                  maxRowsUsed = true;
		               }
               
             		}
             		else if (maxRowsUsed)
             		{
               			// the user used up all the turns, the game is now over. time to display the scoreboard
		                gameOver = true;
		                scoreDisplay = true;
		                maxRowsUsed = false;
		                gw.showMessage("You Lose.");
        		}
		}
	}

	// main method
	public static void main(String[] args) 
	{
		new Wordle().run();
	}
}
