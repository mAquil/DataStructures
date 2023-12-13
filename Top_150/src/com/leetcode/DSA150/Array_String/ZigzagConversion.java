package com.leetcode.DSA150.Array_String;

public class ZigzagConversion {

	//Solution 1 : taking different rows as StringBuilders and building the zigzag string
	public static String convert(String s, int numRows) {
		
		if(numRows == 1)
			return s;
		
		StringBuilder[] sbs = new StringBuilder[numRows];
		for(int i=0; i<sbs.length; i++) {
			sbs[i] = new StringBuilder();
		}
		
		int row = 0, dir = 0;
		for(int i =0; i<s.length(); i++) {
			char c = s.charAt(i);
			row +=dir;
			sbs[row].append(c);
			
			if(row == 0 || row == numRows-1)
				dir = (dir==0 ? 1:-dir);
		}
		return convert(sbs);
	}
	
	//Solution 1 supporting function
	public static String convert(StringBuilder[] sbs) {
		StringBuilder result = new StringBuilder();
		for(StringBuilder sb : sbs) {
			result.append(sb.toString());
		}
		return result.toString();
	}
	
	
	
	//Solution 2 : Building the zigzag character array at once
	public static String convert1(String s, int numRows) {
		if(numRows==1)
			return s;
			
		int n = s.length();
		char[] result = new char[n];
		int step = numRows*2-2;
		int substep = step;
		int index = 0;
		int row = 0;
		
		for(int i =0; i<n; i++) {
			result[i] = s.charAt(index);
			
			if(substep>0 && substep<step && index + substep < n) {
				result[++i] = s.charAt(index + substep);
			}
			
			index += step;
			if(index>=n) {
				index = ++row;
				substep -= 2;
			}
			
		}
		return new String(result);
	}
	
	
	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		int numRows = 3;		
		System.out.println(convert(s, numRows));
		System.out.println(convert1(s, numRows));
	}

}
