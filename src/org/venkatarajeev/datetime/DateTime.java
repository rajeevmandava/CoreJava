package org.venkatarajeev.datetime;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

/**
 * This code is for personal reference of Date & Time API.
 */
public class DateTime {
	public static void main(String... strings) {

		// Creating LocalDate with now
		LocalDate localDate = LocalDate.now();
		System.out.println("LocalDate " + localDate);

		// Creating LocalDate with of
		LocalDate localDate2 = LocalDate.of(1983, 10, 22);
		System.out.println("LocalDate2 " + localDate2);

		// Creating LocalDate with parse
		LocalDate localDate3 = LocalDate.parse("1980-10-01");
		System.out.println("LocalDate3 " + localDate3);

		// Creating LocalTime with now
		LocalTime localTime = LocalTime.now();
		System.out.println("LocalTime " + localTime);

		// Creating LocalTime with of
		LocalTime localTime2 = LocalTime.of(8, 30, 30);
		System.out.println("LocalTime2 " + localTime2);

		// Creating LocalTime with parse
		LocalTime localTime3 = LocalTime.parse("09:30:45");
		System.out.println("LocalTime3 " + localTime3);

		// Creating Duration based on minutes between two times
		LocalTime localTime4 = LocalTime.of(12, 12, 12);
		LocalTime localTime5 = LocalTime.of(12, 15, 59);
		long minutes = ChronoUnit.MINUTES.between(localTime4, localTime5);
		System.out.println("Minutes between are " + minutes);
		Duration duration = Duration.ofMinutes(minutes);
		System.out.println("Duration " + duration);

		// Adding Duration to LocalTime
		LocalTime localtime6 = localTime4.plus(duration);
		System.out.println("LocalTime6 " + localtime6);

		// Adding Minutes to LocalTime
		LocalTime localTime7 = localTime4.plusMinutes(minutes);
		System.out.println("LocalTime7 " + localTime7);

		// Creating LocalDateTime with now
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("LocalDateTime " + localDateTime);

		// Creating LocalDateTime with of
		LocalDateTime localDateTime2 = LocalDateTime.of(localDate, localTime);
		System.out.println("LocalDateTime2 " + localDateTime2);

		// Creating LocalDateTime with parse method using DateTimeFormatter
		String myBirthDateAndTime = "1983-10-22 08:30";
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime localDateTime3 = LocalDateTime.parse(myBirthDateAndTime, dateTimeFormatter);
		System.out.println("LocaDateTime3 " + localDateTime3);

		// Printing LocalDate with format method using DateTimeFormatter
		DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("dd, MM, yyyy, hh, mm");
		System.out.println("DateTimeFormatter2 " + localDateTime3.format(dateTimeFormatter2));

		// Adding Hours to LocalDateTime
		localDateTime3 = localDateTime3.plusHours(2);
		System.out.println("LocalDateTime3 " + localDateTime3);

		// Adding Days to LocalDateTime
		localDateTime3 = localDateTime3.plusDays(3);
		System.out.println("LocalDateTime3 " + localDateTime3);

		// Getting Day of Week with getDayOfWeek method.
		System.out.println("LocalDateTime3 " + localDateTime3.getDayOfWeek());

		// Creating Instant from LocalDateTime
		LocalDateTime localDateTime4 = LocalDateTime.now();
		Instant instant2 = localDateTime4.toInstant(ZoneOffset.ofHoursMinutes(5, 30));
		System.out.println("Instant2 " + instant2);

		/////////////////////////////////////////////////////////////////////////////////////////

		// Creating ZonedDateTime with now
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		System.out.println("Zoned Date Time " + zonedDateTime);

		// Creating ZonedDateTime with of
		ZonedDateTime zonedDateTime2 = ZonedDateTime.of(localDateTime3, ZoneId.of("Asia/Kolkata"));
		System.out.println("ZoneDateTime2 " + zonedDateTime2);

		// Printing all the ZoneIds available
//		for (String zoneIdS : ZoneId.getAvailableZoneIds()) {
//			if (zoneIdS.contains("US"))
//				System.out.println(zoneIdS);
//		}

		// Using ZoneId and Given Instant - knowing where the day is in DayLightSavings
		ZoneId zoneId = ZoneId.of("Asia/Kolkata");
		System.out.println("Day Light Saving " + zoneId.getRules().isDaylightSavings(zonedDateTime2.toInstant()));

		// Getting Day of Week with getDAyOfWeek method
		System.out.println("Day of the Week " + zonedDateTime2.getDayOfWeek());

		// Using with method with TemporalAdjusters and changing ZonedDateTime
		ZonedDateTime zonedDateTime3 = zonedDateTime2.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		System.out.println("Modified and Day of the Week " + zonedDateTime3.getDayOfWeek());
		System.out.println("ZoneDateTime3 " + zonedDateTime3);

		// Creating ZonedDateTime with of
		ZonedDateTime zonedDateTime4 = ZonedDateTime.of(2024, 4, 8, 13, 35, 56, 0, ZoneId.of("Asia/Kolkata"));
		System.out.println("ZonedDateTime4 " + zonedDateTime4);

		// Creating Period
		Period period = Period.ofMonths(1);
		System.out.println("Period " + period);

		// Using minus on ZonedDateTime
		ZonedDateTime zonedDateTime5 = zonedDateTime4.minus(period);
		System.out.println("ZonedDateTime5 " + zonedDateTime5);

		// Convering ZonedDateTime to LocalDateTime
		System.out.println("ZonedDateTime5 to LocalDateTime " + zonedDateTime5.toLocalDateTime());

		// Finding Equivalent time in other time zone
		ZonedDateTime zonedDateTime6 = zonedDateTime5.withZoneSameInstant(ZoneId.of("US/Central"));
		System.out.println("ZonedDateTime6 " + zonedDateTime6);

		// Creating and Instant of ZonedDateTime
		ZonedDateTime zonedDateTime7 = ZonedDateTime.of(1983, 10, 22, 8, 30, 0, 0, ZoneId.of("Asia/Kolkata"));
		Instant instant = zonedDateTime7.toInstant();
		System.out.println("Instant " + instant);

		// Creating current Instance
		Instant instant3 = Instant.now();

		// Knowing no. of minutes between two Instant
		long minutes2 = ChronoUnit.MINUTES.between(instant, instant3);
		System.out.println("Minutes2 " + minutes2);

		// Creating Duration
		Duration duration2 = Duration.ofMinutes(minutes2);
		System.out.println("Minutes2 " + minutes2 + " Duration " + duration2);

		// Getting No. of seconds of an instant from start time.
		System.out.println("Seconds till now " + instant3.getEpochSecond());

		// Using minus with ZonedDateTime and also getting Day Of Week
		System.out.println("Three days before birthdaydate " + zonedDateTime7.minus(Period.ofDays(3)));
		System.out
				.println("Three days before birthdaydate day " + zonedDateTime7.minus(Period.ofDays(3)).getDayOfWeek());

		// Finding Equivalent time in other time zone.
		ZonedDateTime zonedDateTime8 = zonedDateTime7.withZoneSameInstant(ZoneId.of("US/Central"));
		System.out.println("ZonedDateTime8 " + zonedDateTime8);

		// Using plusHours on ZonedDateTime
		System.out.println("2 Hours after in india and chicago " + zonedDateTime7.plusHours(2) + " "
				+ zonedDateTime8.plusHours(2));

		// To compare two ZonedDateTimes
		System.out.println("ZonedDateTime7 before now " + zonedDateTime7.isBefore(ZonedDateTime.now()));

		// To find out if the year is a leap year.
		System.out.println("Current Year Leap Year " + zonedDateTime7.toLocalDate().isLeapYear());
		System.out.println("GIven Year Leap Year " + Year.of(2024).isLeap());

		// Printing ZonedDateTime with DateTimeFormatter.
		DateTimeFormatter dateTimeFormatter3 = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
		System.out.println("DateTimeFormatter3 " + zonedDateTime7.format(dateTimeFormatter3));

		// Using Local for printing ZonedDateTime
		System.out.println("DateTimeFormatter with Local " + zonedDateTime7
				.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.UK)));

		/////////////////////////////////////////////////////////////////////////////////////////

		// Creating OffsetDateTime with now
		OffsetDateTime offsetDateTime = OffsetDateTime.now();
		System.out.println("OffsetDateTime " + offsetDateTime);

		/////////////////////////////////////////////////////////////////////////////////////////

		// Getting default Locale
		Locale locale = Locale.getDefault();
		System.out.println("Locale " + locale);

		// Printing LocalDateTime using default Locale
		LocalDateTime lLocalDateTime = LocalDateTime.of(2023, 10, 22, 8, 30);
		System.out.println("Default Locale Format "
				+ lLocalDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));

		// Crating ZonedDateTime from LocalDateTime and ZoneId
		ZonedDateTime lZonedDateTime = ZonedDateTime.of(lLocalDateTime, ZoneId.of("US/Central"));
		System.out.println("Local Zoned Date Time " + lZonedDateTime);

		// Creating Indian Locale
		Locale locale2 = new Locale("hi", "IN");

		// Printing ZonedDateTime in long format.
		System.out.println("India Long "
				+ lZonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(locale2)));

		// Printing LocalDateTime in long format.
		System.out.println("India Medium "
				+ lLocalDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(locale2)));

		// Using getDisplayCountry in different ways.
		System.out.println("India Country " + locale2.getDisplayCountry());
		System.out.println("India Country : local :" + "India Country " + locale2.getDisplayCountry(locale2));

		// Using getDisplayLanguage in different ways.
		System.out.println("India Language " + locale2.getDisplayLanguage());
		System.out.println("India Language : local :" + locale2.getDisplayLanguage(locale2));
	}
}
