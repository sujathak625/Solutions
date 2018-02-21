package com.sujatha;

import java.util.*;

public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {
		FirstNonRepeatingCharacter fnrc = new FirstNonRepeatingCharacter();		
		String inputStr = "aaaabbbbcc cddddeeef";
		char[] inputArray = fnrc.strToCharArray(inputStr);
		Map<Character,Integer> inputMap = fnrc.addCharactersToMap(inputArray);
		char result = fnrc.getFirstNonRepeatedCharacter(inputMap);
		System.out.println("Result: "+result);

	}
	
	private char[] strToCharArray(String input) {
		char[] output = new char[input.length()];
		output = input.toCharArray();
		return output;
	}
	
	private Map<Character, Integer> addCharactersToMap(char[] inputArray) {
		char firstNonRepeatedChar = ' ';
		LinkedHashMap<Character, Integer> inputMap = new LinkedHashMap<Character, Integer>();
		for (int c = 0; c < inputArray.length; c++) {
			char c1 = inputArray[c];
			Iterator itr = inputMap.keySet().iterator();
			
			if (inputMap.containsKey(c1)) {
				int value = inputMap.get(c1);
				value = value + 1;
				inputMap.put(c1, value);
			} else {
				inputMap.put(c1, 1);
			}

		}
		return inputMap;
	}
	
	private char getFirstNonRepeatedCharacter(Map<Character,Integer> map) {
		char c = ' ';
		Iterator itr = map.keySet().iterator();
		while(itr.hasNext()) {
			char key = (char) itr.next();
			int value = map.get(key);
			if(value==1) {
				c = key;
				break;
			}
		}
		return c;
	}

}
