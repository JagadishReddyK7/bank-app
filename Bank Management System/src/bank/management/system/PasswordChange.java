package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PasswordChange extends JFrame implements ActionListener {
	
	String accountNumber;
	JButton confirm, cancel;
	JPasswordField passwordTextField, rePasswordTextField;
	
	PasswordChange(String accountNumber) {
		this.accountNumber=accountNumber;
		
		JLabel password=new JLabel("Enter PIN");
		password.setFont(new Font("Raleway",Font.BOLD,20));
		password.setBounds(50,100,150,30);
		add(password);
		
		passwordTextField=new JPasswordField();
		passwordTextField.setFont(new Font("Raleway",Font.BOLD,14));
		passwordTextField.setBounds(200,100,200,30);
		add(passwordTextField);
		
		JLabel repassword=new JLabel("Re-Enter PIN");
		repassword.setFont(new Font("Raleway",Font.BOLD,20));
		repassword.setBounds(50,150,150,30);
		add(repassword);
		
		rePasswordTextField=new JPasswordField();
		rePasswordTextField.setFont(new Font("Raleway",Font.BOLD,14));
		rePasswordTextField.setBounds(200,150,200,30);
		add(rePasswordTextField);
		
		confirm=new JButton("Confirm");
		confirm.setBackground(Color.black);
		confirm.setForeground(Color.white);
		confirm.setBounds(250,230,100,40);
		confirm.addActionListener(this);
		add(confirm);
		
		cancel=new JButton("Cancel");
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.setBounds(120,230,100,40);
		cancel.addActionListener(this);
		add(cancel);
		
		setLayout(null);
		setSize(500,400);
		setLocation(400,150);
		getContentPane().setBackground(Color.white);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==cancel) {
			new Transactions(accountNumber);
		}
		else if(ae.getSource()==confirm) {
			String password=passwordTextField.getText();
			String rePassword=rePasswordTextField.getText();
			if(password.equals(rePassword)) {
				try {
					Dbcon c=new Dbcon();
					String query1="update login set Password='"+password+"'where Account_Number='"+accountNumber+"'";
					String query2="update signupthree set Password='"+password+"'where Account_Number='"+accountNumber+"'";
					c.s.executeUpdate(query1);
					c.s.executeUpdate(query2);
					JOptionPane.showMessageDialog(null, "Password changed successfully");
				}
				catch(Exception e) {
					System.out.println(e);
				}
				setVisible(false);
				new Transactions(accountNumber);
			}
			else {
				passwordTextField.setText("");
				rePasswordTextField.setText("");
				JOptionPane.showMessageDialog(null, "Passwords do not match");
			}
		}
	}

	public static void main(String[] args) {
		new PasswordChange("");

	}

}
