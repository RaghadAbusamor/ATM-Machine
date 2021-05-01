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
public class ConsoleScreen {
    
    public void display(String message){
        System.out.println(message);  
        
    }
    public int readPIN() throws  InvalidPIN{
        
       Scanner input = new Scanner(System.in);
       int pin  ;
       pin = input.nextInt();
        if( pin>=1000 && pin<10000)
        return pin;
        else 
         
        throw new InvalidPIN();
        
    }
    
    public int readMenuChoice(String prompt, String[] menu)throws Cancelled{
        return 0;
    }
    
    public int readAmount(String prompt) throws Cancelled{
        return 0;
    }

    
}
    