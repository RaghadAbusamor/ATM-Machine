/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;


import ATMExcetpions.AccountNotFoundException;
import ATMExcetpions.Cancelled;
import ATMExcetpions.InsufficientBalanceException;
import ATMExcetpions.InvalidPIN;
import ATMExcetpions.NotEnoughCash;
import atm.screen;
import atm.MyLogger;





/**
 *
 * @author raghad , ayat 
 */
public class MAIN {

  
    public static void main(String[] args) throws Cancelled, InvalidPIN, AccountNotFoundException, InsufficientBalanceException, NotEnoughCash {  
    
    MyLogger mylogger =new MyLogger();
    Atm atmm = new Atm(mylogger);
    atmm.start();
 
    }

   
 
}
  

