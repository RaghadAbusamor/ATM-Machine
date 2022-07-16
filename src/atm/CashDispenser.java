/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;
import ATMExcetpions.NotEnoughCash;

/**
 *
 * @author raghad , ayat
 */
public class CashDispenser {
    
    private int cashOnHand=10000;
    private Log log;
   public CashDispenser(Log log){
       this.log = log;
   }
    public void setInitialCash(int initialCash){
    this.cashOnHand = initialCash;
    }
    
    public boolean checkCashOnHand(double amount){
         if (this.cashOnHand >= amount){
            return true;
        }
        else{
             return false;
        }
    }
    
    public void dispenseCash(int amount)throws NotEnoughCash{
       if (this.checkCashOnHand(amount)){
        this.cashOnHand -= amount;
       log.log("client has withdrawn succesfully from cash dispenser");
        }
        else{
            throw new NotEnoughCash();
        } 
       
    }
    
    
}
