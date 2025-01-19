import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class WordOrNumberAdditional {

    public static void main(String[] args) {

        fakeInput();

        Scanner cin = new Scanner(System.in);

        int n = Integer.parseInt(cin.nextLine());
        String[] input = new String[n];

        for (int i = 0; i < n; i++) {
            input[i] = cin.nextLine();
        }

        int numSum = 0;
        String strConcat = "";

        int i = 0;
        do {

            String result = "";

            try {
                Double.parseDouble(input[i]);

                numSum += Integer.parseInt(input[i]);

                if(!strConcat.trim().equals(""))
                    System.out.printf("%s%n", strConcat.substring(0, strConcat.length()-1));

                strConcat = "";
                i++;

            } catch(Exception e) {
                strConcat += input[i] + "-";

                if(numSum != 0)
                    System.out.printf("%d%n", numSum);

                numSum = 0;
                i++;
            }

            if(i == n) {
                System.out.println((strConcat.isEmpty()) ? numSum : strConcat);
            }

        } while(i < n);



    }

    private static void fakeInput() {

        String test = "9\n" +
                "try\n" +
                "google\n" +
                "it\n" +
                "2\n" +
                "plus\n" +
                "2\n" +
                "=\n" +
                "52\n" +
                "-10";

        System.setIn(new ByteArrayInputStream(test.getBytes()));

    }

}
