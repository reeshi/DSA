/* 
 * Dyanamic programming is only applied on a problem
 * if problem has :
 * 		1. recursive in nature(optimal sub-structure).
 * 		2. overlapping subproblems.
 * 
 **/
package dynamicPrograming1;

public class FindNthFibonacci {

	public static void main(String[] args) {
		int n = 10;
//		int[] dp = new int[n+1];
//		for(int i=0; i<dp.length; i++) {
//			dp[i] = -1;
//		}
//		
//		System.out.println(fibo(n, dp));
		System.out.println(fiboIterative(n));

	}
	
	// this is a Iterative way of doing dynamic programming.
	// this is the better way of doing dynamic programming.
	// but first we solve the problem in recursion than if there is a overlapping sub-problems.
	// so we should optimize with dp(memoization) than do with iterative.
	public static int fiboIterative(int n) {
		if(n == 0 || n == 1) {
			return n;
		}
		
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i=2; i<=n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		return dp[n];
	}
	
	//this is called Memoization in dynamic programming.
	// Memoization --> recursion + storage.
	public static int fibo(int n, int[] dp) {
		if(n == 0 || n == 1) {
			return n;
		}
		
		int ans1, ans2;
		
		if(dp[n-1] == -1) {
			ans1 = fibo(n-1, dp);
			dp[n-1] = ans1;
		}else {
			ans1 = dp[n-1];
		}
		
		if(dp[n-2] == -1) {
			ans2 = fibo(n-2, dp);
			dp[n-2] = ans2;
		}else {
			ans2 = dp[n-2];
		}
		
		int myAns = ans1 + ans2;
		
		return myAns;
		
	}

}
