package com.leetcode.DSA150;

public class BuyAndSellStocks {

//	public static int maxProfit(int[] prices) {
//	    int min = prices[0];
//	    int profit=0;
//	    
//	    for(int i =1; i<prices.length; i++) {
//	    	int diff = prices[i]-min;
//	    	profit= Math.max(profit, diff);
//	    	min = Math.min(min, prices[i]);
//	    }
//	    return profit;
//	  }
	
	public static int maxProfit(int[] prices) {
	    int profit = 0;
	    int hold = Integer.MIN_VALUE;

	    for (final int price : prices) {
	      profit = Math.max(profit, hold + price);
	      hold = Math.max(hold, -price);
	    }

	    return profit;
	  }
	
	public static void main(String[] args) {
		int[] arr= {7,1,5,3,6,10};
		
		System.out.println("Max Profit: "+ maxProfit(arr));
	}

}
