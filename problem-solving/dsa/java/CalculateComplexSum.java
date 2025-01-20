/*
        Calculate Complex Sum
        Description
        Write a program that, for a given two numbers N and x, calculates the sum S = 1 + 1!/x + 2!/x2 + … + N!/xN.

        Use only one loop. Print the result with 5 digits after the decimal point.

        Input
        On the first line you will receive one number - N.
        On the second line you will receive another number - x.

        Output
        Output only one number - the sum of the sequence for the given N and x.

        Constraints
        N will always be a valid integer between 2 and 10, inclusive.
        X will always be a valid floating-point number between 0.5 and 100

        Sample tests
        Input	Output
        3
        2	    2.75000
        4
        3	    2.07407
        5
        -4	    0.75781

 */

import java.util.Scanner;

public class CalculateComplexSum {

    public static void main(String[] args) {

        // Write a program that, for a given two numbers N and x,
        // calculates the sum S = 1 + 1!/x + 2!/x2 + … + N!/xN.

        Scanner cin = new Scanner(System.in);

        int n = Integer.parseInt(cin.nextLine());
        double x = Double.parseDouble(cin.nextLine());

        double sum = 1.0;
        int fact = 1;

        for (int i = 1; i <= n; i++) {
            fact *= i;
            sum += fact / Math.pow(x, i);
        }


        System.out.printf("%.5f", sum);
    }

}
