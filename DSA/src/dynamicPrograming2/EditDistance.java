/*
You are given two strings S and T of lengths M and N, respectively. Find the 'Edit Distance' between the strings.
Edit Distance of two strings is the minimum number of steps required to make one string equal to the other. In order to do so, you can perform the following three operations:
1. Delete a character
2. Replace a character with another one
3. Insert a character
Note : Strings don't contain spaces in between.

Input format :
The first line of input contains the string S of length M.
The second line of the input contains the String T of length N.

Output format :
Print the minimum 'Edit Distance' between the strings.

Constraints :
0 <= M <= 10 ^ 3
0 <= N <= 10 ^ 3
Time Limit: 1 sec

Sample Input 1 :
abc
dc
Sample Output 1 :
2
Explanation to the Sample Input 1 :
In 2 operations we can make string T to look like string S.
First, insert character 'a' to string T, which makes it "adc".
And secondly, replace the character 'd' of string T with 'b' from the string S. This would make string T as "abc" which is also string S. 
Hence, the minimum distance.

Sample Input 2 :
whgtdwhgtdg
aswcfg
Sample Output 2 :
9
 */
package dynamicPrograming2;

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//Iterative.
	public static int editDistanceItera(String s, String t){
		int[][] dp = new int[s.length() + 1][t.length() + 1];

		for(int j=0; j<dp[0].length; j++){
			dp[dp.length-1][j] = t.length() - j;
		}

		for(int i=0; i<dp.length; i++){
			dp[i][dp[0].length-1] = s.length() - i;
		}

		for(int i=dp.length-2; i>=0; i--){
			for(int j=dp[0].length-2; j>=0; j--){
				if(s.charAt(i) == t.charAt(j)){
					dp[i][j] = dp[i+1][j+1];
				}else{
					// delete
					int ans1 = 1 + dp[i+1][j];
					// replace
					int ans2 = 1 + dp[i+1][j+1];
					// insert
					int ans3 = 1 + dp[i][j+1];

					dp[i][j] = Math.min(ans1, Math.min(ans2, ans3));
				}
			}
		}

		return dp[0][0];
	}

	// Memoization.
	public static int editDistanceMemo(String s, int i, String t, int j, int[][] dp){
		if(i == s.length()){
			return t.length()-j;
		}
		if(j == t.length()){
			return s.length()-i;
		}

		if(dp[i][j] != 0){
			return dp[i][j];
		}

		int ans;
		if(s.charAt(i) == t.charAt(j)){
			ans = editDistanceMemo(s, i+1, t, j+1, dp);
		}else{
			// delete
			int ans1 = 1 + editDistanceMemo(s, i+1, t, j, dp);

			// replace
			int ans2 = 1 + editDistanceMemo(s, i+1, t, j+1, dp);

			// insert
			int ans3 = 1 + editDistanceMemo(s, i, t, j+1, dp);

			ans = Math.min(ans1, Math.min(ans2, ans3));
		}

		dp[i][j] = ans;

		return dp[i][j];

	}

	// Recursive.
	public static int editDistanceRecur(String s, int i, String t, int j){
		if(i == s.length()){
			return t.length()-j;
		}
		if(j == t.length()){
			return s.length()-i;
		}

		if(s.charAt(i) == t.charAt(j)){
			return editDistanceRecur(s, i+1, t, j+1);
		}else{
			// delete
			int ans1 = 1 + editDistanceRecur(s, i+1, t, j);

			// replace
			int ans2 = 1 + editDistanceRecur(s, i+1, t, j+1);

			// insert
			int ans3 = 1 + editDistanceRecur(s, i, t, j+1);

			int myAns = Math.min(ans1, Math.min(ans2, ans3));

			return myAns;
		}

	}

}
