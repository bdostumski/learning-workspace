import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayMaximumSequence {

    public static void main(String[] args) {

        fakeInput();

        Scanner cin = new Scanner(System.in);

        String[] rawInput = cin.nextLine().split(" ");
        int[] array = new int[rawInput.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(rawInput[i]);
        }

        int counter = 1;
        int maxCounter = 1;
        for (int i = 0; i < array.length - 1; i++) {
            if(array[i] == array[i+1]) {
                counter++;
                if(counter > maxCounter) {
                    maxCounter = counter;
                }
            } else {
                counter = 1;
            }
        }

        System.out.println(maxCounter);

    }

    private static void fakeInput() {
        String test = "2 1 1 1 1 1 1 2 3 3 2 2 2 2 1 1 1 1 1";

        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

}
