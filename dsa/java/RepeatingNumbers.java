import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class RepeatingNumbers {

    public static void main(String[] args) {

        fakeInput();

        Scanner cin = new Scanner(System.in);

        String[] rawInput = cin.nextLine().split(" ");
        int[] array = new int[rawInput.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(rawInput[i]);
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if(array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = array[j];
                }
            }
        }

        int result = 0;
        for (int i = 0; i < array.length-1; i++) {
            if(array[i] == array[i+1]) {
                result = array[i];
            }
        }

        System.out.println(result);
//        System.out.println(Arrays.toString(array));

    }

    private static void fakeInput() {
        String test = "1 2 3 4 5 6 5 8 9";

        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

}
