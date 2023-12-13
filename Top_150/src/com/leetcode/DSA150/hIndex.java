package com.leetcode.DSA150;

import java.util.Arrays;

public class hIndex {

//	public static int get_h_Index(int[] citations) {
//	       int n = citations.length;
//	       Arrays.sort(citations);
//	       for(int i =0; i <n; i++){
//	           if(citations[i] >= n-i) {
//	        	   System.out.println("n: "+n + " , i= "+ i);
//	               return n-i;
//	           }
//	       }
//	       return 0;
//	   }

	
	public static int get_h_Index(int[] citations) {
	    final int n = citations.length;
	    int accumulate = 0;
	    int[] count = new int[n + 1];
	    
	    for (final int citation : citations)
	      ++count[Math.min(citation, n)];

	    System.out.println(Arrays.toString(count));
	    // To find the largest h-index, loop from back to front
	    // I is the candidate h-index
	    for (int i = n; i >= 0; --i) {
	      accumulate += count[i];
	      if (accumulate >= i)
	        return i;
	    }

	    throw new IllegalArgumentException();
	  }
	
	
	public static void main(String[] args) {
		int[] citations = {3,0,6,1,5,3};
		System.out.println("The h-index is: "+ get_h_Index(citations));

	}

}
