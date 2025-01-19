import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class BalancedNumber {

    public static void main(String[] args) {

        fakeInput();

        Scanner cin = new Scanner(System.in);

        boolean isBalanced;
        int sum = 0;

        do {
            isBalanced = false;

            String input = cin.nextLine();

            int a = Integer.parseInt(String.valueOf(input.charAt(0)));
            int b = Integer.parseInt(String.valueOf(input.charAt(1)));
            int c = Integer.parseInt(String.valueOf(input.charAt(2)));

            if(b == a + c) {
                sum += Integer.parseInt(input);
                isBalanced = true;
            }

        } while(isBalanced);

        System.out.println(sum);

    }

    private static void fakeInput() {
//        String test = "132\n" +
//                "123";

        String test = "275\n" +
                "693\n" +
                "110\n" +
                "742";

        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

}
