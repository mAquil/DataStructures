package com.leetcode.DSA150.Array_String;

public class ReverseWordsInString {

	
	//Solution 1 : using split function 
	public static String reverseWords(String s) {
        String[] splitted = s.split(" +");
        StringBuilder sb = new StringBuilder();
        for (int i = splitted.length - 1; i >= 0; i--) {
            sb.append(splitted[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
	
	
	// Solution 2: Picking each word and appending in front of the stringbuilder
	public static String reverseWords1(String s) {
		s= s.trim();
        int n = s.length(), i=0;
        StringBuilder result = new StringBuilder();

	    while(i<n){
	        while(i<n && s.charAt(i) == ' '){
	            i++;
	        }
	        
	        int j = i+1;
	        while(j<n && s.charAt(j) != ' '){
	            j++;
	        }
	        StringBuilder word = new StringBuilder(s.substring(i,j));
	        word.append(" ");
	        result = word.append(result);
	        i = j+1;;
	    }
	    return result.toString().trim();
    }
	
	// Solution 3: Reverse each word and then reverse the whole string
	public static String reverseWords2(String s) {
		s=s.trim();
		StringBuilder result = new StringBuilder();
		int n = s.length(), i=0;
		
		while(i<n){
	        while(i<n && s.charAt(i) == ' '){
	            i++;
	        }
	        
	        int j = i+1;
	        while(j<n && s.charAt(j) != ' '){
	            j++;
	        }
	        StringBuilder word = new StringBuilder(s.substring(i,j));
	        word.reverse();
	        word.append(" ");
	        result = result.append(word);
	        i = j+1;;
	    }
		
		return result.reverse().toString().trim();
	}
	
	
	// Solution 4 : Best sol, Taking least time. Traversing words from the end.
	public static String reverseWords3(String s) {
		s = s.trim();
        if(s.length() < 2){
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int endPointer = getNewWordEnding(s, s.length()-1);
        int i = getNewWordStarting(s, endPointer);
        while( i > 0 && endPointer > 0){
            sb.append(s, i, endPointer + 1);
            endPointer = getNewWordEnding(s, i);
            i = getNewWordStarting(s, endPointer);
        }

        sb.append(" ");
        sb.append(s.substring(i, endPointer + 1));
        return sb.toString().trim();
	}
	
	// Supporting function for solution 4
	public static int getNewWordEnding(String s, int index){
        while(index > 0 && s.charAt(index) == ' '){
            index--;
        }
        return index;
    }

	// Supporting function for solution 4
    public static int getNewWordStarting(String s, int index){
        while(index > 0 && s.charAt(index) != ' '){
            index--;
        }
        return index;
    }
	
	
	public static void main(String[] args) {
		String s = "the sky is blue";
		System.out.println(reverseWords(s));
		System.out.println(reverseWords1(s));
		System.out.println(reverseWords2(s));
		System.out.println(reverseWords3(s));
	}

}
