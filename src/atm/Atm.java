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
public class Atm {
    
     private Cardreader card_reader ;
     private CashDispenser cash_dispenser ;
     private ConsoleScreen console_screen;
     private Bank bank_account;

    public Atm() {
        
    }
     
    public void withdrow(BankAccount BA)
    {
       bank_account.withdraw(BA);
    }
    
    public void Balance_inquiry(BankAccount BA){
        
        bank_account.Balance_inquiry(BA);
        
    }
           
    
}
