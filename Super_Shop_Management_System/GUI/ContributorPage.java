package GUI;

import GUI.HomePage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ContributorPage implements ActionListener{
	JPanel topPanel, middlePanel, bottomPanel;
	JButton backButton;
	Font f40 = new Font("Goudy Old Style", Font.ITALIC, 40);
	JFrame frame;
	JLabel label, label2, label3, label4, label5, label6, label7, label8, label9;
	
	public ContributorPage() {
		label = new JLabel("Contributor's");
		label.setForeground(Color.magenta);
		label.setBounds(190, 15, 500, 90);
		label.setFont(new Font("Jokerman", Font.BOLD, 50));
		
		label2 = new JLabel("Name: Ankita Islam");
		label2.setForeground(Color.blue);
		label2.setFont(f40);
		label2.setBounds(50, 45, 450, 50);
		
		label3 = new JLabel("ID   : 23-53768-3");
		label3.setForeground(Color.blue);
		label3.setFont(f40);
		label3.setBounds(50, 90, 450, 50);
		
		label4 = new JLabel("Name: Ashfi Raihan ");
		label4.setForeground(Color.blue);
		label4.setFont(f40);
		label4.setBounds(50, 135, 450, 50);

		label5 = new JLabel("ID   : 23-53818-3");
		label5.setForeground(Color.blue);
		label5.setFont(f40);
		label5.setBounds(50, 180, 450, 50);

		label6 = new JLabel("Name: Tanvir Ahmmed Kawser");
		label6.setForeground(Color.blue);
		label6.setFont(f40);
		label6.setBounds(50, 225, 650, 50);

		label7 = new JLabel("ID   : 23-53048-3");
		label7.setForeground(Color.blue);
		label7.setFont(f40);
		label7.setBounds(50, 270, 450, 50);

		label8 = new JLabel("Name: Koushik Ahsan");
		label8.setForeground(Color.blue);
		label8.setFont(f40);
		label8.setBounds(50, 315, 450, 50);

		label9 = new JLabel("ID   : 23-53812-3");
		label9.setForeground(Color.blue);
		label9.setFont(f40);
		label9.setBounds(50, 360, 450, 50);
		
		//Back button
		backButton = new JButton("<Back");
		backButton.setBounds(630, 3, 100, 30);
		backButton.setBackground(new Color(0x50AB60));
		backButton.setForeground(Color.white);
		backButton.setFocusable(false);
		backButton.addActionListener(this);
				
		topPanel = new JPanel();
		topPanel.setBounds(0, 0, 750, 100);
		topPanel.add(label);
		topPanel.setLayout(null);
		topPanel.setBackground(Color.cyan);
		
		middlePanel = new JPanel();
		middlePanel.setBounds(0, 100, 750, 575);
		middlePanel.setLayout(null);
		middlePanel.setBackground(Color.gray);
		middlePanel.add(label2);
		middlePanel.add(label3);
		middlePanel.add(label4);
		middlePanel.add(label5);
		middlePanel.add(label6);
		middlePanel.add(label7);
		middlePanel.add(label8);
		middlePanel.add(label9);
		
		
		bottomPanel = new JPanel();
		bottomPanel.setLayout(null);
		bottomPanel.setBounds(0, 675, 750, 75);
		bottomPanel.setBackground(Color.cyan);
		bottomPanel.add(backButton);
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(750, 750);
		frame.setTitle("Contributor Page");
		frame.setLocation(400, 50);
		frame.setLayout(null);
		frame.add(topPanel);
		frame.add(middlePanel);
		frame.add(bottomPanel);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		
		if (e.getSource() == backButton){
			HomePage home = new HomePage();
			frame.dispose();
		}
	}
}

