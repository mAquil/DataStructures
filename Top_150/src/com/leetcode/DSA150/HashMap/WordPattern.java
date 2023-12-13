package com.leetcode.DSA150.HashMap;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

	
	public static boolean wordPattern(String pattern, String s) {
	    String[] words = s.split(" ");
	    int n = words.length;
	    int m= pattern.length();

	    if (n != m)
	      return false;

	    Map<Character, Integer> charToIndex = new HashMap<>();
	    Map<String, Integer> stringToIndex = new HashMap<>();

	    for (Integer i = 0; i < m; i++)
	      if (charToIndex.put(pattern.charAt(i), i) != stringToIndex.put(words[i], i))
	        return false;

	    return true;
	    }
	
	public static void main(String[] args) {
		String pattern = "abba", s = "dog cat cat dog";
		System.out.println(wordPattern(pattern, s));

	}

}
