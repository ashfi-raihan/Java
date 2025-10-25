package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import GUI.*;
import GUI.Product.*;
import GUI.Branch.*;
import GUI.Employee.*;
import GUI.Customer.*;
import GUI.Records.*;

public class HomePage extends JFrame implements ActionListener{
	
		
	JFrame frame = new JFrame();
	JLabel label;
	JPanel topPanel, middlePanel, bottomPanel;
	
	JButton employeeButton, customerButton, productButton, branchButton, logoutButton, orderRecordsButton,PaymentRecordsButton, contributorButton;
	
	Font font1 = new Font("Times New Roman", Font.ITALIC, 35);
	Font font2 = new Font("MV Boli", Font.BOLD, 35);
	
	public HomePage(){
	
		label = new JLabel("Welcome to SuperShop Management");
		label.setForeground(Color.magenta);
		label.setBounds(35,30,700,40);
		label.setFont(new Font("Algerian", Font.PLAIN, 36));
		
		//Logout button
		logoutButton = new JButton("Log out");
		logoutButton.setBounds(630, 3, 100, 30);
		logoutButton.setBackground(Color.red);
		logoutButton.setForeground(Color.white);
		logoutButton.setFocusable(false);
		logoutButton.addActionListener(this);
		
		//employeeButton
		employeeButton = new JButton("Employee Management");
		employeeButton.setBounds(150, 130, 450, 50);
		employeeButton.setBackground(Color.blue);
		employeeButton.setForeground(Color.white);
		employeeButton.setFont(font2);
		employeeButton.addActionListener(this);
		employeeButton.setFocusable(false);
		
		//customerButton
		customerButton = new JButton("Customer Management");
		customerButton.setBounds(150, 190, 450, 50);
		customerButton.setBackground(Color.blue);
		customerButton.setForeground(Color.white);
		customerButton.setFont(font2);
		customerButton.addActionListener(this);
		customerButton.setFocusable(false);	
		
		//productButton
		productButton = new JButton("Product Management");
		productButton.setBounds(150, 250, 450, 50);
		productButton.setBackground(Color.blue);
		productButton.setForeground(Color.white);
		productButton.setFont(font2);
		productButton.setFocusable(false);
		productButton.addActionListener(this);
		
		//branchButton
		branchButton = new JButton("Branch Management");
		branchButton.setBounds(150, 310, 450, 50);
		branchButton.setBackground(Color.blue);
		branchButton.setForeground(Color.white);
		branchButton.setFont(font2);
		branchButton.addActionListener(this);
		branchButton.setFocusable(false);
		
		//orderRecordsButton
		orderRecordsButton = new JButton("Order Records");
		orderRecordsButton.setBounds(180, 370, 400, 50);
		orderRecordsButton.setBackground(Color.black);
		orderRecordsButton.setForeground(Color.white);
		orderRecordsButton.setFont(font1);
		orderRecordsButton.setFocusable(false);
		orderRecordsButton.addActionListener(this);
		
		//PaymentRecordsButton
		PaymentRecordsButton = new JButton("Payment Records");
		PaymentRecordsButton.setBounds(180, 430, 400, 50);
		PaymentRecordsButton.setBackground(Color.black);
		PaymentRecordsButton.setForeground(Color.white);
		PaymentRecordsButton.setFont(font1);
		PaymentRecordsButton.setFocusable(false);
		PaymentRecordsButton.addActionListener(this);
		
		topPanel = new JPanel();
		topPanel.setLayout(null);
		topPanel.setBounds(0, 0, 750, 100);
		topPanel.setBackground(Color.cyan);
		topPanel.add(label);
		
		middlePanel = new JPanel();
		middlePanel.setBounds(0, 100, 750, 575);
		middlePanel.setLayout(null);
		middlePanel.setBackground(Color.gray);
		middlePanel.add(employeeButton);
		middlePanel.add(customerButton);
		middlePanel.add(productButton);
		middlePanel.add(branchButton);
		middlePanel.add(orderRecordsButton);
		middlePanel.add(PaymentRecordsButton);
		
		bottomPanel = new JPanel();
		bottomPanel.setLayout(null);
		bottomPanel.setBounds(0, 675, 750, 75);
		bottomPanel.setBackground(Color.cyan);
		bottomPanel.add(logoutButton);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(750, 750);
		frame.setTitle("Home Page");
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.add(topPanel);
		frame.add(middlePanel);
		frame.add(bottomPanel);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		
		if (e.getSource() == logoutButton){
			int option = JOptionPane.showConfirmDialog(this,"Do you want to logout?");
			if(option == JOptionPane.YES_OPTION){
				LoginPage lp = new LoginPage();
				frame.dispose();
			}
		}
		if ( e.getSource() == PaymentRecordsButton){
			new PaymentRecords();
			frame.dispose();
		}
		if ( e.getSource() == orderRecordsButton){
			OrderRecords or = new OrderRecords();
			frame.dispose();
		}
		if ( e.getSource() == productButton){
			ProductPage pp = new ProductPage();
			frame.dispose();
		}
		if ( e.getSource() == branchButton){
			BranchPage bp = new BranchPage();
			frame.dispose();
		}
		if( e.getSource() == employeeButton){
			EmployeePage ep = new EmployeePage();
			frame.dispose();
		}
		if ( e.getSource() == customerButton){
			CustomerPage cp = new CustomerPage();
			frame.dispose();
		}
		
	}
}
