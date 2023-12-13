package com.leetcode.DSA150;

public class JumpGame {

	public static boolean canJump(int[] nums) {
	       int n= nums.length;
	       int reachable = 0;


	       for(int i =0; i<n; i++){
	           if(reachable < i)
	               return false;
	           reachable = Math.max(reachable,i+nums[i]);
	       }
	       System.out.println(reachable);
	       return true;
	   }
	
	public static void main(String[] args) {
		int nums[] = {2,3,1,1,4};
		
		System.out.println(canJump(nums));
	}

}
