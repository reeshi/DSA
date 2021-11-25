/*
Byteland has a very strange monetary system. Each Bytelandian gold coin has an integer number written on it.
A coin n can be exchanged in a bank into three coins: n/2, n/3 and n/4. But these numbers are all rounded down (the banks have to make a profit).
You can also sell Bytelandian coins for American dollars. The exchange rate is 1:1. But you can not buy Bytelandian coins.
You have one gold coin. What is the maximum amount of American dollars you can get for it?

Input format :
The first and the only line of input contains a the integer value of 'n'. It is the number written on your coin.

Output format :
Print the the maximum amount of American dollars you can make.

Constraints :
0 <= n <= 10 ^ 9
Time Limit: 1 sec

Sample Input 1 :
12
Sample Output 1 :
13
Explanation of Sample Output 1 :
You can change 12 into 6, 4 and 3, and then change these into $6 + $4 + $3 = $13.

Sample Input 2 :
2
Sample Output 1 :
2
Explanation of Sample Output 2 :
If you try changing the coin 2 into 3 smaller coins, you will get 1, 0 and 0, and later you can get no more than $1 out of them. 
It is better just to change the 2 coin directly into $2.
*/

package dynamicPrograming1;

import java.util.HashMap;

public class ByteLandian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(byteLandianMemo(2, new HashMap<Long, Long>()));
		System.out.println(byteLandianIter(12));
	}
	
	//Iterative.
	public static long byteLandianIter(long n) {
		HashMap<Long, Long> dp = new HashMap<>();
		dp.put(0L, 0L);
		
		for(long i=1; i<=n; i++) {
			long exchange = dp.get(i/2) + dp.get(i/3) + dp.get(i/4);
			dp.put(i, Math.max(i, exchange));
		}
		
		return dp.get(n);
	}
	
	// Memoization.
	public static long byteLandianMemo(long n, HashMap<Long, Long> memo) {
		// base Case
		if(n == 0) {
			return 0;
		}
		
		long ans1, ans2, ans3;
		if(!memo.containsKey(n/2)) {
			ans1 = byteLandianMemo(n/2, memo);
			memo.put(n/2, ans1);
		}else {
			ans1 = memo.get(n/2);
		}
		
		if(!memo.containsKey(n/3)) {
			ans2 = byteLandianMemo(n/3, memo);
			memo.put(n/3, ans2);
		}else {
			ans2 = memo.get(n/3);
		}
		
		if(!memo.containsKey(n/4)) {
			ans3 = byteLandianMemo(n/4, memo);
		}else {
			ans3 = memo.get(n/4);
		}
		
		return Math.max(n, ans1+ans2+ans3);
	}
	
	// Recursive 
	public static long byteLandian(int n) {
		if(n == 0) {
			return 0;
		}
		
		long ans1 = byteLandian(n/2);
		long ans2 = byteLandian(n/3);
		long ans3 = byteLandian(n/4);
		
		return Math.max(n, ans1+ans2+ans3);
	}

}
