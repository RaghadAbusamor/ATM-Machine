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
public class InsufficientBalanceException extends Exception {

    /**
     *
     * @return
     */
    @Override
    public String getMessage() {
        return "Insufficient Balance";
    }
    
    
}
