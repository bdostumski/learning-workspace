import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class SmallerGreaterOrEqual {

    public static void main(String[] args) {

        fakeIntpu();

        Scanner cin = new Scanner(System.in);

        int n = Integer.parseInt(cin.nextLine());
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(cin.nextLine());
        }

        String result = "";
        for (int i = 0; i < n - 1; i++) {
            if(array[i] < array[i+1]) {
                result += array[i] + "<";
            } else if(array[i] > array[i+1]) {
                result += array[i] + ">";
            } else {
                result += array[i] + "=";
            }
        }
        result += array[n-1];

        System.out.println(result);

//        System.out.println(Arrays.toString(array));

    }

    private static void fakeIntpu() {

//        String test = "3\n" +
//                "2\n" +
//                "5\n" +
//                "1";

        String test = "4\n" +
                "-1\n" +
                "4\n" +
                "4\n" +
                "4";

        System.setIn(new ByteArrayInputStream(test.getBytes()));

    }

}
