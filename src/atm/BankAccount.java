/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;
import ATMExcetpions.InsufficientBalanceException;
import ATMExcetpions.Cancelled;
import javax.swing.JOptionPane;

/**
 *
 * @author raghad , ayat
 */
public class BankAccount {
    
    private String accountNo; 
    private String clientName;
    private double balance;
    private int PIN;
  
   

    public BankAccount(String accountNo, String clientName, double balance, int PIN) {
        this.accountNo = accountNo;
        this.clientName = clientName;
        this.balance = balance;
        this.PIN = PIN;
    }
    
    public void withdraw(double amount) throws InsufficientBalanceException{

        if (amount > this.balance){
            throw new InsufficientBalanceException();
        }
        else {
            this.balance -= amount;
        }
    }
    public void Balance_inquiry(){
        JOptionPane.showMessageDialog(null, " the balance for "+this.getAccountNo()+ " Account is :" + this.getBalance()+" NIS");
    }
    public String getAccountNo() {
        return accountNo;
    }

    public String getClientName() {
        return clientName;
    }

    public double getBalance() {
        return balance;
    }

    public int getPIN() {
        return PIN;
    }
    
    
    
    
    
    
    
    
    
}

