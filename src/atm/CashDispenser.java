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
public class CashDispenser {
    private Double cash_amount;
    
    
    public boolean cheackCashAmount()
    {
       return true; 
    }

    public CashDispenser() {
    }

    public Double getCash_amount() {
        return cash_amount;
    }

    public void setCash_amount(Double cash_amount) {
        this.cash_amount = cash_amount;
    }
    
    
}
