package com.leetcode.DSA150.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {

	public static List<Integer> findSubstring(String s, String[] words) {
		if (s.isEmpty() || words.length == 0)
		      return new ArrayList<>();

	    Map<String, Integer> count = new HashMap<>();

	    for (String word : words)
	      count.put(word, count.getOrDefault(word, 0)+1);
	    
		System.out.println(count);
		
	    List<Integer> ans = new ArrayList<>();
		int len = words.length;
		int sLen = words[0].length();
		int n = s.length();
		   
		for (int i = 0; i <= n - len * sLen; i++) {
			String substr = s.substring(i, i+sLen*len);
			Map<String, Integer> seen = new HashMap<>();
			   
			for (int j=0; j < substr.length(); j+=sLen) {
			     String word = substr.substring(j, j+sLen);
			     seen.put(word, seen.getOrDefault(word, 0)+1);
			}
			if (seen.equals(count))
			   ans.add(i);
			}

		return ans;		
	}
	
	public static void main(String[] args) {
		String s = "wordgoodgoodgoodbestword";
		String[] words = {"word","good","best","word"};
//		String s = "barfoofoobarthefoobarman";
//		String[] words = {"bar","foo","the"};
//		String s = "barfoothefoobarman";
//		String[] words = {"foo","bar"};
		System.out.println(findSubstring(s, words));

	}

}
