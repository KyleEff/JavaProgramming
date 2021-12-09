// Kyle Free
// ITSE 2317
// 10/21/2021
// PigLatin.java
// This program demostrates use of text processing wrapper objects and methods

package piglatin;

import javax.swing.*;

/**
 * @author kfree
 */
public class PigLatin {
    // Attributes
    private String[] tokens;
    private StringBuilder finalPhrase;
    private String
            input,
            finishedPhrase;
    
    // Default constructor
    public PigLatin() {
        
        welcomeMessage();
        
        finalPhrase = new StringBuilder();
        
        input();
    }
    
    public void welcomeMessage() {
        // Welcome message
        JOptionPane.showMessageDialog(null,
                "Welcome to the Pig Latin Translator!\n" + 
                "This program requires you to enter a word or phrase,\n" + 
                "and then it will be translated to Pig Latin!"
        );
    }
    
    public void input() {
        // Get input from the user
        input = JOptionPane.showInputDialog(
        
                "Enter a word or phrase to be translated:"
        );
        // create tokens
        tokens = input.split(" ");
    }
    
    public void translate() {
        // Translates the tokens
        for (String s : tokens) {
            // Create a temporary StringBuilder object
            StringBuilder temp = new StringBuilder();
            
            // Append a token to the temp object
            temp.append(s.toUpperCase());
            temp.append(' ');
            
            // Set the character at the end of the token
            //  to the character at the beginning
            temp.setCharAt(temp.length() - 1, temp.charAt(0));
            // Append "AY"
            temp.append("AY");
            // Delete the first character of the token
            temp.delete(0, 1);
            
            // Append the translated token to the final phrase builder
            finalPhrase.append(temp);
            finalPhrase.append(' ');
        }
        // Finish the phrase as a string
        finishedPhrase = finalPhrase.toString();
    }
    
    public void display() {
        // Displays the translated phrase
        JOptionPane.showMessageDialog(null,
        
                "Your phrase translated into Pig Latin is:\n" + 
                finishedPhrase
        );
    }
    
    // Accessor Functions
    public String[] getTokens()
        {return tokens;}
    
    public String toString()
        {return finishedPhrase;}
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Driver function
        
        // Create a new phrase to translate
        PigLatin phrase = new PigLatin();
        
        // Print the tokens
        for (String s : phrase.getTokens())
            System.out.println(s);
        
        // Translate and then display the translated phrase
        phrase.translate();
        phrase.display();
        
        // Print the finished phrase
        System.out.println(phrase);
        
        System.exit(0);
    }
}
