import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class BottleDeposit {

    public static void main(String[] args) {

        fakeInput();

        Scanner cin = new Scanner(System.in);

        int smallBottles = Integer.parseInt(cin.nextLine()); // 0.5L bottles
        int bigBottles = Integer.parseInt(cin.nextLine()); // 1L bottles

        double depositSmallBottles = 0.1; // Desposit 0.5L bottles
        double depositBigBottles = 0.25; // Deposit 1L bottles

        double result = (smallBottles * depositSmallBottles) + (bigBottles * depositBigBottles);

        System.out.printf("%.2f", result);


        // 10 * 0.1 = 1
        // 10 * 0.25 = 2.5
        // result = 3.5

    }

    private static void fakeInput() {
        String test = "10\n" +
                "10";

        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

}
