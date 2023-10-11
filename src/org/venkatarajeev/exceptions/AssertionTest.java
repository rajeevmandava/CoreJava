package org.venkatarajeev.exceptions;

public class AssertionTest {

	public static void main(String... strings) {
		AssertionTest at = new AssertionTest();
		at.doSomethingUsefull(1);

	}

	void doSomethingUsefull(int i) {
		assert (i > 0) : "Value of i is " + i;
	}
}
