/*
        Jumps
        Given a sequence of elements(numbers), calculate the longest possible sequence of 'jumps' from each number.

        Each 'jump' must be made according to the following rules:

        You can only 'jump' on a number that is greater than the current one;
        You can 'jump' on a number, only if there isn't one with a greater value between;
        You can 'jump' only from left to right;
        Input
        Read from the standard input

        On the first line, you will find the number N
        The number of elements
        On the second line you will find N numbers, separated by a space
        The elements themselves
        The input will be correct and in the described format, so there is no need to check it explicitly.

        Output
        Print to the standard output

        On the first line, print the length of the longest sequence of jumps
        On the second line, print the lengths of the sequences, starting from each element
        Constraints
        The N will always be less than 103344
        Sample Tests
        Input
        6
        1 4 2 6 3 4
        Output
        2
        2 1 1 0 1 0
        Explanation
        Element 1:
        1 -> 4 -> 6 (2 jumps)
        Element 2:
        4 -> 6 (1 jump)
        Element 3:
        2 -> 6 (1 jump)
        Element 4:
        6 (0 jumps)
        Element 5:
        3 -> 4 (1 jump)
        Element 6:
        4 -> (0 jumps)
        Input
        5
        1 1 1 1 1
        Output
        0
        0 0 0 0 0
 */

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Jumps {

    public static void main(String[] args) {

        fakeInput();

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] numbersStr = scanner.nextLine().split(" ");

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(numbersStr[i]);
        }

        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && numbers[i] >= numbers[stack.peek()]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[i] = result[stack.peek()] + 1;
            }
            stack.push(i);
        }

        StringBuilder output = new StringBuilder();
        output.append(Arrays.stream(result).max().getAsInt());
        output.append("\n");
        for (int x : result) {
            output.append(x);
            output.append(" ");
        }

        System.out.println(output);

    }

    public static void fakeInput() {
//        String test = "6\n" +
//                "1 4 2 6 3 4";

        String test = "5\n" +
                "1 1 1 1 1";
//
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

}

/*
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] numbersStr = scanner.nextLine().split(" ");

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(numbersStr[i]);
        }

        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && numbers[i] >= numbers[stack.peek()]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[i] = result[stack.peek()] + 1;
            }
            stack.push(i);
        }

        StringBuilder output = new StringBuilder();
        output.append(Arrays.stream(result).max().getAsInt());
        output.append("\n");
        for (int x : result) {
            output.append(x);
            output.append(" ");
        }

        System.out.println(output);
    }
}
 */
