// Kyle Free
// ITSE 2317
// 9/15/2021
// Hotel Occupancy Program
// This program demonstrates use of basic loops used in Java

package hoteloccupancy;

import javax.swing.*;
import java.text.NumberFormat;

public class HotelOccupancy {

    public static void main(String[] args) {
        
        // Declare Variables
        double occupancyRate;
        
        int
            numFloors,
            occRooms = 0,
            numRooms = 0,
            vaccRooms,
            input,
            occInput;
        
        // Room and floor CONSTANTS
        final int
            MIN_ROOMS = 10,
            MIN_FLOORS = 1,
            MAX_ROOMS = 30,
            MAX_FLOORS = 8,
            UNLUCKY_FLOOR = 13;
            
        // Welcome Message
        JOptionPane.showMessageDialog(null,
            "Welcome to the Hotal Occupancy program!\n"
          + "This program will calculate the occupancy\n"
          + "rate on every floor of the hotel!");

        // Input
        numFloors = Integer.parseInt(JOptionPane.showInputDialog(
            "How many floors are in the hotel?"));
        
        // Input Validation for the number of floors
        while (numFloors < MIN_FLOORS) {
            
            JOptionPane.showMessageDialog(
                null,
                "ERROR: The number entered was less than " + MIN_FLOORS 
                        + ".\nTry again!",
                null,
                JOptionPane.WARNING_MESSAGE
            );
            
            numFloors = Integer.parseInt(JOptionPane.showInputDialog(
                "How many floors are in the hotel?"));
        }
        
        while (numFloors > MAX_FLOORS) {
            
                JOptionPane.showMessageDialog(
                    null,
                    "ERROR: The number entered was greater than " + MAX_FLOORS
                            + ".\nTry again!",
                    null,
                    JOptionPane.WARNING_MESSAGE
                );
            
            numFloors = Integer.parseInt(JOptionPane.showInputDialog(
                "How many floors are in the hotel?"));
        }
        
        for (int i = 1; i <= numFloors; i++) {
        // Main loop of the program
        // This loop adds to the running total of rooms
        
            // This statement skips the 13th floor
            if (i == UNLUCKY_FLOOR) {
                
                ++numFloors;
                ++i;
            }
            
            input = Integer.parseInt(JOptionPane.showInputDialog(
                "How many rooms are on floor number " + i + '?'));
            
            // Input validation for number of room input
            while (input < MIN_ROOMS) {
                
                JOptionPane.showMessageDialog(
                    null,
                    "ERROR: The number of rooms entered was less than "
                            + MIN_ROOMS + ".\nTry again!",
                    null,
                    JOptionPane.WARNING_MESSAGE);
                
                input = Integer.parseInt(JOptionPane.showInputDialog(
                "How many rooms are on floor number " + i + '?'));
            }
            
            while (input > MAX_ROOMS) {
            
                JOptionPane.showMessageDialog(
                    null,
                    "ERROR: The number of rooms entered was greater than "
                            + MAX_ROOMS + ".\nTry again!",
                    null,
                    JOptionPane.WARNING_MESSAGE);
                
                input = Integer.parseInt(JOptionPane.showInputDialog(
                "How many rooms are on floor number " + i + '?'));
            }
            
            numRooms += input;
            
            occInput = Integer.parseInt(JOptionPane.showInputDialog(
                    "How many rooms are occupied on this floor?"));
            
            // Input validation for occupied room input
            while (occInput > input) {
            
                JOptionPane.showMessageDialog(
                    null,
                    "ERROR: The number of rooms entered was more than the "
                            + "total rooms on the floor!\nTry again!",
                    null,
                    JOptionPane.WARNING_MESSAGE);
                
                occInput = Integer.parseInt(JOptionPane.showInputDialog(
                    "How many rooms are occupied on this floor?"));
            }
            occRooms += occInput;
            
            /*
            // Debug statements
            System.out.println(i);
            numRooms += 11;
            occRooms += 4;
            */
        }
        
        // Reduces the number of floors if over 13
        if (numFloors > UNLUCKY_FLOOR)
            --numFloors;
        
        // Calculate the occupancy rate and vacant rooms
        occupancyRate = (double)occRooms / (double)numRooms;
        vaccRooms = numRooms - occRooms;
        
        // Create formatting object
        NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMinimumFractionDigits(2);
        
        // Output all the information of the program
        JOptionPane.showMessageDialog(null,
            "Number of Floors: " + numFloors + '\n'
          + "Total Number of Rooms: " + numRooms + '\n'
          + "Number of Occupied Rooms: " + occRooms + '\n'
          + "Number of Vacant Rooms: " + vaccRooms + '\n'
          + "Occupancy Rate: " + percent.format(occupancyRate));
        
        System.exit(0);
    }
}
