import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayrollFrame extends JFrame {
	private JPanel mainPanel = new JPanel();
	
	// Input labels and fields
	private JPanel inputPanel = new JPanel(new GridBagLayout());
	private JLabel nameLabel = new JLabel("Name:");
	private JLabel hoursLabel = new JLabel("Hours:");
	private JLabel payrateLabel = new JLabel("Payrate:");
	private JLabel dependentsLabel = new JLabel("Dependents:");
	private JLabel healthplanLabel = new JLabel("Health Plan:");
	private JTextField nameField = new JTextField();
	private JTextField hoursField = new JTextField();
	private JTextField payrateField = new JTextField();
	private JTextField dependentsField = new JTextField();
	private String[] healthPlanOptions = {"", "Yes", "No"};
	private JComboBox<String> healthPlanBox = new JComboBox<String>(healthPlanOptions);

	// Output labels and fields
	private JPanel outputPanel = new JPanel(new GridBagLayout());
	private JLabel nameOutputLabel = new JLabel("Computed pay for:");
	private JLabel grossPayLabel = new JLabel("Gross Pay:");
	private JLabel fedTaxLabel = new JLabel("Federal Tax:");
	private JLabel healthPremiumLabel = new JLabel("Health Premium:");
	private JLabel ficaLabel = new JLabel("FICA:");
	private JLabel netPayLabel = new JLabel("Net Pay:");
	private JTextField nameOutputField = new JTextField();
	private JTextField grossPayField = new JTextField();
	private JTextField fedTaxField = new JTextField();
	private JTextField healthPremiumField = new JTextField();
	private JTextField ficaField = new JTextField();
	private JTextField netPayField = new JTextField();
	
	// Buttons
	private buttonHandler buttonHandler = new buttonHandler();
	private JPanel buttonPanel = new JPanel(new FlowLayout());
	private JButton computePayButton = new JButton("Compute Pay");
	private JButton clearButton = new JButton("Clear");
	private JButton exitButton = new JButton("Exit");
	
	public PayrollFrame(){
		//Allows using different font size/style for messages
		Font titleFont = new Font("", Font.BOLD, 42);
		Font labelFont = new Font("", Font.PLAIN, 18);
		
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		/* Adding input components to the inputPanel */
		
		// Adds name label and input field
		nameLabel.setFont(labelFont);
		addItem(inputPanel, nameLabel, 0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addItem(inputPanel, nameField, 1, 0, 1, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
		
		// Adds hours label and input field
		hoursLabel.setFont(labelFont);
		addItem(inputPanel, hoursLabel, 0, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addItem(inputPanel, hoursField, 1, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
		
		// Adds pay rate label and input field
		payrateLabel.setFont(labelFont);
		addItem(inputPanel, payrateLabel, 0, 2, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addItem(inputPanel, payrateField, 1, 2, 1, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
		
		// Adds dependents label and input field
		dependentsLabel.setFont(labelFont);
		addItem(inputPanel, dependentsLabel, 0, 3, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addItem(inputPanel, dependentsField, 1, 3, 1, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
		
		// Adds health label and combo box
		healthplanLabel.setFont(labelFont);
		addItem(inputPanel, healthplanLabel, 0, 4, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addItem(inputPanel, healthPlanBox, 1, 4, 1, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
		
		// Adds the input panel to the main panel
		mainPanel.add(inputPanel);
		
		
		/* Adding output components to the outputPanel */
		
		// Makes the output fields uneditable
		nameOutputField.setEditable(false);
		grossPayField.setEditable(false);
		fedTaxField.setEditable(false);
		healthPremiumField.setEditable(false);
		ficaField.setEditable(false);
		netPayField.setEditable(false);
		
		// Adds name output label and field
		nameOutputLabel.setFont(labelFont);
		addItem(outputPanel, nameOutputLabel, 0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addItem(outputPanel, nameOutputField, 1, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL);
	
		// Adds gross pay output label and field
		grossPayLabel.setFont(labelFont);
		addItem(outputPanel, grossPayLabel, 0, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addItem(outputPanel, grossPayField, 1, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
		
		// Adds federal tax output label and field
		fedTaxLabel.setFont(labelFont);
		addItem(outputPanel, fedTaxLabel, 0, 2, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addItem(outputPanel, fedTaxField, 1, 2, 1, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
		
		// Adds health premium output label and field
		healthPremiumLabel.setFont(labelFont);
		addItem(outputPanel, healthPremiumLabel, 0, 3, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addItem(outputPanel, healthPremiumField, 1, 3, 1, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
		
		// Adds social security output label and field
		ficaLabel.setFont(labelFont);
		addItem(outputPanel, ficaLabel, 0, 4, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addItem(outputPanel, ficaField, 1, 4, 1, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
		
		// Adds net pay output label and field
		netPayLabel.setFont(labelFont);
		addItem(outputPanel, netPayLabel, 0, 5, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addItem(outputPanel, netPayField, 1, 5, 1, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
		
		// Adds the output panel to the main panel
		mainPanel.add(outputPanel);
		
		
		/* Adding buttons to the buttonPanel */
		buttonPanel.add(computePayButton);
		computePayButton.addActionListener(buttonHandler);
		buttonPanel.add(clearButton);
		clearButton.addActionListener(buttonHandler);
		buttonPanel.add(exitButton);
		exitButton.addActionListener(buttonHandler);
		mainPanel.add(buttonPanel);
		
		// Adds the main panel to the frame
		this.add(mainPanel);
		
	} // End PayrollFrame constructor
	
	private void addItem(JPanel myPanel, JComponent item, int xGrid, int yGrid, int width, int height, int location, int fill) {
		GridBagConstraints cons = new GridBagConstraints();
		
		cons.gridx = xGrid;
		cons.gridy = yGrid;
		cons.gridheight = height;
		cons.gridwidth = width;
		cons.weightx=1;
		cons.weighty=1;
		cons.anchor = location;
		cons.fill = fill;
		
		myPanel.add(item, cons);
			
	} // End addItem function
	
	private class buttonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == computePayButton){
				// Sets the name output to the name that was input
				String name = nameField.getText();
				nameOutputField.setText(name);
				
				// Reads hours from input. If empty or invalid input, hours = 0
				int hours;
				if(hoursField.getText() == "") {
					hours = 0;
				} else {
					try{
						hours = Integer.parseInt(hoursField.getText());
					} catch (NumberFormatException exception) {
						hours = 0;
					}
				}
				
				// Reads payrate from input. If empty or invalid input, payrate = 0
				double payrate;
				if(payrateField.getText() == "") {
					payrate = 0.00;
				} else {
					try{
						payrate = Double.parseDouble(payrateField.getText());
					} catch (NumberFormatException exception) {
						payrate = 0.00;
					}
				}
				
				// Reads dependents from input. If empty or invalid input, dependents = 0
				int dependents;
				if(dependentsField.getText() == "") {
					dependents = 0;
				} else {
					try{
						dependents = Integer.parseInt(dependentsField.getText());
					} catch (NumberFormatException exception) {
						dependents = 0;
					}
				}
				
				// Reads the combobox answer. If answer = yes, healthPlan is true otherwise healthPlan is false
				boolean healthPlan;
				if (healthPlanBox.getSelectedItem() == "Yes") {
					healthPlan = true;
				} else {
					healthPlan = false;
				}
				
				// Sends hours and payrate to compute the gross pay for the employee
				double grossPay = PayrollCompute.computeGrossPay(hours, payrate);
				grossPayField.setText(Double.toString(grossPay));
				
				// Sends gross pay to compute federal tax owed(if any)
				double fedTax = PayrollCompute.computeFedTax(grossPay);
				fedTaxField.setText(Double.toString(fedTax));
				
				// Sends dependents to compute health insurance if healthPlan is true, otherwise the premium is 0
				double healthPremium;
				if(healthPlan == true) {
					 healthPremium = PayrollCompute.computeHealthInsurance(dependents);
				} else {
					healthPremium = 0.00;
				}
				healthPremiumField.setText(Double.toString(healthPremium));
				
				// Sends gross pay to compute social security tax owed
				double fica = PayrollCompute.computeSSTax(grossPay);
				ficaField.setText(Double.toString(fica));
				
				// Sends gross pay, federal tax, health premium, and social security tax to calculate employee's net pay
				double netPay = PayrollCompute.computeNetPay(grossPay, fedTax, fica, healthPremium);
				netPayField.setText(Double.toString(netPay));
				
			} else if (e.getSource() == clearButton){
				
			} else if (e.getSource() == exitButton){
				
			}
			
		}
	}
}
