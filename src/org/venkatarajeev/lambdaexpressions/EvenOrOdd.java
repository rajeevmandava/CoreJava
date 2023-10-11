package org.venkatarajeev.lambdaexpressions;

import java.util.function.Predicate;

public class EvenOrOdd {
	public static void main(String... strings) {
		EvenOrOdd evenOrOdd = new EvenOrOdd();
		evenOrOdd.printEvenOrOdd(100, integer -> integer % 2 == 0);
	}

	void printEvenOrOdd(final int tillNumber, Predicate<Integer> predicate) {
		for (int i = 1; i < tillNumber; i++) {
			if (predicate.test(i)) {
				System.out.println(i);
			}
		}
	}
}