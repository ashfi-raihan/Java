package GUI.Product;

import GUI.*;
import GUI.Product.*;
import Entity.Product;
import EntityList.ProductList;
import File.ProductIO.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ProductPage implements ActionListener {
	
	JFrame frame;
	JTextArea textArea;
	JPanel topPanel, leftPanel, rightPanel, bottomPanel;
	JLabel label, label2, label3, label4, label5, label6, label7, label8, label9;
	JButton backButton, homeButton, deleteButton, searchButton, clearButton, addButton, updateButton;
	JTextField tf3, tf4, tf5, tf7, tf8;
	JComboBox  cb1, cb2;
	String type[] = {" ", "Food", "Beverages", "Furniture", "Electronics", "Home Appliances",
			"Clothing", "Personal Care", "Sports", "Fitness", "Health", "Medicine",
			"Beauty Product", "Other"};
	String country[] = {" ", "Australia", "Bangladesh", "Brazil", "Canada", "China", 
			"France", "Germany", "India", "Indonesia", "Italy", "Japan", "Pakistan",
			"Russia", "Saudi Arabia", "South Korea", "Switzerland", "Taiwan", "Turkey",
			"United Kingdom", "United States", "Vietnam"};
	
	Font f30 = new Font("Segoe UI", Font.PLAIN, 30); 
	Font f20 = new Font("Segoe UI", Font.PLAIN, 20);
	Font f20b = new Font("Segoe UI", Font.BOLD, 20);
		
	public ProductPage(){
		
		this.products = products;
			
		int tf = 60; //text field vertical positioning start
		int tfS = 230; //text field start
		int tfL = 300; //text field length
		int txtS = 15; //text start
		int gap = 55;
		
		label = new JLabel("Welcome to Product Management Page");
		label.setForeground(Color.magenta);
		label.setBounds(150,30,700,40);
		label.setFont(new Font("Algerian", Font.ITALIC, 33));
		
		label2 = new JLabel("Put all the details of a product.");
		label2.setForeground(Color.white);
		label2.setBounds(20, 10, 700, 40);
		label2.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		
		label3 = new JLabel("Product Name: ");
		label3.setForeground(Color.black);
		label3.setBounds(txtS, tf, 300, 35);
		label3.setFont(f30);
		
		tf3 = new JTextField();
		tf3.setBounds(tfS, tf, tfL, 35);
		tf3.setBackground(Color.lightGray);
		tf3.setFont(f30);
		tf3.setForeground(Color.black);
		
		tf += gap;
		label4 = new JLabel("Product ID: ");
		label4.setForeground(Color.black);
		label4.setBounds(txtS, tf, tfL, 35);
		label4.setFont(f30);
		
		tf4 = new JTextField();
		tf4.setBounds(tfS, tf, tfL, 35);
		tf4.setBackground(Color.lightGray);
		tf4.setFont(f30);
		tf4.setForeground(Color.black);
		
		tf += gap;
		label5 = new JLabel("Product Price: ");
		label5.setForeground(Color.black);
		label5.setBounds(txtS, tf, tfL, 35);
		label5.setFont(f30);
		
		tf5 = new JTextField();
		tf5.setBounds(tfS, tf, tfL, 35);
		tf5.setBackground(Color.lightGray);
		tf5.setFont(f30);
		tf5.setForeground(Color.black);
		
		tf += gap;
		label6 = new JLabel("Product Type: ");
		label6.setForeground(Color.black);
		label6.setBounds(txtS, tf, tfL, 35);
		label6.setFont(f30);
		
		cb1 = new JComboBox(type);
		cb1.setBounds(tfS, tf, tfL - 20, 35);
		cb1.setBackground(Color.lightGray);
		cb1.setFont(f30);
		cb1.setForeground(Color.black);
		
		tf += gap;
		label7 = new JLabel("M. Company:");
		label7.setForeground(Color.black);
		label7.setBounds(txtS, tf, tfL, 35);
		label7.setFont(f30);
		
		tf7 = new JTextField();
		tf7.setBounds(tfS, tf, tfL, 35);
		tf7.setBackground(Color.lightGray);
		tf7.setFont(f30);
		tf7.setForeground(Color.black);
		
		tf += gap;
		label8 = new JLabel("M. Date: ");
		label8.setForeground(Color.black);
		label8.setBounds(txtS, tf, tfL, 35);
		label8.setFont(f30);
		
		tf8 = new JTextField();
		tf8.setBounds(tfS, tf, tfL, 35);
		tf8.setBackground(Color.lightGray);
		tf8.setFont(f30);
		tf8.setForeground(Color.black);
		
		tf += gap;
		label9 = new JLabel("Product origin: ");
		label9.setForeground(Color.black);
		label9.setBounds(txtS, tf, tfL, 35);
		label9.setFont(f30);
		
		cb2 = new JComboBox(country);
		cb2.setBounds(tfS, tf, tfL - 20, 35);
		cb2.setBackground(Color.lightGray);
		cb2.setFont(f30);
		cb2.setForeground(Color.black);
		
		//Text Area for data Display
		textArea = new JTextArea();
		textArea.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		textArea.setBackground(Color.black);
		textArea.setForeground(Color.white);
		textArea.setEditable(false);
		
		JScrollPane jsp = new JScrollPane(textArea);
		jsp.setBounds(10, 20, 360, 550);
				
		ProductFileIO.loadAllProduct(products);
		updateTextArea();
				
			//clear Button
		tf += gap;	
		clearButton = new JButton("Clear");
      	clearButton.setBounds(tfS + 205, tf, tfL - 180, 35);
      	clearButton.setBackground(Color.green);
      	clearButton.setForeground(Color.white);
      	clearButton.setFont(f20);
      	clearButton.setFocusable(false); 
      	clearButton.addActionListener(this);
		
				//add Button
		tf += gap;
		addButton = new JButton("Add Product");
      	addButton.setBounds(tfS - 20, tf, tfL - 130, 35);
      	addButton.setBackground(new Color(0x50AB60));
      	addButton.setForeground(Color.white);
      	addButton.setFont(f20b);
      	addButton.setFocusable(false); 
      	addButton.addActionListener(this);
		
		
			//Delete Button
		deleteButton = new JButton("Delete Product");
      	deleteButton.setBounds(tfS + 170, tf, tfL - 130, 35);
      	deleteButton.setBackground(Color.red);
      	deleteButton.setForeground(Color.white);
      	deleteButton.setFont(f20);
      	deleteButton.setFocusable(false); 
      	deleteButton.addActionListener(this);
		
		
			//search Button
		tf += gap;	
		searchButton = new JButton("Search Product");
      	searchButton.setBounds(tfS - 20, tf, tfL - 130, 35);
      	searchButton.setBackground(Color.magenta);
      	searchButton.setForeground(Color.white);
      	searchButton.setFont(f20);
      	searchButton.setFocusable(false); 
      	searchButton.addActionListener(this);
		
		
			// updateButton
		updateButton = new JButton("Update");
      	updateButton.setBounds(tfS + 170, tf, tfL - 130, 35);
      	updateButton.setBackground(Color.orange);
      	updateButton.setForeground(Color.white);
      	updateButton.setFont(f20b);
      	updateButton.setFocusable(false); 
      	updateButton.addActionListener(this);
					
				//Back button
      	backButton = new JButton("<Back");
      	backButton.setBounds(850, 3, 100, 30);
      	backButton.setBackground(new Color(0x50AB60));
      	backButton.setForeground(Color.white);
      	backButton.setFocusable(false);
      	backButton.setFont(f20);
      	backButton.addActionListener(this);
      	
      	 		//Home Button
      	homeButton = new JButton("Home");
      	homeButton.setBounds(50, 3, 100, 30);
      	homeButton.setBackground(new Color(0x50AB60));
      	homeButton.setForeground(Color.white);
      	homeButton.setFocusable(false);
      	homeButton.setFont(f20);
      	homeButton.addActionListener(this);
      	      	
      	topPanel = new JPanel();
		topPanel.setLayout(null);
		topPanel.setBounds(0, 0, 1000, 80);
		topPanel.add(label);
		topPanel.setBackground(Color.cyan);
		
		leftPanel = new JPanel();
		leftPanel.setBounds(0, 80, 600, 595);
		leftPanel.setLayout(null);
		leftPanel.setBackground(new Color(153,153,255));
		leftPanel.add(label2);
		leftPanel.add(label3);
		leftPanel.add(tf3);
		leftPanel.add(label4);
		leftPanel.add(tf4);
		leftPanel.add(label5);
		leftPanel.add(tf5);
		leftPanel.add(label6);
		leftPanel.add(cb1);
		leftPanel.add(label7);
		leftPanel.add(tf7);
		leftPanel.add(label8);
		leftPanel.add(tf8);
		leftPanel.add(label9);
		leftPanel.add(cb2);
		leftPanel.add(addButton);
		leftPanel.add(deleteButton);
		leftPanel.add(clearButton);
		leftPanel.add(updateButton);
		leftPanel.add(searchButton);
		
		rightPanel = new JPanel();
		rightPanel.setBounds(600, 80, 400, 595);
		rightPanel.setLayout(null);
		rightPanel.setBackground(new Color(102,178,255));			
		rightPanel.add(jsp);
										
		bottomPanel = new JPanel();
		bottomPanel.setLayout(null);
		bottomPanel.setBounds(0, 675, 1000, 75);
		bottomPanel.setBackground(Color.cyan);
		bottomPanel.add(backButton);
		bottomPanel.add(homeButton);
				
		frame = new JFrame("Insert product");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 750);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.add(topPanel);
		frame.add(leftPanel);
		frame.add(rightPanel);
		frame.add(bottomPanel);
		frame.setResizable(false);
		frame.setVisible(true);
		
	}
	ProductList products = new ProductList();
	
	@Override
    public void actionPerformed(ActionEvent e){
		
		if (e.getSource() == backButton){
			new HomePage();
			frame.dispose();
		}
		if (e.getSource() == homeButton) {
  			new HomePage();
  			frame.dispose();
  		}
		if(e.getSource() == addButton){
			if(!tf3.getText().isEmpty() && !tf4.getText().isEmpty() && !tf5.getText().isEmpty()) {
				Product p = new Product(tf3.getText(), tf4.getText(), Double.parseDouble(tf5.getText()), cb1.getSelectedItem(), tf7.getText(), tf8.getText(), cb2.getSelectedItem());
				products.insertProduct(p);
				ProductFileIO.addProduct(p);
				JOptionPane.showMessageDialog(frame, "New Product Added Successful...",
						"Information", JOptionPane.INFORMATION_MESSAGE);
				updateTextArea();
			}
		else {					
			JOptionPane.showMessageDialog(frame, "Please input product's Name, ID and price",
					"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource() == deleteButton){
			Product p = products.getByProductId(tf4.getText());
			if(p!=null){
				products.removeProduct(tf4.getText());
				ProductFileIO.updateAllPriducts(products);
				JOptionPane.showMessageDialog(frame,"Product Deleted");
				
			}
			else{
				JOptionPane.showMessageDialog(frame,"Product Not Found","Warning",JOptionPane.ERROR_MESSAGE);
			}
			updateTextArea();
		}
		if(e.getSource() == clearButton){
			
			tf3.setText("");
			tf4.setText("");
			tf5.setText("");
			cb1.setSelectedItem("");
			tf7.setText("");
			tf8.setText("");
			cb2.setSelectedItem("");
		}
		if(e.getSource() == searchButton){
			Product p = products.getByProductId(tf4.getText());
			if(p != null){
				JOptionPane.showMessageDialog(frame, p.getProductAsString());
			}
			else{
				JOptionPane.showMessageDialog(frame, "Product Not Found", "Warning",JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource() == updateButton){
			try{
				Product temP = new Product(tf3.getText(), tf4.getText(), Double.parseDouble(tf5.getText()), cb1.getSelectedItem(), tf7.getText(), tf8.getText(), cb2.getSelectedItem());
				Product p = products.getByProductId(tf4.getText());
				products.removeProduct(tf4.getText());
				if(p != null){
					p = temP;
					products.insertProduct(temP);
					ProductFileIO.updateAllPriducts(products);
					updateTextArea();
					JOptionPane.showMessageDialog(frame, "Information Updated");
				}
				else{
					JOptionPane.showMessageDialog(frame, "Product not Found", "Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			catch(NumberFormatException er){
				JOptionPane.showMessageDialog(frame, "Invalid input! Enter price in number format", "Error", JOptionPane.ERROR_MESSAGE);
			}
			catch(Exception er){
				JOptionPane.showMessageDialog(frame, "Invalid input!", "Error", JOptionPane.WARNING_MESSAGE);
			}
			
		}
	}
	public void updateTextArea(){		
			textArea.setText(products.getAllProductAsString());
		}

}
