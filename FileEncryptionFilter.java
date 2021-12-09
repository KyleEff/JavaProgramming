// Kyle Free
// ITSE 2317
// 11/27/21
// This class encrypts a message by creating an object from the class, or by
//  using static methods. The message is encrypted by going from a string,
//  to characters, to unicode, to hexadecimal, to binary. Decrypting involves
//  this process in reverse.

package fileencryptionfilter;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

/**
 * @author kfree
 */
public class FileEncryptionFilter {
    // Attributes
    protected static int numFilters = 0;
    
    protected static ArrayList<String> hex = new ArrayList<>();

    protected static FileInputStream istream;
    protected static FileOutputStream ostream;
    
    protected static DataInputStream inputFile;
    protected static DataOutputStream outputFile;
    
    /**
     * Default Constructor
     * @throws IOException  From the stream objects
     **/
    public FileEncryptionFilter() throws IOException {
        
        ++numFilters;
        
        String str = enterFile();
        
        ostream = new FileOutputStream(
                str + ".dat"
        );
        
        istream = new FileInputStream(
                str + ".dat"
        );
    }
    
    /**
     * Specialized constructor
     * @param message  The message to be encrypted
     * @throws IOException  From the stream objects
     **/
    public FileEncryptionFilter(String message) throws IOException {
    
        ++numFilters;
        
        String str = enterFile();
        
        ostream = new FileOutputStream(
                str + ".dat"
        );
        
        istream = new FileInputStream(
                str + ".dat"
        );
    
        encrypt(message);
    }
    
    /**
     * This function prompts the user to enter a file name, and then returns the
     *  input as a string
     * @return str  File name string
    **/
    public static String enterFile() {
    
        String str = JOptionPane.showInputDialog(
                "Enter the file name:"
        );
        
        return str;
    }
    /**
     * This function prompts the user to enter a phrase to be encrypted
     * @return str  The phrase to be encrypted
     **/
    public String writePhrase() {
    
        String str = JOptionPane.showInputDialog(
                "Enter your message to be encrypted:"
        );
        
        return str;
    }
    
    /**
     * This function needs to be attached to an object
     * @throws IOException  From the stream objects
     **/
    public void encrypt() throws IOException {
    
        String message = writePhrase();
        
        String[] tokens = message.split("");
        
        for (String s : tokens) {
        
            char[] c = s.toCharArray();
            
            for (char i : c) 
                hex.add(Integer.toHexString(i));
            
        }
        
        outputFile = new DataOutputStream(ostream);
        
        for (int i = 0; i < hex.size(); i++)
                outputFile.writeUTF(hex.get(i));
        
        outputFile.close();
        
        System.out.println(hex);
        
        hex.clear();
    }
    
    /**
     * This function operates by itself, it encrypts the message that is
     *  passed as an argument
     * @param message   The message to be encrypted
     * @throws IOException   From the FileOutputStream object
     **/
    public static void encrypt(String message) throws IOException {
        
        String str = enterFile();
  
        ostream = new FileOutputStream(
                str + ".dat"
        );
    
        String[] tokens = message.split(""); 
        
        for (String s : tokens) {
        
            char[] c = s.toCharArray();
            
            for (char i : c) 
                hex.add(Integer.toHexString(i));
            
        }
        // This initiation throws an IOException
        outputFile = new DataOutputStream(ostream);
        
        for (String s: hex)
                outputFile.writeUTF(s);
        
        outputFile.close();
        
        System.out.println(hex);
        
        hex.clear();
    }
    
    /**
     * This function decrypts the message and operates within the class
     **/
    public void decrypt() {
    
        boolean endOfFile = false;
        
        inputFile = new DataInputStream(istream);
        
        ArrayList<Integer> uni = new ArrayList<>();
        
        while (!endOfFile) {
        
            try {
            
                uni.add(Integer.parseInt(inputFile.readUTF(), 16));
            }
            
            catch (EOFException e) {
            
                endOfFile = true;
                JOptionPane.showMessageDialog(null, "End of File");
            }
            
            catch (IOException e) {
            
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        
        try {
            PrintWriter decrypted = new PrintWriter(
                "Decrypted" + Integer.toString(numFilters) + ".txt"
            );
        
            for (int i : uni) {
            
                decrypted.print((char) i);
            }
            
            decrypted.close();
        }
        catch (IOException e) {
        
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        System.out.println(uni);
        
        ++numFilters;
        
        hex.clear();
    }
    
    public static void decrypt(String fileName) {
        
        try {
            
            istream = new FileInputStream(
                    fileName + ".dat"
            );
            
            boolean endOfFile = false;
        
            inputFile = new DataInputStream(istream);
        
            ArrayList<Integer> uni = new ArrayList<>();
        
            while (!endOfFile) {
        
                try {
            
                    uni.add(Integer.parseInt(inputFile.readUTF(), 16));
                }
            
                catch (EOFException e) {
            
                    endOfFile = true;
                    JOptionPane.showMessageDialog(null, "End of File");
                }
            
                catch (IOException e) {
            
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        
            try {
                PrintWriter decrypted = new PrintWriter(
                    "Decrypted" + Integer.toString(numFilters) + ".txt"
                );
        
                for (int i : uni) {
            
                    decrypted.print((char) i);
                }
            
                decrypted.close();
            }
            
            catch (IOException e) {
        
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        
            System.out.println(uni);
            
            ++numFilters;
        }
        
        catch (FileNotFoundException e)
            {JOptionPane.showMessageDialog(null, e.getMessage());}
        
        hex.clear();
    }
    
    /**
     * Driver function
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            
            encrypt("This is my message.");
            decrypt("test"); // This argument needs to be the filename entered in the encrypt method
            
            FileEncryptionFilter filter = new FileEncryptionFilter();
            
            filter.encrypt();
            filter.decrypt();
        }
        
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
