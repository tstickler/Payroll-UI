/* 
 * Programmer's name: Tyler Stickler
 * Email address:     Stickler@csu.fullerton.edu
 * Course:            CPSC223J
 * Assignment number: 2
 * Due date:          Sept 30, 2015
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
	private static final double ficaTax = .085;
	
	public static double computeGrossPay(int hours, double payrate) {
		double grossPay;
		
		// If the employee has more than 40 hours, increase their pay for hours > 40 by 50%
		if(hours > maxStandardHours) {
			// Number of hours to give overtime pay for
			int overtimeHours = hours - 40;
			
			// Pay is computed by using original payrate for the first 40 hours plus overtime payrate for hours above 40
			grossPay = (payrate * maxStandardHours) + (payrate * overtimeHours * overtimeRate);
		} else {
			grossPay = payrate * hours;
		}
		
		return grossPay;
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
	
	public static double computeFicaTax(double pay) {
		double amountTaxed = pay * ficaTax;
		
		// Social Security tax is can be no larger than $55.00
		if (amountTaxed > 55.00) {
			amountTaxed = 55.00;
		}
		
		return amountTaxed;
	}
	
	public static double computeHealthInsurance(int dependents){
		double amountDeducted = employeeHealthPremium;
		
		// Health insurance is 28.75 for the employee plus 17.35 for each dependent
		if(dependents > 0){
			amountDeducted += dependentHealthPremium * dependents;
		}
		
		return amountDeducted;
	}
	
	public static double computeNetPay(double grossPay, double fed, double SS, double healthInsurance) {
		// Net pay is calculated by taking gross pay and subraction federal tax, social security tax, and
		// the cost of health insurance.
		
		double netPay = grossPay - fed - SS - healthInsurance;
		
		return netPay;
	}
}
