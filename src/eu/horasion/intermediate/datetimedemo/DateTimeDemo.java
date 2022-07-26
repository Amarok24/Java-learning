package eu.horasion.intermediate.datetimedemo;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeDemo {

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		LocalDate customDate = LocalDate.of(1986, Month.MAY, 15);

		LocalTime now = LocalTime.now();

		// Instant.now() returns UTC time (timezone 0)
		long unixTime = Instant.now().getEpochSecond();

		DateTimeFormatter dtFormatter = DateTimeFormatter
			.ofPattern("dd.MM.yyyy");

		System.out.printf("The time now is %s\n", now);
		System.out.printf("Today's date is %s\n", today);
		System.out.printf("Today formatted: %s\n", dtFormatter.format(today));
		System.out.printf("customDate formatted: %s\n", dtFormatter.format(customDate));

		long differenceInDays = ChronoUnit.DAYS.between(customDate, today);

		System.out.printf("Number of days between customDate and today: %d\n", differenceInDays);

		System.out.printf("Unix time now: %s\n", unixTime);

	}
}

/*

The time now is 18:19:43.157402600
Today's date is 2022-07-26
Today formatted: 26.07.2022
customDate formatted: 15.05.1986
Number of days between customDate and today: 13221
Unix time now: 1658852383

 */
