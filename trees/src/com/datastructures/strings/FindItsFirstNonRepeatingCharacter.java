package com.datastructures.strings;

import java.util.HashMap;
import java.util.Map;

public class FindItsFirstNonRepeatingCharacter {

	static char firstNonRepeatingCharacter(String string){
		if(string == null) return '\0';
		if(string.length() == 1) return string.charAt(0);
		
		Map<Character, CharIndex> map = new HashMap<>(); 
		for (int i =0; i < string.toCharArray().length; i++) {
			CharIndex ci = map.get(string.charAt(i));
			if(ci != null)
				ci = new CharIndex(i, ci.count);
			else
				ci = new CharIndex(i, 0);
			map.put(string.charAt(i), ci);
		}
		
		int index = -1;
		for (int i = 0;i<string.toCharArray().length; i++) {
			if(map.get(string.charAt(i)).count == 1){
				index = map.get(string.charAt(i)).index; 
				break;
			}
			
		}
		return ((index > -1 && index < string.length()) ? string.charAt(index) : '\0');
	}

	static class CharIndex{
		CharIndex(int index, int count){
			this.count = count +1;
			this.index = index;
		}
		int count;
		int index;
		
		@Override
		public String toString() {
			return count+":"+index;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + count;
			result = prime * result + index;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CharIndex other = (CharIndex) obj;
			if (count != other.count)
				return false;
			if (index != other.index)
				return false;
			return true;
		}
		
		
	}
	
	public static void main(String[] args) {
		char chr = firstNonRepeatingCharacter("geeksforgeeks");
		System.out.println(chr);
		
	}
}
