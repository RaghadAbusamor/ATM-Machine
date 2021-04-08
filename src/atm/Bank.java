/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Bank {
    
     ArrayList<BankAccount> bank_account = new ArrayList<BankAccount>();
     
     public void add(BankAccount BA )
     {
        bank_account.add(BA);
     }
     
     public BankAccount search(int pin)
     {
         
         for (int i=0 ;i<bank_account.size();i++){
             if(bank_account.get(i).getCard().getPIN() == pin) {
             return bank_account.get(i);}
        
                 }
         return bank_account.get(-1);
     }
     public void withdraw (BankAccount BA){
         
          System.out.println("How much would you like to withdraw fro your account?");
          Scanner input =new Scanner(System.in);
          int amount =input.nextInt();
			
			if( BA.getBalance() > amount ){
				 BA.setBalance(BA.getBalance() - amount);
			}else{
                         System.out.println("\"Sorry, Insufficient Funds!\"");
			}
     }
   
     
    public Double Balance_inquiry(BankAccount BA){
        return BA.getBalance();
    }
}
