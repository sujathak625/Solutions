package com.sujatha;

import java.util.*;

public class FindNthNonRepeatingCharacter {

	public static void main(String[] args) {
		FindNthNonRepeatingCharacter fnrc = new FindNthNonRepeatingCharacter();		
		String inputStr = "SujathaKannan";
		// converts input string to character array.
		char[] inputArray = fnrc.strToCharArray(inputStr);
		// to retrieve nth non repeated character. ex: retrieve 4th non repeated character or 2nd non repeated character
		int nthPositionNo = 1;
		// checks the characters and no of times they have occured.
		Map<Character,Integer> inputMap = fnrc.addCharactersToMap(inputArray);
		// retrieves character which occurred only once.
		Map<Character,Integer> nonRepeatedCharactersMap = fnrc.getNonRepeatedCharactersMap(inputMap);
		// retrieves the nth character which has occured once.
		char result = fnrc.getNthRepeatedCharacter(nthPositionNo-1,nonRepeatedCharactersMap);
		System.out.println("Result: "+result);

	}
	
	/** 
	 * Converts the given input string to character array.
	 * */
	private char[] strToCharArray(String input) {
		char[] output = new char[input.length()];
		output = input.toCharArray();
		return output;
	}
	
	/**
	 * Adds the characters as keys and its no of repeated times as value.
	 *  */
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
	/**
	 * Gives the first key which has value 1.
	 *  */
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
	/** 
	 * Stores the key which have the value 1.
	 * */
	private Map<Character,Integer> getNonRepeatedCharactersMap(Map<Character,Integer> map) {
		char c = ' ';
		LinkedHashMap<Character,Integer> lhm = new LinkedHashMap<Character,Integer>();
		
		Iterator itr = map.keySet().iterator();
		while(itr.hasNext()) {
			char key = (char) itr.next();
			int value = map.get(key);
			if(value==1) {
				c = key;
				lhm.put(key, value);
			} else {
				continue;
			}
		}
		return lhm;
	}
	/**
	 * Gives the key and value in specific position. 
	 * */
	private char getNthRepeatedCharacter(int index,Map inputMap) {
		char c = ' ';		
		Object[] c1 = inputMap.keySet().toArray();
		c = (char) c1[index];
		return c;
	}

}
