
public class PayrollCompute {
	private static final int maxStandardHours = 40;
	private static final double overtimeRate = 1.5;
	private static final double fedTax = .22;
	private static final double employeeHealthPremium = 28.75;
	private static final double dependantHealthPremium = 17.35;
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
		// Federal tax is applies only if pay is greater than 300 and only to pay above 300
		double payAbove300 = pay - 300.00;
		double amountTaxed = payAbove300 * (fedTax);
		
		return amountTaxed;
	}
	
	public static double computeSSTax(double pay) {
		double amountTaxed = 0;
		
		return amountTaxed;
	}
}
