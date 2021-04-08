/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

/**
 *
 * @author HP
 */
public class BankAccount {
    private String ClientName;
    private int ClientNo;
    private double balance;
    private Card card;

    public BankAccount(String ClientName, int ClientNo, double balance, Card card) {
        this.ClientName = ClientName;
        this.ClientNo = ClientNo;
        this.balance = balance;
        this.card = card;
    }

    public int getClientNo() {
        return ClientNo;
    }

    public void setClientNo(int ClientNo) {
        this.ClientNo = ClientNo;
    }

    
    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String ClientName) {
        this.ClientName = ClientName;
    }

 
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
    
   
    
           
    }

