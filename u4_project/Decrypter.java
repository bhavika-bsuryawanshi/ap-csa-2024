// Bhavika Suryawanshi 

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;

public class Decrypter {
   //Methods to read in and write to a file - do not modify or delete!
   public static String readInFile(String fileName) throws Exception {
      String newText = "";
      Scanner kb = new Scanner(new File(fileName));
      while(kb.hasNextLine()) {
         newText += kb.nextLine();
      }
      kb.close();
      return newText;
   }
   public static void writeToFile(String fileName, String text) throws Exception {
      try {
         FileWriter myWriter = new FileWriter(fileName);
         myWriter.write(text);
         myWriter.close();
         System.out.println("Successfully wrote to the file.");
       } 
       catch (IOException e) {
         System.out.println("An error occurred.");
         e.printStackTrace();
       }
   }
   
   // add your methods below:    
   
   // totalLetters method
   public static int totalLetters(String letters) {
      
      int count = 0;
      
      for (int x = 0; x < letters.length(); x++) {
        
         if (!(letters.substring(x, x + 1).equals(" "))) 
         {
            count++;
        }
                
      }
      return count;
   }
   
   // letterFreq method
   public static double letterFreq(String letter, String text) {
      int totLet = totalLetters(text); 
      int count = 0;
      
      for (int x = 0; x < text.length(); x++) {
        if (!(text.substring(x, x + 1).equals(" "))) {
            if (text.substring(x, x + 1).equals(letter)) {
                count++;
            }
        }
    }     
      
      double letFreq = (double)count/totLet;
      return letFreq;
   }
      
   // matchLetter method
   
   public static String matchLetter(String letter, String cipherText, String comparisonText) {
   
      double cipherFreq = letterFreq(letter, cipherText);
    
      // max frequency is 100 because it's a base comparison point
      double maxFreq = 100.0;
      String maxLetter = "";
    
      for (int x = 0; x < comparisonText.length(); x++) 
      {
         // current (temporary) index
         String tempLetter = comparisonText.substring(x, x + 1);
         
         // ignore if space
         if (tempLetter.equals(" ")) 
         {
            continue;
         }
         
         // temporary variable to store letterFreq of current (temporary) index
         double tempFreq = letterFreq(tempLetter, comparisonText);
         
         // the absolute value (displacement) of the temporary frequency from the "max" frequency
         double freqDiff = Math.abs(tempFreq - cipherFreq);
        
         // check to see if the absolute value difference is less than the base comparison point
         // update the max frequency and max letter through the iterations as needed
         if (freqDiff < maxFreq) 
         {
            maxFreq = freqDiff;
            maxLetter = tempLetter;
         }
    }
    return maxLetter;
   }
    
    // decryptText method
    public static String decryptText(String cipherText, String comparisonText)
    {
      String newString = "";
      for (int ind = 0; ind < cipherText.length(); ind++)
      {
         System.out.println("Progress: " + ind + " out of " + cipherText.length());
         if (cipherText.substring(ind, ind+1).equals(" "))
         {
            String space = " ";
            newString += space;
         } 
         else 
         {
            String currentFreq = matchLetter(cipherText.substring(ind, ind+1), cipherText, comparisonText);
            newString += currentFreq;
         }
      }
      return newString;
    }
    
    
   
   // Main Method:
   public static void main(String[] args) throws Exception {
      String encFile = readInFile("encryptedClue.txt");
      String compFile = readInFile("comparisonText.txt");
      
      // Testing Day 1 Methods
      System.out.println(totalLetters(encFile));
      System.out.println(letterFreq("a", encFile));
      System.out.println(letterFreq("l", compFile));
      
      // Testing Day 2 Method
      System.out.println(matchLetter("a", encFile, compFile));
      
      // Testing Day 3 Method
      String decrypted = decryptText(encFile, compFile);
      writeToFile("decryptedClue.txt", decrypted);
           
   }
}