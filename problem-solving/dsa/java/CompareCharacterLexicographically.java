/*
    Compare Character Arrays Lexicographically
    Write a program that compares two char arrays lexicographically (letter by letter).
    Research how to convert string to char array.

    Input:
        On the first line, you will receive the first array as a string
        On the second line, you will receive the second array as a string

    Output:
        Print First if the first array is lexicographically smaller
        Print Second if the second array is lexicographically smaller
        Print Equal if the arrays are equal


    Examples:
    Input           Output
    telerik
    teleric 	    Second
 */

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class CompareCharacterLexicographically {

    public static void main(String[] args) {

        fakeInput();

        Scanner cin = new Scanner(System.in);

        char[] input1 = cin.nextLine().toLowerCase().toCharArray();
        char[] input2 = cin.nextLine().toLowerCase().toCharArray();


        /*
            Output:
                Print First if the first array is lexicographically smaller
                Print Second if the second array is lexicographically smaller
                Print Equal if the arrays are equal
         */


        if(input1.length < input2.length) {
            System.out.println("First");
        } else if (input1.length > input2.length) {
            System.out.println("Second");
        } else if (input1.length == input2.length) {
            boolean areEqual = true;
            for (int i = 0; i < input1.length; i++) {
                if(input1[i] == input2[i]) {
                    areEqual = true;
                } else if(input1[i] < input2[i]) {
                    System.out.println("First");
                    areEqual = false;
                    break;
                } else if(input1[i] > input2[i]) {
                    System.out.println("Second");
                    areEqual = false;
                    break;
                }
            }
            if(areEqual) {
                System.out.println("Equal");
            }

        }

        System.out.println(Arrays.toString(input1));
        System.out.println(Arrays.toString(input2));

    }

    private static void fakeInput() {

        String test = "telerik\n" +
                "telerika";

        System.setIn(new ByteArrayInputStream(test.getBytes()));

    }

}
