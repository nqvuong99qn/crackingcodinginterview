package javaPractice;



public class BestTimeToBuySellStock {

	int maxProfit(int[] prices) {
		int result = 0;
		int temp;
		for(int i = 1; i < prices.length; i++) {
			temp = prices[i-1];
			while(prices[i] > prices[i-1]) {
				i++;
				if(i >= prices.length) {
					return result + prices[i-1] - temp;
				}
			}
			result += prices[i-1] - temp;
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		System.out.println("Say hi!!!!");
		


		BestTimeToBuySellStock solution = new BestTimeToBuySellStock();
		// init data
		int[] arr = new int[7];
		arr[0] = 1;
		arr[1] = 6;
		arr[2] = 2;
		arr[3] = 4;
		arr[4] = 5;
		arr[5] = 6;
		arr[6] = 7;

		System.out.println("Expected: " + solution.maxProfit(arr));
	}

}
