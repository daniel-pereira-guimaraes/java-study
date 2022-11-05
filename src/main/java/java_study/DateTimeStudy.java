package java_study;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeStudy {

	public static void main(String[] args) {
		makeLocalDateTime();
	}
	
	private static void makeLocalDateTime() {
		
		final DateTimeFormatter fmt01 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		final DateTimeFormatter fmt02 = DateTimeFormatter.ofPattern("HH:mm");
		final DateTimeFormatter fmt03 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		final LocalDate v01 = LocalDate.now();
		final LocalDate v02 = LocalDate.of(2022, 11, 4);
		final LocalDate v03 = LocalDate.parse("2022-11-04");
		final LocalDate v04 = LocalDate.parse("04/11/2022", fmt01);
		
		final LocalTime v05 = LocalTime.now();
		final LocalTime v06 = LocalTime.of(20, 3, 10);
		final LocalTime v07 = LocalTime.parse("20:28", fmt02);
		
		final LocalDateTime v08 = LocalDateTime.now();
		final LocalDateTime v09 = LocalDateTime.of(2022, 11, 4, 20, 4, 15);
		final LocalDateTime v10 = LocalDateTime.of(v02,  v06);
		final LocalDateTime v11 = LocalDateTime.parse("04/11/2022 20:29", fmt03);
		
		System.out.println("v01: " + v01);
		System.out.println("v02: " + v02);
		System.out.println("v03: " + v03);
		System.out.println("v04: " + v04);
		System.out.println("v05: " + v05);
		System.out.println("v06: " + v06);
		System.out.println("v07: " + v07);
		System.out.println("v08: " + v08);
		System.out.println("v09: " + v09);
		System.out.println("v10: " + v10);
		System.out.println("v11: " + v11);
	}

}
