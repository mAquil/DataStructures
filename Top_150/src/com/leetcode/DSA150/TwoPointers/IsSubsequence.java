package com.leetcode.DSA150.TwoPointers;

public class IsSubsequence {

	public static boolean isSubsequence(String s, String t) {
		if (s.isEmpty())
			return true;
		
		if(t.length()<s.length())
			return false;

		int i = 0;
		for (final char c : t.toCharArray())
	  	if (s.charAt(i) == c && ++i == s.length())
	    	return true;

		return false;
	  }

	
	public static void main(String[] args) {
		String s = "abc", t = "ahbgdc";
		System.out.println(isSubsequence(s,t));
	}

}
