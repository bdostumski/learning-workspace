import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class NumberWave {

    public static void main(String[] args) {

        fakeInput();

        Scanner cin = new Scanner(System.in);

        int n = Integer.parseInt(cin.nextLine());

        int counter = 1;
        for (int i = 1; i <= n; i++) {
            System.out.printf("%d ", i);
            if(i == n) {
                for (int j = n-1; j >= 1; j--) {
                    System.out.printf("%d ", j);
                }
            }
        }

    }

    private static void fakeInput() {

        String test = "3";

        System.setIn(new ByteArrayInputStream(test.getBytes()));

    }

}
