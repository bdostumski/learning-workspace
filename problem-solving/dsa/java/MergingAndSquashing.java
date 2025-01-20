import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class MergingAndSquashing {

    public static void main(String[] args) {

        fakeInput();

        Scanner cin = new Scanner(System.in);
        int n = Integer.parseInt(cin.nextLine());
        String[] array = new String[n];

        // Merging ab and cd produces bc
        // Squashing ab and cd produces a(b+c)d - the middle digit is the sum of b and c

        for (int i = 0; i < n; i++) {
            array[i] = cin.nextLine();
        }

        String merged = "";
        String squashed = "";

        for (int i = 0; i < n - 1; i++) {
            String a = String.valueOf(array[i].charAt(0));
            int b = Integer.parseInt(String.valueOf(array[i].charAt(1)));
            int c = Integer.parseInt(String.valueOf(array[i+1].charAt(0)));
            String d = String.valueOf(array[i+1].charAt(1));

            merged += String.valueOf(b) + c + " ";
            int sum = (b + c) % 10;
            squashed += a + sum + d + " ";

        }

        System.out.println(merged.substring(0, merged.length()-1));
        System.out.println(squashed.substring(0, squashed.length()-1));
        System.out.println(Arrays.toString(array));

    }

    private static void fakeInput() {
        String test = "11\n" +
                "44\n" +
                "69\n" +
                "46\n" +
                "63\n" +
                "83\n" +
                "13\n" +
                "62\n" +
                "14\n" +
                "31\n" +
                "68\n" +
                "87";

        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

}
