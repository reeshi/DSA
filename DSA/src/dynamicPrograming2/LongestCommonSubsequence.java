/*
Given two strings, S and T with lengths M and N, find the length of the 'Longest Common Subsequence'.
For a string 'str'(per se) of length K, the subsequences are strings containing characters in the same relative order as they are present in 'str,' but not necessarily contiguous.
Subsequences contain all the strings of length varying from 0 to K.
Example : Subsequences of string "abc" are:  ""(empty string), a, b, c, ab, bc, ac, abc.

Input format :
The first line of input contains the string S of length M.
The second line of the input contains the String T of length N.

Output format :
Print the length of the 'Longest Common Subsequence'.

Constraints :
0 <= M <= 10 ^ 3
0 <= N <= 10 ^ 3
Time Limit: 1sec

Sample Input 1 :
adebc
dcadb
Sample Output 1 :
3
Explanation of the Sample Input 1 :
Both the strings contain a common subsequence 'adb', which is the longest common subsequence with length 3. 

Sample Input 2 :
ab
defg
Sample Output 2 :
0
Explanation of the Sample Input 2 :
The only subsequence that is common to both the given strings is an empty string("") of length 0.
*/
package dynamicPrograming2;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "adebc";
		String str2 = "dcadb";
		
		System.out.println("Recursion " + longestCommonSubsequenceRecur(str1, 0, str2, 0));
		
		int[][] dp = new int[str1.length()][str2.length()];
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++) {
				dp[i][j] = -1;
			}
		}
		
		System.out.println("Memoization " + longestCommonSubsequenceMemo(str1, 0, str2, 0, dp));
		
		System.out.println("Iterative " + longestCommonSubsequenceItera(str1, str2));
	}
	
	// Iterative
	public static int longestCommonSubsequenceItera(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();
		
		int[][] dp = new int[m+1][n+1];
		
		for(int i=m-1; i>=0; i--) {
			for(int j=n-1; j>=0; j--) {
				int ans;
				if(str1.charAt(i) == str2.charAt(j)) {
					ans = 1 + dp[i+1][j+1];
				}else {
					ans = Math.max(dp[i+1][j], dp[i][j+1]);
				}
				
				dp[i][j] = ans;
			}
		}
		
		return dp[0][0];
	}
	
	// Memoization.
	public static int longestCommonSubsequenceMemo(String str1, int i, String str2, int j, int[][] dp) {
		if(i == str1.length() || j == str2.length()) {
			return 0;
		}
		
		if(dp[i][j] != -1) {
			return dp[i][j];
		}
		
		int myAns;
		if(str1.charAt(i) == str2.charAt(j)) {
			myAns = 1 + longestCommonSubsequenceMemo(str1, i+1, str2, j+1, dp);
		}else {
			int ans1 = longestCommonSubsequenceMemo(str1, i+1, str2, j, dp);
			int ans2 = longestCommonSubsequenceMemo(str1, i, str2, j+1, dp);
			
			myAns = Math.max(ans1, ans2);
		}
		
		// store
		dp[i][j] = myAns;
		
		return dp[i][j];
	}
	
	// Recursive
	public static int longestCommonSubsequenceRecur(String str1, int i, String str2, int j) {
		if(i == str1.length() || j == str2.length()) {
			return 0;
		}
		
		if(str1.charAt(i) == str2.charAt(j)) {
			return 1 + longestCommonSubsequenceRecur(str1, i+1, str2, j+1);
		}else {
			int ans1 = longestCommonSubsequenceRecur(str1, i+1, str2, j);
			int ans2 = longestCommonSubsequenceRecur(str1, i, str2, j+1);
			
			return Math.max(ans1, ans2);
		}
	}

}
