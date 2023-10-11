package org.venkatarajeev.problemsolving;


public class StringReverse {

	public static void main(String... strings) {
		String strintToReverse = "Venkata";
		String reversedString = "";

		// Slow way of reversing the string
		for (int i = strintToReverse.length() - 1; i >= 0; i--) {
			reversedString += strintToReverse.charAt(i);
		}
		System.out.println(reversedString);

		// Faster way of reversing the string
		System.out.println((new StringBuffer(strintToReverse)).reverse());
	}
}
