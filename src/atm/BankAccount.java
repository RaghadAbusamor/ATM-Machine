/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ATM;


/**
 *
 * @author apauser
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
        if (amount <= this.balance){
            this.balance -= amount;
        }
        else{
            
            throw new InsufficientBalanceException();
        }
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

