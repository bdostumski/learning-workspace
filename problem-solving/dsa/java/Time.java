/*
        Time
        Write a program that reads days, hours, minutes and seconds from the standard input.
        Display the total amount of seconds.

        Input
        First line - d - days
        Second line - h - hours
        Third line - m - minutes
        Fourth line - s - seconds

        Output
        On the only line of output, print the total amount of seconds

        Constraints
        0 <= d, h, m, s <= 1000


        Input
        4
        3
        11
        40

        Output
        357100


        Input
        0
        2
        6
        0

        Output
        7560
 */

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class Time {

    public static void main(String[] args) {

        fakeInput();

        Scanner cin = new Scanner(System.in);

        int days = Integer.parseInt(cin.nextLine());    // 24 * 60 * 60
        int hours = Integer.parseInt(cin.nextLine());   // 60 * 60
        int minutes = Integer.parseInt(cin.nextLine()); // 60
        int seconds = Integer.parseInt(cin.nextLine()); // 1

        int d = days * 24 * 60 * 60;
        int h = hours * 60 * 60;
        int m = minutes * 60;
        int s = seconds;

        int totalSeconds = 0;

        totalSeconds = d + h + m + s;

        System.out.println(totalSeconds);
    }

    private static void fakeInput() {

        String test = "4\n" +
                "3\n" +
                "11\n" +
                "40";

        System.setIn(new ByteArrayInputStream(test.getBytes()));

    }
}
