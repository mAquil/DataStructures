package com.leetcode.DSA150.TwoPointers;

public class ContainerWithMostWater {

	 public static int maxArea(int[] height) {
		 int left=0, right=height.length-1;
		 int ans =0;
		 
		 while(left<right) {
			 int min = Math.min(height[left], height[right]);
			 ans = Math.max(ans, min*(right-left));
			 if(height[left]<height[right])
				 left++;
			 else
				 right--;
		 }
		 return ans;
	 }
	
	public static void main(String[] args) {
		int[]  height = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(height));
	}

}
