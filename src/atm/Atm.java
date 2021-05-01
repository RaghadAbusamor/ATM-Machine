/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ATM;

import ATMExcetpions.Cancelled;
import atm.InvalidPIN;
import java.util.Scanner;

/**
 *
 * @author apauser
 */
public class Atm {
    
    private Bank bank;
    private Cardreader cardReader;
    private CashDispenser cashDispenser;
    private ConsoleScreen console;
    private Log log;
    
   public Atm(Log log){
       this.bank = new Bank();
       this.console = new ConsoleScreen ();
       this.cardReader = new Cardreader();
   
   }
   
   public void start() throws Cancelled, InvalidPIN{
      
   this.log.log("ATM Started");
       
       
       cashDispenser.setInitialCash(10000);
       Scanner input = new Scanner (System.in);
       String no; 
       String name;
       System.out.println("please enter your card number :");
       no= input.nextLine();
       System.out.println("please enter your card name: ");
       name= input.nextLine();
       Card c = new Card(no,name);   
      
            this.log.log("card number and name are inserted");
        
       
        for(BankAccount b: this.bank.clients){
            if (no.equals(b.getAccountNo())){
                cardReader.readCard(c);
                this.log.log("card reader is active");
                console.display("please enter your PIN number,limitation on attempt : three times ");
                int pin = console.readPIN();
                boolean n = verifyPIN(c,pin);
 
                int count =1;
                
                try{
              if( !n  && count<3  )
              {
                console.display("please enter your PIN number,limitation on attempt :"+(3-count)+ "times ");
                console.readPIN();
               n = verifyPIN(c,pin);
               count++;
              }
              
              
            }
            catch( InvalidPIN ex){
                System.out.println(ex);
            }
        }
   }
   }
   public boolean verifyPIN(Card card, int PIN){
           String c = card.getNo();
           Bank b = new Bank();
         if (b.getBankAccountByNo(c).getPIN()== PIN)
          {
          return true;    
          }
         else 
             return false;
     
   }
    
    
}
