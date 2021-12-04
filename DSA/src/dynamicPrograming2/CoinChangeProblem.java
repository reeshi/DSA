/*
For the given infinite supply of coins of each of denominations, D = {D0, D1, D2, D3, ...... Dn-1}. 
You need to figure out the total number of ways W, in which you can make the change for Value V using coins of denominations D.
Return 0 if the change isn't possible.

Input Format
The first line of the input contains an integer value N, which denotes the total number of denominations.
The second line of input contains N values, separated by a single space. These values denote the value of denomination.
The third line of the input contains an integer value, that denotes the value of V.

Output Format
Print the total total number of ways i.e. W.

Constraints :
1 <= n <= 10
1 <= V <= 1000
Time Limit: 1sec

Sample Input 1 :
3
1 2 3
4
Sample Output 1 :
4
Explanation to Sample Input 1 :
Number of ways are - 4 total i.e. (1,1,1,1), (1,1, 2), (1, 3) and (2, 2).

Sample Input 2 :
6
1 2 3 4 5 6
250
Sample Output 2 :
13868903
*/
package dynamicPrograming2;

public class CoinChangeProblem {

	public static int countWaysToMakeChange(int denominations[], int value){
		// int[][] dp = new int[denominations.length + 1][value + 1];
		// return countWaysToMakeChangeMemo(denominations, value, 0, dp);
		return countWaysToMakeChangeItera(denominations, value);
	}

	//Iteravtive.
	public static int countWaysToMakeChangeItera(int[] denominations, int value){
		int[][] dp = new int[denominations.length + 1][value + 1];

		for(int i=dp.length-2; i>=0; i--){
			for(int j=0; j<dp[0].length; j++){
				//first column
				if(j == 0){
					dp[i][j] = 1;
				}else{
					if(j - denominations[i] >= 0){
						// addition of both inlcude and exclude.
						dp[i][j] = dp[i][j-denominations[i]] + dp[i+1][j];
					}else{
						dp[i][j] = dp[i+1][j];
					}
				}
			}
		}

		return dp[0][value];
	}

	//Memoiztion
	public static int countWaysToMakeChangeMemo(int[] denominations, int value, int idx, int[][] dp){

		if(value < 0){
			return 0;
		}

		if(idx == denominations.length){
			return 0;
		}

		if(value == 0){
			return 1;
		}

		if(dp[idx][value] != 0){
			return dp[idx][value];
		}

		// include
		int ans1 = countWaysToMakeChangeMemo(denominations, value - denominations[idx], idx, dp);

		// exclude
		int ans2 = countWaysToMakeChangeMemo(denominations, value, idx + 1, dp);

		dp[idx][value] = ans1 + ans2;

		return dp[idx][value];

	}

	//Recursion.
	public static int countWaysToMakeChangeRecur(int[] denominations, int value, int idx){

		if(value < 0){
			return 0;
		}

		if(idx == denominations.length){
			return 0;
		}

		if(value == 0){
			return 1;
		}

		// include
		int ans1 = countWaysToMakeChangeRecur(denominations, value - denominations[idx], idx);

		// exclude
		int ans2 = countWaysToMakeChangeRecur(denominations, value, idx + 1);

		return ans1 + ans2;
	}

}
