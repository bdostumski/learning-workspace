import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class CrookedDigits {

    public static void main(String[] args) {

        /*
            * Sums the digits of the number N and stores the result back in N.
            * If the obtained result is bigger than 9, step 1. is repeated, otherwise the algorithm finishes.
            * The last obtained value of N is the result, calculated by the algorithm.
         */

        fakeInput();

        Scanner cin = new Scanner(System.in);
        String n = cin.nextLine();

        int sum;
        do {

            sum = 0;
            for (char x : n.toCharArray()) {
                if(x != '-' && x != '.') {
                    sum += Integer.parseInt(String.valueOf(x));
                }
            }

            n = String.valueOf(sum);

        } while(Integer.parseInt(n) > 9);

        System.out.println(sum);

    }

    private static void fakeInput() {

//        String test = "3";
        String test = "-7231";
//        String test = "1020340567.89";

        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

}
