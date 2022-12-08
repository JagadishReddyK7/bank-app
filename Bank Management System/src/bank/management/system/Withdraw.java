package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {
	
	JTextField amountTextField;
	JButton next, back;
	String accountNumber;
	
	Withdraw(String accountNumber) {
		
		this.accountNumber=accountNumber;
		
		setLayout(null);
		setSize(600,500);
		setLocation(400,150);
		getContentPane().setBackground(Color.white);
		setTitle("ONLINE BANKING - INDIA BANK");
		setVisible(true);
		
		JLabel withdraw=new JLabel("ENTER THE AMOUNT TO BE DEPOSITED");
		withdraw.setBounds(100,100,400,30);
		withdraw.setFont(new Font("Raleway",Font.BOLD,20));
		add(withdraw);
		
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
			if(amount.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter the amount");
			}
			else {
				if(balanceAmount<Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
				}
				else {
					try {
						String query1="insert into transactions values('"+accountNumber+"','"+date+"','withdraw','"+amount+"')";
						c.s.executeUpdate(query1);
						JOptionPane.showMessageDialog(null, "Withdraw successful");
						setVisible(false);
						new Transactions(accountNumber);
					}
					catch(Exception e) {
						System.out.println(e);
					}
				}
			}
		}
		
	}

	public static void main(String[] args) {
		new Withdraw("");

	}

}
