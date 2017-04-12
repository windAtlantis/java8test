package java8.newLib;

import java.time.*;

/**
 * @author Karl
 * @date 2017/4/12 22:35
 */
public class DateLib {

    /*
    * Joda-Time——一个可替换标准日期/时间处理且功能非常强大的Java API的诞生。
    * Java 8新的Date-Time API (JSR 310)在很大程度上受到Joda-Time的影响，并且吸取了其精髓。
    * 新的java.time包涵盖了所有处理日期，时间，日期/时间，时区，时刻（instants），过程（during）与时钟（clock）的操作。
    * 在设计新版API时，十分注重与旧版API的兼容性：不允许有任何的改变（从java.util.Calendar中得到的深刻教训）。
    * 如果需要修改，会返回这个类的一个新实例。
    */
    public static void main(String[] args) {

        // 第一个是Clock类，它通过指定一个时区，然后就可以获取到当前的时刻，日期与时间。
        // Clock可以替换System.currentTimeMillis()与TimeZone.getDefault()。
        System.out.println("\r\n// Get the system clock as UTC offset");
        final Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
        System.out.println(clock.millis());

        // 我们需要关注的其他类是LocaleDate与LocalTime。LocaleDate只持有ISO-8601格式且无时区信息的日期部分。
        // 相应的，LocaleTime只持有ISO-8601格式且无时区信息的时间部分。LocaleDate与LocalTime都可以从Clock中得到。
        System.out.println("\r\n// Get the local date and local time");
        final LocalDate localDate = LocalDate.now();
        final LocalDate dateFromClick = LocalDate.now(clock);
        System.out.println(localDate);
        System.out.println(dateFromClick);
        final LocalTime localTime = LocalTime.now();
        final LocalTime timeFromClick = LocalTime.now(clock);
        System.out.println(localTime);
        System.out.println(timeFromClick);

        // LocaleDateTime把LocaleDate与LocaleTime的功能合并起来，它持有的是ISO-8601格式无时区信息的日期与时间。
        System.out.println("\r\n// Get the local date/time");
        final LocalDateTime localDateTime = LocalDateTime.now();
        final LocalDateTime dateTimeFromClick = LocalDateTime.now(clock);
        System.out.println(localDateTime);
        System.out.println(dateTimeFromClick);

        // 如果你需要特定时区的日期/时间，那么ZonedDateTime是你的选择。它持有ISO-8601格式具具有时区信息的日期与时间。
        System.out.println("\r\n// Get the zoned date/time");
        final ZonedDateTime zonedDateTime = ZonedDateTime.now();
        final ZonedDateTime zonedDateTimeFromClick = ZonedDateTime.now(clock);
        final ZonedDateTime zonedDateTimeFromZone = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTimeFromClick);
        System.out.println(zonedDateTimeFromZone);

        // 在秒与纳秒级别上的一段时间。Duration使计算两个日期间的不同变的十分简单。
        System.out.println("\r\n// Get duration between two dates");
        final LocalDateTime from = LocalDateTime.of(2014, Month.APRIL, 16, 0 ,0, 0);
        final LocalDateTime to = LocalDateTime.of(2015, Month.APRIL, 16, 23, 59, 59);
        final Duration duration = Duration.between(from, to);
        System.out.println( "Duration in days: " + duration.toDays() );
        System.out.println( "Duration in hours: " + duration.toHours() );
        System.out.println( "Duration in nanos: " + duration.toNanos());

    }
}
