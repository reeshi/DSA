package recursion;

public class SumOfNNaturalNumbers {

	public static void main(String[] args) {
		
		System.out.println(sumOfN(10));
	}
	
	static int sumOfN(int n) {
		if(n == 0) return 0;
		
		int smallerOutput = sumOfN(n-1);
		int output = n + smallerOutput;
		
		return output;
	}

}
