package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {
	
	long random1, random2;
	JButton submit, cancel;
	JRadioButton r1,r2,r3,r4;
	JCheckBox c1,c2,c3,c4,c5,c6;
	String formno;
	
	SignupThree(String formno) {
		this.formno=formno;
		
		setLayout(null);
		
		setTitle("Bank Application Form");
		setSize(850,550);
		setLocation(350,10);
		setVisible(true);
		
		getContentPane().setBackground(Color.white);
		
		Random r=new Random();
		random1=Math.abs((r.nextLong()%90000000000L)+10000000000L);
		random2=Math.abs((r.nextLong()%9000L)+1000L);
		
		
		JLabel accountDetails=new JLabel("Page 3: Account Details");
		accountDetails.setFont(new Font("Raleway",Font.BOLD,28));
		accountDetails.setBounds(250,20,400,50);
		add(accountDetails);
		
		JLabel accountType=new JLabel("Account Type");
		accountType.setFont(new Font("Raleway",Font.BOLD,20));
		accountType.setBounds(100,90,200,30);
		add(accountType);
		
		r1=new JRadioButton("Savings Account");
		r1.setBackground(Color.white);
		r1.setFont(new Font("Raleway",Font.BOLD,16));
		r1.setBounds(300,100,200,30);
		add(r1);
		
		r2=new JRadioButton("Current Account");
		r2.setBackground(Color.white);
		r2.setFont(new Font("Raleway",Font.BOLD,16));
		r2.setBounds(520,100,200,30);
		add(r2);
		
		r3=new JRadioButton("FD Account");
		r3.setBackground(Color.white);
		r3.setFont(new Font("Raleway",Font.BOLD,16));
		r3.setBounds(300,150,200,30);
		add(r3);
		
		r4=new JRadioButton("RD Account");
		r4.setBackground(Color.white);
		r4.setFont(new Font("Raleway",Font.BOLD,16));
		r4.setBounds(520,150,200,30);
		add(r4);
		
		ButtonGroup accountGroup=new ButtonGroup();
		accountGroup.add(r1);
		accountGroup.add(r2);
		accountGroup.add(r3);
		accountGroup.add(r4);
		
		JLabel services=new JLabel("Services");
		services.setFont(new Font("Raleway",Font.BOLD,20));
		services.setBounds(100,240,200,30);
		add(services);
		
		c1=new JCheckBox("ATM Card");
		c1.setBackground(Color.white);
		c1.setFont(new Font("Raleway",Font.BOLD,16));
		c1.setBounds(300,250,200,30);
		add(c1);
		
		c2=new JCheckBox("Internet Banking");
		c2.setBackground(Color.white);
		c2.setFont(new Font("Raleway",Font.BOLD,16));
		c2.setBounds(520,250,200,30);
		add(c2);
		
		c3=new JCheckBox("Mobile Banking");
		c3.setBackground(Color.white);
		c3.setFont(new Font("Raleway",Font.BOLD,16));
		c3.setBounds(300,300,200,30);
		add(c3);
		
		c4=new JCheckBox("Email & SMS alerts");
		c4.setBackground(Color.white);
		c4.setFont(new Font("Raleway",Font.BOLD,16));
		c4.setBounds(520,300,200,30);
		add(c4);
		
		c5=new JCheckBox("E-Statement");
		c5.setBackground(Color.white);
		c5.setFont(new Font("Raleway",Font.BOLD,16));
		c5.setBounds(300,350,200,30);
		add(c5);
		
		c6=new JCheckBox("Cheque Book");
		c6.setBackground(Color.white);
		c6.setFont(new Font("Raleway",Font.BOLD,16));
		c6.setBounds(520,350,200,30);
		add(c6);
		
		submit=new JButton("Submit");
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.setBounds(350,420,100,40);
		submit.addActionListener(this);
		add(submit);
		
		cancel=new JButton("Cancel");
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.setBounds(470,420,100,40);
		cancel.addActionListener(this);
		add(cancel);
		
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==cancel) {
			setVisible(false);
			
		}
		else if(ae.getSource()==submit) {
			String accountNumber=""+random1;
			String password=""+random2;
			String accountType=null;
			if(r1.isSelected()) {
				accountType="Savings Account";
			}
			else if(r2.isSelected()) {
				accountType="Current Account";
			}
			else if(r3.isSelected()) {
				accountType="FD Account";
			}
			else if(r4.isSelected()) {
				accountType="RD Account";
			}
			String services="";
			if(c1.isSelected()) {
				services=services+"ATM Card ";
			}
			if(c2.isSelected()) {
				services=services+"Internet Banking ";
			}
			if(c3.isSelected()) {
				services=services+"Mobile Banking ";
			}
			if(c4.isSelected()) {
				services=services+"SMS & Email Alerts ";
			}
			if(c5.isSelected()) {
				services=services+"E_Statement ";
			}
			if(c6.isSelected()) {
				services=services+"Cheque Book ";
			}
			
			try {
				if(accountType==null) {
					JOptionPane.showMessageDialog(null,"AccountType required");
				}
				else {
					Dbcon c=new Dbcon();
					String query1="insert into signupthree values('"+formno+"','"+accountType+"','"+services+"','"+accountNumber+"','"+password+"')";
					String query2="insert into login values('"+formno+"','"+accountNumber+"','"+password+"')";
					c.s.executeUpdate(query1);
					c.s.executeUpdate(query2);
					JOptionPane.showMessageDialog(null,"Account Number: "+random1+"\nPin: "+random2);
					
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}
			setVisible(false);
			new Deposit(accountNumber);
			
		}
	}

	public static void main(String[] args) {
		new SignupThree("");

	}

}
