/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordgame;
import javax.swing.JOptionPane; // using JOption pane to create
// dialog boxes.

/**
 *
 * @author Sample
 */
public class WordGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //creating string variables
        String userName;
        String userAge;
        String userCity;
        String userCollege;
        String userProfession;
        String userAnimal;
        String userPetName;
        
        //Informing user about how the progam works.  Using JOptionPane class
        //to create dialog boxes
        
        //Creating dialog box to tell user what the program does
        JOptionPane.showMessageDialog(null, "This is a simple program" +
                " to create a short story \n using  " +
                "your input.");
        //Creating dialog box to tell user what to do
        JOptionPane.showMessageDialog(null,"Just enter the information \n" +
                "asked for. Have fun!");
        
        //Collecting user answers
        userName = 
                JOptionPane.showInputDialog("Enter your name. \n");
        userAge =
                JOptionPane.showInputDialog("Enter your age. \n");
        userCity =
                JOptionPane.showInputDialog("Enter your hometown. \n");
        userCollege =
                JOptionPane.showInputDialog("Enter name of a college. \n");
        userProfession =
                JOptionPane.showInputDialog("Enter dream job. \n");
        userAnimal =
                JOptionPane.showInputDialog("Enter your favorite animal. \n");
        userPetName =
                JOptionPane.showInputDialog("Enter another name. \n");
        
        // Display story using information provided by the user
        JOptionPane.showMessageDialog(null,"There once was a person named " +
                userName + " who lived in " + userCity + ".\n At the age of " + 
                userAge + ", " + userName + " went to college at "
                + userCollege + ".\n " + 
                userName + " graduated and went to work as a " +
                userProfession + ". \nThen " + userName + " adopted an " +
                userAnimal + " named " + userPetName + ". \n They both lived " +
                "happily ever after.");
        
        JOptionPane.showMessageDialog(null,"Thank you!");
        
        System.exit(0);
    }
    
}
