/* 
* Programmer's name: Tyler Stickler
* Email address:     Stickler@csu.fullerton.edu
* Course:            CPSC223J
* Assignment number: 2
* Due date:          Sept 28, 2015
* Title:             Payroll
* Purpose:           Compute the payroll for the given indivdual
* This file name:    PayrollCompute.java
*/

public class PayrollCompute {
	private static final int maxStandardHours = 40;
	private static final double overtimeRate = 1.5;
	private static final double fedTax = .22;
	private static final double employeeHealthPremium = 28.75;
	private static final double dependentHealthPremium = 17.35;
	private static final double ssTax = .085;
	
	public static double computeGrossPay(int hours, double payrate) {
		double pay;
		
		// If the employee has more than 40 hours, increase their pay for hours > 40 by 50%
		if(hours > maxStandardHours) {
			// Number of hours to give overtime pay for
			int overtimeHours = hours - 40;
			
			// Pay is computed by using original payrate for the first 40 hours plus overtime payrate for hours above 40
			pay = (payrate * maxStandardHours) + (overtimeHours * payrate * overtimeRate);
		} else {
			pay = payrate * hours;
		}
		
		return pay;
	}
	
	public static double computeFedTax(double pay) {
		double amountTaxed;
		
		// Federal tax is applies only if pay is greater than 300 and only to pay above 300
		if (pay > 300.00) {
		double payAbove300 = pay - 300.00;
		amountTaxed = payAbove300 * (fedTax);
		} else {
			amountTaxed = 0.00;
		}
		
		return amountTaxed;
	}
	
	public static double computeSSTax(double pay) {
		double amountTaxed = pay * ssTax;
		
		if (amountTaxed > 55.00) {
			amountTaxed = 55.00;
		}
		
		return amountTaxed;
	}
	
	public static double computeHealthInsurance(int dependents){
		double amountDeducted = employeeHealthPremium;
		
		if(dependents > 0){
			amountDeducted += dependentHealthPremium * dependents;
		}
		
		return amountDeducted;
	}
	
	public static double computeNetPay(double grossPay, double fed, double SS, double healthInsurance) {
		double netPay = grossPay - fed - SS - healthInsurance;
		
		return netPay;
	}
}
