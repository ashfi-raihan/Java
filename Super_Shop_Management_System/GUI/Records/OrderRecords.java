package GUI.Records;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import GUI.HomePage;
import File.SellIO.*;

public class OrderRecords implements ActionListener{

	JPanel topPanel, middlePanel, bottomPanel;
	JLabel title;
	JButton backButton;
	JTextArea textArea;
	JScrollPane jsp;
	JFrame frame;
	
	Font font15P = new Font("Segoe UI",Font.PLAIN,15);
	

	public OrderRecords() {
		
        //----------------------- TOP PANEL ---------------------
        topPanel = new JPanel();
		topPanel.setBounds(0, 0, 750, 100);
		topPanel.setLayout(null);
		topPanel.setBackground(Color.gray);
		
		title = new JLabel("Order Records");
		title.setForeground(Color.orange);
		title.setBounds(230, 10, 300, 90);
		title.setFont(new Font("Segoe UI", Font.BOLD, 35));
		topPanel.add(title);
		
		
		//----------------------- MIDDLE PANEL ---------------------
		middlePanel = new JPanel();
		middlePanel.setBounds(0, 100, 750, 575);
		middlePanel.setLayout(null);
		//middlePanel.setBackground(Color.gray);
		
		// Text Area 
		textArea = new JTextArea();
		textArea.setFont(font15P);
		textArea.setEditable(false);
		
		jsp = new JScrollPane(textArea);
		jsp.setBounds(175,40,400,500);
		middlePanel.add(jsp);
		
		textArea.setText(SellFileIO.getHistory());
		/*
		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		for(int i=0; i<1000; i++);{
			String[] info = new String[1000];
			SellFileIO.getRecords(info);
			String s = info[i];
			textArea.setText(textArea.getText()+s);
		}
		*/
		
		//----------------------- BOTTOM PANEL ---------------------
		bottomPanel = new JPanel();
		bottomPanel.setLayout(null);
		bottomPanel.setBounds(0, 675, 750, 75);
		bottomPanel.setBackground(Color.gray);
		
		
		//Back button
      	backButton = new JButton("<Back");
      	backButton.setBounds(630, 3, 100, 30);
      	backButton.setBackground(new Color(0x50AB60));
      	backButton.setForeground(Color.white);
      	backButton.setFocusable(false);
      	backButton.addActionListener(this);
		bottomPanel.add(backButton);
		
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(750, 750);
		frame.setTitle("Project Details Page");
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.add(topPanel);
		frame.add(middlePanel);
		frame.add(bottomPanel);
		frame.setVisible(true);
	}
        
        @Override
        public void actionPerformed(ActionEvent e){
    		
    		if (e.getSource() == backButton){
    			new HomePage();
    			frame.dispose();
    		}
    	}
	

}



/*
		
		JLabel label, label2, label3, label4, label5, label6, label7, label8, label9;
		Font f40 = new Font("Serif", Font.BOLD, 40);
		Font f38 = new Font("Goudy Old Style", Font.BOLD, 38);
		
	
		label = new JLabel("Project Details");
		label.setForeground(Color.magenta);
		label.setBounds(185, 15, 500, 90);
		label.setFont(new Font("Jokerman", Font.BOLD, 50));
		
		label2 = new JLabel("Project Title - ");
		label2.setForeground(Color.yellow);
		label2.setFont(f40);
		label2.setBounds(50, 45, 650, 50);
		
		label3 = new JLabel("Supershop Management System");
		label3.setForeground(Color.blue);
		label3.setFont(f38);
		label3.setBounds(90, 90, 660, 50);
		
		label4 = new JLabel("Project Idea - ");
		label4.setForeground(Color.yellow);
		label4.setFont(f40);
		label4.setBounds(50, 350, 650, 50);
		
		label5 = new JLabel("The main intention of our project is to show");
		label5.setForeground(Color.blue);
		label5.setFont(f38);
		label5.setBounds(90, 400, 660, 50);
		
		label6 = new JLabel("all the management system of a Supershop.");
		label6.setForeground(Color.blue);
		label6.setFont(f38);
		label6.setBounds(50, 450, 700, 50);
		
*/		
