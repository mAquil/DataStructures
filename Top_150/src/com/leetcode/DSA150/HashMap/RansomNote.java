package com.leetcode.DSA150.HashMap;

public class RansomNote {

	
	  public static boolean canConstruct(String ransomNote, String magazine) {
	        int[] map = new int[26];

	        for(char c : magazine.toCharArray()){
	            map[c-'a']++;
	        }

	        for(char c : ransomNote.toCharArray()){
	            if(map[c-'a'] == 0){
	                return false;
	            }
	            map[c-'a']--;
	        }

	        return true;   
	    }
	
	public static void main(String[] args) {
		String ransomNote = "aa", magazine = "aab";
		System.out.println(canConstruct(ransomNote, magazine));
	}

}
