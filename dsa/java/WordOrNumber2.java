import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class WordOrNumber2 {

    public static void main(String[] args) {

        fakeInput();

        Scanner cin = new Scanner(System.in);

        int n = Integer.parseInt(cin.nextLine());
        String[] array = new String[n];

        for (int i = 0; i < n; i++) {
            array[i] = cin.nextLine();
        }

        int sum = 0;
        String result = "";

        for (int i = 0; i < array.length; i++) {

            if((int)array[i].charAt(0) > 47 && (int)array[i].charAt(0) < 58) {
                sum += Integer.parseInt(array[i]);
            } else {
                result += array[i] + "-";
            }

        }

        result = (result.length() > 1) ? result.substring(0, result.lastIndexOf("-")) : "no words";


        System.out.printf("%s%n", result);
        System.out.printf("%d%n", sum);

//        System.out.println(Arrays.toString(array));

    }

    private static void fakeInput() {

        String test = "5\n" +
                "1\n" +
                "go\n" +
                "1\n" +
                "there\n" +
                "5";

        System.setIn(new ByteArrayInputStream(test.getBytes()));

    }

}
