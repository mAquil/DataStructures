package com.leetcode.DSA150.Array_String;

public class LongestCommonPrefix {

	public static String longestCommonPrefix(String[] strs) {
	    if (strs.length == 0)
	      return "";

	    for (int i = 0; i < strs[0].length(); ++i)
	      for (int j = 1; j < strs.length; ++j)
	        if (i == strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i))
	          return strs[0].substring(0, i);

	    return strs[0];
	  }
	
	public static void main(String[] args) {
		//String[] strs = {"dog","racecar","car"};
		String[] strs = {"flower","flow","flight"};
		System.out.println(longestCommonPrefix(strs));
		
	}

} 