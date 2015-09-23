/* 
* Programmer's name: Tyler Stickler
* Email address:     Stickler@csu.fullerton.edu
* Course:            CPSC223J
* Assignment number: 2
* Due date:          Sept 28, 2015
* Title:             Payroll
* Purpose:           Compute the payroll for the given indivdual
* This file name:    PayrollDriver.java
*/

import javax.swing.*;

import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.Dimension;

public class PayrollDriver {
	public static void main(String[] args) {		
		PayrollFrame myFrame = new PayrollFrame();
		
		//Sets the window to open in the middle of the screen
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dm = tk.getScreenSize();
		int width = 750;
		int height = 1000;
		int xPos = (dm.width / 2) - width/2;
		int yPos = (dm.height / 2) - height/2;
		
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setLocation(xPos,yPos);
		myFrame.setSize(width, height);
		myFrame.setVisible(true);
		myFrame.setTitle("Payroll");
		
		
	}
}