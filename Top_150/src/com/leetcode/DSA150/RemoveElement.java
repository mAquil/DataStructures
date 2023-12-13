package com.leetcode.DSA150;

import java.util.Arrays;

public class RemoveElement {

	/*public static int removeElement(int[] nums, int val) {
		
		int k = 0;
        for (int x : nums) {
            if (x != val) {
                nums[k++] = x;
            }
        }
        System.out.println(Arrays.toString(nums));
        //OUTPUT [2, 1, 9, 6, 7, 0, 7, 0, 4]
        return k;
		
	} */
	
	public static int removeElement(int[] nums, int val) {
		int l=nums.length;
		int k=0,j=l-1,i=l-1;
		
		while(i>=0) {
			if(nums[i]==val) {
				int temp=nums[i];
				nums[i]=nums[j];
				nums[j]=temp;
				j--;
			}
			else
				k++;
			i--;
		}
		System.out.println(Arrays.toString(nums));
		return k;
	} 
	
	public static void main(String[] args) {
		int[] nums= {2,4,1,9,6,4,7,0,4};
		int val=4;
		
		System.out.println("k = "+removeElement(nums,val));

	}

}
