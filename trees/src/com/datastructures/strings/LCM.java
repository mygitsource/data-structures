package com.datastructures.strings;

public class LCM {
	public static void main(String[] args) {
		String s1 = "xxccc";
		String s2 = "bcccc";
		System.out.println(lcm(s1, s2));
	}

	static String lcm(String s1, String s2) {
		int result = 0;
		int[][] lcmdp = new int[s1.length() + 1][s2.length() + 1];
		int index = 0;

		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					lcmdp[i + 1][j + 1] = lcmdp[i][j] + 1;
//					System.out.println("["+(i+1)+"]["+(j+1)+"]  = "+i+""+j);
					// result = Math.max(lcmdp[i+1][j+1], result);
					if (result < lcmdp[i + 1][j + 1]) {
						result = lcmdp[i + 1][j + 1];
						System.out.println("I : "+i+" j: "+j);
						index = i;
					}
					// System.out.println(result);
				}
			}
			printArray(lcmdp);
		}
		// System.out.println("substring starts at : "+(index-result+1));
		System.out.println("substring starts at : "+(index+" "+result));
		String substring = "";
		for (int count = index - result + 1; count <= index; count++) {
			System.out.println(count+" "+s1.charAt(count));
			substring += s1.charAt(count);
		}
		return substring;
	}
	
	static void printArray(int [][] lcmdp){
		int len = lcmdp.length;
		for(int i =0; i <len; i++){
			for(int j =0; j < lcmdp[i].length; j++){
				System.out.print(lcmdp[i][j]+" ");
			}
			System.out.print("\n");
		}
		System.out.println("********");
	}
}
