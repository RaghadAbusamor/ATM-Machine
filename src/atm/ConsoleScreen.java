/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.util.Scanner;

/**
 *
 * @author HP
 */
public class ConsoleScreen {
  
    public int enterPIN()
    {  
     Scanner input = new Scanner(System.in);
     System.out.println(" enter 4 digit PIN number ");
     int pin= input.nextInt();
        return pin;

    }
    
    
      public void menu(){
          
          System.out.println("   choose 1. Withdraw\n" + "2. Balance inquiry "+  "3. Cancle");
     Scanner input =new Scanner(System.in);
     int x =input.nextInt();
     switch(x){
         case 1: 
          break;
         case 2:
          break;
         case 3:
             System.out.println( );
         
     }  }
    
      public void display_balance(){
          
      }
}
