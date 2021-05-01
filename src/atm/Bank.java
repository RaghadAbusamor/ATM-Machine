/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ATM;

import java.util.ArrayList;

/**
 *
 * @author apauser
 */
public class Bank {
    
    private String name;
    ArrayList<BankAccount> clients;
    
    public Bank(){
        this.clients = new ArrayList<>();
        this.clients.add(new BankAccount("2222", "Ahmed", 4000, 1234));
        this.clients.add(new BankAccount("3333", "Ali", 5000, 1222));
        this.clients.add(new BankAccount("4444", "Mohammed", 10000, 4422));
    }
    
    public BankAccount getBankAccountByNo(String no) throws AccountNotFoundException{
        for(BankAccount b: this.clients){
            if (no.equals(b.getAccountNo())){
                return b;
            }
        }
        throw new AccountNotFoundException();
    }
    
    
    
    
    
}
