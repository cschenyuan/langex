package com.atella.java.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * Referred instruction <a>http://tutorials.jenkov.com/java-date-time/index.html</a>
 * Created by yuan on 16/10/9.
 */
public class DateExample {

    public static void main(String[] args) throws Exception {
//        testDate();
//        testCalendar();
//        testTimeZone();
//        testDateFormat();
        testInstant();
//        testDuration();
    }

    static void print() {
        print("");
    }

    static void print(Object out) {
        System.out.println(out);
    }

    static void testDate() {
        Date date = new Date();
        System.out.println(date.getTime());
        System.out.println(date.toString());
    }

    static void testCalendar() {
        Calendar calendar = new GregorianCalendar();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        print(String.format("%s-%s-%s %s:%s:%s",
                year, month, day, hour, minute, second));

        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        int weekOfYear = calendar.getWeeksInWeekYear();

        print("day of year: " + dayOfYear);
        print("week of year: " + weekOfYear);


        calendar.set(Calendar.YEAR, 2016);
        calendar.set(Calendar.MONTH, 12);
        calendar.set(Calendar.DAY_OF_MONTH, 31);

        calendar.add(Calendar.DAY_OF_MONTH, 1);

        print(calendar.getTime().toString());
    }

    static void testTimeZone() {
        Arrays.asList(TimeZone.getAvailableIDs()).stream()
                .forEach( zone ->  print(zone) );

        Calendar calendar = new GregorianCalendar();
        TimeZone tz = calendar.getTimeZone();
        print(tz.getDisplayName());
        print(tz.getID());

        print(calendar.get(Calendar.HOUR_OF_DAY));
        calendar.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
        print(calendar.get(Calendar.HOUR_OF_DAY));
        print(calendar.getTime().toString());
    }

    /**
    * y   = year   (yy or yyyy)
    * M   = month  (MM)
    * d   = day in month (dd)
    * h   = hour (0-12)  (hh)
    * H   = hour (0-23)  (HH)
    * m   = minute in hour (mm)
    * s   = seconds (ss)
    * S   = milliseconds (SSS)
    * z   = time zone  text        (e.g. Pacific Standard Time...)
    * Z   = time zone, time offset (e.g. -0800)
    **/
    static void testDateFormat() throws ParseException {
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
        Date date = format1.parse("2099-12-31 23:59:59:999");
        DateFormat format2 = new SimpleDateFormat("yy/MM/dd hh:mm:ss:SS z/Z");
        String dateString = format2.format(date);
        print(dateString);
    }

    // 表示一瞬间
    static void testInstant() {
        Instant now = Instant.now();
        Instant any = Instant.ofEpochSecond(1262275200L);
        print(any.getEpochSecond());

        print(now.getEpochSecond());
        Instant later = now.plusSeconds(-1);
        Instant earlier = now.minusSeconds(3);
        print(later.getEpochSecond());
        print(earlier.getEpochSecond());

        Instant _20100101 = Instant.ofEpochSecond(1262275200L);
        Instant _20150101 = Instant.ofEpochSecond(1420041600L);
        Instant _20161231 = Instant.ofEpochSecond(1483199999L);

        print(_20100101.compareTo(_20100101));
        print(_20100101.compareTo(_20150101));
        print(_20161231.compareTo(_20150101));
    }

    // 表示一段时间
    static void testDuration() {
        Instant first = Instant.now();
        Instant second = first.plus(1L, ChronoUnit.DAYS);

        Duration duration = Duration.between(first, second);
        Duration oneDay = Duration.ofDays(1);
        Duration oneHour = Duration.ofHours(12);

        print(duration.toHours());
        print(duration.toMinutes());
        print(duration.toMillis());
    }

    static void test() {
    }

}
