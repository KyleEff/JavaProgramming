package firsttoone;

import javax.swing.*;

public class Game {
    // Attributes
    private Player
            one,
            two,
            winner;
    
    private boolean play;
    
    // Default constructor
    public Game() {
    
        play = true;
        
        welcomeMessage();
        
        one = new Player();
        two = new Player();
    }
    
    public void welcomeMessage() {
        // Welcome message
        JOptionPane.showMessageDialog(null,
                "Welcome to the First to One Game!\n" + 
                "Each player starts with 50 points, then rolls a dice and has\n" + 
                "the amount rolled subtracted from their points!\n" + 
                "The first player to have 1 point wins, but beware that if your\n" +
                "points reach 0, they will be reset back to 50!\n" + 
                "Ready?"
        );
    }
    
    public void playGame() {
        // This function runs the game
        int round = 1;
        
        JOptionPane.showMessageDialog(null,
                // Beginning stats
                "Starting Off:\n" + 
                one.getName() + ": " + one.getPoints() + '\n' +
                two.getName() + ": " + two.getPoints()
        );
        
        while (!one.winner() && !two.winner()) {
            // Runs the game while there are no winners
            one.rollDice();
            two.rollDice();
            
            JOptionPane.showMessageDialog(null,
                    
                    "Round " + round + "\n\n" +
                    "Rolls:\n" +
                    one.getName() + ": " + one.dice.getValue() + '\n' +
                    two.getName() + ": " + two.dice.getValue() + "\n\n" +

                    "Points Remaining:\n" + 
                    one.getName() + ": " + one.getPoints() + '\n' +
                    two.getName() + ": " + two.getPoints()   
            );
            
            round++;
        }
        // Assigns winners
        if (one.winner())
            winner = one;
        
        else if (two.winner())
                winner = two;
        
        JOptionPane.showMessageDialog(null,
                // Final display of the game
                "Game over!\n" + 
                winner.getName() + " WINS!\n\n" +

                "Points Remaining:\n" +
                one.getName() + ": " + one.getPoints() + '\n' +
                two.getName() + ": " + two.getPoints()
        );
        
        playAgain();
    }
    
    public void playAgain() {
        // Asks the players if they want to play again
        int choice = JOptionPane.showOptionDialog(null,
                "Do you want to play again?",
                "Quit?",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, null, null);
        
        if (choice == JOptionPane.YES_OPTION) {
        
            winner = null;
            
            one.playerReset();
            two.playerReset();
        }
        
        else play = false;
    }
    
    // Accessor Function
    public boolean play()
        {return play;}
}
