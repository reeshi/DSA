/*Afzal has been working with an organization called 'Money Traders' for the past few years.
 *The organization is into the money trading business.
 *His manager assigned him a task.
 *For a given array/list of stock's prices for N days, find the stock's span for each day.
 *
 *The span of the stock's price today is defined 
 *as the maximum number of consecutive days(starting from today and going backwards)
 *for which the price of the stock was less than today's price.
 *
 *For example, if the price of a stock over a period of 7 days are [100, 80, 60, 70, 60, 75, 85],
 *then the stock spans will be [1, 1, 1, 2, 1, 4, 6].
 * */
package stackAssigment;

import java.util.Stack;

public class StockSpan {

	public static void main(String[] args) {
		
		int[] arr = {60, 70, 80, 100, 90, 75, 80, 120};
		
		int[] res = stockSpan(arr);
		
		for(int i: res) {
			System.out.print(i + " ");
		}

	}
	// Next greater element to the left.
	public static int[] stockSpan(int[] price) {
		int[] span = new int[price.length];

		Stack<Integer> st = new Stack<>();
		st.push(0);
		span[0] = 1;

		for(int i=1; i<price.length; i++){
			while(st.size() > 0 && price[i] > price[st.peek()]){
				st.pop();
			}

			if(st.isEmpty()){
				span[i] = i + 1;
			}else{
				span[i] = i - st.peek();
			}

			st.push(i);
		}

		return span;
	}

}
