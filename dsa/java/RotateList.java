/*
        Rotate List
        Write a program that rotates a list several times (the first element becomes last).

        list = 1,2,3,4,5 and N = 2 -> result = 3,4,5,1,2
        Note that N could be larger than the length of the list.

        list = 1,2,3,4,5 and N = 6 -> result = 2,3,4,5,1
        Input
        On the first line you will receive the list of numbers.
        On the second line you will receive N
        Output
        On the only line of output, print the numbers separated by a space.

        Input
        5,3,2,1
        2
        Output
        2,1,5,3

        Input
        2,1,3,4
        5
        Output
        1,3,4,2
 */


import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class RotateList {

    public static void main(String[] args) {

        fakeInput();

        Scanner cin = new Scanner(System.in);

        String[] input = cin.nextLine().split(",");
        int n = Integer.parseInt(cin.nextLine());

        int[] array = new int[input.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                int temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
            }
        }

        System.out.println(Arrays.toString(array));

    }

    private static void fakeInput() {
        String test = "5,3,2,1\n" +
                "2";

        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

}
