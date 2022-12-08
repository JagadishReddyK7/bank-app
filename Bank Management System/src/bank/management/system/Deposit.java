package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
	
	JTextField amountTextField;
	JButton next, back;
	String accountNumber;
	
	Deposit(String accountNumber) {
		
		this.accountNumber=accountNumber;
		
		setLayout(null);
		setSize(600,500);
		setLocation(400,150);
		getContentPane().setBackground(Color.white);
		setTitle("ONLINE BANKING - INDIA BANK");
		setVisible(true);
		
		JLabel deposit=new JLabel("ENTER THE AMOUNT TO BE DEPOSITED");
		deposit.setBounds(100,100,400,30);
		deposit.setFont(new Font("Raleway",Font.BOLD,20));
		add(deposit);
		
		amountTextField=new JTextField();
		amountTextField.setFont(new Font("Raleway",Font.BOLD,14));
		amountTextField.setBounds(200,200,200,30);
		add(amountTextField);
		
		next=new JButton("Next");
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setBounds(400,300,100,40);
		next.addActionListener(this);
		add(next);
		
		back=new JButton("Back");
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.setBounds(270,300,100,40);
		back.addActionListener(this);
		add(back);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==back) {
			setVisible(false);
			new Transactions(accountNumber);
		}
		else if(ae.getSource()==next) {
			String amount=amountTextField.getText();
			Date date=new Date();
			if(amount.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter the amount");
			}
			else {
				try {
					Dbcon c=new Dbcon();
					String query="insert into transactions values('"+accountNumber+"','"+date+"','deposit','"+amount+"')";
					c.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Deposited successfully");
					setVisible(false);
					new Transactions(accountNumber);
				}
				catch(Exception e) {
					System.out.println(e);
				}
			}
		}
		
	}

	public static void main(String[] args) {
		new Deposit("");

	}

}
