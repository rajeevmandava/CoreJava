package org.venkatarajeev.singleton;

import java.util.HashSet;
import java.util.Set;

/**
 * The following is the problem class code
 */

//class Show {
//
//	private Set<String> seats;
//
//	Show() {
//		seats = new HashSet<>();
//		
//		seats.add("A1");
//		seats.add("A2");
//	}
//	
//	Set<String> getSeats() {
//		return seats;
//	}
//	
//}

/**
 * The following is first way of implementing the "Singleton Pattern". (Eager)
 */
//class Show {
//	private static final Show show = new Show();
//	private Set<String> seats;
//	
//	private Show() {
//		seats = new HashSet<>();
//		
//		seats.add("A1");
//		seats.add("A2");
//	}
//	
//	static Show getInstance() {
//		return show;
//	}
//	
//	Set<String> getSeats(){
//		return seats;
//	}
//}

/**
 * The following is the second way of implementing the "Singleton Pattern". (Lazy)
 */
//class Show {
//	private static Show show;
//	private Set<String> seats;
//
//	private Show() {
//		seats = new HashSet<>();
//
//		seats.add("A1");
//		seats.add("A2");
//	}
//	
//	static Show getInstance() {
//		if(show == null) {
//			show = new Show();
//		}
//		return show;
//	}
//	
//	Set<String> getSeats(){
//		return seats;
//	}
//}

/**
 * The following is the third way of implementing the "Singleton Patter". (using
 * enum)
 */
enum Show {
	INSTANCE;

	private Set<String> seats;

	private Show() {
		seats = new HashSet<>();

		seats.add("A1");
		seats.add("A2");
	}

	Set<String> getSeats() {
		return seats;
	}
}

/**
 * The following is the code using the singleton instance.
 */
public class Mediator {
	public static void main(String... strings) {
		Mediator m = new Mediator();

		System.out.println(m.bookTicket("A1"));
		System.out.println(m.bookTicket("A1"));
	}

	boolean bookTicket(String seat) {
		Show s = Show.INSTANCE;
		return s.getSeats().remove(seat);
	}
}