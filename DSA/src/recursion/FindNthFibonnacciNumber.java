package recursion;

public class FindNthFibonnacciNumber {

	public static void main(String[] args) {
		
		System.out.println(fibo(10));

	}
	
	static int fibo(int n) {
		// Base case 
		if(n == 1 || n == 2)
			return 1;
		
		// assumation
		int fibo_n_1 = fibo(n-1);
		int fibo_n_2 = fibo(n-2);
		
		int output = fibo_n_1 + fibo_n_2;
		
		return output;
	}

}
