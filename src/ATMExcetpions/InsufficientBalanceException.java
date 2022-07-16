/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ATMExcetpions;

/**
 *
 * @author raghad & ayat
 */
public class InsufficientBalanceException extends Exception {
      @Override
      public String getMessage() {
        return "Insufficient Balance";
    } 
    
}
