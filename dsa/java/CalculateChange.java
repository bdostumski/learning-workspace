/*
        Calculate Change
        Write a program that determines the least amount of coins needed for a cashier to return change.

        For example, if the price of something is 0.76 leva and the customer has paid 1 leva,
        the least amount of coins is 1 x 20 stotinki and 2 x 2 stotinki.

        Use the coins of 1 lev, 50, 20, 10, 5, 2 and 1 stotinki.

        Input
        On the first line, you will receive the price in leva.
        On the second line, you will receive how much the customer has paid in leva.

        Output
        There is a variable amount of output lines.
        Print each required denomination on a new line, ordered from highest to lowest.


        Input
        0.76
        1

        Output
        1 x 20 stotinki
        2 x 2 stotinki


        Input
        1.92
        5

        Output
        3 x 1 lev
        1 x 5 stotinki
        1 x 2 stotinki
        1 x 1 stotinka
 */


import java.io.ByteArrayInputStream;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculateChange {

    public static void main(String[] args) {

        // Write a program that determines the least amount of coins needed for a cashier to return change.

        fakeInput();

        Scanner cin = new Scanner(System.in);


        // Use the coins of 1 lev, 50, 20, 10, 5, 2 and 1 stotinki.

        int oneLev = 0;
        int fifteenCoints = 0;
        int twentyCoints = 0;
        int thenCoints = 0;
        int fiveCoints =  0;
        int twoCoints = 0;
        int oneCoints = 0;


        /*
            Input
            On the first line, you will receive the price in leva.
            On the second line, you will receive how much the customer has paid in leva.
         */

        double priceLeva = Double.parseDouble(cin.nextLine());
        double customerPay = Double.parseDouble(cin.nextLine());
        double result = customerPay - priceLeva;

        DecimalFormat df = new DecimalFormat("#.###");
        df.setRoundingMode(RoundingMode.CEILING);

        while(result >= 0.005) {

            if(result - 1.0 > 0) {
                result = Double.parseDouble(df.format(result - 1.0));
                oneLev++;
            } else if (result - 0.50 >= 0.0) {
                result = Double.parseDouble(df.format(result - 0.50));
                fifteenCoints++;
            } else if (result - 0.20 >= 0.0) {
                result = Double.parseDouble(df.format(result - 0.20));
                twentyCoints++;
            } else if (result - 0.10 >= 0.0) {
                result = Double.parseDouble(df.format(result - 0.10));
                thenCoints++;
            } else if (result - 0.05 >= 0.0) {
                result = Double.parseDouble(df.format(result - 0.05));
                fiveCoints++;
            } else if (result - 0.02 >= 0.0) {
                result = Double.parseDouble(df.format(result - 0.02));
                twoCoints++;
            } else if (result - 0.01 >= 0.0) {
                result = Double.parseDouble(df.format(result - 0.01));
                oneCoints++;
            }

        }

        if(oneLev > 0)
            System.out.printf("%d x 1 lev%n", oneLev);
        if(fifteenCoints > 0)
            System.out.printf("%d x 50 stotinki%n", fifteenCoints);
        if(twentyCoints > 0)
            System.out.printf("%d x 20 stotinki%n", twentyCoints);
        if(thenCoints > 0)
            System.out.printf("%d x 10 stotinki%n", thenCoints);
        if(fiveCoints > 0)
            System.out.printf("%d x 5 stotinki%n", fiveCoints);
        if(twoCoints > 0)
            System.out.printf("%d x 2 stotinki%n", twoCoints);
        if(oneCoints >0)
            System.out.printf("%d x 1 stotnka%n", oneCoints);

        /*
            Output
            3 x 1 lev
            1 x 5 stotinki
            1 x 2 stotinki
            1 x 1 stotinka
         */




    }

    private static void fakeInput() {

        String test = "0.76\n" +
                "1";

//        String test = "1.92\n" +
//                "5";

        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

}
