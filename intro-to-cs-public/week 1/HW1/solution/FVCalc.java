// Computes the future value of a saving investment.
public class FVCalc {
	public static void main(String[] args){
		int currentValue = Integer.parseInt(args[0]);
		double percent = Double.parseDouble(args[1]);
		int numOfYears = Integer.parseInt(args[2]);
		double rate = percent / 100;
		double futureValue = currentValue * Math.pow(1 + rate, numOfYears);
		System.out.println("After " + numOfYears + " years, $" + currentValue +
			               " saved at " + percent + "% will yield $" + (int) futureValue);
	}
}