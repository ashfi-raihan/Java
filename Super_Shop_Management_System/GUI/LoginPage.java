package GUI;

import File.UserIO.*;
import GUI.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage implements ActionListener, KeyListener{
	
	JButton loginButton, signUpButton, submitButton,backbtn;
	JFrame frame = new JFrame();
	JPanel leftPanel, rightPanel;
	ImageIcon icon1, icon2;	
	JLabel label1, label2, label3, label4, label5, label6, label7, label8, userNameLabel, passwordLabel;
	Font font = new Font("Cambria", Font.BOLD , 20);
	JTextField userNameField;
	JPasswordField passwordField;
	Cursor c; 
	JCheckBox checkBox;
	
	Cursor cursor= new Cursor(Cursor.HAND_CURSOR);
	
	public LoginPage (){
		
		int vPos = 375;
		int gap = 60;
		
		c = new Cursor(Cursor.HAND_CURSOR);
				
		icon1 = new ImageIcon("./Resource/Supershop.gif");
		icon2 = new ImageIcon("./Resource/Follow.png");
						
		label1 = new JLabel();
		label1.setBounds(0, 0, 365, 330);
		label1.setIcon(icon1);	
		
		label2 = new JLabel();
		label2.setBounds(280, 537, 300, 100);
		label2.setIcon(icon2);
				
		label3 = new JLabel("Welcome to");
		label3.setBounds(10, 10, 400, 85);
		label3.setFont(new Font("Edwardian Script ITC", Font.BOLD, 80));
		
		label4 = new JLabel("Groceteria!");
		label4.setBounds(70, 50, 400, 100);
		label4.setForeground(Color.magenta);
		label4.setFont(new Font("Cooper Black", Font.BOLD, 50));
		
		label5 = new JLabel("Please Login.");
		label5.setBounds(100, 160, 400, 50);
		label5.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		label6 = new JLabel("New Here !!");
		label6.setBounds(100, vPos, 350, 35);
		label6.setForeground(Color.magenta);
		label6.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		vPos += gap;
		label7 = new JLabel("Sign-Up to join our family");
		label7.setBounds(45, vPos, 350, 35);
		label7.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		
		userNameLabel = new JLabel("User Name:");
		userNameLabel.setBounds(20, 230, 400, 25);
		userNameLabel.setFont(font);
		
		userNameField = new JTextField();
		userNameField.setBounds(135, 225, 250, 35);
		userNameField.setBackground(Color.lightGray);
		userNameField.setFont(new Font("Amasis MT Pro", Font.PLAIN, 28));
		userNameField.setForeground(Color.black);
		userNameField.setCursor(c);
		userNameField.addKeyListener(this);
		
		passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(28, 300, 400, 28);
		passwordLabel.setFont(font);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(135, 295, 250, 35);
		passwordField.setFont(new Font("Arial Black", Font.BOLD, 60));
		passwordField.setBackground(Color.lightGray);
		passwordField.setForeground(Color.black);
		//passwordField.setEchoChar('$');
		passwordField.setCursor(c);
		
		checkBox = new JCheckBox();
		checkBox.setBounds(140, 350, 120, 35);
		checkBox.setText("I'm not a Robot!");
		checkBox.setFocusable(false);		
		checkBox.setBackground(new Color (0xB3ABCF));
		checkBox.setCursor(c);
		checkBox.setEnabled(true);
		
		submitButton = new JButton("Submit");
		submitButton.setBounds(280, 350, 100, 35);
		submitButton.setBackground(Color.green);
		submitButton.setForeground(Color.white);
		submitButton.setFocusable(false);
		submitButton.setFont(font);		
		submitButton.setCursor(c);
		submitButton.setEnabled(true);
		submitButton.addActionListener(this);
		
		loginButton = new JButton("Log in");
		loginButton.setBounds(160, 405, 200, 35);
		loginButton.setBackground(Color.darkGray);
		loginButton.setForeground(Color.white);
		loginButton.setFocusable(false);
		loginButton.setFont(font);
		loginButton.setEnabled(false);
		loginButton.addActionListener(this);
		
		vPos += gap;
		signUpButton = new JButton("Sign Up");
		signUpButton.setBounds(105, vPos, 150, 30);
		signUpButton.setBackground(Color.orange);
		signUpButton.setForeground(Color.white);
		signUpButton.setFocusable(false);
		signUpButton.setFont(font);
		signUpButton.addActionListener(this);
		
		//---------------------Back Botton-------------------------
		backbtn = new JButton("Back");
		backbtn.setBounds(320,530,80,50);
		backbtn.setBackground(Color.white);
		//backbtn.setContentAreaFilled(false);
		//backbtn.setFocusPainted(false);
		backbtn.setCursor(cursor);
		backbtn.addActionListener(this);
		
		
		leftPanel = new JPanel();
		leftPanel.setSize(365, 750);
		leftPanel.setLayout(null);
		leftPanel.setBackground(new Color(0x37FFA2));
		leftPanel.add(label6);
		leftPanel.add(label7);
		leftPanel.add(signUpButton);
		leftPanel.add(label1);		
				
		rightPanel = new JPanel();
		rightPanel.setLayout(null);
		rightPanel.setBounds(364, 0, 435, 750);
		rightPanel.setBackground(new Color(0xFFE1DF));
		rightPanel.add(label3);
		rightPanel.add(label4);
		rightPanel.add(label5);		
		rightPanel.add(userNameLabel);
		rightPanel.add(userNameField);
		rightPanel.add(passwordLabel);
		rightPanel.add(passwordField);
		rightPanel.add(checkBox);
		rightPanel.add(loginButton);
		rightPanel.add(submitButton);
		rightPanel.add(backbtn);
				
		frame.setTitle("Login page");
		frame.setSize(800, 650);
		//frame.setLocation(400, 100);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(label2);
		frame.add(rightPanel);	
		frame.add(leftPanel);			
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);				
	}
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == submitButton){
			String uname = userNameLabel.getText();
            String upass = String.valueOf(passwordField.getPassword());
			if(uname.isEmpty() || upass.isEmpty() || !checkBox.isSelected()){
				JOptionPane.showMessageDialog(frame, "Put Username and Password also verify you are not a robot","Warning", JOptionPane.WARNING_MESSAGE);
			}
			else{		
				loginButton.setBackground(Color.green);
				loginButton.setEnabled(true);
				submitButton.setEnabled(false);
				submitButton.setBackground(new Color (0xB3ABCF));
				checkBox.setEnabled(false);				
			}
			
		}	
				
		if(e.getSource() == loginButton){
			
			String name = userNameField.getText();
			String pass = String.valueOf(passwordField.getPassword());
			
			if (UserFileIO.checkUser(name,pass)) {
				
				JOptionPane.showMessageDialog(frame, "Login Successfull");				
				userNameField.setText("");
				passwordField.setText("");
				HomePage home = new HomePage();
				frame.dispose();
			}			
			else {
				int option = JOptionPane.showConfirmDialog(frame,"Invalid User Name or Password. Try again!");
				if(option == JOptionPane.YES_OPTION){
					frame.dispose();
					LoginPage login = new LoginPage();
				}				
			}
		}
		
		if (e.getSource() == signUpButton){
			SignUpPage sp = new SignUpPage();
			frame.dispose();
		}
		else if (e.getSource() == backbtn){
			frame.dispose();
			new Welcome();
		}		
		
	}
		public void keyReleased(KeyEvent key){
		
		}
		public void  keyPressed(KeyEvent key){
		
		}
		public void  keyTyped(KeyEvent key){
					
			if(!userNameField.getText().isEmpty()){
				userNameField.setBackground(Color.GREEN);
			}
			else{
				userNameField.setBackground(Color.lightGray);
			}
		}
}