// Kyle Free
// ITSE 2317
// 9/22/2021
// Rock Paper Scissors
//  This program demonstrates proper use of methods in Java

package rockpaperscissors;

import java.util.Random; // Random number generator
import javax.swing.JOptionPane;

public class RockPaperScissors {

    public static void main(String[] args) {
        
        // Declare local variables
        int
                npc, // computer choice
                player, // player choice
                npcWins = 0,
                playerWins = 0,
                tie = 0;
        
        boolean play = true; // Program loop
        
        String // String representations of the choices
                NPC,
                Player;
        
        welcomeMessage();
        
        // Main loop of the program
        while (play) {
            
            // Assign NPC and player values
            npc = assignNPC();
            Player = assignPlayer();
            
            // Assign integer and String values where needed
            player = playerChoice(Player);
            NPC = npcChoice(npc);
            
            // Debug console statements
            System.out.println(
                    "NPC: " + NPC + '\n'
                  + "Player: " + Player);
            
            // Runs the game and keeps score
            switch (runGame(player, npc, NPC)) {
            
                case 0:
                    ++npcWins;
                    break;
                    
                case 1:
                    ++playerWins;
                    break;
                    
                case 2:
                    ++tie;
                    break;
                
                default:
                    System.out.println("BIG ERROR");
                    break;
            }
            
            // Display results
            display(playerWins, npcWins, tie);
        
            // Play again
            play = playAgain();
        }
        
        // 1 - rock
        // 2 - paper
        // 3 - scissors
        
        System.exit(0);
    }
    
    public static void welcomeMessage() {
    // Welcome message
        JOptionPane.showMessageDialog(null,
                "Welcome to the Rock, Paper, Scissors Program!\n"
              + "This program runs rounds of the classic game that we all know!\n");
    }
    
    public static int assignNPC() {
        /** @return Assigns a number to the computer choice **/
        Random random = new Random(); // Random object
        
        // Assigns a random integer 1-3
        int npc = random.nextInt(3) + 1;
        
        // Console debug statement
        System.out.println(npc);
        
        return npc;
    }
    
    public static String assignPlayer() {
        /** Asks the player for input then assigns the choice
         *  @return user input in lower case
         **/
        
        String player = JOptionPane.showInputDialog(
                "Write your choice (rock, paper, or scissors): ");
        
        return player.toLowerCase();
    }
    
    public static int playerChoice(String Player) {
        // Assigns an integer value to the player choice
        switch (Player) {
        
            case "rock": return 1;
            case "paper": return 2;
            case "scissors": return 3;
            default: return 0;
        }
    }
    
    public static String npcChoice(int npc) {
        // Assigns a string literal to the npc choice
        switch (npc) {
         
            case 1: return "rock";
            case 2: return "paper";
            case 3: return "scissors";
            default: return "ERROR";
        }
    }
    
    public static int runGame(int player, int npc, String NPC) {
    /** Runs the game
     * @return 0 - false, 1 - true, 2 - tie **/
        if (player > npc) {
            
            switch (npc) {
                
                case 1: // NPC chooses rock
                    switch (player) {
                        
                        case 2: // player chooses paper
                            JOptionPane.showMessageDialog(null,
                                "The computer chose " + NPC + "!\nYou win!",
                                null,
                                JOptionPane.WARNING_MESSAGE);
                    
                            return 1; // Player Win
                
                        case 3: // player chooses scissors
                            JOptionPane.showMessageDialog(null,
                                "The computer chose " + NPC + ".\nYou lose.",
                                null,
                                JOptionPane.WARNING_MESSAGE);
                    
                            return 0; // NPC Win
                }
                
                case 2: // NPC chooses paper
                    switch (player) {
                            
                        case 3: // player chooses scissors
                            JOptionPane.showMessageDialog(null,
                                    "The computer chose " + NPC + "!\nYou win!",
                                    null,
                                    JOptionPane.WARNING_MESSAGE);
                            
                            return 1; // Player Win
                    }
            }
        }
        
        if (player < npc) {
        
            switch (npc) {
                
                case 3: // NPC chooses scissors
                    switch (player) {
                    
                        case 2: // Player chooses paper
                            JOptionPane.showMessageDialog(null,
                                    "The computer chose " + NPC + ".\nYou lose.",
                                    null,
                                    JOptionPane.WARNING_MESSAGE);
                            
                            return 0; // NPC Win
                            
                        case 1: // player chooses rock
                            JOptionPane.showMessageDialog(null,
                                    "The computer chose " + NPC + "!\nYou win!",
                                    null,
                                    JOptionPane.WARNING_MESSAGE);
                            
                            return 1; // Player Win
                    }
                    
                case 2: // NPC chooses paper
                    switch (player) {
                        
                        case 1: // Player chooses rock
                            JOptionPane.showMessageDialog(null,
                                    "The computer chose " + NPC + "!\nYou lose!",
                                    null,
                                    JOptionPane.WARNING_MESSAGE);
                            
                            return 0; // Loss
                    }
            }
        }
            // Display a tie
            JOptionPane.showMessageDialog(null,
                "The computer chose " + NPC + ".\nIt is a draw.",
                null,
                JOptionPane.WARNING_MESSAGE);
                            
                return 2; // Tie
    }
    
    public static void display(int playerWins, int npcWins, int tie) {
        // Displays wins and ties
        JOptionPane.showMessageDialog(null,
                "Player Wins: " + playerWins + '\n'
              + "Computer Wins: " + npcWins + '\n'
              + "Tie Games: " + tie);
    }
    
    public static boolean playAgain() {
    /** Asks the player to play again 
      * @return boolean matching input to the string "yes"
     **/
        String play =
                JOptionPane.showInputDialog("Play again? (yes/no)").toLowerCase();
        
        return play.equals("yes");
    
    }
}
