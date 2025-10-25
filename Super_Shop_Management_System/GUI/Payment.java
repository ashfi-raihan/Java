package GUI;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import GUI.Sell.*;
import File.PaymentIO.*;

public class Payment extends JFrame implements ActionListener, MouseListener{
	Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
	
	Font font24B = new Font("Segoe UI", Font.BOLD, 24);
	Font f2 = new Font("Segoe UI", Font.PLAIN, 18);


	JPanel panel;
	JLabel imagelbl, title, accountNumberlbl, amountlbl, pinlbl;
	JTextField accountNumber, amount;
	JPasswordField pin;
	JButton viewbtn, paybtn, backbtn;
	ImageIcon img;
	
	
	public Payment(Double price)
	{
		super("Payment method");
		this.setSize(1000, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		img = new ImageIcon("Resource/payment#2.jpg");
		imagelbl = new JLabel(img);
		imagelbl.setBounds(0,0, 500, 600);
		imagelbl.setBackground(Color.green);
		imagelbl.setOpaque(true);
		panel.add(imagelbl);
		
		/*
		backbtn = new JButton("Back");
		backbtn.setBounds(20,20,80,50);
		backbtn.setBackground(Color.white);
		//backbtn.setContentAreaFilled(false);
		backbtn.setFocusPainted(false);
		backbtn.setCursor(cursor);
		backbtn.addActionListener(this);
		panel.add(backbtn);
		*/
		
		title = new JLabel("Payment Method");
		title.setBounds(650,50, 200,100);
		title.setForeground(new Color(0,102,102));
		title.setOpaque(true);
		title.setFont(font24B);
		panel.add(title);
		
		accountNumberlbl = new JLabel("Enter number: ");
		accountNumberlbl.setBounds(550, 140, 250, 90);
		accountNumberlbl.setFont(f2);
		panel.add(accountNumberlbl);
		
		accountNumber = new JTextField();
		accountNumber.setBounds(550, 210, 400, 50);
		panel.add(accountNumber);
		
		amountlbl = new JLabel("Total Amount: ");
		amountlbl.setBounds(550, 240, 250, 90);
		amountlbl.setFont(f2);
		panel.add(amountlbl);
		
		amount = new JTextField();
		amount = new JTextField();
		amount.setBounds(550, 310, 180, 50);
		amount.setText(Double.toString(price));
		amount.setFont(f2);
		amount.setEditable(false);
		panel.add(amount);
		
		
		pinlbl = new JLabel("Enter Pin number: ");
		pinlbl.setBounds(550,350,250,90);
		pinlbl.setFont(f2);
		panel.add(pinlbl);
		
		pin = new JPasswordField();
		pin.setBounds(550, 420, 290, 50);
		pin.setEchoChar('*');
		panel.add(pin);
		
		viewbtn = new JButton("View");
		viewbtn.setBounds(860,420,100,50);
		viewbtn.setFocusPainted(false);
		//viewbtn.setCursor(cursor);
		viewbtn.addMouseListener(this);
		panel.add(viewbtn);
		
		paybtn = new JButton("Pay Now");
		paybtn.setBounds(550, 490, 100, 50);
		paybtn.setFocusPainted(false);
		paybtn.setCursor(cursor);
		paybtn.addActionListener(this);
		panel.add(paybtn);
		
		
		this.add(panel);
		this.setVisible(true);
		
	}
	
	//MouseListener methods
	public void mousePressed(MouseEvent me){}
	public void mouseClicked(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseEntered(MouseEvent me){
		
		if(me.getSource()== viewbtn)
		{
			pin.setEchoChar((char)0);
		}
	}
	public void mouseExited(MouseEvent me){
		
		if(me.getSource()== viewbtn)
		{
			pin.setEchoChar('*');
		}
	}
	
	
	
	//ActionListener methods
	public void actionPerformed(ActionEvent ae)
	{
		String s1, s2, s3;
		s1 = accountNumber.getText();
		s2 = amount.getText();
		s3 = pin.getText();
		
		if(ae.getSource()== paybtn)
		{
			
			if(s1.isEmpty() || s2.isEmpty() || s3.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Fill up all information");
			}
			
			else 
			{
				int choice = JOptionPane.showConfirmDialog(this, s2+" tk will deduct from account"+"\n"+"Confirm payment?", "Payment gateway", JOptionPane.YES_NO_CANCEL_OPTION);
			    if(choice == JOptionPane.YES_OPTION)
				{
					JOptionPane.showMessageDialog(this, "Payment Successful");
					PaymentFileIO.addPayment(s1,s2,s3);
					new SellPage();
					this.dispose();
				}
			
			}
			
		}
		
		if(ae.getSource()== backbtn)
		{
			new SellPage();
			this.dispose();
		}
		
		
		
		
	}
}