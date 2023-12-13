package com.leetcode.DSA150.SlidingWindow;

public class MinimumSizeSubArraySum {

	//Brute force technique. Gives TLE in leetcode
	public static int minSubArrayLen(int target, int[] nums) {
        int sum =0, count =0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>=target) {
                count = 1;
                break;
            }
            sum = nums[i];
            for(int j=i+1; j<nums.length; j++){
                sum +=nums[j];
                if(sum>=target) {
                    count = count == 0 ? j-i+1 : Math.min(count,j-i+1);
                    break;
                }
            }

        }
        return count;
    }
	
	
	 public static int minSubArrayLen1(int target, int[] nums) {
	        int n = nums.length;
	        int left =0;
	        int right =0;
	        int sum =0;
	        int shortest = Integer.MAX_VALUE;

	        while(right<n){
	            sum += nums[right];
	            if(sum>=target){
	                while(sum>=target){
	                    sum -=nums[left];
	                    left++;
	                }  
	                shortest = Math.min(shortest, right-left +2); // +1 to grt correct size, +1 to go back to left index
	            }
	            right++;
	        }
	        return shortest == Integer.MAX_VALUE ? 0:shortest;
	    }
	 
	 
	public static void main(String[] args) {
		int target = 4;      //11;	7;
		int[] nums = {1,4,4};   //{1,1,1,1,1,1,1,1};	{2,3,1,2,4,3};
		System.out.println(minSubArrayLen(target, nums));
		System.out.println(minSubArrayLen1(target, nums));

	}

}
