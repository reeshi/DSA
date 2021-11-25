/*
Whis and Beerus are playing a new game today. They form a tower of N coins and make a move in alternate turns. Beerus plays first. 
In one step, the player can remove either 1, X, or Y coins from the tower. The person to make the last move wins the game. Can you find out who wins the game?

Input format :
The first and the only line of input contains three integer values separated by a single space. They denote the value of N, X and Y, respectively.

Output format :
Prints the name of the winner, either 'Whis' or 'Beerus' (Without the quotes).

Constraints :
1 <= N <= 10 ^ 6
2 <= X <= Y<= 50
Time Limit: 1 sec

Sample Input 1 :
4 2 3
Sample Output 1 :
Whis

Sample Input 2 :
10 2 4
Sample Output 2 :
Beerus
*/
package dynamicPrograming1;

public class CoinTower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		if(findWinner(4, 2, 3)) {
//			System.out.println("Beerus");
//		}else {
//			System.out.println("Whis");
//		}
	}
	
	// Iterative
	public static String findWinnerItera(int n, int x, int y) {
        
		int[] dp = new int[n+1];
        dp[0] = 0; // Beerus lose 
        dp[1] = 1; // WHis win    
            
        for(int i=2; i<=n; i++){
        	//Beerus wins if dp[i-1] or dp[i-x] or dp[i-y] is 0,
            if(dp[i-1] == 0){
                dp[i] = 1;
            }else if(i-x >= 0 && dp[i-x] == 0){
                dp[i] = 1;
            }else if(i-y >= 0 && dp[i-y] == 0){
                dp[i] = 1;
            }else{
                dp[i] = 0;
            }
            
        }
        
        if(dp[n] == 0){
            return "Whis";
        }else{
            return"Beerus";
        }
        
	}
	
	
	// Recursive
	public static boolean findWinner(int n, int x, int y) {
		if(n <= 0) {
			return false;
		}
		if(n == 1 || n == x || n == y ) {
			return true;
		}
		
		boolean ans1 = findWinner(n-1, x, y);
		if(!ans1) {
			return true;
		}
		boolean ans2 = findWinner(n-x, x, y);
		if(!ans2) {
			return true;
		}
		boolean ans3 = findWinner(n-y, x, y);
		if(!ans3) {
			return true;
		}
		
		return false;
		                                   
	}

}
