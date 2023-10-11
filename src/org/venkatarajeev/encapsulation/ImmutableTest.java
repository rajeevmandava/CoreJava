
package org.venkatarajeev.encapsulation;

//final class Immutable {
//	private final StringBuffer sb;
//
//	Immutable(String initialValue) {
//		sb = new StringBuffer(initialValue);
//	}
//
//	StringBuffer getSB() {
//		return sb;
//	}
//}

final class Immutable {
	private final StringBuffer sb;

	Immutable(String initialValue) {
		sb = new StringBuffer(initialValue);
	}

	StringBuffer getSB() {
		return new StringBuffer(sb);
	}
}

public class ImmutableTest {
	public static void main(String... strings) {
		Immutable imtble = new Immutable("Initial Value");
		imtble.getSB().append(" is modified");
		System.out.println(imtble.getSB());
	}
}