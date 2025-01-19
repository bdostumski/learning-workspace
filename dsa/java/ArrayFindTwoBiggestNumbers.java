import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class ArrayFindTwoBiggestNumbers {

    public static void main(String[] args) {

        fakeInput();

        Scanner cin = new Scanner(System.in);

        String[] rawInput = cin.nextLine().split(" ");
        int[] array = new int[rawInput.length];

        int biggest = Integer.MIN_VALUE;
        int smallest = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(rawInput[i]);

            if(biggest <= array[i]) {
                smallest = biggest;
                biggest = array[i];
            }

        }

        System.out.println(biggest + " " + smallest);

    }

    private static void fakeInput() {

        String test = "8 2 1 3 5 8 9 11 2 5";
//        String test = "8 7 8 11 7 11 5 8 10";

        System.setIn(new ByteArrayInputStream(test.getBytes()));

    }

}
