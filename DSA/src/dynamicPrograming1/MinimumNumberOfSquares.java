/*Given an integer N,
 *find and return the count of minimum numbers required to represent N as a sum of squares
 *
 *That is, if N is 4, then we can represent it as : {1^2 + 1^2 + 1^2 + 1^2} and {2^2}.
 *The output will be 1, as 1 is the minimum count of numbers required to represent N as sum of squares
 * */
package dynamicPrograming1;

public class MinimumNumberOfSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		
        int[] dp = new int[n+1];
        for(int i=1; i<dp.length; i++){
            dp[i] = -1;
        }
        
        System.out.println(minCountMemo(n, dp));
        System.out.println(minCountItera(n));

	}

	public static int minCountItera(int n) {
        int[] dp = new int[n+1];
        
		for(int i=1; i<=n; i++){
			int minAns = Integer.MAX_VALUE;
			for(int j=1; j*j <= i; j++){
				int ans = dp[i-(j*j)];
				minAns = Math.min(minAns, ans);
			}
			dp[i] = minAns + 1;
		}

		return dp[n];
	}

	// Memoization.
	public static int minCountMemo(int n, int[] dp){
		if(n == 0){
			return 0;
		}

		int minAns = Integer.MAX_VALUE;
		for(int i=1; i*i <= n; i++){
			int ans;

			if(dp[n-(i*i)] == -1){
				ans = minCountMemo(n-(i*i), dp);
				dp[n-(i*i)] = ans;
			}else{
				ans = dp[n-(i*i)];
			}

			minAns = Math.min(minAns, ans);
		}

		return minAns + 1;
	}

}
