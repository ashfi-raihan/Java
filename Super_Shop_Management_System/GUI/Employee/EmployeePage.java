package GUI.Employee;

import GUI.*;
import Entity.*;
import EntityList.*;
import File.EmployeeIO.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.util.*;



public class EmployeePage extends JFrame implements ActionListener{
	Font font30B = new Font("Segoe UI",Font.BOLD,30);
	Font font20 = new Font("Segoe UI",Font.PLAIN,20);
	Font font20B = new Font("Segoe UI",Font.BOLD,20);
	Font font15 = new Font("Segoe UI",Font.PLAIN,15);
	
	
	JTextField name,id,age,designation,branch,salary,gender;
	JTextArea textArea;
	JScrollPane jsp;
	JPanel topPanel,leftPanel,rightPanel,bottomPanel; 
	JButton deleteBtn,addBtn,backButton,homeButton,searchBtn,updateBtn,clear;
	JComboBox comboBox;
	JTable table;
	DefaultTableModel model;
	
	Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
	String gen[] = {" ","Male","Female"};
	
	public EmployeePage(){
		super("Employee Page");
		this.setSize(1350,700);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//=========================TOP PANEL===========================
		topPanel = new JPanel();
		topPanel.setBounds(0,0,1350,80); //x,y,w,h
		topPanel.setLayout(null);
		
		//------------------Welcome-------------------
		JLabel title = new JLabel("Welcome to Employee Management Page");
		title.setBounds(400,15,700,50); //x,y,w,h
		title.setFont(font30B);
		topPanel.add(title);
		
		this.add(topPanel);
		
		
		//=========================LEFT PANEL===========================
		leftPanel = new JPanel();
		leftPanel.setBounds(0,80,550,550);
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
		//-------------------Designation------------------
		JLabel designationLabel = new JLabel("Designation");
		designationLabel.setBounds(60,vPos,lblsize,30); //x,y,w,h
		designationLabel.setFont(font20);
		leftPanel.add(designationLabel);

		designation = new JTextField();
		designation.setBounds(200,vPos,txtfieldsize,30); //x,y,w,h
		designation.setFont(font20);
		leftPanel.add(designation);
		
		vPos+=gap;
		//-------------------Branch--------------------
		JLabel branchLabel = new JLabel("Branch");
		branchLabel.setBounds(60,vPos,lblsize,30); //x,y,w,h
		branchLabel.setFont(font20);
		leftPanel.add(branchLabel);

		branch = new JTextField();
		branch.setBounds(200,vPos,txtfieldsize,30); //x,y,w,h
		branch.setFont(font20);
		leftPanel.add(branch);
		
		vPos+=gap;
		//-------------------Salary--------------------
		JLabel salaryLabel = new JLabel("Salary");
		salaryLabel.setBounds(60,vPos,lblsize,30); //x,y,w,h
		salaryLabel.setFont(font20);
		leftPanel.add(salaryLabel);

		salary = new JTextField();
		salary.setBounds(200,vPos,txtfieldsize,30); //x,y,w,h
		salary.setFont(font20);
		leftPanel.add(salary);
		
		vPos+=gap;
		//------------------Gender------------------------------
		JLabel gender = new JLabel("Gender");
		gender.setBounds(60,vPos,lblsize,30); //x,y,w,h
		gender.setFont(font20);
		leftPanel.add(gender);
		
		comboBox = new JComboBox(gen);
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
		rightPanel.setBounds(550,80,800,550);
		rightPanel.setLayout(null);
		rightPanel.setBackground(new Color(102,178,255));
		/*
		//------------------Text Area -------------------

		textArea = new JTextArea();
		textArea.setFont(font15);
		textArea.setEditable(false);
		
		JScrollPane jsp = new JScrollPane(textArea);
		jsp.setBounds(13, 13, 360, 525); 
		rightPanel.add(jsp);
		EmployeeFileIO.loadAllEmployee(employees);
		updateTextArea();
		this.add(rightPanel);
		*/
		
		//-------------------- Table ---------------------
		// Creating Model
		model = new DefaultTableModel();
		model.addColumn("Name");
		model.addColumn("ID");
		model.addColumn("Age");
		model.addColumn("Designation");
		model.addColumn("Branch");
		model.addColumn("Salary");
		model.addColumn("Gender");
		
		// Creating Table
		table = new JTable(model);
		table.setBounds(13, 13, 750, 525);
		table.setFont(font15);
		//table.setBackground(COLOR.WHITE);
		table.setRowHeight(20);
		table.setSelectionBackground(new Color(247, 146, 146));
		table.getTableHeader().setFont(font20);
		//table.setEnabled(false);
		
		jsp = new JScrollPane(table);
		jsp.setBounds(13, 13, 750, 525);
		
		//Copy data in the model 
		Employee employeesArray [];
		EmployeeFileIO.loadAllEmployee(employees);
		employeesArray = employees.getAllEmployeesArray();
		
		for(int i=0; i<employeesArray.length; i++){
			
			if(employeesArray[i] != null){
				model.addRow(new Object[]{
					employeesArray[i].getName(),
					employeesArray[i].getId(),
					employeesArray[i].getAge(),
					employeesArray[i].getDesignation(),
					employeesArray[i].getBranch(),
					employeesArray[i].getSalary(),
					employeesArray[i].getGender()
					
				});
			}
			
		}
		rightPanel.add(jsp);
		
		
		
		this.add(rightPanel);
		
		//=========================BOTTOM PANEL===========================
		bottomPanel = new JPanel();
		bottomPanel.setBounds(0,620,1350,80);
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
      	homeButton.setBounds(1250,10,100, 30);
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
	

	EmployeeList employees = new EmployeeList();
	
	
	@Override
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == addBtn){
			try{
				Employee em = new Employee(name.getText(),id.getText(),
									Integer.parseInt(age.getText()),
									comboBox.getSelectedItem(), designation.getText(),
									branch.getText(),
									Integer.parseInt(salary.getText()));
									
				employees.insert(em);
				EmployeeFileIO.addEmployee(em);
				model.addRow(new Object[]{
					em.getName(),
					em.getId(),
					em.getAge(),
					em.getDesignation(),
					em.getBranch(),
					em.getSalary(),
					em.getGender()
				});
				clearTxt();
			}
			catch(NumberFormatException er){
				JOptionPane.showMessageDialog(this, "Invalid input! Enter Age & Salary in number format", "Error", JOptionPane.ERROR_MESSAGE);
			}
			catch(Exception er){
				JOptionPane.showMessageDialog(this, "Invalid input! Enter ID in number format", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(e.getSource() == deleteBtn){
			Employee em = employees.getById(id.getText());
			if(em != null){
				employees.removeById(id.getText());
				EmployeeFileIO.updateAllEmployee(employees);
				JOptionPane.showMessageDialog(this,"Employee Deleted");
			}
			else{
				JOptionPane.showMessageDialog(this,"Employee Not Found", "Warning",JOptionPane.ERROR_MESSAGE);
			}
			//updateTextArea();
			clearTxt();
		}
		
		if(e.getSource() == updateBtn){
			try{
				Employee tempE = new Employee(name.getText(),id.getText(),
								Integer.parseInt(age.getText()),
								comboBox.getSelectedItem(), designation.getText(),
								branch.getText(),
								Integer.parseInt(salary.getText()));
				Employee em = employees.getById(id.getText());
				employees.removeById(id.getText());
				if(em != null){
					em = tempE;
					employees.insert(tempE);
					EmployeeFileIO.updateAllEmployee(employees);
					//updateTextArea();
					// We have to add the updated value in the table. Which is missing.
					JOptionPane.showMessageDialog(this,"Information Updated");
				}
				else{
					JOptionPane.showMessageDialog(this,"Employee Not Found", "Warning",JOptionPane.ERROR_MESSAGE);
				}
			}
			catch(NumberFormatException er){
				JOptionPane.showMessageDialog(this, "Invalid input! Enter Age & Salary in number format", "Error", JOptionPane.ERROR_MESSAGE);
			}
			catch(Exception er){
				JOptionPane.showMessageDialog(this, "Invalid input! Enter ID in number format", "Error", JOptionPane.ERROR_MESSAGE);
			}
			clearTxt();
		}
		
		if(e.getSource() == searchBtn){
			Employee em = employees.getById(id.getText());
			if(em != null){
				JOptionPane.showMessageDialog(this,em.getEmployeeAsString());
			}
			else{
				JOptionPane.showMessageDialog(this,"Employee Not Found", "Warning",JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource() == clear){
			clearTxt();
			
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
		
		textArea.setText(employees.getAllEmployeeAsString());
	}
	
	public void clearTxt(){
		name.setText("");
		id.setText("");
		age.setText("");
		designation.setText("");
		branch.setText("");
		salary.setText("");
	}

}





