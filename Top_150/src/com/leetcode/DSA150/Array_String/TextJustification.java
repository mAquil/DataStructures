package com.leetcode.DSA150.Array_String;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

	public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int startIndex = 0;

        while (startIndex < words.length) {
            int endIndex = findEndIndex(words, startIndex, maxWidth);
            result.add(justifyLine(words, startIndex, endIndex, maxWidth));
            startIndex = endIndex + 1;
        }

        return result;
    }

    private static int findEndIndex(String[] words, int startIndex, int maxWidth) {
        int endIndex = startIndex;
        int currentWidth = words[startIndex].length();

        while (endIndex + 1 < words.length && currentWidth + 1 + words[endIndex + 1].length() <= maxWidth) {
            endIndex++;
            currentWidth += 1 + words[endIndex].length();
        }

        return endIndex;
    }

    private static String justifyLine(String[] words, int startIndex, int endIndex, int maxWidth) {
        StringBuilder line = new StringBuilder();

        // If it's the last line or there is only one word in the line
        if (endIndex == words.length - 1 || endIndex == startIndex) {
            for (int i = startIndex; i <= endIndex; i++) {
                line.append(words[i]);
                if (i < endIndex) {
                    line.append(" ");
                }
            }
            // Add extra spaces to the right to reach maxWidth
            while (line.length() < maxWidth) {
                line.append(" ");
            }
        } else {
            int totalSpaces = maxWidth;
            for (int i = startIndex; i <= endIndex; i++) {
                totalSpaces -= words[i].length();
            }

            int spaceCount = endIndex - startIndex;
            int spacesBetweenWords = totalSpaces / spaceCount;
            int extraSpaces = totalSpaces % spaceCount;

            for (int i = startIndex; i <= endIndex; i++) {
                line.append(words[i]);
                if (i < endIndex) {
                    // Distribute spaces between words
                    for (int j = 0; j < spacesBetweenWords + (extraSpaces > 0 ? 1 : 0); j++) {
                        line.append(" ");
                    }
                    extraSpaces--;
                }
            }
        }

        return line.toString();
        
    }

	
	
	public static void main(String[] args) {
		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		int maxWidth = 16;
		
		System.out.println(fullJustify(words, maxWidth));

	}

}
