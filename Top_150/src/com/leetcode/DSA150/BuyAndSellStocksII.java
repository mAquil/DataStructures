package com.leetcode.DSA150;

public class BuyAndSellStocksII {

	public static int maxProfit(int[] prices) {
	    int sell = 0;
	    int hold = Integer.MIN_VALUE;

	    for (final int price : prices) {
	      sell = Math.max(sell, hold + price);
	      hold = Math.max(hold, sell - price);
	    }

	    return sell;
	  }
	
	public static void main(String[] args) {
		
		int[] arr= {7,1,5,3,6,4};
		System.out.println("Max Profit: "+ maxProfit(arr));	}

}
