import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class CalculateDiscount {

    public static void main(String[] args) {

        fakeInput();

        Scanner cin = new Scanner(System.in);

        int n = Integer.parseInt(cin.nextLine());
        double[] array = new double[n];

        for (int i = 0; i < n; i++) {
            array[i] = Double.parseDouble(cin.nextLine());
            System.out.printf("%.2f%n", (100 - 65) * array[i] / 100);
        }

//        System.out.println(Arrays.toString(array));

    }

    private static void fakeInput() {

//        String test = "2\n" +
//                "50\n" +
//                "40";

        String test = "4\n" +
                "9.99\n" +
                "19.99\n" +
                "29.99\n" +
                "39.99";

        System.setIn(new ByteArrayInputStream(test.getBytes()));

    }

}
