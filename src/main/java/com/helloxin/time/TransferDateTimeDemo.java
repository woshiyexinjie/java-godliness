package com.helloxin.time;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class TransferDateTimeDemo {
    public static void main(String[] args) {
        // get an Instant
//        Instant timestamp = Instant.now();
//        System.out.println("Timestamp: " + timestamp);
//
//        // String to Instant
//        Instant timestampFromString = Instant.parse("2019-02-24T14:31:33.197021300Z");
//        System.out.println("\nTimestamp from string: " + timestampFromString);
//
//        // Plus two hours
//        Instant twoHourLater = Instant.now().plus(2, ChronoUnit.HOURS);
//        System.out.println("\nTwo hours later: " + twoHourLater);
//
//        // Minus 10 minutes
//        Instant tenMinutesEarlier = Instant.now().minus(10, ChronoUnit.MINUTES);
//        System.out.println("Ten minutes earlier: " + tenMinutesEarlier);
//
//        // check if one Instant is after another Instant
//        Instant timestamp1 = Instant.now();
//        Instant timestamp2 = timestamp1.plusSeconds(10);
//        boolean isAfter = timestamp1.isAfter(timestamp2);
//        System.out.println("\n" + timestamp1 + " is " + (isAfter ? "" : "not ") + "after " + timestamp2);
//
//        // check if one Instant is before another Instant
//        boolean isBefore = timestamp1.isBefore(timestamp2);
//        System.out.println(timestamp1 + " is " + (isBefore ? "" : "not ") + "before " + timestamp2);
//
//        // difference between two Instants
//        long difference = timestamp1.until(timestamp2, ChronoUnit.SECONDS);
//        System.out.println("Between " + timestamp1 + " and " + timestamp2 + " there are " + difference + " seconds");
//
//        // convert Instant to LocalDateTime
//        LocalDateTime ldt = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC);
//        System.out.println("\nInstant to LocaleDateTime: " + ldt);
//        // convert LocalDateTime to Instant
//        Instant instantLDT = LocalDateTime.now().toInstant(ZoneOffset.UTC);
//        System.out.println("LocaleDateTime to Instant: " + instantLDT);
//
//        // convert Instant to ZonedDateTime
//        ZonedDateTime zdt = Instant.now().atZone(ZoneId.of("Europe/Paris"));
//        System.out.println("Instant to ZonedDateTime: " + zdt + " (offset: " + zdt.getOffset() + ")");
//        // convert ZonedDateTime to Instant
//        Instant instantZDT = LocalDateTime.now().atZone(ZoneId.of("Europe/Paris")).toInstant();
//        System.out.println("ZonedDateTime to Instant: " + instantZDT);
//
//        // convert Instant to OffsetDateTime
//        OffsetDateTime odt = Instant.now().atOffset(ZoneOffset.of("+02:00"));
//        System.out.println("Instant to OffsetDateTime: " + odt + " (offset: " + odt.getOffset() + ")");
//        // convert OffsetDateTime to Instnat
//        Instant instantODT = LocalDateTime.now().atOffset(ZoneOffset.of("+02:00")).toInstant();
//        System.out.println("OffsetDateTime to Instant: " + instantODT);
//
//
//        System.out.println("----------------------------------------");
//        System.out.println(LocalDateTime.now().toInstant(ZoneOffset.of("+08:00")));
//        System.out.println(LocalDateTime.now().toInstant(ZoneOffset.of("+00:00")));

//        System.out.println("Before JDK 8:");
//
//        Date date = new Date();
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//
//        int yearC = calendar.get(Calendar.YEAR);
//        int monthC = calendar.get(Calendar.MONTH);
//        int weekC = calendar.get(Calendar.WEEK_OF_MONTH);
//        int dayC = calendar.get(Calendar.DATE);
//        int hourC = calendar.get(Calendar.HOUR_OF_DAY);
//        int minuteC = calendar.get(Calendar.MINUTE);
//        int secondC = calendar.get(Calendar.SECOND);
//        int millisC = calendar.get(Calendar.MILLISECOND);
//
//        System.out.println("Date: " + date);
//        System.out.println("Year: " + yearC + " Month: " + monthC
//                + " Week: " + weekC + " Day: " + dayC + " Hour: " + hourC
//                + " Minute: " + minuteC + " Second: " + secondC + " Millis: " + millisC);
//
//        System.out.println("\nStarting with JDK 8:");
//
//        LocalDateTime ldt = LocalDateTime.now();
//
//        int yearLDT = ldt.getYear();
//        int monthLDT = ldt.getMonthValue();
//        int dayLDT = ldt.getDayOfMonth();
//        int hourLDT = ldt.getHour();
//        int minuteLDT = ldt.getMinute();
//        int secondLDT = ldt.getSecond();
//        int nanoLDT = ldt.getNano();
//
//        System.out.println("LocalDateTime: " + ldt);
//        System.out.println("Year: " + yearLDT + " Month: " + monthLDT
//                + " Day: " + dayLDT + " Hour: " + hourLDT + " Minute: " + minuteLDT
//                + " Second: " + secondLDT + " Nano: " + nanoLDT);
//
//        int yearLDT2 = ldt.get(ChronoField.YEAR);
//        int monthLDT2 = ldt.get(ChronoField.MONTH_OF_YEAR);
//        int dayLDT2 = ldt.get(ChronoField.DAY_OF_MONTH);
//        int hourLDT2 = ldt.get(ChronoField.HOUR_OF_DAY);
//        int minuteLDT2 = ldt.get(ChronoField.MINUTE_OF_HOUR);
//        int secondLDT2 = ldt.get(ChronoField.SECOND_OF_MINUTE);
//        int nanoLDT2 = ldt.get(ChronoField.NANO_OF_SECOND);
//
//        System.out.println("Year: " + yearLDT2 + " Month: " + monthLDT2
//                + " Day: " + dayLDT2 + " Hour: " + hourLDT2 + " Minute: " + minuteLDT2
//                + " Second: " + secondLDT2 + " Nano: " + nanoLDT2);


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a, MMM dd, yyyy");
        DateTimeFormatter zoneFormatter = DateTimeFormatter.ofPattern("hh:mm a, MMM dd, yyyy Z VV");

        LocalDateTime ldt = LocalDateTime.of(2019, Month.FEBRUARY, 26, 16, 00);

        System.out.println("Perth LocalDateTime: " + ldt.format(formatter)
                + " | Scheduled Flight Time: 15 hours and 30 minutes\n");

        ZonedDateTime auPerthDepart = ldt.atZone(ZoneId.of("Europe/Paris"));
        ZonedDateTime euBucharestDepart = auPerthDepart.withZoneSameInstant(ZoneId.of("Europe/Paris"));

        ZonedDateTime auPerthArrive = auPerthDepart.plusHours(15).plusMinutes(30);
        ZonedDateTime euBucharestArrive = auPerthArrive.withZoneSameInstant(ZoneId.of("Europe/Paris"));

        OffsetDateTime utcAtDepart = auPerthDepart.withZoneSameInstant(ZoneId.of("UTC")).toOffsetDateTime();
        OffsetDateTime utcAtArrive = auPerthArrive.withZoneSameInstant(ZoneId.of("UTC")).toOffsetDateTime();

        System.out.println("UTC time at depart is: " + utcAtDepart.format(formatter));
        System.out.println("UTC time at arrive is: " + utcAtArrive.format(formatter));
        System.out.println("\nAt depart, in Perth is: " + auPerthDepart.format(zoneFormatter));
        System.out.println("At arrive, in Perth is: " + auPerthArrive.format(zoneFormatter));
        System.out.println("\nAt depart, in Bucharest is: " + euBucharestDepart.format(zoneFormatter));
        System.out.println("At arrive, in Bucharest is: " + euBucharestArrive.format(zoneFormatter));
    }
}
