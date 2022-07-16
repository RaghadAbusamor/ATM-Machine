    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package atm;

    import ATMExcetpions.Cancelled;
    import ATMExcetpions.InsufficientBalanceException;
    import ATMExcetpions.InvalidPIN;
    import ATMExcetpions.NotEnoughCash;
    import java.awt.BorderLayout;
    import java.awt.Color;
    import java.awt.Dimension;
    import java.awt.FlowLayout;
    import java.awt.Font;
    import java.awt.GridLayout;
    import static java.awt.SystemColor.text;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.util.logging.Level;
    import java.util.logging.Logger;
    import javax.swing.BorderFactory;
    import javax.swing.ButtonGroup;
    import javax.swing.ImageIcon;
    import javax.swing.JButton;
    import javax.swing.JFrame;
    import javax.swing.JLabel;
    import javax.swing.JOptionPane;
    import javax.swing.JPanel;
    import javax.swing.JPasswordField;
    import javax.swing.JRadioButton;
    import javax.swing.JTextField;
    import javax.swing.border.Border;
    import javax.swing.border.TitledBorder;
    import sun.net.www.content.image.jpeg;


    /**
     *
     * @author raghad , ayat
     */
        public class ConsoleScreen extends JFrame{
         private Log log;



           public ConsoleScreen(Log log){
             this.log=log;
           }

            public void display(String message){
                JOptionPane.showMessageDialog(rootPane, message); 
            }

            public int readPIN() 
            {
              log.log(" The PIN Has Been Read ");
            int pin= Integer.parseInt(JOptionPane.showInputDialog("please enter your PIN number  : "));
             return pin;  
            }

        public void readMenuChoice( BankAccount b, String menu)throws Cancelled, InsufficientBalanceException , NotEnoughCash 
        {
            this.setSize(400,500);
            this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            this.setLayout(new BorderLayout());
            this.setTitle(" Transition "); 
            Font f =new Font("Serif",Font.ITALIC | Font.BOLD, 20);
            Font f4 =new Font("Serif", Font.BOLD, 22);

            JPanel p1=new JPanel();
            JPanel p2=new JPanel(new GridLayout(3,1,5,5));
            JLabel Menu =new JLabel(menu);
            Menu.setFont(f4);
            Menu.setForeground(Color.DARK_GRAY);
            Menu.setPreferredSize(new Dimension(200, 100));
            p1.add(Menu); 

         ///BUtton
            JButton withdraw , Balance_inquiry ,Cancelled;
             withdraw =new JButton(" Withdraw ");

             Balance_inquiry=new JButton(" Balance Inquiry");
             Cancelled =new JButton(" Cancelled ");
             withdraw.setFont(f);
             Balance_inquiry.setFont(f);
             Cancelled.setFont(f);
             withdraw.setBackground(Color.LIGHT_GRAY);
             Balance_inquiry.setBackground(Color.LIGHT_GRAY);
             Cancelled.setBackground(Color.LIGHT_GRAY);

             withdraw.setForeground(Color.blue);
             Balance_inquiry.setForeground(Color.blue);
             Cancelled.setForeground(Color.blue);

             p2.add(withdraw);
             p2.add(Balance_inquiry);
             p2.add(Cancelled);
             p2.setPreferredSize(new Dimension(20,20));
             p1.setVisible(true);
             this.add(p1,BorderLayout.NORTH);
             this.add(p2,BorderLayout.CENTER);
             this.setVisible(true);

               withdraw.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    log.log(" Withdraw option has been approved ");
                        double Amount;
                    try {
                        Amount = readAmount(b);
                           b.withdraw(Amount);
                    } catch (Cancelled ex) {
                   JOptionPane.showMessageDialog(rootPane, ex);
                    }
                   catch (InsufficientBalanceException ex) {
                    JOptionPane.showMessageDialog(rootPane, ex);  
                    }



                }
            }); 


               Balance_inquiry.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {

                     b.Balance_inquiry();
                     log.log(" Balance Inquiry option has been approved ");
                }
            }); 


              Cancelled.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {  
                    log.log(" YOUR OPERATION CANCELD ");
                    cancel();
                }
            }); 


        }
        public double readAmount(BankAccount b) throws Cancelled{
           JFrame j = new JFrame();
           j.setSize(500,400);
           j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           j.setLayout(new BorderLayout());
           j.setTitle(" read amount "); 
           Font f =new Font("Serif",Font.ITALIC | Font.BOLD, 20);
   


           JButton ok =new JButton(" OK ");

            ok.setFont(f);
            ok.setBackground(Color.blue);
            ok.setForeground(Color.white);
            JPanel imagepanel =new JPanel(new BorderLayout());   
            imagepanel.setPreferredSize(new Dimension(400, 400));
            JPanel buttonPanel =new JPanel();     

            buttonPanel.add(ok);

           j.add(buttonPanel,BorderLayout.SOUTH);

             JLabel image =new JLabel();
             image.setPreferredSize(new Dimension(200, 200));
             ImageIcon icon = new ImageIcon("amount1.png");
             image.setIcon(icon);
             image.setVisible(true);

              imagepanel.add(image);
              j.add(imagepanel,BorderLayout.CENTER);
              j.setVisible(true);




 int i=Integer.parseInt(JOptionPane.showInputDialog(" Press  1   2   3  4   5   6   7  8  For Amount ")) ;

            ok.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                   log.log(" Withdrawal process has been cancelled ");
                   j.dispose();
                }
            }); 
       switch(i){
           case(1):log.log(" you have withdraw 100 NIS "); return 100;
           case(2):log.log(" you have withdraw 200 NIS "); return 200;  
           case(3):log.log(" you have withdraw 400 NIS ");return 400;
           case(4):log.log(" you have withdraw 600 NIS ");return 600;
           case(5):log.log(" you have withdraw 800 NIS ");return 800;
           case(6):log.log(" you have withdraw 1000 NIS ");return 1000;
           case(7):log.log(" you have withdraw 1200 NIS ");return 1200;
           case(8):
       int your_amount = Integer.parseInt(JOptionPane.showInputDialog("Enter your own amount :"));
      if(( your_amount%20 == 0 || your_amount%50 == 0)&& your_amount<4000)
      {log.log(" you have withdraw "+your_amount +" NIS");
          return your_amount;
      }
      else{
    JOptionPane.showMessageDialog( rootPane,"You Entered Invalid Amount ! try again" ) ;      
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.dispose();
        return 0;
      
      }
      
    default:JOptionPane.showMessageDialog(rootPane, " please choose from 1 to 8 only !! ");
      }  
     return 0;   }   


    public void cancel(){
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     this.dispose();
    }     
    }


