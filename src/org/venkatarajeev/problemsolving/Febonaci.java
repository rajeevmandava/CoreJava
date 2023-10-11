package org.venkatarajeev.problemsolving;

public class Febonaci {

	public static void main(String... strings) {

		int i = 0;
		int j = 1;
		System.out.println(i);
		do {
			System.out.println(j);
			int temp = j;
			j += i;
			i = temp;
		} while (j < 100);
	}
}
