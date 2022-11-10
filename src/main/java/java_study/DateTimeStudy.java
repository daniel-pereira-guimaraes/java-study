package java_study;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

public class DateTimeStudy {

	public static void main(String[] args) throws ParseException {
		makeAndFormatDate();
		calendarOperations();
		makeLocalDateTime();
		formatDateTime();
		dateTimeOperations();
		durationsWithLocalDateTime();
		minusPlusDateTime();
		instantOperations();
		showZoneIds();
	}
	
	private static void makeAndFormatDate() throws ParseException {
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		sdf3.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		Date dt01 = new Date();
		Date dt02 = new Date(System.currentTimeMillis());
		Date dt03 = new Date(0L); 						// 1970-01-01T00:00:00Z
		Date dt04 = new Date(10L * 60L * 60L * 1000L);	// 1970-01-01T10:00:00Z
		Date dt05 = sdf1.parse("08/11/2022");
		Date dt06 = sdf2.parse("08/11/2022 20:07:15");
		Date dt07 = sdf3.parse("08/11/2022 20:07:15");
		Date dt08 = Date.from(Instant.parse("2022-11-08T20:07:15Z"));
		
		System.out.println("--- makeAndFormatDate ---");
		System.out.println("dt01: " + dt01);
		System.out.println("dt02: " + dt02);
		System.out.println("dt03: " + dt03);
		System.out.println("dt04: " + dt04);
		System.out.println("dt05: " + dt05);
		System.out.println("dt06: " + dt06);
		System.out.println("dt07: " + dt07);
		System.out.println("dt08: " + dt08);
		System.out.println("---");
		System.out.println("dt01: " + sdf1.format(dt01));
		System.out.println("dt02: " + sdf1.format(dt02));
		System.out.println("dt03: " + sdf1.format(dt03));
		System.out.println("dt04: " + sdf1.format(dt04));
		System.out.println("dt05: " + sdf1.format(dt05));
		System.out.println("dt06: " + sdf1.format(dt06));
		System.out.println("dt07: " + sdf1.format(dt07));
		System.out.println("dt08: " + sdf1.format(dt08));
		System.out.println("---");
		System.out.println("dt01: " + sdf2.format(dt01));
		System.out.println("dt02: " + sdf2.format(dt02));
		System.out.println("dt03: " + sdf2.format(dt03));
		System.out.println("dt04: " + sdf2.format(dt04));
		System.out.println("dt05: " + sdf2.format(dt05));
		System.out.println("dt06: " + sdf2.format(dt06));
		System.out.println("dt07: " + sdf2.format(dt07));
		System.out.println("dt08: " + sdf2.format(dt08));
		System.out.println("---");
		System.out.println("dt01: " + sdf3.format(dt01));
		System.out.println("dt02: " + sdf3.format(dt02));
		System.out.println("dt03: " + sdf3.format(dt03));
		System.out.println("dt04: " + sdf3.format(dt04));
		System.out.println("dt05: " + sdf3.format(dt05));
		System.out.println("dt06: " + sdf3.format(dt06));
		System.out.println("dt07: " + sdf3.format(dt07));
		System.out.println("dt08: " + sdf3.format(dt08));
		System.out.println();
	}
	
	private static void calendarOperations() {
		
		Date dt01 = Date.from(Instant.parse("2022-11-08T20:27:05-04:00"));
		Date dt02 = calendarAdd(dt01, Calendar.HOUR, 5);
		Date dt03 = calendarAdd(dt01, Calendar.HOUR_OF_DAY, 5);
		Date dt04 = calendarAdd(dt01, Calendar.HOUR, -3);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dt01);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int month = calendar.get(Calendar.MONTH) + 1;
		int year = calendar.get(Calendar.YEAR);
		
		System.out.println("--- calendarOperations ---");
		System.out.println();
		System.out.println("dt01: " + dt01);
		System.out.println("dt02: " + dt02);
		System.out.println("dt03: " + dt03);
		System.out.println("dt04: " + dt04);
		System.out.println("Day: " + day);
		System.out.println("Month: " + month);
		System.out.println("Year: " + year);
		System.out.println();
	}
	
	private static Date calendarAdd(Date date, int field, int value) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(field, value);
		return calendar.getTime();
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
		System.out.println("LocalData.atTime: " + LocalDate.now().atTime(20,44));
		System.out.println("startOfMonth: " + startOfMonth(LocalDate.now()));
		System.out.println("endOfMonth: " + endOfMonth(LocalDate.now()));
		System.out.println("priorMonday: " + priorMonday(LocalDate.now()));
		System.out.println("nextSunday: " + nextSunday(LocalDate.now()));
		System.out.println("priorDayOfWeek(MONDAY, now): " + priorDayOfWeek(DayOfWeek.MONDAY, LocalDate.now()));
		System.out.println("priorDayOfWeek(SATURDAY, now): " + priorDayOfWeek(DayOfWeek.SATURDAY, LocalDate.now()));
		System.out.println("nextDayOfWeek(MONDAY, now): " + nextDayOfWeek(DayOfWeek.MONDAY, LocalDate.now()));
		System.out.println("nextDayOfWeek(SATURDAY, now): " + nextDayOfWeek(DayOfWeek.SATURDAY, LocalDate.now()));
		System.out.println();
	}
	
	private static void durationsWithLocalDateTime() {
		LocalDateTime startDateTime = LocalDateTime.now().minusYears(5);
		LocalDateTime endDateTime = LocalDateTime.now();
		Duration duration = Duration.between(startDateTime, endDateTime);

		System.out.println("--- durations ---\n");
		System.out.println("Years: " + ChronoUnit.YEARS.between(startDateTime, endDateTime));
		System.out.println("Months: " + ChronoUnit.MONTHS.between(startDateTime, endDateTime));
		System.out.println("Weeks: " + ChronoUnit.WEEKS.between(startDateTime, endDateTime));
		System.out.println("Days: " + ChronoUnit.DAYS.between(startDateTime, endDateTime));
		System.out.println("Hours: " + ChronoUnit.HOURS.between(startDateTime, endDateTime));
		System.out.println("Minutes: " + ChronoUnit.MINUTES.between(startDateTime, endDateTime));
		System.out.println("Seconds: " + ChronoUnit.SECONDS.between(startDateTime, endDateTime));
		System.out.println("Milliseconds: " + ChronoUnit.MILLIS.between(startDateTime, endDateTime));
		System.out.println("Microseconds: " + ChronoUnit.MICROS.between(startDateTime, endDateTime));
		System.out.println("durarion - days: " + duration.toDays());
		System.out.println("durarion - hours: " + duration.toHours());
		System.out.println("durarion - minutes: " + duration.toMinutes());
		System.out.println("durarion - seconds: " + duration.toSeconds());
		
		System.out.println();
	}
	
	private static void minusPlusDateTime() {
		
		LocalDateTime dt00 = LocalDateTime.now();
		
		LocalDateTime dt01 = dt00.minusSeconds(5);
		LocalDateTime dt02 = dt00.minusMinutes(5);
		LocalDateTime dt03 = dt00.minusHours(5);
		LocalDateTime dt04 = dt00.minusDays(5);
		LocalDateTime dt05 = dt00.minusWeeks(5);
		LocalDateTime dt06 = dt00.minusMonths(5);
		LocalDateTime dt07 = dt00.minusYears(5);

		LocalDateTime dt11 = dt00.plusSeconds(5);
		LocalDateTime dt12 = dt00.plusMinutes(5);
		LocalDateTime dt13 = dt00.plusHours(5);
		LocalDateTime dt14 = dt00.plusDays(5);
		LocalDateTime dt15 = dt00.plusWeeks(5);
		LocalDateTime dt16 = dt00.plusMonths(5);
		LocalDateTime dt17 = dt00.plusYears(5);
	
		System.out.println("--- minusPlusDateTime ---");
		System.out.println();
		
		System.out.println("dt00: " + dt00);
		System.out.println();

		System.out.println("dt01: " + dt01);
		System.out.println("dt02: " + dt02);
		System.out.println("dt03: " + dt03);
		System.out.println("dt04: " + dt04);
		System.out.println("dt05: " + dt05);
		System.out.println("dt06: " + dt06);
		System.out.println("dt07: " + dt07);
		System.out.println();
	
		System.out.println("dt11: " + dt11);
		System.out.println("dt12: " + dt12);
		System.out.println("dt13: " + dt13);
		System.out.println("dt14: " + dt14);
		System.out.println("dt15: " + dt15);
		System.out.println("dt16: " + dt16);
		System.out.println("dt17: " + dt17);
		System.out.println();
	}
	
	private static void instantOperations() {
		
		Instant dt00 = Instant.now();
		ZonedDateTime dt01 = dt00.atZone(ZoneId.of("America/Sao_Paulo"));
		Instant dt02 = Instant.parse("2022-11-07T23:51:00Z");
		Instant dt03 = Instant.parse("2022-11-07T19:51:00-04:00");
		LocalDateTime dt04 = LocalDateTime.ofInstant(dt00, ZoneId.of("America/Sao_Paulo"));
		LocalDateTime dt05 = LocalDateTime.ofInstant(dt00, ZoneId.of("-03:00"));
		LocalDateTime dt06 = LocalDateTime.ofInstant(dt00, ZoneId.systemDefault());
		Instant dt07 = dt00.minus(7, ChronoUnit.DAYS);
		Instant dt08 = dt00.plus(7, ChronoUnit.DAYS);

		System.out.println("--- instantOperations ---");
		System.out.println();
		System.out.println("dt00: " + dt00);
		System.out.println("dt01: " + dt01);
		System.out.println("dt02: " + dt02);
		System.out.println("dt03: " + dt03);
		System.out.println("dt04: " + dt04);
		System.out.println("dt05: " + dt05);
		System.out.println("dt06: " + dt06);
		System.out.println("dt07: " + dt07);
		System.out.println("dt08: " + dt08);
		System.out.println();
	}
	
	private static void showZoneIds() {
		String defaultZone = ZoneId.systemDefault().toString();
		Set<String> zones = ZoneId.getAvailableZoneIds();

		System.out.println("--- showZoneIds ---");
		System.out.println();
		System.out.println("defaultZone: " + defaultZone);
		System.out.println();
		
		for (String zone : zones) {
			if (zone.equals(defaultZone))
				zone = "*" + zone;
			System.out.println(zone);
		}
		
		System.out.println("--- Zone count: " + zones.size() + " ---");
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
	
	private static LocalDate nextSunday(Temporal temporal) {
		LocalDate localDate = LocalDate.from(temporal).plusDays(1);
		while (localDate.getDayOfWeek() != DayOfWeek.SUNDAY)
			localDate = localDate.plusDays(1);
		return localDate;
	}
	
	private static LocalDate priorDayOfWeek(DayOfWeek dayOfWeek, Temporal temporal) {
		LocalDate localDate = LocalDate.from(temporal).minusDays(1);
		while (localDate.getDayOfWeek() != dayOfWeek)
			localDate = localDate.minusDays(1);
		return localDate;
	}
	
	private static LocalDate nextDayOfWeek(DayOfWeek dayOfWeek, Temporal temporal) {
		LocalDate localDate = LocalDate.from(temporal).plusDays(1);
		while (localDate.getDayOfWeek() != dayOfWeek)
			localDate = localDate.plusDays(1);
		return localDate;
	}
	
	
}
