import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class NegativePositiveSort {

    public static void main(String[] args) {

        fakeInput();

        Scanner cin = new Scanner(System.in);

        String[] rawInput = cin.nextLine().split(" ");
        int[] array = new int[rawInput.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(rawInput[i]);
        }

        String[] sortedArray = new String[array.length];

        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] < 0) {
                sortedArray[counter] = String.valueOf(array[i]);
                counter++;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if(array[i] == 0) {
                sortedArray[counter] = String.valueOf(array[i]);
                counter++;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if(array[i] > 0) {
                sortedArray[counter] = String.valueOf(array[i]);
                counter++;
            }
        }

        String result = String.join(" ", sortedArray);
        System.out.println(result);

    }

    private static void fakeInput() {

        String test = "7 2 -2 1 -5 4 5 -3 1 0";

        System.setIn(new ByteArrayInputStream(test.getBytes()));

    }

}
