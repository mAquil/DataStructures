package com.leetcode.DSA150.SlidingWindow;

public class LongestSubstringWithoutRepeatingCharacters {

	public static int lengthOfLongestSubstring(String s) {
        int n =s.length();
        int[] count = new int[256];
        int left =0;
        int right =0;
        int ans =0;

        while(right<n){
            count[s.charAt(right)]++;
            while(count[s.charAt(right)] > 1){
                count[s.charAt(left)]--;
                left++;
            }
            ans = Math.max(ans,right-left+1);
            right++;
        }
        return ans;
    }
	
	public static void main(String[] args) {
		String s = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(s));

	}

}
