package recursionAssigment;

public class SumOfDigitsRecursive {

	public static void main(String[] args) {
		
		System.out.println(sumOfDigits(12345));

	}
	
	static int sumOfDigits(int num) {
		if(num == 0) {
			return 0;
		}
		
		int remDigitsSum = sumOfDigits(num/10);
		
		int sum = remDigitsSum + num % 10;
		
		return sum;
	}
}
