/*
An integer matrix of size (M x N) has been given. Find out the minimum cost to reach from the cell (0, 0) to (M - 1, N - 1).
From a cell (i, j), you can move in three directions:
1. ((i + 1),  j) which is, "down"
2. (i, (j + 1)) which is, "to the right"
3. ((i+1), (j+1)) which is, "to the diagonal"
The cost of a path is defined as the sum of each cell's values through which the route passes.

Input format :
The first line of the test case contains two integer values, 'M' and 'N', separated by a single space. 
They represent the 'rows' and 'columns' respectively, for the two-dimensional array/list.
The second line onwards, the next 'M' lines or rows represent the ith row values.
Each of the ith row constitutes 'N' column values separated by a single space.

Output format :
Print the minimum cost to reach the destination.

Constraints :
1 <= M <= 10 ^ 2
1 <= N <=  10 ^ 2
Time Limit: 1 sec

Sample Input 1 :
3 4
3 4 1 2
2 1 8 9
4 7 8 1
Sample Output 1 :
13

Sample Input 2 :
3 4
10 6 9 0
-23 8 9 90
-200 0 89 200
Sample Output 2 :
76

Sample Input 3 :
5 6
9 6 0 12 90 1
2 7 8 5 78 6
1 6 0 5 10 -4 
9 6 2 -10 7 4
10 -2 0 5 5 7
Sample Output 3 :
18
*/
package dynamicPrograming2;

public class MinCostPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input = {{1,5,11},{8,13,12},{2,3,7},{15,16,18}};
		System.out.println("Recusion " + minCostPathRecur(input, 0, 0));
		
		int[][] dp = new int[input.length][input[0].length];
		System.out.println("Memoization " + minCostPathMemo(input, 0, 0, dp));
		
		System.out.println("Iterative " + minCostPathItera(input));
	}
	
	//Iterative.
	public static int minCostPathItera(int[][] input) {
		int[][] dp = new int[input.length][input[0].length];
		int n = input.length;
		int m = input[0].length;
		
		for(int i=n-1; i>=0; i--) {
			for(int j=m-1; j>=0; j--) {
				//Destination
				if(i == n-1 && j == m-1) {
					dp[i][j] = input[i][j];
				}else if(i == n-1) {
					// last row
					dp[i][j] = input[i][j] + dp[i][j+1];
				}else if(j == m-1) {
					// last column
					dp[i][j] = input[i][j] + dp[i+1][j];
				}else {
					dp[i][j] = input[i][j] + Math.min(dp[i][j+1], Math.min(dp[i+1][j], dp[i+1][j+1]));
				}
			}
		}
		
		return dp[0][0];
	}
	
    // Memoization.
    public static int minCostPathMemo(int[][] input, int i, int j, int[][] dp){
        // -ve base case
        if(i >= input.length || j >= input[0].length){
            return Integer.MAX_VALUE;
        }

        //+ve base case
        if(i == input.length-1 && j == input[0].length-1){
            return input[i][j];
        }
        
        if(dp[i][j] != 0){
            return dp[i][j];
        }

        // down
        int cost1 = minCostPathMemo(input, i+1, j, dp);
        // right
        int cost2 = minCostPathMemo(input, i, j+1, dp);
        // diagonal
        int cost3 = minCostPathMemo(input, i+1, j+1, dp);

        dp[i][j] = input[i][j] + Math.min(cost1, Math.min(cost2, cost3));

        return dp[i][j];

    }

	// Recursion.
	public static int minCostPathRecur(int[][] input, int i, int j){
		// -ve base case
		if(i >= input.length || j >= input[0].length){
			return Integer.MAX_VALUE;
		}

		//+ve base case
		if(i == input.length-1 && j == input[0].length-1){
			return input[i][j];
		}

		// down
		int cost1 = minCostPathRecur(input, i+1, j);
		// right
		int cost2 = minCostPathRecur(input, i, j+1);
		// diagonal
		int cost3 = minCostPathRecur(input, i+1, j+1);

		int minCost = input[i][j] + Math.min(cost1, Math.min(cost2, cost3));

		return minCost;

	}

}
