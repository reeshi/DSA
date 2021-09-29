package recursionAssigment;

public class CountZerosRecursivly {

	public static void main(String[] args) {
		
		System.out.println(countZeros(708000));

	}
	
	static int countZeros(int num) {
		
		if(num == 0) {
			return 1;
		}else if(num < 10) {
			return 0;
		}
		
		int countZeroRem = countZeros(num / 10);
		
		if(num % 10 == 0) {
			return countZeroRem + 1;
		}else {
			return countZeroRem;
		}
	}

}
