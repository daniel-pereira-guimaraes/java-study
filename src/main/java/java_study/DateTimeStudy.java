package java_study;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAmount;
import java.util.Locale;

public class DateTimeStudy {

	public static void main(String[] args) {
		makeLocalDateTime();
		formatDateTime();
		dateTimeOperations();
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

		System.out.println("--- makeDateTime ---\n");
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
		System.out.println();
	}
	
	private static void formatDateTime() {

		final ZoneId saoPaulo = ZoneId.of("America/Sao_Paulo");
		final ZoneId portugal = ZoneId.of("Portugal");
		final ZoneId tokyo = ZoneId.of(ZoneId.SHORT_IDS.get("JST"));
		final ZoneId acre = ZoneId.of("-05:00");

		final DateTimeFormatter fmt01 = DateTimeFormatter.ofPattern("dd/MM/yy");
		final DateTimeFormatter fmt02 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		final DateTimeFormatter fmt03 = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
		final DateTimeFormatter fmt04 = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy");
		final DateTimeFormatter fmt05 = DateTimeFormatter.ofPattern("E, dd 'de' MMM 'de' yyyy");
		final DateTimeFormatter fmt06 = DateTimeFormatter.ofPattern("EEEE, dd 'de' MMMM 'de' yyyy");
		final DateTimeFormatter fmt07 = DateTimeFormatter.ofPattern("HH:mm");
		final DateTimeFormatter fmt08 = DateTimeFormatter.ofPattern("KK:mm a");
		final DateTimeFormatter fmt09 = DateTimeFormatter.ofPattern("HH:mm:ss");
		final DateTimeFormatter fmt10 = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
		final DateTimeFormatter fmt11 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		final DateTimeFormatter fmt12 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		final DateTimeFormatter fmt13 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSSSS");
		
		final DateTimeFormatter fmt14 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss XXX (VV)").withZone(saoPaulo);
		final DateTimeFormatter fmt15 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss XXX (VV)").withZone(portugal);
		final DateTimeFormatter fmt16 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss XXX (VV)").withZone(tokyo);
		final DateTimeFormatter fmt17 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss XXX").withZone(acre);
		final DateTimeFormatter fmt18 = DateTimeFormatter.ofPattern("EEEE, dd - MMMM - yyyy").withLocale(Locale.ITALY);
		final DateTimeFormatter fmt19 = DateTimeFormatter.ofPattern("EEEE, dd - MMMM - yyyy").withLocale(Locale.ENGLISH);
		final DateTimeFormatter fmt20 = DateTimeFormatter.ofPattern("EEEE, dd - MMMM - yyyy").withLocale(Locale.getDefault());
		
		final LocalDateTime localDateTime = LocalDateTime.now();
		final Instant instant = Instant.now();
		
		System.out.println("--- formatDateTime ---\n");
		System.out.println("fmt01: " + localDateTime.format(fmt01));
		System.out.println("fmt02: " + localDateTime.format(fmt02));
		System.out.println("fmt03: " + localDateTime.format(fmt03));
		System.out.println("fmt04: " + localDateTime.format(fmt04));
		System.out.println("fmt05: " + localDateTime.format(fmt05));
		System.out.println("fmt06: " + localDateTime.format(fmt06));
		System.out.println("fmt07: " + localDateTime.format(fmt07));
		System.out.println("fmt08: " + localDateTime.format(fmt08));
		System.out.println("fmt09: " + localDateTime.format(fmt09));
		System.out.println("fmt10: " + localDateTime.format(fmt10));
		System.out.println("fmt11: " + localDateTime.format(fmt11));
		System.out.println("fmt12: " + localDateTime.format(fmt12));
		System.out.println("fmt13: " + localDateTime.format(fmt13));

		System.out.println("fmt14: " + fmt14.format(instant));
		System.out.println("fmt15: " + fmt15.format(instant));
		System.out.println("fmt16: " + fmt16.format(instant));
		System.out.println("fmt17: " + fmt17.format(instant));
		
		System.out.println("fmt18: " + fmt18.format(localDateTime));
		System.out.println("fmt19: " + fmt19.format(localDateTime));
		System.out.println("fmt20: " + fmt20.format(localDateTime));
		
		System.out.println();
	}

	private static void dateTimeOperations() {
		System.out.println("--- dateTimeOperations ---\n");
		System.out.println("startOfMonth: " + startOfMonth(LocalDate.now()));
		System.out.println("endOfMonth: " + endOfMonth(LocalDate.now()));
		System.out.println("priorMonday: " + priorMonday(LocalDate.now()));
		System.out.println();
	}
	
	private static LocalDate startOfMonth(Temporal temporal) {
		final int month = Month.from(temporal).getValue();
		final int year = Year.from(temporal).getValue();
		return LocalDate.of(year, month, 1);
	}
	
	private static LocalDate endOfMonth(Temporal temporal) {
		final LocalDate nextMonthDate = LocalDate.from(temporal).plusMonths(1);
		final int month = nextMonthDate.getMonthValue();
		final int year = nextMonthDate.getYear();
		return LocalDate.of(year, month, 1).minusDays(1);
	}
	
	private static LocalDate priorMonday(Temporal temporal) {
		LocalDate localDate = LocalDate.from(temporal).minusDays(1);
		while (localDate.getDayOfWeek() != DayOfWeek.MONDAY)
			localDate = localDate.minusDays(1);
		return localDate;
	}
	
}
