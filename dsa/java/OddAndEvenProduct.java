/*

    Odd and Even Product
    Description
    You are given N integers, each on a new line

    Write a program that checks whether the product of the odd lines is equal to the product of the even lines.
    Lines are counted from 1 to N, so the first line is odd, the second is even, etc.

    Input
    On the first line you will receive the number N
    On each of the next N lines, you will receive a number

    Output
    If the two products are equal, output a string in the format "yes PRODUCT_VALUE",
    otherwise write on the console "no ODD_PRODUCT_VALUE EVEN_PRODUCT_VALUE"

    Constraints
    N will always be a valid integer number in the range [4, 50]
    All input numbers will also be valid integers in range [-1000000, 1000000]

    Sample tests
    Input
    5
    2
    1
    1
    6
    3

    Output
    yes 6


    Input
    5
    4
    3
    2
    5
    2

    Output
    no 16 15

 */

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class OddAndEvenProduct {

    public static void main(String[] args) {

        fakeInput();

        Scanner cin = new Scanner(System.in);

        int n = Integer.parseInt(cin.nextLine());

        int prodOdd = 1;
        int prodEven = 1;



        for (int i = 1; i <= n; i++) {
            int currentNumber = Integer.parseInt(cin.nextLine());
            if(i % 2 == 0) {
                prodEven *= currentNumber;
            } else {
                prodOdd *= currentNumber;
            }
        }


        if(prodOdd == prodEven) {
            System.out.printf("yes %d", prodEven);
        } else {
            System.out.printf("no %d %d", prodOdd, prodEven);
        }


    }

    private static void fakeInput() {

        String test = "5\n" +
                "2\n" +
                "1\n" +
                "1\n" +
                "6\n" +
                "3";

//        String test = "5\n" +
//                "4\n" +
//                "3\n" +
//                "2\n" +
//                "5\n" +
//                "2";

        System.setIn(new ByteArrayInputStream(test.getBytes()));

    }

}
