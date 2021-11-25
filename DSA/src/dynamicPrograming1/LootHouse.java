package dynamicPrograming1;

public class LootHouse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] houses = {5,5,10,100,10,5};
		//		System.out.println(lootHouseRecursive(houses, 0));

		int[] dp = new int[houses.length];
		for(int i=0; i<dp.length; i++) { 
			dp[i] = -1;
		}

		System.out.println(lootHouseMemo(houses, 0, dp));
		
		System.out.println(lootHouseItera(houses));
	}

	// Iterative.
	public static int lootHouseItera(int[] houses) {
		if(houses.length == 0) {
			return 0;
		}
		
		if(houses.length == 1) {
			return houses[0];
		}
		
		int[] dp = new int[houses.length];
		dp[0] = houses[0];
		dp[1] = Math.max(houses[0], houses[1]);                                 

		for(int i=2; i<houses.length; i++) {
			
			//For every house, we consider two cases
			//Case 1 - Current house is counted as part of the max value => This means the previous house cannot be counted
			int maxVal1=dp[i-2]+houses[i];

			//Case 2 - Current house is not counted as part of the max value => This means previous house can be counted
			int maxVal2=dp[i-1];

			//Max value till current house is maximum of the two possible max values till now
			dp[i]=Math.max(maxVal1,maxVal2);
			
		}

		return dp[houses.length-1];
	}

	// Memoization.
	public static int lootHouseMemo(int[] houses, int idx, int[] dp) {
		if(idx >= houses.length) {
			return 0;
		}

		if(dp[idx] != -1) {
			return dp[idx];
		}

		// Include
		int ans1 = houses[idx] + lootHouseRecursive(houses, idx + 2);

		// Not include.
		int ans2 = lootHouseRecursive(houses, idx + 1);

		dp[idx] = Math.max(ans1, ans2);

		return dp[idx];

	}

	//Recursive
	public static int lootHouseRecursive(int[] houses, int idx) {
		if(idx >= houses.length) {
			return 0;
		}

		// Include
		int ans1 = houses[idx] + lootHouseRecursive(houses, idx + 2);

		// Not include.
		int ans2 = lootHouseRecursive(houses, idx + 1); 

		return Math.max(ans1, ans2);
	}

}
