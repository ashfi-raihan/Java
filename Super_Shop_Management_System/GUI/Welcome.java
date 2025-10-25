package GUI;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Welcome extends JFrame implements ActionListener
{
	JPanel panel;
	JLabel imglb;
	ImageIcon  img, icon;
	JButton btn1, btn2;
	Font font;
	Color color;
	Cursor cursor;
	
	
	
	public Welcome()
	{
		
		super("Welcome");
		this.setSize(800,500);
		/*icon = new ImageIcon("image/logo.gif");
		this.setIconImage(icon.getImage());*/
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		panel = new JPanel();
		panel.setLayout(null);
		
		font = new Font("Harlow Solid Italic", Font.PLAIN, 20);
		color = new Color(255, 106, 112);
		cursor = new Cursor(Cursor.HAND_CURSOR);
		
		btn1 = new JButton("Admin");
		btn1.setBounds(345,150,110,50);
		btn1.setFont(font);
		btn1.setBackground(color);
		btn1.setFocusPainted(false);
		btn1.setBorder(null);
		btn1.setCursor(cursor);
		btn1.addActionListener(this);
		panel.add(btn1);
		
		btn2 = new JButton("Seller");
		btn2.setBounds(345,230,110,50);
		btn2.setFont(font);
		btn2.setBackground(color);
		btn2.setFocusPainted(false);
		btn2.setBorder(null);
		btn2.setCursor(cursor);
		btn2.addActionListener(this);
		panel.add(btn2);
		
		img = new ImageIcon("Resource/Welcome.png");
		imglb = new JLabel(img);
		imglb.setBounds(0,0,800,500);
		panel.add(imglb);
		
		
		this.add(panel);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()== btn2)
		{
			new CustomerLoginPage();
			this.dispose();
		}
		
		else if(ae.getSource()== btn1)
		{
			
			new LoginPage();
			this.dispose();
		}
	}
}
