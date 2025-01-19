import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class IsArrayInWaveForm {

    public static void main(String[] args) {

        fakeInput();

        Scanner cin = new Scanner(System.in);

        String[] input = cin.nextLine().split(" ");
        int[] array = new int[input.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        boolean isWaveForm = true;
        boolean switcher = true;

        for (int i = 0; i < array.length - 1; i++) {
            if(switcher) {
                if(array[i] > array[i+1]) {
                    isWaveForm = true;
                } else {
                    isWaveForm = false;
                    break;
                }
                switcher = false;
            } else {
                if(array[i] < array[i+1]) {
                    isWaveForm = true;
                } else {
                    isWaveForm = false;
                    break;
                }
                switcher = true;
            }
        }

        if(isWaveForm) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }

    private static void fakeInput() {

        String test = "2 1 2 1 2 1 2";
//        String test = "7 3 5 2 8 4";
//        String test = "2 1 3 4 2 3";


        System.setIn(new ByteArrayInputStream(test.getBytes()));

    }

}
