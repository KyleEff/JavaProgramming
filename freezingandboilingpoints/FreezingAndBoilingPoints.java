// Kyle Free
// ITSE 2317 - Java Programming
// 10/5/2021
// Freezing and Boiling Points Program

package freezingandboilingpoints;

import javax.swing.JOptionPane;

public class FreezingAndBoilingPoints {

    public static void main(String[] args) {
        
        // Create Substance objects
        Substance ethyl = new Substance(-173, 172, "Ethyl Alcohol");
        Substance mercury = new Substance(-38, 676, "Mercury");
        Substance oxygen = new Substance(-362, -306, "Oxygen");
        Substance water = new Substance(32, 212, "Water");
        
        // Boolean Loop variable
        boolean cont = true; // cont = continue
        
        // Create temperature input variable
        double temp;
        
        welcomeMessage();
        // Main loop of the program
        while (cont) {
        
            temp = Double.parseDouble(JOptionPane.showInputDialog(
                "Enter a temperature in Farenheit"));
            
            ethyl.setTemp(temp);
            mercury.setTemp(temp);
            oxygen.setTemp(temp);
            water.setTemp(temp);
            
            JOptionPane.showMessageDialog(null,
                display(ethyl) +
                display(mercury) +
                display(oxygen) +
                display(water));
            
            cont = contLoop();
        }
        
        System.exit(0);
    }
    
    public static void welcomeMessage() {
    // Welcome Message
        JOptionPane.showMessageDialog(null,
                "Welcome to the State of the Matter program!\n" + 
                "The user will enter a temperature and then the program\n" +
                "will display different substances' states at that temperature!");
    }
    
    public static String display(Substance substance) {
    /* @return formatted output from the substance object */
        return substance.getName() + ": " + substance.getState() + '\n';
    }
    
    public static boolean contLoop() {
    // Loop verification
        String cont =
                JOptionPane.showInputDialog(
                        "Run the program again? (yes/no)").toLowerCase();
        
        return cont.equals("yes");
    }
}