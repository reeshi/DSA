/*Given an integer N, find and return the count of minimum numbers, sum of whose squares is equal to N.
That is, if N is 4, then we can represent it as : {1^2 + 1^2 + 1^2 + 1^2} and {2^2}.
Output will be 1, as 1 is the minimum count of numbers required.
 * */
package recursion;

public class MinimumCount {

	public static void main(String[] args) {
		
		System.out.println(minCount(12));

	}
	
	public static int minCount(int n){
		if(n == 1){
            return 1;
        }else if(n == 0){
            return 0;
        }
        
        int min_count = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++){
            if(i * i <= n){
                int min_countOfRemN = 1 + minCount(n - i*i);
                min_count = Math.min(min_count, min_countOfRemN);
            }else{
                break;
            }
        }
        
        return min_count;
		
	}

}
