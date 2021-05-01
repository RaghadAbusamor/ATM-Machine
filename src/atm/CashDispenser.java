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
public class CashDispenser {
    
    private int cashOnHand;
    private Log log;
    
    public CashDispenser(Log log){
       this.log = log;
    }
    public void setInitialCash(int initialCash){
    this.cashOnHand = initialCash;
    }
    
    public boolean checkCashOnHand(int amount){
         if (this.cashOnHand>= amount){
            return true;
        }
        else{
             return false;
        }
    
    }
    
    public void dispenseCash(int amount)throws NotEnoughCash{
       if (checkCashOnHand(amount)){
        this.cashOnHand -= amount;
        this.log.log("client has withdrawn succesfully from cash dispenser");
        }
        else{
            throw new NotEnoughCash("Sorry, insufficient cash in dispenser");
        } 
       
    }
    
    
}
