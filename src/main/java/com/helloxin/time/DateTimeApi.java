package com.helloxin.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.MONTHS;
import static java.time.temporal.ChronoUnit.YEARS;
import static java.util.Comparator.comparingInt;

/**
 * Created by nandiexin on 2019/1/22.
 */
public class DateTimeApi {

    public static void testNow(){

        System.out.println(Instant.now());
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
        System.out.println(ZonedDateTime.now());
        System.out.println(MonthDay.now());
        System.out.println(YearMonth.now());
        System.out.println(Year.now());

        System.out.println("--------------------------");

        Clock antarctica = Clock.system(ZoneId.of("Antarctica/South_Pole"));
        System.out.println(ZonedDateTime.now(antarctica));

        // Easier to do the Antarctica time this way (now() uses ZoneId directly)
        System.out.println(ZonedDateTime.now(ZoneId.of("Antarctica/South_Pole")));

        // Can create a Clock with an offset, though
        System.out.println(ZonedDateTime.now(
                Clock.offset(antarctica, Duration.ofHours(1))));

        // Other factory methods on Clock
        System.out.println(ZonedDateTime.now(Clock.systemDefaultZone()));
        System.out.println(ZonedDateTime.now(Clock.systemUTC()));

        // Clock that always returns the same instant
        Clock fixed = Clock.fixed(Instant.now(), ZoneId.of("Antarctica/South_Pole"));
        System.out.println(ZonedDateTime.now(fixed));
        System.out.println(ZonedDateTime.now(fixed));
        System.out.println(ZonedDateTime.now(fixed));
        //这样又会发生什么呢
        fixed = Clock.fixed(Instant.now(), ZoneId.of("Antarctica/South_Pole"));
        System.out.println(ZonedDateTime.now(fixed));
        System.out.println(ZonedDateTime.now(fixed));
        System.out.println(ZonedDateTime.now(fixed));



    }

    public static void testof(){

        LocalDate moonLandingDate = LocalDate.of(1969, Month.JULY, 20);
        LocalTime moonLandingTime = LocalTime.of(20, 18);
        System.out.println("Date: " + moonLandingDate);
        System.out.println("Time: " + moonLandingTime);

        LocalTime walkTime = LocalTime.of(20, 2, 56, 0);
        LocalDateTime walk = LocalDateTime.of(moonLandingDate, walkTime);
        System.out.println(walk);


    }


    public static void testMonth(){

        System.out.println("Days in Feb in a leap year: " +
                Month.FEBRUARY.length(true));
        System.out.println("Day of year for first day of Aug (leap year): " +
                Month.AUGUST.firstDayOfYear(true));
        System.out.println("Month.of(1): " + Month.of(1));
        System.out.println("Adding two months: " +
                Month.JANUARY.plus(2));
        System.out.println("Subtracting a month: " +
                Month.MARCH.minus(1));

    }

    public static void addingAndSubtracting(){

        LocalDate groundHogDay = LocalDate.of(2017, Month.FEBRUARY, 2);
        System.out.println(groundHogDay.plusDays(3));
        System.out.println(groundHogDay.plusWeeks(5));
        System.out.println(groundHogDay.plusMonths(7));
        System.out.println(groundHogDay.plusYears(2));

        System.out.println(groundHogDay.minusDays(3));
        System.out.println(groundHogDay.minusWeeks(5));
        System.out.println(groundHogDay.minusMonths(7));
        System.out.println(groundHogDay.minusYears(2));

    }

    public static void antarcticaTimeZones(){

        LocalDateTime now = LocalDateTime.now();
        List<ZonedDateTime> antarticZones =
                ZoneId.getAvailableZoneIds().stream()  // Stream<String>
                        .filter(regionId -> regionId.contains("Antarctica"))
                        .map(ZoneId::of)  // Stream<ZoneId>
                        .map(now::atZone) // Stream<ZonedDateTime>
                        .sorted(comparingInt(zoneId -> zoneId.getOffset().getTotalSeconds()))
                        .collect(Collectors.toList());

        antarticZones.forEach(zdt ->
                System.out.printf("%7s: %25s %7s%n", zdt.getOffset(), zdt.getZone(),
                        zdt.getZone().getRules().isDaylightSavings(zdt.toInstant())));

    }

    public static void cTtoIndia() {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.MIDNIGHT;
        ZonedDateTime zdt = ZonedDateTime.of(localDate, localTime,
                ZoneId.of("America/New_York"));
        ZoneId india = ZoneId.of("Asia/Kolkata");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mma");

        System.out.println("Connecticut India");
        IntStream.rangeClosed(20, 30)  // start at 8pm, incr by 1 hr 10 times
                .mapToObj(zdt::plusHours)
                .forEach(zonedDateTime -> System.out.printf("  %s   %s%n",
                        zonedDateTime.toLocalTime().format(formatter),
                        zonedDateTime.withZoneSameInstant(india).toLocalTime()));
    }

    public static void daysToElection() {
        LocalDate electionDay = LocalDate.of(2020, Month.NOVEMBER, 3);
        LocalDate today = LocalDate.now();

        // Using "between"
        System.out.printf("%d days to go...%n", DAYS.between(today, electionDay));

        long years = YEARS.between(today, electionDay);
        long months = MONTHS.between(today.plusYears(years), electionDay);
        long days = DAYS.between(today.plusYears(years).plusMonths(months), electionDay);
        System.out.printf("%d year%s, %d month%s, and %d day%s%n",
                years,  pluralize(years),
                months, pluralize(months),
                days,   pluralize(days));

        // Using "until"
        Period until = today.until(electionDay);
        System.out.println(today.until(electionDay));

        years = until.getYears();
        months = until.getMonths();
        days = until.getDays();
        System.out.printf("%d year%s, %d month%s, and %d day%s%n",
                years,  pluralize(years),
                months, pluralize(months),
                days,   pluralize(days));
    }

    private static String pluralize(long num) {
        return num == 1 ? "" : "s";
    }





    public static void main(String[] args) {
        daysToElection();
    }


}
