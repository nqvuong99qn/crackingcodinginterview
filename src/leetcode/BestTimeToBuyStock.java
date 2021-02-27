package leetcode;

public class BestTimeToBuyStock {
	
	
	int solution(int[] prices) {
		
		// check input
		if(prices.length == 0) {
			return 0;
		}
		
		// input okay
		int profit = 0;
		int minPrice = prices[0];
		for(int i = 1; i < prices.length; i++) {
			if(prices[i] > prices[i - 1]) {
				profit = Math.max(profit, prices[i] - minPrice);
			}
			else {
				minPrice = prices[i];
			}	
		}
		return profit;
	}	
	public static void main(String args[]) {
		
		System.out.println("say hi!!!");
		
		BestTimeToBuyStock test = new BestTimeToBuyStock();
		int[] prices = { 1, 3, 5, 3, 6};
		System.out.println("Expected Result: " + test.solution(prices));
		
		
		
		
		
		
	}

}
