package com.leetcode.DSA150.HashMap;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	
	public static int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n<2)
            return n;
        
        int count =0;
        Set<Integer> set=new HashSet<>();
        for(int i=0; i<n; i++)
            set.add(nums[i]);
        
        for(int num:nums){
            if(!set.contains(num-1)){
                int length=1;
                while(set.contains(++num)){
                    length++;
                }
                count = Math.max(count, length);
            }
        }
        return count;
    }
	
	public static void main(String[] args) {
		int[] nums = {100,4,200,1,3,2};
		System.out.println(longestConsecutive(nums));

	}

}
