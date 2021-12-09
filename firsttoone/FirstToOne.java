// Kyle Free
// ITSE 2317
// 10/20/21
// This program demonstrates proper use of objects in Java

package firsttoone;

public class FirstToOne {

    public static void main(String[] args) {
        // Driver function
        
        // Creates a new game to play
        Game game = new Game();
        
        // This loop runs the actual game
        while (game.play())
            game.playGame();
    }
}
