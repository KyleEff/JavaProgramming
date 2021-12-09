package firsttoone;

import javax.swing.*;

public class Player {
    // Static Attribute keeps track of how many players have been created
    private static int playerCount = 0;
    
    // Attributes
    private String name;
    private int points;
    Die dice;
    
    private final int WINNER = 1;
    private boolean winner = false;
    
    // Default Constructor
    public Player() {
    
        dice = new Die(6);

        ++playerCount;
        
        pointReset();
        askName();
    }
    // Specialized Constructor
    public Player(String name) {
    
        dice = new Die(6);

        ++playerCount;
        
        pointReset();
        this.name = name;
    }
    
    public void askName() {
        // Ask the player for their name
        name = JOptionPane.showInputDialog(
                "Enter Player " + playerCount + " name: "
        );
    }
    
    public void rollDice() {
        // Rolls the player's die
        dice.roll();
        
        points -= dice.getValue();
        
        if (points == WINNER) {
           // If the player has 1 point left, they win
            winner = true;
            
            JOptionPane.showMessageDialog(null,
                    name + " wins!"
            );
        }
        
        else if (points < WINNER){
            // If the player has less than 1 point, the points are reset
            pointReset();
            
            JOptionPane.showMessageDialog(null,
                    name + "'s points have been reset!"
            );
        }
    }
    
    public void playerReset() {
    
        points = 50;
        winner = false;
    }
    
    public void pointReset()
        {points = 50;}
    
    // Accessor Functions
    public int getPoints()
        {return points;}
    
    public String getName()
        {return name;}
    
    public boolean winner()
        {return winner;}
    
    public int getPlayerCount()
        {return playerCount;}
}
