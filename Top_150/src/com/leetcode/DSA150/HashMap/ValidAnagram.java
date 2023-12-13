package com.leetcode.DSA150.HashMap;

public class ValidAnagram {

	public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] count = new int[26];

        for (char c : s.toCharArray())
            ++count[c - 'a'];

        for (char c : t.toCharArray()) {
            if (count[c - 'a'] == 0)
                return false;
            --count[c - 'a'];
        }

        return true;
    }
	
	public static void main(String[] args) {
		String s = "anagram", t = "nagaram";
		System.out.println(isAnagram(s, t));

	}

}
