package recursion;

import java.util.Scanner;

public class FindFactorial {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.close();
		
		System.out.println(fact(n));

	}
	
	static int fact(int n) {
		if(n == 0)
			return 1;
		int smallerOutput = fact(n-1);
		int output = n * smallerOutput;
		
		return output;
	}

}
