import javax.swing.*;

import java.awt.*;

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
	private String[] healthPlanOptions = {"","Yes", "No"};
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
	
	public PayrollFrame(){
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		// Adding input components to the inputPanel
		addItem(inputPanel, nameLabel, 0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addItem(inputPanel, nameField, 1, 0, 1, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
		addItem(inputPanel, hoursLabel, 0, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addItem(inputPanel, hoursField, 1, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
		addItem(inputPanel, payrateLabel, 0, 2, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addItem(inputPanel, payrateField, 1, 2, 1, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
		addItem(inputPanel, dependentsLabel, 0, 3, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addItem(inputPanel, dependentsField, 1, 3, 1, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
		addItem(inputPanel, healthplanLabel, 0, 4, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addItem(inputPanel, healthPlanBox, 1, 4, 1, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
		
		mainPanel.add(inputPanel);
		
		// Adding output components to the outputPanel
		nameOutputField.setEditable(false);
		grossPayField.setEditable(false);
		fedTaxField.setEditable(false);
		healthPremiumField.setEditable(false);
		ficaField.setEditable(false);
		netPayField.setEditable(false);
		
		addItem(outputPanel, nameOutputLabel, 0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addItem(outputPanel, nameOutputField, 1, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL);
		addItem(outputPanel, grossPayLabel, 0, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addItem(outputPanel, grossPayField, 1, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
		addItem(outputPanel, fedTaxLabel, 0, 2, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addItem(outputPanel, fedTaxField, 1, 2, 1, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
		addItem(outputPanel, healthPremiumLabel, 0, 3, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addItem(outputPanel, healthPremiumField, 1, 3, 1, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
		addItem(outputPanel, ficaLabel, 0, 4, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addItem(outputPanel, ficaField, 1, 4, 1, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
		addItem(outputPanel, netPayLabel, 0, 5, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addItem(outputPanel, netPayField, 1, 5, 1, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
		
		mainPanel.add(outputPanel);
		
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
}
