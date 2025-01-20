import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class IsArraySymmetric {

    public static void main(String[] args) {

        fakeInput();

        Scanner cin = new Scanner(System.in);

        String[] input = cin.nextLine().split(" ");
        int[] array = new int[input.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        boolean isArraySymmetric = true;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == array[array.length - 1 - i] && array[array.length / 2] >= array[array.length / 2 - 1]) {
                isArraySymmetric = true;
            } else {
                isArraySymmetric = false;
                break;
            }
        }

        if (isArraySymmetric) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

//        System.out.println(Arrays.toString(array));


    }

    private static void fakeInput() {
        String test = "1 2 3 4 4 3 2 1";
//        String test = "7 8 9 8 7";
//        String test = "3 4 5 3 4 5";

        System.setIn(new ByteArrayInputStream(test.getBytes()));

    }

}
