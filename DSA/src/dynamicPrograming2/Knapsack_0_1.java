/*
A thief robbing a store can carry a maximal weight of W into his knapsack. There are N items, and i-th item weigh 'Wi' and the value being 'Vi.' 
What would be the maximum value V, that the thief can steal?

Input Format :
The first line of the input contains an integer value N, which denotes the total number of items.
The second line of input contains the N number of weights separated by a single space.
The third line of input contains the N number of values separated by a single space.
The fourth line of the input contains an integer value W, which denotes the maximum weight the thief can steal.

Output Format :
Print the maximum value of V that the thief can steal.

Constraints :
1 <= N <= 20
1<= Wi <= 100
1 <= Vi <= 100
Time Limit: 1 sec

Sample Input 1 :
4
1 2 4 5
5 4 8 6
5
Sample Output 1 :
13

Sample Input 2 :
5
12 7 11 8 9
24 13 23 15 16
26
Sample Output 2 :
51
 */
package dynamicPrograming2;

public class Knapsack_0_1 {
	
	public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {
		// return knapsackRecur(weights, values, n, maxWeight, 0);
		// int[][] dp = new int[n+1][maxWeight + 1];
		// return knapsackMemo(weights, values, n, maxWeight, 0, dp);

		return knapsackItera(weights, values, n, maxWeight);
	}

	// Iteravtive
	public static int knapsackItera(int[] weights, int[] values, int n, int maxWeight){
		int[][] dp = new int[n + 1][maxWeight + 1];

		for(int i=dp.length-2; i>=0; i--){
			for(int j = 0; j<dp[0].length; j++){
				if(weights[i] <= j){
					// include
					int ans1 = values[i] + dp[i+1][j - weights[i]];
					// exclude
					int ans2 = dp[i+1][j];

					dp[i][j] = Math.max(ans1, ans2);
				}else{
					dp[i][j] = dp[i+1][j];
				}
			}
		}

		return dp[0][maxWeight];
	}

	// Memoization
	public static int knapsackMemo(int[] weights, int[] values, int n, int maxWeight, int idx, int[][] dp){
		if(idx == n){
			return 0;
		}

		if(dp[idx][maxWeight] != 0){
			return dp[idx][maxWeight];
		}

		int ans;
		if(weights[idx] <= maxWeight){
			// include
			int ans1 = values[idx] + knapsackMemo(weights, values, n, maxWeight-weights[idx], idx + 1, dp);

			// not include
			int ans2 = knapsackMemo(weights, values, n, maxWeight, idx + 1, dp);

			ans = Math.max(ans1, ans2);
		}else{
			ans = knapsackMemo(weights, values, n, maxWeight, idx + 1, dp);
		}

		dp[idx][maxWeight] = ans;

		return dp[idx][maxWeight];
	}

	// Recursive
	public static int knapsackRecur(int[] weights, int[] values, int n, int maxWeight, int idx){
		if(idx == n){
			return 0;
		}

		if(weights[idx] <= maxWeight){
			// include
			int ans1 = values[idx] + knapsackRecur(weights, values, n, maxWeight-weights[idx], idx + 1);

			// not include
			int ans2 = knapsackRecur(weights, values, n, maxWeight, idx + 1);

			return Math.max(ans1, ans2);
		}else{
			return knapsackRecur(weights, values, n, maxWeight, idx + 1);
		}
	}
	
}
