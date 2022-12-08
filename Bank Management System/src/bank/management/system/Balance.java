package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Balance extends JFrame implements ActionListener {
	String accountNumber;
	JButton back;
	
	Balance(String accountNumber) {
		this.accountNumber=accountNumber;
		
		setLayout(null);
		
		JLabel text=new JLabel("Your current balance is");
		text.setFont(new Font("Raleway",Font.BOLD,20));
		text.setBounds(70,30,400,30);
		add(text);
		
		int balanceAmount=0;
		Dbcon c=new Dbcon();
		try {
			String query="select * from transactions where Account_Number='"+accountNumber+"'";
			ResultSet rs=c.s.executeQuery(query);
			while(rs.next()) {
				if(rs.getString("Type").equals("deposit")) {
					balanceAmount+=Integer.parseInt(rs.getString("Amount"));
				}
				else if(rs.getString("Type").equals("withdraw")) {
					balanceAmount-=Integer.parseInt(rs.getString("Amount"));
				}
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		JLabel balance =new JLabel(Integer.toString(balanceAmount));
		balance.setFont(new Font("Raleway",Font.BOLD,20));
		balance.setBounds(150,80,200,30);
		add(balance);
		
		back=new JButton("Back");
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.setBounds(250,150,100,40);
		back.addActionListener(this);
		add(back);
		
		
		setSize(400,300);
		setLocation(400,100);
		getContentPane().setBackground(Color.white);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Transactions(accountNumber);
		
	}

	public static void main(String[] args) {
		new Balance("");

	}

}
