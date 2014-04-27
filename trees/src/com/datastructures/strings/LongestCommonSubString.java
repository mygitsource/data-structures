package com.datastructures.strings;

public class LongestCommonSubString {

	/* Returns length of longest common substring of X[0..m-1] and Y[0..n-1] 
	 * O(m*n)
	 * dynamic programming
	 * */
	
	static int longestCommonSubString(String string1, String string2, int m, int n){
	    // Create a table to store lengths of longest common suffixes of
	    // substrings.   Notethat LCSuff[i][j] contains length of longest
	    // common suffix of X[0..i-1] and Y[0..j-1]. The first row and
	    // first column entries have no logical meaning, they are used only
	    // for simplicity of program
		
	    int[][] lcs = new int[m+1][n+1];
	    int result = 0;  // To store length of the longest common substring
	 
	    char[] chars1 = string1.toCharArray();
	    char[] chars2 = string2.toCharArray();
	    
	    /* Following steps build lcs[m+1][n+1] in bottom up fashion. */
	    for (int i=0; i<=m; i++) {
	        for (int j=0; j<=n; j++) {
	            if (i == 0 || j == 0) {
	                lcs[i][j] = 0;
	                
	            }else if (chars1[i-1] == chars2[j-1]) {
	                lcs[i][j] = lcs[i-1][j-1] + 1;
	                result = Math.max(result, lcs[i][j]);
	            }
	            else lcs[i][j] = 0;
	        }
	    }
	    return result;
	}
	
	public static void main(String[] args) {
		String string1 = "thisisforthistesting";
		String string2 = "thisfortesting";
		System.out.println(longestCommonSubString(string1,string2, string1.length(), string2.length()));
	}
}
