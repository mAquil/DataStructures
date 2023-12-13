package com.leetcode.DSA150;

import java.util.Arrays;

public class KeepDuplicatesSortedArray {

	 public static int removeDuplicates(int[] nums) {
		    int i = 0;

		    for (final int num : nums)
		      if (i < 2 || num > nums[i - 2])
		        nums[i++] = num;

		    System.out.println(Arrays.toString(nums));
		    return i;
		  }
	
	public static void main(String[] args) {

		int arr[] = { 1, 1, 1, 2,
                2, 2, 3, 3,
                3, 3, 3, 3,
                4, 5 };


  // Function call
  System.out.println(removeDuplicates(arr));

	}

}
