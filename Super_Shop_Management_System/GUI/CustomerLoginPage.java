package GUI;

import GUI.*;
import File.UserIO.*;
import GUI.Sell.*;

import java.util.Random;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CustomerLoginPage extends JFrame implements ActionListener{
	
	
	//------------ Random Number for Captcha---------------
	Random random = new Random();
	
	int a = random.nextInt(8)+1;
	int b = random.nextInt(8)+1;
	int result = a+b;
	
	
	JFrame frame = new JFrame();
	JPanel leftPanel, rightPanel;
	//ImageIcon icon, icon2;
	JLabel label1, label2, label3, label4, label5,userNameLable,userPassLabel,captchaLebel;
	JButton btnLogin,btnReg,backbtn;
	JCheckBox checkbox;
	JTextField userName,captcha;
	JPasswordField password;
	
	Cursor cursor;
	
	Font font = new Font("Segoe UI", Font.PLAIN, 20);
	
	public CustomerLoginPage(){
		
		frame.setTitle("Login page");
		frame.setSize(750,600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setResizable(false);
		
		cursor= new Cursor(Cursor.HAND_CURSOR);
		
		//-----------------------------LEFT Panel--------------------------------
		
		leftPanel = new JPanel();
		leftPanel.setLayout(null);
		leftPanel.setBounds(0, 0, 300, 750);
		//leftPanel.setBackground(Color.cyan);
		leftPanel.setBackground(new Color(102,178,255));
		
		label1 = new JLabel("New Here");
		label1.setBounds(90, 0+260, 150, 80);
		label1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		leftPanel.add(label1);
								
		label2 = new JLabel("Sign-Up to join our family");
		label2.setBounds(20, 0+80, 350, 500);
		label2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		leftPanel.add(label2);
		
		
		//---------------------Reg Botton-------------------------
		btnReg = new JButton("Sign Up");
        btnReg.setBounds(70, 350, 110, 35);
        btnReg.setFont(font);
		btnReg.setFocusable(false);
		btnReg.setCursor(cursor);
        btnReg.addActionListener(this);
        leftPanel.add(btnReg);
		
		
		//-----------------------------RIGHT Panel--------------------------------
		
		rightPanel = new JPanel();
		rightPanel.setLayout(null);
		rightPanel.setBounds(300, 0, 500, 750);
		rightPanel.setBackground(Color.lightGray);
		
		label3 = new JLabel("Welcome to");
		label3.setBounds(70, 20, 400, 85);
		label3.setFont(new Font("Edwardian Script ITC", Font.BOLD, 80));
		rightPanel.add(label3);
		
		label4 = new JLabel("Groceteria!");
		label4.setBounds(70, 60, 400, 100);
		label4.setFont(new Font("Cooper Black", Font.BOLD, 50));
		rightPanel.add(label4);
		
		
		label5 = new JLabel("Please log in to your account");
		label5.setBounds(60,180, 400, 100);
		label5.setFont(new Font("Segoe UI", Font.BOLD, 20));
		rightPanel.add(label5);
		
		
		int hposlbl=60, hpostxt=hposlbl+120;
		int vpos=260, vgap=30;
		
		//USER NAME Lable
        userNameLable = new JLabel("User Name");
        userNameLable.setBounds(hposlbl, vpos, 100, 25);
        userNameLable.setFont(font);
        rightPanel.add(userNameLable);
		//USER NAME TextField
        userName = new JTextField();
        userName.setBounds(hpostxt, vpos, 210, 25);
        userName.setFont(font);
        rightPanel.add(userName);
		
		vpos+=vgap;
		
		//User Password Label 
        userPassLabel = new JLabel("Password");
        userPassLabel.setBounds(hposlbl, vpos, 100, 25);
        userPassLabel.setFont(font);
        rightPanel.add(userPassLabel);
		//Password TextField
         password = new JPasswordField();
        password.setBounds(hpostxt, vpos, 210, 25);
		password.setEchoChar('$');
        password.setFont(font);
        rightPanel.add(password);

		vpos+=vgap;
		
		//CheckBox 
		checkbox = new JCheckBox();
		checkbox.setBounds(hposlbl, vpos, 150, 25);
		checkbox.setText("I am not a Robot!!");
		checkbox.setFocusable(false);
		checkbox.setBackground(Color.lightGray);
		rightPanel.add(checkbox);
		
		vpos+=vgap;
		
		//Captcha Label 
        captchaLebel = new JLabel(a+" + "+b);
        captchaLebel.setBounds(hposlbl, vpos, 100, 25);
        captchaLebel.setFont(font);
        rightPanel.add(captchaLebel);
		//Captcha Field
        captcha = new JTextField();
        captcha.setBounds(hpostxt, vpos, 210, 25);
        captcha.setFont(font);
        rightPanel.add(captcha);

		vpos+=vgap;
		
		
		//---------------------Login Botton-------------------------
        btnLogin = new JButton("Login");
        btnLogin.setBounds(hpostxt, vpos, 100, 35);//x,y,w,h
        btnLogin.setFont(font);
		btnLogin.setFocusable(false);
		btnLogin.setCursor(cursor);
        btnLogin.addActionListener(this);
        rightPanel.add(btnLogin);
		
		
		//---------------------Back Botton-------------------------
		backbtn = new JButton("Back");
		backbtn.setBounds(350,500,80,50);
		backbtn.setBackground(Color.white);
		//backbtn.setContentAreaFilled(false);
		//backbtn.setFocusPainted(false);
		backbtn.setCursor(cursor);
		backbtn.addActionListener(this);
		rightPanel.add(backbtn);
		
		frame.add(leftPanel);
		frame.add(rightPanel);
		frame.setVisible(true);
				
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		
		if (e.getSource() == btnLogin){
			String name = userName.getText();
            String pass = String.valueOf(password.getPassword());
			boolean flag= (Integer.parseInt(captcha.getText())== result);
			
            if (CustomerUserFileIO.checkUser(name,pass) && checkbox.isSelected() && flag ){
				
				new SellPage();
				frame.dispose();
				
				userName.setText("");
                password.setText("");
			}			
			else{
                JOptionPane.showMessageDialog(this, "Invalid User Name or Password", 
											  "Error",JOptionPane.ERROR_MESSAGE);
								
				frame.dispose();
				new CustomerLoginPage();
				
			}	
		}
		else if (e.getSource() == btnReg){
				frame.dispose();
				new CustomerSignUpPage();
		}
		else if (e.getSource() == backbtn){
				frame.dispose();
				new Welcome();
		}
		
	}
	
}




