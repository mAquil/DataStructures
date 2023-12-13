package com.leetcode.DSA150.Array_String;

public class LongestCommonPrefixTRIE {

	static final int ALPHABET_SIZE = 26;
	
	static class TrieNode
    {
        TrieNode[] child = new TrieNode[ALPHABET_SIZE];
        boolean isEnd;     // isEnd is true if the node represents end of a word
         
        // constructor : In java however constructor is not needed since by default isEnd is false, and child is null
        public TrieNode() {
            isEnd = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                child[i] = null;
        }
    };
	
    static TrieNode root;
    static int indexes;
    
	static void insert(String key)
    {      
        TrieNode curr = root;
        for (int i = 0; i < key.length(); i++)
        {
           int index = key.charAt(i) - 'a';
            if (curr.child[index] == null)
                curr.child[index] = new TrieNode();
      
            curr = curr.child[index];
        }
      
        // mark last node as leaf
        curr.isEnd = true;
    }
	
	static int countChildren(TrieNode node)
    {
        int count = 0;
        for (int i=0; i<ALPHABET_SIZE; i++)
        {
            if (node.child[i] != null)
            {
                count++;
                indexes = i;
            }
        }
        return (count);
    }
	
	static String walkTrie()
    {
        TrieNode curr = root;
        indexes = 0;
        String prefix = "";
      
        while (countChildren(curr) == 1 &&
                curr.isEnd == false)
        {
            curr = curr.child[indexes];
            prefix += (char)('a' + indexes);
        }
        return prefix;
    }
	
	static void constructTrie(String strs[], int n)
    {
        for (int i = 0; i < n; i++)
            insert (strs[i]);
        return;
    }
	
	static String longestCommonPrefix(String strs[])
    {
		int n = strs.length;
		if (n == 0)
            return "";
		
		root = new TrieNode();
        constructTrie(strs, n);
      
        // Perform a walk on the trie
        return walkTrie();
    }
	
	public static void main(String[] args) {
		String strs[] = {"geeksforgeeks", "geeks",
                "geek", "geezer"};
		
		String ans = longestCommonPrefix(strs);
		
		if (ans.length() != 0)
		    System.out.println("The longest common prefix is "+ans);
		else
		    System.out.println("There is no common prefix");
		
	}

}
