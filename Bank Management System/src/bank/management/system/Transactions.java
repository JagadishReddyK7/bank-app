package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {
	
	JButton deposit, withdraw, balance, statement, changePassword, logout;
	String accountNumber;
	
	
	Transactions(String accountNumber) {
		
		this.accountNumber=accountNumber;
		
		setLayout(null);
		setSize(500,500);
		setLocation(400,150);
		getContentPane().setBackground(Color.white);
		setTitle("ONLINE BANKING - INDIA BANK");
		setVisible(true);
		
		JLabel services=new JLabel("Choose your Service ");
		services.setFont(new Font("Raleway",Font.BOLD,28));
		services.setBounds(110,20,400,50);
		add(services);
		
		deposit=new JButton("Cash Deposit");
		deposit.setFont(new Font("Raleway",Font.BOLD,16));
		deposit.setBounds(150,100,200,30);
		deposit.addActionListener(this);
		add(deposit);
		
		withdraw=new JButton("Money Withdrawl");
		withdraw.setFont(new Font("Raleway",Font.BOLD,16));
		withdraw.setBounds(150,150,200,30);
		withdraw.addActionListener(this);
		add(withdraw);
		
		balance=new JButton("Balance Enquiry");
		balance.setFont(new Font("Raleway",Font.BOLD,16));
		balance.setBounds(150,200,200,30);
		balance.addActionListener(this);
		add(balance);
		
		statement=new JButton("E-Statement");
		statement.setFont(new Font("Raleway",Font.BOLD,16));
		statement.setBounds(150,250,200,30);
		statement.addActionListener(this);
		add(statement);
		
		changePassword=new JButton("Password Change");
		changePassword.setFont(new Font("Raleway",Font.BOLD,16));
		changePassword.setBounds(150,300,200,30);
		changePassword.addActionListener(this);
		add(changePassword);
		
		logout=new JButton("Logout");
		logout.setFont(new Font("Raleway",Font.BOLD,16));
		logout.setBounds(150,350,200,30);
		logout.addActionListener(this);
		add(logout);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==deposit) {
			setVisible(false);
			new Deposit(accountNumber);
			
		}
		else if(ae.getSource()==withdraw) {
			setVisible(false);
			new Withdraw(accountNumber);
		}
		else if(ae.getSource()==balance) {
			setVisible(false);
			new Balance(accountNumber);
		}
		else if(ae.getSource()==statement) {
			setVisible(false);
			new Estatement(accountNumber);
		}
		else if(ae.getSource()==changePassword) {
			setVisible(false);
			new PasswordChange(accountNumber);
		}
		else if(ae.getSource()==logout) {
			setVisible(false);
			new Login();
		}
		
	}

	public static void main(String[] args) {
		new Transactions("");

	}

}
