package recursionAssigment;

public class MultiplicationRecursive {

	public static void main(String[] args) {
		
		System.out.println(multiplyTwoIntegers(3, 5));

	}

	public static int multiplyTwoIntegers(int m, int n){
		if(n == 1){
			return m;
		}

		int remMultiplication = multiplyTwoIntegers(m, n-1);

		int ans = remMultiplication + m;

		return ans;

	}

}
