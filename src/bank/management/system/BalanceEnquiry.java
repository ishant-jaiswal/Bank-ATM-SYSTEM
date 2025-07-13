
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener{
    String pinnumber;
    JButton back;
    BalanceEnquiry(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("CHANGE YOUR PIN");
        text.setBounds(235,280,500,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        back=new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        
        Conn c=new Conn();
        int balance=0;
        try{
            ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance+=Integer.parseInt(rs.getString("amount"));
                }
                else{
                    balance-=Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){
            System.out.print(e);
        }
        
        JLabel btext=new JLabel("Your Current Account balance is Rs "+ balance);
        btext.setForeground(Color.WHITE);
        btext.setBounds(170,300,400,30);
        image.add(btext);
        
        setSize(900,900);
        setLocation(300,0);
        //setUndecorated(true);
        setVisible(true);
    
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
    
    public static void main(String args[]) {
        // TODO code application logic here
        new BalanceEnquiry("");
    }
}
