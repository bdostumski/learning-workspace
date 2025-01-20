import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class OddEvenProduct {

    public static void main(String[] args) {

        fakeInput();

        Scanner cin = new Scanner(System.in);

        String[] input = cin.nextLine().split(" ");
        int[] array = new int[input.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        int oddProd = 1;
        int evenProd = 1;

        for (int i = 0; i < array.length; i++) {
            if(i % 2 == 0) {
                evenProd *= array[i];
            } else {
                oddProd *= array[i];
            }
        }

        if(evenProd == oddProd) {
            System.out.println("yes");
            System.out.println("product = " + evenProd);
        } else {
            System.out.println("no");
            System.out.println("odd_product = " + oddProd);
            System.out.println("even_product = " + evenProd);
        }

    }

    private static void fakeInput() {

        String test = "4 3 2 5 2";

        System.setIn(new ByteArrayInputStream(test.getBytes()));

    }

}
