package GUI;

import GUI.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import File.UserIO.*;

public class CustomerSignUpPage implements ActionListener{ 
	
	JFrame frame = new JFrame();
	JPanel leftPanel, rightPanel;
	//ImageIcon icon, icon2;
	JLabel label1, label2, label3, label4, label5,userNameLable,userPassLabel,captchaLebel;
	JTextField name,id,email;
	JPasswordField password,repassword;
	JButton deleteBtn,addBtn,backBtn;
	Cursor cursor;
	
	
	
	//Font font = new Font("Segoe UI", Font.PLAIN, 20);
	Font font25 = new Font("Segoe UI",Font.PLAIN,25);
	Font font20 = new Font("Segoe UI",Font.PLAIN,20);
	Font font15 = new Font("Segoe UI",Font.PLAIN,15);
	
	public CustomerSignUpPage(){
		
		frame.setTitle("Registration page");
		frame.setSize(750,500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setResizable(false);
		
		cursor= new Cursor(Cursor.HAND_CURSOR);
		
		//-------------------- Left Panel--------------------------
		
		leftPanel = new JPanel();
		leftPanel.setLayout(null);
		leftPanel.setBounds(0, 0, 300, 750);
		//leftPanel.setBackground(Color.cyan);
		leftPanel.setBackground(new Color(102,178,255));
		
		
		
		//-------------------- Right Panel--------------------------
		
		rightPanel = new JPanel();
		rightPanel.setLayout(null);
		rightPanel.setBounds(300, 0, 500, 750);
		rightPanel.setBackground(Color.lightGray);
		
		
		
		//Welcome Title
		JLabel title = new JLabel("Welcome to Registration Page");
		title.setBounds(60,10,500,40); //x,y,w,h
		title.setFont(font25);
		rightPanel.add(title);
		
		int vPos = 90;
		int gap=40;
		int hlblpos = 40;
		int htxtpos = 180;
		//----------------Name----------
		JLabel nameLabel = new JLabel("Full Name");
		nameLabel.setBounds(hlblpos,vPos,150,30); //x,y,w,h
		nameLabel.setFont(font20);
		rightPanel.add(nameLabel);
		
		//Name TextField
		name = new JTextField();
		name.setBounds(htxtpos,vPos,150,30); //x,y,w,h
		name.setFont(font20);
		rightPanel.add(name);
		
		vPos+=gap;
		//---------------ID-------------
		JLabel idLabel1 = new JLabel("Enter Last 4 digits of your");
		idLabel1.setBounds(hlblpos,vPos,300,30); //x,y,w,h
		idLabel1.setFont(font20);
		rightPanel.add(idLabel1);
		vPos+=gap;
		
		id = new JTextField();
		id.setBounds(htxtpos,vPos,150,30); //x,y,w,h
		id.setFont(font20);
		rightPanel.add(id);
		
		JLabel idLabel2 = new JLabel("Phone Number:");
		idLabel2.setBounds(hlblpos,vPos,200,30); //x,y,w,h
		idLabel2.setFont(font20);
		rightPanel.add(idLabel2);

		vPos+=gap;
		//---------------Email-------------
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setBounds(hlblpos,vPos,150,30); //x,y,w,h
		emailLabel.setFont(font20);
		rightPanel.add(emailLabel);

		email = new JTextField();
		email.setBounds(htxtpos,vPos,150,30); //x,y,w,h
		email.setFont(font20);
		rightPanel.add(email);
		
		vPos+=gap;
		//---------------Password-------------
		JLabel passwordLabel = new JLabel("Enter Password:");
		passwordLabel.setBounds(hlblpos,vPos,150,30); //x,y,w,h
		passwordLabel.setFont(font20);
		rightPanel.add(passwordLabel);
		
        password = new JPasswordField();
        password.setBounds(htxtpos,vPos,150,30);
		password.setEchoChar('$');
        password.setFont(font20);
        rightPanel.add(password);
		
		vPos+=gap;
		
		JLabel repasswordLabel = new JLabel("Reenter Password:");
		repasswordLabel.setBounds(hlblpos,vPos,200,30); //x,y,w,h
		repasswordLabel.setFont(font20);
		rightPanel.add(repasswordLabel);
		vPos+=gap;
		
        repassword = new JPasswordField();
        repassword.setBounds(htxtpos,vPos,150,30);
		repassword.setEchoChar('$');
        repassword.setFont(font15);
        rightPanel.add(repassword);
		
		vPos+=gap;
		//Button
		addBtn = new JButton("Add");
		addBtn.setBounds(hlblpos,400,100,30); //x,y,w,h
		addBtn.setFont(font20);
		addBtn.setBackground(new Color(87,70,229));
		addBtn.setForeground(Color.WHITE);
		addBtn.setCursor(cursor);
		addBtn.addActionListener(this);
		rightPanel.add(addBtn);
		
		
		//Button
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(hlblpos+110,400,100,30); //x,y,w,h
		deleteBtn.setFont(font20);
		deleteBtn.setBackground(Color.RED);
		deleteBtn.setForeground(Color.WHITE);
		deleteBtn.setCursor(cursor);
		deleteBtn.addActionListener(this);
		rightPanel.add(deleteBtn);
		
		//Button
		backBtn = new JButton("<=Back");
		backBtn.setBounds(hlblpos+220,400,120,30); //x,y,w,h
		backBtn.setFont(font20);
		backBtn.setBackground(Color.RED);
		backBtn.setForeground(Color.WHITE);
		backBtn.setCursor(cursor);
		backBtn.addActionListener(this);
		rightPanel.add(backBtn);
		
		
		
		frame.add(leftPanel);
		frame.add(rightPanel);
		frame.setVisible(true);
		
	}
	
	
	public void actionPerformed(ActionEvent e){
		/*
		if(e.getSource() == deleteBtn){
			
            String uname = name.getText();
            String upass = String.valueOf(password.getPassword());
			if(!upass.isEmpty()){
			FileIO.removeUser(uname,upass);
			JOptionPane.showMessageDialog(frame, "User Removed from the house","Information", JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				JOptionPane.showMessageDialog(frame, "Put a valid Password to removed user","ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		*/
		if(e.getSource() == addBtn){
			
            String uname = name.getText();
            String upass = String.valueOf(password.getPassword());
		
			if (!uname.isEmpty() && !upass.isEmpty() ){
				CustomerUserFileIO.addUser(uname,upass,email.getText(),id.getText());
				JOptionPane.showMessageDialog(frame, "User Added in the house","Information", JOptionPane.INFORMATION_MESSAGE);
				new CustomerLoginPage();
				frame.dispose();
			}
			else{
				JOptionPane.showMessageDialog(frame, "Please fill up all the information","ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(e.getSource() == backBtn){
			new CustomerLoginPage();
			frame.dispose();
		}
		
	}
}