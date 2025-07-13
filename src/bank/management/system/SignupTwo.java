package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupTwo extends JFrame implements ActionListener{
   JTextField panTextField,aadharTextField;
   JComboBox category,income,education,occupation,religion;
   JButton next;
   JRadioButton NoSeniorCitizen,yesSeniorCitizen,yesAccount,noAccount;
   String formno;
    
   public SignupTwo(String formno){
       this.formno=formno;
       setLayout(null);
       setTitle("New Account APPlication Form-Page 2");
       
       JLabel additionalDetails =new JLabel("Page 2: Additional Details ");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80, 400, 30);
        add(additionalDetails);
        
        JLabel religionName =new JLabel("Religion:");
        religionName.setFont(new Font("Raleway",Font.BOLD,20));
        religionName.setBounds(100,140, 100, 30);
        add(religionName);
        
        String valReligion[]={"Hindu", "Muslim", "Sikh", "christian","0ther"};
        religion=new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);
       
        JLabel categoryName =new JLabel("Category:");
        categoryName.setFont(new Font("Raleway",Font.BOLD,20));
        categoryName.setBounds(100,190, 200, 30);
        add(categoryName);
        
        String valCategory[]={"General","OBC","SC","ST","Other"};
        category=new JComboBox(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel icomeName =new JLabel("Income:");
        icomeName.setFont(new Font("Raleway",Font.BOLD,20));
        icomeName.setBounds(100,240, 200, 30);
        add(icomeName);
        
        String incomeCategory[]={"Null","less than 1,50,000","less than 2,50,0000","less than 5,00,000","upto 10,00,000"};
        income=new JComboBox(incomeCategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);
        
        
        JLabel educateName =new JLabel("Education:");
        educateName.setFont(new Font("Raleway",Font.BOLD,20));
        educateName.setBounds(100,290, 200, 30);
        add(educateName);
        
        JLabel qName =new JLabel("Qualification:");
        qName.setFont(new Font("Raleway",Font.BOLD,20));
        qName.setBounds(100,315, 200, 30);
        add(qName);
        
        String educationValues[]={"Non Graduation","Graduate","Post Graduartion","Doctrate","others"};
        education=new JComboBox(educationValues);
        education.setBounds(300, 295, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);
        
        JLabel OccupName =new JLabel("Occupation:");
        OccupName.setFont(new Font("Raleway",Font.BOLD,20));
        OccupName.setBounds(100,390, 200, 30);
        add(OccupName);
        
        String occupationValues[]={"Self-Employed","Bussiness man","Student","Retried","others"};
        occupation=new JComboBox(occupationValues);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
       
        
        JLabel panNo =new JLabel("Pan Number:");
        panNo.setFont(new Font("Raleway",Font.BOLD,20));
        panNo.setBounds(100,440, 200, 30);
        add(panNo);
        
        panTextField=new JTextField();
        panTextField.setFont(new Font("Releway",Font.BOLD,14));
        panTextField.setBounds(300, 440, 400, 30);
        add(panTextField);
        
        
        JLabel aadharNo =new JLabel("Aadhar Number:");
        aadharNo.setFont(new Font("Raleway",Font.BOLD,20));
        aadharNo.setBounds(100,490, 200, 30);
        add(aadharNo);
        
        aadharTextField=new JTextField();
        aadharTextField.setFont(new Font("Releway",Font.BOLD,14));
        aadharTextField.setBounds(300, 490, 400, 30);
        add(aadharTextField);
        
        JLabel sc =new JLabel("Senior Citizen:");
        sc.setFont(new Font("Raleway",Font.BOLD,20));
        sc.setBounds(100,540, 200, 30);
        add(sc);
        
        yesSeniorCitizen=new JRadioButton("Yes");
        yesSeniorCitizen.setBounds(300, 540, 100, 30);
        yesSeniorCitizen.setBackground(Color.WHITE);
        add(yesSeniorCitizen);
        
        NoSeniorCitizen=new JRadioButton("No");
        NoSeniorCitizen.setBounds(450, 540, 100, 30);
        NoSeniorCitizen.setBackground(Color.WHITE);
        add(NoSeniorCitizen);
        
        ButtonGroup citizenGroup=new ButtonGroup();
        citizenGroup.add(NoSeniorCitizen);
        citizenGroup.add(NoSeniorCitizen);
        
        
        JLabel existAccount =new JLabel("Existing Account:");
        existAccount.setFont(new Font("Raleway",Font.BOLD,20));
        existAccount.setBounds(100,590, 200, 30);
        add(existAccount);
        
        yesAccount=new JRadioButton("Yes");
        yesAccount.setBounds(300, 590, 100, 30);
        yesAccount.setBackground(Color.WHITE);
        add(yesAccount);
        
        noAccount=new JRadioButton("No");
        noAccount.setBounds(450, 590, 100, 30);
        noAccount.setBackground(Color.WHITE);
        add(noAccount);
        
        ButtonGroup AccountGroup=new ButtonGroup();
        AccountGroup.add(yesAccount);
        AccountGroup.add(noAccount);
        
        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(600, 640, 80, 30);
        next.addActionListener(this);
        add(next);
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setVisible(true);
        setLocation(350,10);

   }
   public void actionPerformed(ActionEvent ae){
        String pan=panTextField.getText();
        String aadhar=aadharTextField.getText();
        String existAccount=null;
        if(yesAccount.isSelected()){
            existAccount="Yes";
        }
        else if(noAccount.isSelected()){
            existAccount="No";
        }
        String seniorCitizen=null;
        if(yesSeniorCitizen.isSelected()){
            seniorCitizen="Yes";
        }
        else if(NoSeniorCitizen.isSelected()){
            seniorCitizen="No";
        }
        String sreligion=(String)religion.getSelectedItem();
        String scategory=(String)category.getSelectedItem();
        String sincome=(String)income.getSelectedItem();
        String seducation=(String)education.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();
        
        try{
            if(aadhar.equals("")){
                JOptionPane.showMessageDialog(null, "aadhar is Required");
            }
            else{
                Conn c=new Conn();
                String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+pan+"','"+aadhar+"','"+seniorCitizen+"','"+existAccount+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
   }
    
    public static void main(String args[]) {
         new SignupTwo("");
    }
}
