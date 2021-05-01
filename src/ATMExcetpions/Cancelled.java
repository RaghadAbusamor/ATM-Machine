/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ATMExcetpions;

/**
 *
 * @author HP
 */
public class Cancelled extends Exception{
    
    public void  Cancelled(){
   System.out.println("exit");            
   System.exit(0);
   
}
}