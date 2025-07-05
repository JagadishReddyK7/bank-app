package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Estatement extends JFrame implements ActionListener {
	
	String accountNumber;
	JButton back;
	
	Estatement(String accountNumber) {
		this.accountNumber=accountNumber;
		
		JLabel statement=new JLabel("E-Statement");
		statement.setFont(new Font("Raleway",Font.BOLD,28));
		statement.setBounds(200,20,400,30);
		add(statement);
		
		JLabel accountNo=new JLabel("Account Number: XXXXXXX"+accountNumber.substring(6));
		accountNo.setFont(new Font("Raleway",Font.BOLD,16));
		accountNo.setBounds(50,80,400,20);
		add(accountNo);
		
		JLabel history=new JLabel();
		history.setBounds(50,120,400,650);
		add(history);
		
		back=new JButton("Back");
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.setBounds(400,600,100,40);
		back.addActionListener(this);
		add(back);
		
		try {
			Dbcon c=new Dbcon();
			String query1="select * from transactions where Account_Number='"+accountNumber+"'";
			ResultSet rs=c.s.executeQuery(query1);
			while(rs.next() ) {
				history.setText(history.getText()+"<html>"+rs.getString("Date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("Type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("Amount")+"<br><br><html>");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		setLayout(null);
		setSize(600,700);
		setLocation(400,20);
		getContentPane().setBackground(Color.white);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Transactions(accountNumber);
	}

	public static void main(String[] args) {
		new Estatement("12345678965");

	}

}
