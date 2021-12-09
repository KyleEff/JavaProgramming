package internetserviceprovider;
import javax.swing.*;

public class InternetServiceProvider {

    public static void main(String[] args) {
        
        // Declare Variables
        String
                input,
                more;
        
        boolean loop = true;
        
        // Introduction
        JOptionPane.showMessageDialog(null,
                "Package A: $9.95 per month for 10 hours of access. "
                        + "Additional hours are $2.00 per hour.\n" +
                "Package B: $13.95 per month for 20 hours of access. "
                        + "Additional hours are $1.00 per hour.\n" +
                "Package C: $19.95 per month for unlimited access.");
        
        // Main loop
        while (loop) {
            // Gain input from the user
            input = JOptionPane.showInputDialog("Which package would you like"
                    + "to subscribe to?\nA / B / C");
            // Run decision structure based on user input
            if (input.equalsIgnoreCase("A"))
                JOptionPane.showMessageDialog(null, "If you had purchased"
                        + " package B, you would have saved "
                        + "$1.00 per additional hour.");
            
            else if (input.equalsIgnoreCase("B"))
                JOptionPane.showMessageDialog(null, "If you had purchased "
                        + "package A, you would have saved $4.00 per month.");
            
            else
                JOptionPane.showMessageDialog(null, "If you had purchased "
                        + "package A, you would have saved $10.00 per month.\n"
                        + "If you had purchased package B, you would have "
                        + "saved $6.00 per month.");
            
            // Confirm looping structure
            more = JOptionPane.showInputDialog("Enter another package? Y / N");
            
            if (more.equalsIgnoreCase("N"))
                loop = false;
        }
        // Exit program
        System.exit(0);
    }
}
