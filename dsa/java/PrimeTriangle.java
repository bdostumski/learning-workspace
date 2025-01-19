import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class PrimeTriangle {

    public static void main(String[] args) {

        fakeInput();

        Scanner cin = new Scanner(System.in);
        int n = Integer.parseInt(cin.nextLine());

        for (int i = 1; i <= n; i++) {
            boolean isPrimeNumber = true;
            for (int j = 2; j < n / 2; j++) {
                if(i != j && i % j == 0) {
                    isPrimeNumber = false;
                    break;
                }
            }

            if (isPrimeNumber) {
                for (int j = 1; j <= i; j++) {
                    boolean isPrime = true;
                    for (int k = 2; k < n / 2; k++) {
                        if(j != k && j % k == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                    if (isPrime) {
                        System.out.print(1);
                    } else {
                        System.out.print(0);
                    }
                }
                System.out.println();
            }
        }

    }

    private static void fakeInput() {
        String test = "10";

        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

}
