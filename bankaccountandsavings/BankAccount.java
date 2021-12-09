// Abstract class page 699
package bankaccountandsavings;

import java.text.*;
import javax.swing.*;

/**
 * @author kfree
 */
public abstract class BankAccount {
    // Class Attributes
    private int
            numDeposits,
            numWithdrawals;
    
    protected double
            balance,
            annualInterestRate,
            monthlyServiceCharge;
    
    protected DecimalFormat 
            df, // Decimal Format
            pf; // Percentage Format
    
    // Default Constructor
    public BankAccount() {
        
        df = new DecimalFormat("#.##");
        pf = new DecimalFormat("#.#%");
    
        numDeposits = 0;
        numWithdrawals = 0;
        balance = 0.0;
        annualInterestRate = 0.0;
        monthlyServiceCharge = 0.0;
        
        // Debug statement
        System.out.println("Superclass Constructor");
    }
    
    /**
     * Specialized Constructor
     * @param balance The balance for the account
     * @param annualInterestRate The annual interest rate for the account
     **/
    public BankAccount(double balance, double annualInterestRate) {
    
        df = new DecimalFormat("#.##");
        pf = new DecimalFormat("#.#%");
        
        numDeposits = 0;
        numWithdrawals = 0;
        monthlyServiceCharge = 0.0;
        
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        
        //Debug Statement
        System.out.println("Superclass Constructor");
    }
    
    // Exception
    public class NoBalance extends Throwable {
        
        public NoBalance()
            {super("There is no balance in the account!");}
    }
    
    // Mutators
    /**
     * Deposits to the account
     * @param amount The amount to be deposited
     **/
    public void deposit(double amount) {
       
        balance += amount;
        numDeposits++;
    }
    
    /**
     * @param amount The amount to withdraw from the account
     * @throws NoBalance If the balance is insufficient
     **/
    public void withdraw(double amount) throws Throwable {
    
        if (balance > amount) {
            
            balance -= amount;
            numWithdrawals++;
        }
        
        else throw new NoBalance();
    }
    
    
    // Calculates the interest for the account
    public void calcInterest() {
        
        double monthlyInterestRate = annualInterestRate / 12;
        double monthlyInterest = balance * monthlyInterestRate;
        
        balance += monthlyInterest;
        
        System.out.printf("Monthly Interest: $%.2f\n", monthlyInterest);
        
        JOptionPane.showMessageDialog(null,
                "Monthly Interest: $" + df.format(monthlyInterest)
        );
    }
    
    /**
     * Runs the monthly processes through the account
     * @throws NoBalance If there is no balance in the account
     **/
    
    public void monthlyProcess() throws Throwable {
    
        if (balance >= monthlyServiceCharge)
            balance -= monthlyServiceCharge;
        
        else throw new NoBalance();
        
        calcInterest();
        
        System.out.println(this);
        
        JOptionPane.showMessageDialog(null, this);
        
        numDeposits = 0;
        numWithdrawals = 0;
        monthlyServiceCharge = 0.0;
    }
    
    // Setters
    public void setServiceCharge(double charge)
        {monthlyServiceCharge = charge;}
    
    // Accessors
    public String toString() {
        
        String str =
                printBalance() + '\n' + 
                printInterestRate() + '\n' + 
                printServiceCharge() + '\n' + 
                printNumDeposits() + '\n' + 
                printNumWithdrawals();
        
        /*
        String str = 
                "Account Balance: $" + df.format(balance) +
                "\nAnnual Interest Rate: " + pf.format(annualInterestRate) + 
                "\nMonthly Service Charge: $" + df.format(monthlyServiceCharge) + 
                "\nNumber of Deposits This Month: " + numDeposits + 
                "\nNumber of Withdrawals: " + numWithdrawals;
        */
        return str;
    }
    
    public String printNumDeposits() {
    
        String str = "Number of Deposits This Month: " + numDeposits;
        
        return str;
    }
    
    public int getNumDeposits()
        {return numDeposits;}
    
    public String printNumWithdrawals() {
        
        String str = "Number of Withdrawals This Month: " + numWithdrawals;
        
        return str;
    }
    
    public int getNumWithdrawals()
        {return numWithdrawals;}
    
    public String printBalance() {
    
        String str = "Account Balance: $" + df.format(balance);
        
        return str;
    }
    
    public double getBalance()
        {return balance;}
    
    public String printInterestRate() {
        
        String str = "Annual Interest Rate: " +
            pf.format(annualInterestRate);
        
        return str;
    }
    
    public double getInterestRate()
        {return annualInterestRate;}
    
    public String printServiceCharge() {
        
        String str = "Monthly Service Charge: $" + df.format(monthlyServiceCharge);
        
        return str;
    }
    
    public double getServiceCharge()
        {return monthlyServiceCharge;}
}
