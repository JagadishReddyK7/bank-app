package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
	
	JButton signin, clear, signup;
	JTextField AccountTextField;
	JPasswordField PasswordTextField;
	
	Login() {
		
		setTitle("INDIA BANK");
		
		setLayout(null);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel label=new JLabel(i3);
		label.setBounds(70, 10, 100,100);
		add(label);
		
		JLabel text=new JLabel("Welcome to India Bank");
		text.setFont(new Font("osward",Font.BOLD,38));
		text.setBounds(200,20,500,100);
		add(text);
		
		JLabel accountno=new JLabel("Account Number");
		accountno.setFont(new Font("Raleway",Font.BOLD,20));
		accountno.setBounds(120,150,200,40);
		add(accountno);
		
		AccountTextField=new JTextField();
		AccountTextField.setBounds(340,160,230,30);
		add(AccountTextField);
		
		JLabel password=new JLabel("Password");
		password.setFont(new Font("Raleway",Font.BOLD,20));
		password.setBounds(120,200,200,40);
		add(password);
		
		PasswordTextField=new JPasswordField();
		PasswordTextField.setBounds(340,210,230,30);
		add(PasswordTextField);
		
		signin=new JButton("SIGN IN");
		signin.setBounds(340,270,100,30);
		signin.setBackground(Color.BLACK);
		signin.setForeground(Color.WHITE);
		signin.addActionListener(this);
		add(signin);
		
		clear=new JButton("CLEAR");
		clear.setBounds(470,270,100,30);
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		add(clear);
		
		signup=new JButton("SIGN UP");
		signup.setBounds(340,320,230,30);
		signup.setBackground(Color.BLACK);
		signup.setForeground(Color.WHITE);
		signup.addActionListener(this);
		add(signup);
		
		getContentPane().setBackground(Color.white);
		
		setSize(800,480);
		setVisible(true);
		setLocation(350,200);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if (ae.getSource()== signin) {
			
			String accountNumber=AccountTextField.getText();
			String password=PasswordTextField.getText();
			try {
				Dbcon c=new Dbcon();
				String query="select * from login where Account_Number= '"+accountNumber+"' and Password = '"+password+"'";
				ResultSet credentials=c.s.executeQuery(query);
				if(credentials.next()) {
					setVisible(false);
					new Transactions(accountNumber);
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid Credentials");
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		else if (ae.getSource()==clear) {
			
			AccountTextField.setText("");
			PasswordTextField.setText("");
		}
		else if (ae.getSource()== signup) {
			
			setVisible(false);
			new SignupOne();
		}
	}

	public static void main(String[] args) {
		new Login();

	}

}
