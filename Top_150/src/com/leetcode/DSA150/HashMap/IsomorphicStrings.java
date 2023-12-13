package com.leetcode.DSA150.HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

	public static boolean isIsomorphic(String s, String t) {
	    Map<Character,Integer> charToIndex_s = new HashMap<>();
	    Map<Character, Integer> charToIndex_t = new HashMap<>();
	    
	    for(int i =0; i<s.length(); i++) {
	    	if(charToIndex_s.put(s.charAt(i), i) != charToIndex_t.put(t.charAt(i), i))
	    		return false;
	    }
		return true;
	}
	
	 public static boolean isIsomorphic1(String s, String t) {
	       // if(s.length() != t.length())
	       //     return false;
	       int[] sArray = new int[256];
	       int[] tArray = new int[256];
	       int n = s.length();


	       for(int i=0; i<n; i++) {
	           if(sArray[s.charAt(i)] != tArray[t.charAt(i)])
	               return false;  
	           sArray[s.charAt(i)] = i+1;
	           tArray[t.charAt(i)] = i+1;
	       }

	       return true;
	 }
	 
	
	public static void main(String[] args) {
		String s = "paper", t = "title";
		System.out.println(isIsomorphic(s,t));
		System.out.println(isIsomorphic1(s,t));
	}

}