/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.util.ArrayList;


/**
 *
 * @author HP
 */
public class MAIN {
     
    

   
    public static void main(String[] args) {
        
    MyLogger mylogger = new MyLogger();
    Atm atm = new Atm(mylogger);
    
    atm.start();
  
     
     
     
    }
 
}
    

