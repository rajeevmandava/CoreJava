package org.venkatarajeev.problemsolving;

import java.util.HashMap;
import java.util.Map;

/*
 * The problem statement to reverse the string given without changing the position of special characters
 * 
 * Saw this question in some youtube video and tried to implement it.
 */

class ReverseCharacters {

	String reverseCharacters(String inputString) {
		String outputString = "";

		Map<Integer, Character> positionAndCharacter = new HashMap<>();
		String onlyString = "";

		for (int i = 0; i < inputString.length(); i++) {
			if ((inputString.charAt(i) >= 'a' && inputString.charAt(i) <= 'z')
					|| (inputString.charAt(i) >= 'A' && inputString.charAt(i) <= 'Z')) {
				onlyString += inputString.charAt(i);
			} else {
				positionAndCharacter.put(i, inputString.charAt(i));
			}
		}

		StringBuffer reversedString = new StringBuffer(onlyString);
		reversedString.reverse();

		for (Integer i : positionAndCharacter.keySet()) {
			reversedString.insert(i, positionAndCharacter.get(i).toString());
		}
		outputString = reversedString.toString();

		return outputString;

	}
}

public class TuringTest {
	public static void main(String... strings) {
		ReverseCharacters reverseCharacters = new ReverseCharacters();
		System.out.println(reverseCharacters.reverseCharacters("ab-cd+-12kjkad==sf"));
	}
}
