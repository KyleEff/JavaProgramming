// Kyle Free
// ITSE 2317
// 10/12/2021
// This program demonstrates proper use of arrays/ArrayList in Java

package worldserieschamps;

// Required imports
import java.util.*;
import javax.swing.*;
import java.io.*;

public class WorldSeriesChamps {

    // Champion names
    public static ArrayList<String> champs = new ArrayList<>();
    // Champion win indices and years
    public static ArrayList<ArrayList<Integer>> wins = new ArrayList<>();
    // Total wins accumulator
    public static int totalWins = 0;
    
    public static void welcomeMessage() {
        // Welcome Message to the program
        JOptionPane.showMessageDialog(
                
                null,
                "Welcome to the World Series Champions database!\n"
              + "Enter a team name and this program will display how many times\n"
              + "that team has won the World Series and which years!"
        );
    }
    
    public static void populate(ArrayList<String> list)
            throws FileNotFoundException {
        /** @param Accepts an ArrayList to populate with Strings from a file **/
        
        // Create File object and open the text
        File file = new File(confirmFile());
        
        // Try creating a new Scanner if resources are available
        try (Scanner inputFile = new Scanner(file)) {
            // Read the file contents into the array
            while (inputFile.hasNext())
                // Add the strings from the file to the ArrayList
                list.add(inputFile.nextLine());
        }
    }
    
    public static String askSearch() {
        /**@return returns the searched String**/
        // Brings up a window to ask for search input
        String search = JOptionPane.showInputDialog(
                "Enter the team you wish to search for:"
        );
        
        return search;
    }
    
    public static void search(ArrayList<String> list, String search) {
        /**
         * @param list      The ArrayList to search
         * @param search    The search term specified by the user
         **/
        
        // List of indices where the search term is located
        ArrayList<Integer> indices = new ArrayList<>();
        // List of years the team has won
        ArrayList<Integer> years = new ArrayList<>();
        // Index variable
        int j = 0;
        
        // Enchanced for loop to iterate through the list param
        for (String i : list) {
            
            if (i.toLowerCase().contains(search.toLowerCase())) {
                // Add the current index to the list
                indices.add(j);
                
                if (j == 0) // if year == 1903
                    years.add(j + 1903); // Add the year
                
                else if (j + 1904 < 1994) // if year > 1903 && < 1994
                    years.add(j + 1904); // Add the year plus one
                
                else
                    years.add(j + 1905); // the year plus two
            }
            
            totalWins = indices.size();
            j++;
        }
        
        wins.add(indices);
        wins.add(years);
    }
    
    public static void display(ArrayList winYears, String search){
        /**
         * @param winYears  The array with the winning years as elements
         **/
        // Displays the wins of the searched team
        if (totalWins != 0){
            String winners = ""; // This holds the winning years of the team
        
            for (int i = 0; i < winYears.size(); i++)
                winners = winners + winYears.get(i).toString() + '\n';
        
            JOptionPane.showMessageDialog(
                
                null,
                "The " + search + " have won the World series a total of " + 
                totalWins + " times.\n" + 
                "The Winning Years are:\n" + 
                winners
            );
        }
        
        else JOptionPane.showMessageDialog(
        
                null,
                "That team has unfortunely not won any World Series Games!"
        );
    }
    
    public static boolean confirmContinue() {
        /** 
         * @return choice   The user's choice
         **/
        
        // Confirms to the user to run the program again
        int choice = JOptionPane.showOptionDialog(null,
                "Do you want to search for another team?",
                "Quit?",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, null, null);
        
        return choice == JOptionPane.YES_OPTION;
    }
    
    public static String confirmFile(){
        /**
         * @return fileName Returns the filename, either default or custom
         **/
        String fileName;
        
        int choice = JOptionPane.showOptionDialog(null,
                
                "Do you want to use the default file? WorldSeriesWinners.txt",
                "File",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, null, null
        );
        
        if (choice == JOptionPane.NO_OPTION) {
            
            fileName = JOptionPane.showInputDialog(
        
                "Enter the filename:"
            );
            
            return fileName;
        }
        
        else return "WorldSeriesWinners.txt";
    }
    
    public static void strip(ArrayList list) {
        /**
         * @param list  The list to be stripped
         **/
        
        // Strips the list param
        for (int i = 0; i < list.size(); i++)
            list.remove(i);
    }
    
    public static void strip(ArrayList list, ArrayList list2) {
        /**
         * @param list, list2  The lists to be stripped
         **/
        
        // Strips both list params
        for (int i = 0; i < list2.size(); i++) {
            
            while (i < list.size())
                list.remove(i);
            
            list2.remove(i);
        }
    }
    
    public static void main(String[] args) {
        // Driver function
        
        // cont = continue
        boolean cont = true;
        
        welcomeMessage();
        
        // Populate the array with teams
        try { populate(champs); }
        catch (FileNotFoundException e)
            { System.out.println(e.getMessage()); }
        
        // Main loop of the program
        while (cont) {
            // Ask the user for a search term
            String search = askSearch();
        
            // Search the array of teams
            search(champs, search);
        
            // Prints the list of indices and years won
            System.out.println(wins);
        
            // Displays the results of the search to the user
            display(wins.get(1), search);
            
            // Strip the lists of all elements
            strip(wins, wins.get(1));
            strip(wins);
            
            // Print the blank list
            System.out.println(wins);
            
            // Confirm continue
            cont = confirmContinue();
        }
        
        System.exit(0);
    }
}
