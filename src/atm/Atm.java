 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @author raghad , ayat
 * 
 */
package atm;

import ATMExcetpions.Cancelled;
import ATMExcetpions.AccountNotFoundException;
import ATMExcetpions.InsufficientBalanceException;
import ATMExcetpions.InvalidPIN;
import ATMExcetpions.NotEnoughCash;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Atm extends JFrame {
    
    private Bank bank;
    private Cardreader cardReader;
    private CashDispenser cashDispenser;
    private ConsoleScreen console;
    private Log log;
    String  menu =( " choose transaction :  " ) ;

    
   public  Atm(Log log){  
       this.log= log;
       this.setSize(400,650);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setLayout(new BorderLayout());
       this.setTitle(" ATM Machine ");
       this.bank = new Bank();
       this.console = new ConsoleScreen(log);
       this.cardReader = new Cardreader();
       this.cashDispenser = new CashDispenser(log);
    
        this.setVisible(true);
   }
   
   public void start() throws Cancelled, InvalidPIN, AccountNotFoundException, InsufficientBalanceException, NotEnoughCash{
     
       this.log.log("**********************************************************"); 
       this.log.log("ATM Started");
       JPanel p1,p2,p3,infopanel;
       infopanel=new JPanel(new GridLayout(3, 1, 10, 10));
       JLabel image =new JLabel(); 
       ImageIcon icon = new ImageIcon("imageicon.jpg");
       image.setIcon(icon);
       infopanel.add(image);
     
       cashDispenser.setInitialCash(10000);
       
       p1=new JPanel();
       p2=new JPanel();
       p3=new JPanel();
       JLabel cardNumLabel=new JLabel("Please Enter Your Card Number :"); 
       JLabel cardNameLabel=new JLabel("Please Enter Your Card Name:   "); 
       JTextField cardNum=new JTextField(22);
       JTextField cardName=new JTextField(22);
       JButton nextButton =new JButton(" NEXT ");
       nextButton.setBackground(Color.blue);
       nextButton.setForeground(Color.white);
       
       JButton cancelButton =new JButton(" CANCEL ");
       cancelButton.setBackground(Color.blue);
       cancelButton.setForeground(Color.white);
       
       Font f =new Font("Serif",Font.ITALIC | Font.BOLD, 20);
       cardNameLabel.setFont(f);
        cardNumLabel.setFont(f);
       p1.add(cardNumLabel);
       p1.add(cardNum);
       p2.add(cardNameLabel);
       p2.add(cardName);
       p3.add(nextButton);
       p3.add(cancelButton);
       infopanel.add(p1);
       infopanel.add(p2);
       this.add(infopanel,BorderLayout.CENTER);
       this.add(p3,BorderLayout.SOUTH);
       String no=cardNum.getText();
       String name=cardName.getText();
       Card c = new Card(no,name);   
  
      this.log.log("Card Number And Name Are Inserted");

      cancelButton.addActionListener(new ActionListener(){
       @Override
           public void actionPerformed(ActionEvent ae) {
           log.log(" The Process Is Complitly Canceled , THANK YOU!");
           JOptionPane.showMessageDialog(null," The Process Is Complitly Canceled , THANK YOU!");
           System.exit(0);
           }
           });
        
        nextButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
            c.setNo(cardNum.getText());
            c.setName(cardName.getText());
            log.log("Clint Name is "+c.getName()+" & His Number is "+c.getNo());
               try {
                  
                   
                   end(c);
               } catch (Cancelled ex) {
                   Logger.getLogger(Atm.class.getName()).log(Level.SEVERE, null, ex);
               } catch (InvalidPIN ex) {
                   Logger.getLogger(Atm.class.getName()).log(Level.SEVERE, null, ex);
               } catch (AccountNotFoundException ex) {
                   Logger.getLogger(Atm.class.getName()).log(Level.SEVERE, null, ex);
               } catch (InsufficientBalanceException ex) {
                   Logger.getLogger(Atm.class.getName()).log(Level.SEVERE, null, ex);
               } catch (NotEnoughCash ex) {
                   Logger.getLogger(Atm.class.getName()).log(Level.SEVERE, null, ex);
               }
           }} );
              
      
       p3.add(nextButton);
       this.add(p3,BorderLayout.SOUTH);
            }
   
   public void end(Card card)throws Cancelled, InvalidPIN, AccountNotFoundException, InsufficientBalanceException, NotEnoughCash{
       cashDispenser.setInitialCash(10000);
            
             int cheak =0;
             for(BankAccount b:this.bank.clients){
            if (card.getNo().equals(b.getAccountNo())){
                
                cheak++;
                cardReader.readCard(card);
            this.log.log("Card Reader Is Active");
       
           
        try{
               int pin = console.readPIN();
               boolean n = verifyPIN(card,pin);
               int count = 0;
              while ( !n  && count<2  )
              {
                  console.display("Invalid PIN ,Try Again You Have "+(2-count)+ " Attempt  ");
      this.log.log(" The PIN You Entered IS Invalid ");
                  int p= console.readPIN();
               n = verifyPIN(card,p);
               count++;
              }
              if(n)
              {
                  this.log.log(" The PIN Has Been Recognized ");
                   console.readMenuChoice(b,menu);
              }
              else { 
                  JOptionPane.showMessageDialog(this,"All Attempts Have Been Consumed ");
                  this.log.log("  All Attempts Have Been Consumed ");
              }
               }
         catch(AccountNotFoundException acc){
                JOptionPane.showMessageDialog(rootPane, acc);
              this.log.log(acc.toString());
               }
         catch(Cancelled ce){
             JOptionPane.showMessageDialog(rootPane, ce);
          this.log.log(ce.toString());
            }
        catch(InsufficientBalanceException inex){
            JOptionPane.showMessageDialog(rootPane, inex);
           this.log.log(inex.toString()); 
        }
        catch(NotEnoughCash noex){
             JOptionPane.showMessageDialog(rootPane, noex);
          this.log.log(noex.toString());
        }
           
           
            
            } }
       if(cheak==0){
          JOptionPane.showMessageDialog(rootPane, new AccountNotFoundException());
          this.log.log("***Account Not Found ");
       }
       
   }
            
   
   public boolean verifyPIN(Card card, int PIN) throws AccountNotFoundException{
           String c = card.getNo();
           Bank b = new Bank();
         if(PIN== (b.getBankAccountByNo(c).getPIN()))
          {
          return true;    
          }
         else 
             return false;
     
   }

    

          
        
                
   }
    
            

