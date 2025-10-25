package GUI.Sell;

import Entity.*;
import EntityList.*;
import File.ProductIO.*;
import File.SellIO.*;
import GUI.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.util.*;


public class SellPage extends JFrame implements ActionListener {
    Font font30B = new Font("Segoe UI",Font.BOLD,30);
	Font font20 = new Font("Segoe UI",Font.PLAIN,20);
	Font font15 = new Font("Segoe UI",Font.PLAIN,15);
	
	Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
	
	JPanel topPanel,leftPanel,rightPanel,bottomPanel;
	JButton backButton,proccedButton,buyBtn,selectBtn;
	JTextArea itemsTextArea, soldTextArea;
	JScrollPane itemsJsp,soldJsp;
	JTable table;
	DefaultTableModel model;
	
    JTextField productId,employeeName,customerName,productQuantity;
	
	SellList products = new SellList();
	//ProductList productList = new ProductList();
   

    public SellPage() {
        super("Sell Page");
		this.setSize(1000,700);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.products=products;
		
		//=========================TOP PANEL===========================
		topPanel = new JPanel();
		topPanel.setBounds(0,0,1000,80); //x,y,w,h
		topPanel.setLayout(null);
		//topPanel.setBackground(Color.cyan);
		
		//------------------Welcome-------------------
		JLabel title = new JLabel("Welcome to Groceteria");
		title.setBounds(350,15,700,50); //x,y,w,h
		title.setFont(font30B);
		topPanel.add(title);
		
		this.add(topPanel);
		
		//=========================LEFT PANEL===========================
		leftPanel = new JPanel();
		leftPanel.setBounds(0,80,500,550);
		leftPanel.setLayout(null);
		leftPanel.setBackground(new Color(102,178,255));
		
		/*
		itemsTextArea = new JTextArea();
		itemsTextArea.setFont(font20);
		itemsTextArea.setEditable(false);
		
		itemsJsp = new JScrollPane(itemsTextArea);
		itemsJsp.setBounds(25,50,450,470);
		leftPanel.add(itemsJsp);
		ProductFileIO.loadProductForSell(products);
		itemsTextArea.setText(products.getAllSellProductAsString());
		*/
		
		//-------------------- Table ---------------------
		// Creating Model
		model = new DefaultTableModel();
		model.addColumn("Name");
		model.addColumn("ID");
		model.addColumn("Price");
		model.addColumn("M. Date");
		
		// Creating Table
		table = new JTable(model);
		table.setBounds(13,13,500,550);
		table.setFont(font15);
		//table.setBackground(COLOR.WHITE);
		table.setRowHeight(20);
		table.setSelectionBackground(new Color(247, 146, 146));
		table.getTableHeader().setFont(font20);
		//table.setEnabled(false);
		
		itemsJsp = new JScrollPane(table);
		itemsJsp.setBounds(13,13,500,550);
		
		//Copy data in the model 
		Product productsArray [];
		ProductFileIO.loadProductForSell(products);
		productsArray = products.getAllProductsArray();
		
		for(int i=0; i<productsArray.length; i++){
			
			if(productsArray[i] != null){
				model.addRow(new Object[]{
					productsArray[i].getProductName(),
					productsArray[i].getProductId(),
					productsArray[i].getProductPrice(),
					productsArray[i].getManufacturedDate()
					
				});
			}
			
		}
		leftPanel.add(itemsJsp);
		
		this.add(leftPanel);
		//=========================RIGHT PANEL===========================
		rightPanel = new JPanel();
		rightPanel.setBounds(500,80,500,550);
		rightPanel.setLayout(null);
		rightPanel.setBackground(new Color(153,153,255));
		
		
		
		int vpose = 30;
		int hpos = 20;
		int gap = 30;

		// Employee Name Label
        JLabel employeeNameLabel = new JLabel("Employee Name");
        employeeNameLabel.setBounds(vpose, hpos, 150, 30); // x,y,w,h
        employeeNameLabel.setFont(font20);
        rightPanel.add(employeeNameLabel);

        // Employee Name TextField
        employeeName = new JTextField();
        employeeName.setBounds(vpose+160, hpos, 200, 20); // x,y,w,h
        employeeName.setFont(font15);
        rightPanel.add(employeeName);
		hpos+=gap;
		
		// Customer Name Label
        JLabel customerNameLabel = new JLabel("Customer Name");
        customerNameLabel.setBounds(vpose, hpos, 150, 20); // x,y,w,h
        customerNameLabel.setFont(font20);
        rightPanel.add(customerNameLabel);

        // Customer Name TextField
        customerName = new JTextField();
        customerName.setBounds(vpose+160, hpos, 200, 20); // x,y,w,h
        customerName.setFont(font15);
        rightPanel.add(customerName);
		hpos+=gap;
		hpos+=gap;
		
		// Branch ID Label
        JLabel productIdLabel = new JLabel("Enter Product ID");
        productIdLabel.setBounds(vpose, hpos, 150, 20); // x,y,w,h
        productIdLabel.setFont(font20);
        rightPanel.add(productIdLabel);

        // Branch ID TextField
        productId = new JTextField();
        productId.setBounds(vpose+160, hpos, 200, 20); // x,y,w,h
        productId.setFont(font15);
        rightPanel.add(productId);
		
		hpos+=gap;
		
		// Product Quantity Label
        JLabel productQuantityLabel = new JLabel("Enter Quantity");
        productQuantityLabel.setBounds(vpose, hpos, 150, 25); // x,y,w,h
        productQuantityLabel.setFont(font20);
        rightPanel.add(productQuantityLabel);

        // Product Quantity TextField
        productQuantity = new JTextField();
        productQuantity.setBounds(vpose+160, hpos, 200, 20); // x,y,w,h
        productQuantity.setFont(font15);
        rightPanel.add(productQuantity);
		
		
		// Buy Button
		buyBtn = new JButton("Buy");
		buyBtn.setBounds(vpose+370, hpos-20, 60, 30);
		buyBtn.setCursor(cursor);
		buyBtn.setBackground(Color.orange);
		buyBtn.setFocusable(false);
		buyBtn.addActionListener(this);
		rightPanel.add(buyBtn);
		
		// Select Button
		selectBtn = new JButton("Select");
		selectBtn.setBounds(vpose+370, hpos-110, 70, 30);
		selectBtn.setCursor(cursor);
		selectBtn.setBackground(Color.orange);
		selectBtn.setFocusable(false);
		selectBtn.addActionListener(this);
		rightPanel.add(selectBtn);
		
		
		soldTextArea = new JTextArea();
		soldTextArea.setFont(font15);
		soldTextArea.setEditable(false);
		
		
		
		soldJsp = new JScrollPane(soldTextArea);
		soldJsp.setBounds(60,180,360,350);
		rightPanel.add(soldJsp);
        
		
		this.add(rightPanel);
		//=========================BOTTOM PANEL===========================
		bottomPanel = new JPanel();
		bottomPanel.setBounds(0,620,1000,80);
		bottomPanel.setLayout(null);
		//bottomPanel.setBackground(Color.cyan);
		
		//Back Button
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
      	proccedButton = new JButton("Procced->");
      	proccedButton.setBounds(880,10,110, 30);
      	proccedButton.setBackground(new Color(0x50AB60));
      	proccedButton.setForeground(Color.black);
      	proccedButton.setFocusable(false);
      	proccedButton.setFont(font15);
		proccedButton.setCursor(cursor);
      	proccedButton.addActionListener(this);
		bottomPanel.add(proccedButton);
		
		this.add(bottomPanel);
		
		this.setVisible(true);
	}
	
	double bill = 0;
	int quantity = 0;
	String s;
	
	public void actionPerformed(ActionEvent e){
		
		if (e.getSource() == backButton){
			new CustomerLoginPage();
			this.dispose();
		}
		
		if (e.getSource() == selectBtn){
			
			soldTextArea.setText("====================================\n"+
									"\t"+"Welcome to Groceteria"+"\n"+
								"===================================="+"\n\n");
					   
			s = "Employee Name: "+employeeName.getText()+"\n"+
								"--------------------------------------"+"\n"+
								"Customer Name: "+customerName.getText()+"\n"+
								"--------------------------------------"+"\n";
								
			soldTextArea.setText(soldTextArea.getText()+ s);
		}
		
		
		if(e.getSource() == buyBtn){
			try{
				if(!employeeName.getText().isEmpty()){
					
					if(!productId.getText().isEmpty()){
						
						if(!productQuantity.getText().isEmpty()){
							
							quantity = Integer.parseInt(productQuantity.getText());	

							Product p = products.getByProductId(productId.getText());
							p.setQuantity(quantity);
							p.setProductPrice(p.getProductPrice()*quantity);
							
							s +=  p.getSellProductAsString();
							soldTextArea.setText(soldTextArea.getText() + p.getSellProductAsString());
							bill += p.getProductPrice();
							//bill += p.getProductPrice()*quantity;
							System.out.println(bill);
							
							productId.setText("");
							productQuantity.setText("");
							
						}
						else{
							JOptionPane.showMessageDialog(this,"Please Enter Quantity");
						}
					}
					else{
						JOptionPane.showMessageDialog(this,"Please Enter Product ID");
					}	
				}
				else{
					JOptionPane.showMessageDialog(this, "Please Select the Employee Name");
				}
			}
			catch(NullPointerException ex){
				JOptionPane.showMessageDialog(this,"Product not available right now!");
				productId.setText("");
			}
			catch(Exception ex ){
				ex.printStackTrace(System.out);
				//JOptionPane.showMessageDialog(this,"Invalid Input");
				productId.setText("");
			}
			
		}
		
		// Receipt
		String receipt = s+ "Total                       " +bill;
		
		if (e.getSource() == proccedButton) {
			if(!soldTextArea.getText().isEmpty()){
				SellFileIO.addRecords(receipt);
				soldTextArea.setText(soldTextArea.getText()+ "Total                       " +bill);
				JOptionPane.showMessageDialog(this, soldTextArea.getText());
				new Payment(bill);
				this.dispose();
			}
			else{
				JOptionPane.showMessageDialog(this,"Please buy something first.");
			}
		}
	}
	
}