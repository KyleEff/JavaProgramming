
package bankaccountandsavings;

import javax.swing.JOptionPane;

/**
 * @author kfree
 */
public class SavingsAccount extends BankAccount {
    // Class Attributes
    private boolean active;
    
    private final int
            MINIMUM_AMOUNT = 25,
            MAXIMUM_WITHDRAWALS = 4;
    
    /**
     * Default Constructor
     * @throws NotEnough    The construction fails if there is not enough in the account
     **/
    public SavingsAccount() throws Throwable {
    
        if (balance >= MINIMUM_AMOUNT)
            active = true;
        
        else throw new NotEnough();
    }
    
    /**
     * Specialized Constructor
     * @param balance   The balance for the account
     * @param annualInterestRate The interest rate for the account
     * @throws NotEnough The construction fails if there is not enough in the account
     **/
    public SavingsAccount(
            double balance, double annualInterestRate
        ) throws Throwable {
        
        if (balance >= MINIMUM_AMOUNT){
            
            this.balance = balance;
            this.annualInterestRate = annualInterestRate;
            active = true;
        }
        
        else throw new NotEnough();
    
    }
    
    // Exception
    public class NotEnough extends Throwable {
    
        public NotEnough()
            {super("There are not enough funds in the account!");}
    }
    
    /**@Override withdraw Overrides the withdraw method
     * @param amount    The amount to be withdrawn
     * @throws Throwable Handled within the function
     */
    public void withdraw(double amount) throws Throwable {
    
        if (active) {
            try {
                if (checkBalance())
                    super.withdraw(amount);
            }
        
            catch (Throwable e)
                {JOptionPane.showMessageDialog(null, e.getMessage());}
        }
    }
    
    /**
     * @Override deposit Overrides the deposit method
     * @param amount    Amount to be deposited
     */
    public void deposit(double amount) {
        
        if (active)
            super.deposit(amount);
        
        else if (balance + amount >= MINIMUM_AMOUNT) {
        
            active = true;
            super.deposit(amount);
        }
    }
    
    /**
     * Checks the balance of the account
     * @throws NotEnough If there is not enough in the account
     * @return good     If the balance is good, then a true boolean is returned
     **/
    public boolean checkBalance() throws Throwable {
        
        boolean good = false;
        
        if (balance >= MINIMUM_AMOUNT)
            return good = true;
       
        else throw new NotEnough();
    }
    
    /**
     * @Override monthlyProcess
     * @throws Throwable throws a NotEnough exception if there is not a $25 balance
     **/
    public void monthlyProcess() throws Throwable {
    
            if (getNumWithdrawals() > MAXIMUM_WITHDRAWALS)
                monthlyServiceCharge += getNumWithdrawals() - MAXIMUM_WITHDRAWALS;
            
            if (balance < MINIMUM_AMOUNT) {
                
                active = false;
                throw new NotEnough();
            }
            
            else super.monthlyProcess();
    }
    
}
