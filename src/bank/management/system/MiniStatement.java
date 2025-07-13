package bank.management.system;

import java.awt.Color;
import javax.swing.*;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MiniStatement extends JFrame implements ActionListener {
    String pinnumber;
    JButton back;

    MiniStatement(String pinnumber) {
        this.pinnumber = pinnumber;
        setTitle("Mini Statement");
        setLayout(null);

        // Label for Bank Name
        JLabel bank = new JLabel("Indial Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);

        // Label for Card Number
        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        // Scrollable Mini Statement
        JLabel mini = new JLabel();
        mini.setVerticalAlignment(JLabel.TOP); // Align text to top

        JScrollPane scrollPane = new JScrollPane(mini);
        scrollPane.setBounds(20, 140, 340, 250); // Set size and position
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane);

        // Balance Label
        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);

        // Back Button
        back = new JButton("BACK");
        back.setBounds(100, 500, 150, 30);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin='" + pinnumber + "'");
            while (rs.next()) {
                card.setText("Card Number: " + rs.getString("cardnumber").substring(0, 4) + "-XXXXXXXX-" + rs.getString("cardnumber").substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Conn conn = new Conn();
            int bal = 0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
            StringBuilder statementText = new StringBuilder("<html>");
            while (rs.next()) {
                statementText.append(rs.getString("date"))
                        .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(rs.getString("type"))
                        .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(rs.getString("amount"))
                        .append("<br><br>");

                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            statementText.append("</html>");
            mini.setText(statementText.toString());
            balance.setText("Your current account balance: " + bal);
        } catch (Exception e) {
            System.out.println(e);
        }

        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }

    public static void main(String args[]) {
        new MiniStatement("");
    }
}
