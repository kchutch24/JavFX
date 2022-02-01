import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.*;

class MenuDemo implements ActionListener {
	//set menu frame and text fields
	JMenuItem menu1,menu2,menu3,menu4;
	JMenuBar menuBar;
	JTextField textbox;
	JMenu menu;
	JFrame frame;

	public MenuDemo() {
		
		frame = new JFrame("JavaFX GUI"); //new JFrame
		frame.setLayout(null);
		
		menuBar = new JMenuBar(); //new menu bar
		textbox = new JTextField(); //text field for date/time
		menu = new JMenu("Menu"); //menu - to be clicked
		
		//menuItem - options for menu
		menu1 = new JMenuItem("Date and Time");
		menu2 = new JMenuItem("Write To File");
		menu3 = new JMenuItem("Change Frame Color");
		menu4 = new JMenuItem("Exit");
		
		//add options to menu
		menu.add(menu1);
		menu.add(menu2);
		menu.add(menu3);
		menu.add(menu4);
		
		//add menu to menu bar
		menuBar.add(menu);
		frame.setJMenuBar(menuBar); //add to frame
		
		//click for menu option
		menu1.addActionListener(this);
		menu2.addActionListener(this);
		menu3.addActionListener(this);
		menu4.addActionListener(this);
		
		//set size, visibility, and position of textbox
		textbox.setBounds(125,50,150,30);
		frame.add(textbox);
		frame.setVisible(true);
		frame.setSize(400,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	public void actionPerformed(ActionEvent actionEvent) {
		
		//option 1 - date and time
		if(actionEvent.getSource() == menu1) {
			DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("yyyy/mm/dd hh:mm:ss"); //time/date format
			LocalDateTime currentDateTime = LocalDateTime.now(); //get current time and date
			textbox.setText(dateTime.format(currentDateTime)+""); //print date/time in previous format
		}
		//option 2 - write to file
		if(actionEvent.getSource() == menu2) {
			String textContents = textbox.getText();
			try {
				FileWriter fw = new FileWriter("log.txt"); //save to file log.txt
				fw.write(textContents);
				fw.close();
			}
			catch(Exception e1) {
				textbox.setText("Exception is " + e1);
			}
		}
		//option 3 - change to green color
		if(actionEvent.getSource() == menu3) {
			frame.getContentPane().setBackground(Color.decode("#006600"));
		}
		//option 4 - hide GUI
		if(actionEvent.getSource() == menu4) {
			frame.setVisible(false);
		}
	}
	
	public static void main(String args[]) {
		MenuDemo javaFXDemo = new MenuDemo(); //implement menuDemo class
	}
	
}


//CORRECTIONS:
//realized I initially uploaded version with poorly named file and package which also didn't include comments
//here is the proper version with comments and better use of whitespace