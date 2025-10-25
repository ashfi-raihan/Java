package GUI.Customer;

import Entity.*;
import EntityList.*;
import File.CustomerIO.*;
import GUI.*;
import GUI.Customer.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class CustomerPage extends JFrame implements ActionListener{
	Font font30B = new Font("Segoe UI",Font.BOLD,30);
	Font font20 = new Font("Segoe UI",Font.PLAIN,20);
	Font font20B = new Font("Segoe UI",Font.BOLD,20);
	Font font15 = new Font("Segoe UI",Font.PLAIN,15);
	
	
	JTextField name,id,age,phoneNumber,address,gender;
	JTextArea textArea;
	JScrollPane jsp;
	JPanel topPanel,leftPanel,rightPanel,bottomPanel; 
	JButton deleteBtn,addBtn,backButton,homeButton,searchBtn,updateBtn,clear;
	
	Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
	
	JComboBox comboBox;
	
	CustomerList customers = new CustomerList();
	
	public CustomerPage(){
		super("Customer Page");
		this.setSize(1000,700);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.customers = customers;
		
		//=========================TOP PANEL===========================
		topPanel = new JPanel();
		topPanel.setBounds(0,0,1000,80); //x,y,w,h
		topPanel.setLayout(null);
		
		//------------------Welcome-------------------
		JLabel title = new JLabel("Welcome to Customer Management Page");
		title.setBounds(200,15,700,50); //x,y,w,h
		title.setFont(font30B);
		topPanel.add(title);
		
		this.add(topPanel);
		
		
		//=========================LEFT PANEL===========================
		leftPanel = new JPanel();
		leftPanel.setBounds(0,80,600,550);
		leftPanel.setLayout(null);
		leftPanel.setBackground(new Color(153,153,255));
		
		
		int vPos = 110;
		int gap=40;
		int lblsize=150;
		int txtfieldsize=300;
		//---------------------Name---------------------
		JLabel nameLabel = new JLabel("Full Name");
		nameLabel.setBounds(60,vPos,lblsize,30); //x,y,w,h
		nameLabel.setFont(font20);
		leftPanel.add(nameLabel);
		
		//Name TextField
		name = new JTextField();
		name.setBounds(200,vPos,txtfieldsize,30); //x,y,w,h
		name.setFont(font20);
		leftPanel.add(name);
		
		vPos+=gap;
		//--------------------ID------------------------
		JLabel idLabel = new JLabel("Employee ID");
		idLabel.setBounds(60,vPos,lblsize,30); //x,y,w,h
		idLabel.setFont(font20);
		leftPanel.add(idLabel);

		id = new JTextField();
		id.setBounds(200,vPos,txtfieldsize,30); //x,y,w,h
		id.setFont(font20);
		leftPanel.add(id);
		
		vPos+=gap;
		//-----------------------Age-------------------
		JLabel ageLabel = new JLabel("Age");
		ageLabel.setBounds(60,vPos,lblsize,30); //x,y,w,h
		ageLabel.setFont(font20);
		leftPanel.add(ageLabel);

		age = new JTextField();
		age.setBounds(200,vPos,txtfieldsize,30); //x,y,w,h
		age.setFont(font20);
		leftPanel.add(age);
		
		vPos+=gap;
		//-------------------Phone Number------------------
		JLabel phoneNumberLabel = new JLabel("Phone Number");
		phoneNumberLabel.setBounds(60,vPos,lblsize,30); //x,y,w,h
		phoneNumberLabel.setFont(font20);
		leftPanel.add(phoneNumberLabel);

		phoneNumber = new JTextField();
		phoneNumber.setBounds(200,vPos,txtfieldsize,30); //x,y,w,h
		phoneNumber.setFont(font20);
		leftPanel.add(phoneNumber);
		
		vPos+=gap;
		//-------------------Address--------------------
		JLabel branchLabel = new JLabel("Address");
		branchLabel.setBounds(60,vPos,lblsize,30); //x,y,w,h
		branchLabel.setFont(font20);
		leftPanel.add(branchLabel);

		address = new JTextField();
		address.setBounds(200,vPos,txtfieldsize,30); //x,y,w,h
		address.setFont(font20);
		leftPanel.add(address);
		
		vPos+=gap;
		//------------------Gender------------------------------
		JLabel gender = new JLabel("Gender");
		gender.setBounds(60,vPos,lblsize,30); //x,y,w,h
		gender.setFont(font20);
		leftPanel.add(gender);
		
		comboBox = new JComboBox(new String[]{" ","Male","Female"});
		comboBox.setBounds(200,vPos,150,30); //x,y,w,h
		comboBox.setFont(font20);
		comboBox.setEditable(false);
		comboBox.addActionListener(this);
		leftPanel.add(comboBox);
		
		//------------------ Buttons ------------------------
		int btnhpos =20;
		int btnhgap =130;
		int btnvpos =440;
		
		//Add Button
		addBtn = new JButton("Add");
		addBtn.setBounds(btnhpos,btnvpos,100,30); //x,y,w,h
		addBtn.setFont(font20);
		addBtn.setBackground(new Color(87,70,229));
		addBtn.setForeground(Color.WHITE);
		addBtn.setCursor(cursor);
		addBtn.addActionListener(this);
		leftPanel.add(addBtn);
		
		btnhpos += btnhgap;
		
		//Delete Button
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(btnhpos,btnvpos,120,30); //x,y,w,h
		deleteBtn.setFont(font20);
		deleteBtn.setBackground(Color.RED);
		deleteBtn.setForeground(Color.WHITE);
		deleteBtn.setCursor(cursor);
		deleteBtn.addActionListener(this);
		leftPanel.add(deleteBtn);
		
		btnhpos += btnhgap;
		
		//Update Button
		updateBtn = new JButton("Update");
		updateBtn.setBounds(btnhpos+10,btnvpos,100,30); //x,y,w,h
		updateBtn.setFont(font20);
		updateBtn.setBackground(new Color(87,70,229));
		updateBtn.setForeground(Color.WHITE);
		updateBtn.setCursor(cursor);
		updateBtn.addActionListener(this);
		leftPanel.add(updateBtn);
		
		btnhpos += btnhgap;
		
		//Search Button
		searchBtn = new JButton("Search");
		searchBtn.setBounds(btnhpos,btnvpos,120,30); //x,y,w,h
		searchBtn.setFont(font20);
		searchBtn.setBackground(Color.RED);
		searchBtn.setForeground(Color.WHITE);
		searchBtn.setCursor(cursor);
		searchBtn.addActionListener(this);
		leftPanel.add(searchBtn);
		
		
		//Clear Button
		clear = new JButton("Clear");
		clear.setBounds(370,370,90,30); //x,y,w,h
		clear.setFont(font20);
		clear.setBackground(Color.RED);
		clear.setForeground(Color.WHITE);
		clear.setCursor(cursor);
		clear.addActionListener(this);
		leftPanel.add(clear);
		
		btnhpos += btnhgap;
		
		this.add(leftPanel);
		//=========================RIGHT PANEL===========================
		rightPanel = new JPanel();
		rightPanel.setBounds(600,80,400,550);
		rightPanel.setLayout(null);
		rightPanel.setBackground(new Color(102,178,255));
		
		//------------------Text Area -------------------

		textArea = new JTextArea();
		textArea.setFont(font15);
		textArea.setEditable(false);
		
		JScrollPane jsp = new JScrollPane(textArea);
		jsp.setBounds(13, 13, 360, 525);
		rightPanel.add(jsp);
		CustomerFileIO.loadAllCustomer(customers);
		updateTextArea();
		this.add(rightPanel);
		
		//=========================BOTTOM PANEL===========================
		bottomPanel = new JPanel();
		bottomPanel.setBounds(0,620,1000,80);
		bottomPanel.setLayout(null);
		//bottomPanel.setBackground(Color.cyan);
		
		backButton = new JButton("<Back");
      	backButton.setBounds(0,10,100, 30);
      	backButton.setBackground(new Color(0x50AB60));
      	backButton.setForeground(Color.black);
      	backButton.setFocusable(false);
		backButton.setCursor(cursor);
      	backButton.setFont(font15);
      	backButton.addActionListener(this);
      	bottomPanel.add(backButton);
		
      	 		//Home Button
      	homeButton = new JButton("<Home");
      	homeButton.setBounds(900,10,100, 30);
      	homeButton.setBackground(new Color(0x50AB60));
      	homeButton.setForeground(Color.black);
      	homeButton.setFocusable(false);
      	homeButton.setFont(font15);
		homeButton.setCursor(cursor);
      	homeButton.addActionListener(this);
		bottomPanel.add(homeButton);
		
		this.add(bottomPanel);
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == addBtn){
			try{
				Customer c = new Customer(name.getText(),id.getText(),
								Integer.parseInt(age.getText()),
								comboBox.getSelectedItem(), phoneNumber.getText(),
								address.getText());
								
				CustomerFileIO.addCustomer(c);
				customers.insert(c);
				updateTextArea();
			}
			catch(NumberFormatException er){
				JOptionPane.showMessageDialog(this, "Invalid input! Enter Age in number format", "Error", JOptionPane.ERROR_MESSAGE);
			}
			catch(Exception er){
				JOptionPane.showMessageDialog(this, "Invalid input! Enter ID in number format", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(e.getSource() == deleteBtn){
			Customer c = customers.getById(id.getText());
			if(c != null){
				//CustomerFileIO.removeCustomer(id.getText(),customers);
				customers.removeById(id.getText());
				CustomerFileIO.updateAllCustomer(customers);
				updateTextArea();
				JOptionPane.showMessageDialog(this,"Customer Deleted");
			}
			else{
				JOptionPane.showMessageDialog(this,"Customer Not Found", "Warning",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(e.getSource() == updateBtn){
			try{
				Customer tempC = new Customer(name.getText(),id.getText(),
								Integer.parseInt(age.getText()),
								"MALE", phoneNumber.getText(),
								address.getText());
				Customer c = customers.getById(id.getText());
			
				customers.removeById(id.getText());
				if(c != null){
					c = tempC;
					customers.insert(tempC);
					CustomerFileIO.updateAllCustomer(customers);
					updateTextArea();
					JOptionPane.showMessageDialog(this,"Information Updated");
				}
				else{
					JOptionPane.showMessageDialog(this,"Customer Not Found", "Warning",JOptionPane.ERROR_MESSAGE);
				}
			}
			catch(NumberFormatException er){
				JOptionPane.showMessageDialog(this, "Invalid input! Enter Age in number format", "Error", JOptionPane.ERROR_MESSAGE);
			}
			catch(Exception er){
				JOptionPane.showMessageDialog(this, "Invalid input! Enter ID in number format", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if(e.getSource() == searchBtn){
			Customer c = customers.getById(id.getText());
			if(c != null){
				JOptionPane.showMessageDialog(this,c.getCustomerAsString());
			}
			else{
				JOptionPane.showMessageDialog(this,"Customer Not Found", "Warning",JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource() == clear){
			
			name.setText("");
			id.setText("");
			age.setText("");
			phoneNumber.setText("");
			address.setText("");
		}
		if(e.getSource() == backButton){
			new HomePage();
			this.dispose();	
		}
		if(e.getSource() == homeButton){
			new HomePage();
			this.dispose();	
		}
	}

	public void updateTextArea(){
		textArea.setText(customers.getAllCustomerAsString());
	}	

}





