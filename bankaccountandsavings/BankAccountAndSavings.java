// PDF page 737
package bankaccountandsavings;

import javax.swing.JOptionPane;

/**
 *
 * @author kfree
 */
public class BankAccountAndSavings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Driver function
        try {
            // Savings Account creation
            SavingsAccount myAccount = new SavingsAccount(100, 0.1);
            
            // Window display
            JOptionPane.showMessageDialog(null, myAccount);
            
            /*
            for (int i = 0; i < 10; i++) {
                // Deposits and withdraws
                myAccount.deposit(i + (i * (i + i)));
                System.out.printf("Deposit %d: ", i + 1);
                System.out.println(myAccount.getBalance());
                
                myAccount.withdraw(-i + (i * (i + i)));
                System.out.printf("Withdraw %d: ", i + 1);
                System.out.println(myAccount.getBalance());
                
                System.out.println();
            }
            */
            
            myAccount.deposit(25);
            System.out.println(myAccount.printBalance());
            
            //myAccount.withdraw(101);
            //System.out.println(myAccount.getBalance());
            
            // Withdraw 5 fives, triggering a service charge of $1
            for (int i = 0; i < 5; i++)
                myAccount.withdraw(1);
            System.out.println(myAccount.printBalance());
            
            // Process the account monthly
            myAccount.monthlyProcess();
            
            // This will throw an exception
            SavingsAccount yourAccount = new SavingsAccount();
            
        }
        
        catch (Throwable e) // Displays an exception if thrown
            {JOptionPane.showMessageDialog(null, e.getMessage());}
        
    }
    
}
