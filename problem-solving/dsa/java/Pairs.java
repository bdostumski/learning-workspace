import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Pairs {

    public static void main(String[] args) {

        fakeInput();

        Scanner cin = new Scanner(System.in);

        int n = Integer.parseInt(cin.nextLine());

        String[] input = cin.nextLine().split(" ");
        int[] array = new int[input.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if(array[i] + array[j] == n) {
                    System.out.printf("%d %d%n", array[i], array[j]);
                }
            }
        }

    }

    private static void fakeInput() {
        String test = "6\n" +
                "1 2 3 4 3 6 5 8 3 9";

        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

}
