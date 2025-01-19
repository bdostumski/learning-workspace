/*
        Problem 10. Beer Time

        A beer time is after 1:00 PM and before 3:00 AM.
        Write a program that enters a time in format “hh:mm tt” (an hour in range [01...12],
        a minute in range [00…59] and AM / PM designator) and prints beer time or non-beer time
        according to the definition above or invalid time if the time cannot be parsed.

        Note: You may need to learn how to parse dates and times.

        Examples:
        time           	result
        1:00 PM 	beer time
        4:30 PM 	beer time
        10:57 PM 	beer time
        8:30 AM 	non-beer time
        02:59 AM 	beer time
        03:00 AM 	non-beer time
        03:26 AM 	non-beer time
 */

import java.io.ByteArrayInputStream;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.LocalTime;

public class BeerTime {

    public static void main(String[] args) {

        fakeInput();

        Scanner cin = new Scanner(System.in);

        String input = cin.nextLine();
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("h:mm a");

        // A beer time is after 1:00 PM and before 3:00 AM.
        LocalTime timeNow = LocalTime.parse(input, timeFormat);
        LocalTime affterPM = LocalTime.parse("12:59 PM", timeFormat);
        LocalTime beforeAM = LocalTime.parse("2:59 AM", timeFormat);

        if(timeNow.isAfter(affterPM) || timeNow.equals(affterPM)) {
            System.out.println("beer time");
        } else if (timeNow.isBefore(beforeAM) || timeNow.equals(beforeAM)) {
            System.out.println("beer time");
        } else {
            System.out.println("non-beer time");
        }

    }

    private static void fakeInput() {
        String test = "03:26 AM";

        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

}
