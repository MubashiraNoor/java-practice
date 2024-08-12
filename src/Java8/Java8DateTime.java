package Java8;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatterBuilder;

public class Java8DateTime {
    public static void main(String[] args) {

      LocalDate date = LocalDate.now();
        System.out.println("Today's date is " + date);

      LocalTime time = LocalTime.now();
        System.out.println("Today's time is " + time);


    }
}
