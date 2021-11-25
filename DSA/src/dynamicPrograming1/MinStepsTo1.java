/*Given a positive integer 'n',
 *find and return the minimum number of steps that 'n' has to take to get reduced to 1.
 *You can perform any one of the following 3 steps
 *
 *  1.) Subtract 1 from it. (n = n - ­1) ,
 *  2.) If n is divisible by 2, divide by 2.( if n % 2 == 0, then n = n / 2 ) ,
 *  3.) If n is divisible by 3, divide by 3. (if n % 3 == 0, then n = n / 3 ).
 *  
 * */
package dynamicPrograming1;

public class MinStepsTo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minStepsTo1(10));
	}
	
	public static int minStepsTo1(int n) {
		int ans;
//		ans = minStepsTo1Recur(n);
		
//		int[] dp = new int[n+1];
//		for(int i=0; i<dp.length; i++) {
//			dp[i] = -1;
//		}
//		ans = minStepsTo1Memo(n, dp);
		
		ans = minStepsTo1Itera(n);
		
		return ans;
	}
	
	// Recursive.
	private static int minStepsTo1Recur(int n) {
		if(n == 1) {
			return 0;
		}
		
		int ans1 = minStepsTo1Recur(n-1);
		
		int ans2 = Integer.MAX_VALUE;
		if(n % 2 == 0) {
			ans2 = minStepsTo1Recur(n/2);
		}
		
		int ans3 = Integer.MAX_VALUE;
		if(n % 3 == 0) {
			ans3 = minStepsTo1Recur(n/3);
		}
		
		int myAns = Math.min(ans1, Math.min(ans2, ans3)) + 1;
		
		return myAns;
	}
	
	// Memoization.
	private static int minStepsTo1Memo(int n, int[] dp) {
		if(n == 1) {
			return 0;
		}
		
		int ans1, ans2 = Integer.MAX_VALUE, ans3 = Integer.MAX_VALUE;
		if(dp[n-1] == -1) {
			ans1 = minStepsTo1Memo(n-1, dp);
			dp[n-1] = ans1;
		}else {
			ans1 = dp[n-1];
		}
		
		if(n % 2 == 0) {
			if(dp[n/2] == -1) {
				ans2 = minStepsTo1Memo(n/2, dp);
				dp[n/2] = ans2;
			}else {
				ans2 = dp[n/2];
			}
		}
		
		if(n % 3 == 0) {
			if(dp[n/3] == -1) {
				ans3 = minStepsTo1Memo(n/3, dp);
				dp[n/3] = ans3;
			}else {
				ans3 = dp[n/3];
			}
		}
		
		int myAns = Math.min(ans1, Math.min(ans2, ans3)) + 1;
		
		return myAns;
	}
	
	// Iterative approach.
	private static int minStepsTo1Itera(int n) {
		if(n == 1) {
			return 0;
		}
		
		int[] dp = new int[n+1];
		
		for(int i=2; i<=n; i++) {
			
			int ans1 = dp[i-1];
			
			int ans2 = Integer.MAX_VALUE;
			if(i % 2 == 0) {
				ans2 = dp[i / 2];
			}
			
			int ans3 = Integer.MAX_VALUE;
			if(i % 3 == 0) {
				ans3 = dp[i / 3];
			}
			
			dp[i] = Math.min(ans1, Math.min(ans2, ans3)) + 1;
			
		}
		
		return dp[n];
	}

}
