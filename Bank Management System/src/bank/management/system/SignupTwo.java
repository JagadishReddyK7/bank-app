package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {
	JButton next;
	JComboBox religionBox, categoryBox;
	JTextField incomeTextField, educationTextField, occupationTextField, panTextField, aadharTextField;
	JRadioButton citizenYes, citizenNo, existingYes, existingNo;
	String formno;
	
	SignupTwo(String formno) {
		this.formno=formno;
		
		setLayout(null);
		
		setTitle("Application Form");
		setSize(850,700);
		setLocation(350,10);
		setVisible(true);
		
		getContentPane().setBackground(Color.white);
		
		JLabel additionalDetails=new JLabel("Page 2: Additional Details");
		additionalDetails.setFont(new Font("Raleway",Font.BOLD,28));
		additionalDetails.setBounds(250,20,400,50);
		add(additionalDetails);
		
		JLabel religion=new JLabel("Religion ");
		religion.setFont(new Font("Raleway",Font.BOLD,20));
		religion.setBounds(100,90,200,30);
		add(religion);
		
		String [] religionArray= {"Hindu","Muslim","Christian","Sikh","Other"};
		religionBox=new JComboBox(religionArray);
		religionBox.setBounds(350,90,400,30);
		add(religionBox);
		
		JLabel category=new JLabel("Category");
		category.setFont(new Font("Raleway",Font.BOLD,20));
		category.setBounds(100,140,200,30);
		add(category);
		
		String [] categoryArray= {"General","OBC","SC","ST","Other"};
		categoryBox=new JComboBox(categoryArray);
		categoryBox.setBounds(350,140,400,30);
		add(categoryBox);
		
		JLabel income=new JLabel("Income");
		income.setFont(new Font("Raleway",Font.BOLD,20));
		income.setBounds(100,190,200,30);
		add(income);
		
		incomeTextField=new JTextField();
		incomeTextField.setFont(new Font("Raleway",Font.BOLD,14));
		incomeTextField.setBounds(350,190,400,30);
		add(incomeTextField);
		
		JLabel education=new JLabel("Education ");
		education.setFont(new Font("Raleway",Font.BOLD,20));
		education.setBounds(100,240,200,30);
		add(education);
		
		educationTextField=new JTextField();
		educationTextField.setFont(new Font("Raleway",Font.BOLD,14));
		educationTextField.setBounds(350,240,400,30);
		add(educationTextField);
		
		JLabel occupation=new JLabel("Occupation ");
		occupation.setFont(new Font("Raleway",Font.BOLD,20));
		occupation.setBounds(100,290,200,30);
		add(occupation);
		
		occupationTextField=new JTextField();
		occupationTextField.setFont(new Font("Raleway",Font.BOLD,14));
		occupationTextField.setBounds(350,290,400,30);
		add(occupationTextField);
		
		JLabel pan=new JLabel("PAN Number");
		pan.setFont(new Font("Raleway",Font.BOLD,20));
		pan.setBounds(100,340,200,30);
		add(pan);
		
		panTextField=new JTextField();
		panTextField.setFont(new Font("Raleway",Font.BOLD,14));
		panTextField.setBounds(350,340,400,30);
		add(panTextField);
		
		JLabel aadhar=new JLabel("Aadhar Number");
		aadhar.setFont(new Font("Raleway",Font.BOLD,20));
		aadhar.setBounds(100,390,200,30);
		add(aadhar);
		
		aadharTextField=new JTextField();
		aadharTextField.setFont(new Font("Raleway",Font.BOLD,14));
		aadharTextField.setBounds(350,390,400,30);
		add(aadharTextField);
		
		JLabel seniorcitizen=new JLabel("Senior Citizen");
		seniorcitizen.setFont(new Font("Raleway",Font.BOLD,20));
		seniorcitizen.setBounds(100,440,200,30);
		add(seniorcitizen);
		
		citizenYes=new JRadioButton("Yes");
		citizenYes.setBackground(Color.white);
		citizenYes.setBounds(350,440,150,30);
		add(citizenYes);
		
		citizenNo=new JRadioButton("No");
		citizenNo.setBackground(Color.white);
		citizenNo.setBounds(550,440,150,30);
		add(citizenNo);
		
		ButtonGroup citizengroup=new ButtonGroup();
		citizengroup.add(citizenYes);
		citizengroup.add(citizenNo);
		
		JLabel existinguser=new JLabel("Existing User");
		existinguser.setFont(new Font("Raleway",Font.BOLD,20));
		existinguser.setBounds(100,490,200,30);
		add(existinguser);
		
		existingYes=new JRadioButton("Yes");
		existingYes.setBackground(Color.white);
		existingYes.setBounds(350,490,150,30);
		add(existingYes);
		
		existingNo=new JRadioButton("No");
		existingNo.setBackground(Color.white);
		existingNo.setBounds(550,490,150,30);
		add(existingNo);
		
		ButtonGroup existinggroup=new ButtonGroup();
		existinggroup.add(existingYes);
		existinggroup.add(existingNo);
		
		next=new JButton("Next");
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setBounds(650,540,100,40);
		next.addActionListener(this);
		add(next);
		
	}
	 public void actionPerformed(ActionEvent ae) {
		 String religion=(String) religionBox.getSelectedItem();
		 String category=(String) categoryBox.getSelectedItem();
		 String income=incomeTextField.getText();
		 String education=educationTextField.getText();
		 String occupation=occupationTextField.getText();
		 String pan=panTextField.getText();
		 String aadhar=aadharTextField.getText();
		 String seniorCitizen=null;
		 if(citizenYes.isSelected()) {
			 seniorCitizen="Yes";
		 }
		 else if (citizenNo.isSelected()) {
			 seniorCitizen="No";
		 }
		 String existingUser=null;
		 if(existingYes.isSelected()) {
			 existingUser="Yes";
		 }
		 else if(existingNo.isSelected()) {
			 existingUser="No";
		 }
		 
		 try {
			 
			 Dbcon c=new Dbcon();
			 String query="insert into signuptwo values('"+formno+"', '"+religion+"', '"+category+"', '"+income+"', '"+education+"', '"+occupation+"', '"+pan+"', '"+aadhar+"', '"+seniorCitizen+"', '"+existingUser+"')";
			 c.s.executeUpdate(query);
			 setVisible(false);
			 new SignupThree(formno);
		 }
		 catch (Exception e) {
			 System.out.println(e);
		 }
	 }

	public static void main(String[] args) {
		new SignupTwo("");

	}

}
