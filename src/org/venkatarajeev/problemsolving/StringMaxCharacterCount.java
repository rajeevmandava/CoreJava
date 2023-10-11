package org.venkatarajeev.problemsolving;

import java.util.Map;

public class StringMaxCharacterCount {

	public static void main(String... strings) {

		System.out.println(new StringMaxCharacterCount().stringMaxCharacterCount(null));
	}

	int stringMaxCharacterCount(String inputString) {

		if (inputString == null) {
			return 0;
		}

		Map<Character, Integer> charMap;
		charMap = new java.util.HashMap<>();

		for (int i = inputString.length() - 1; i >= 0; i--) {
			char currentCharacter = inputString.charAt(i);

			if (charMap.get(currentCharacter) == null) {
				charMap.put(currentCharacter, 1);
			} else {
				charMap.put(currentCharacter, charMap.get(currentCharacter) + 1);
			}
		}

		int maxCharacters = 0;
		for (Character c : charMap.keySet()) {
			if (maxCharacters < charMap.get(c)) {
				maxCharacters = charMap.get(c);
			}
		}

		return maxCharacters;
	}
}
