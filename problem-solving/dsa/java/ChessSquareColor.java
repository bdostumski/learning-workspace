import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class ChessSquareColor {

    public static void main(String[] args) {

        fakeInput();

        Scanner cin = new Scanner(System.in);

        // from a to h
        // from 1 to 8
        // Matrix 8 x 8

        int rows = Integer.parseInt(String.valueOf(cin.nextLine().charAt(0) - 96));
        int cols = Integer.parseInt(cin.nextLine());

        String color = "dark";

        for (int i = 1; i <= rows; i++) {
            if(rows % 2 == 0) {
                for (int j = 1; j <= cols; j++)
                    color = (j % 2 == 0) ? "dark" : "light";
            } else {
                for (int j = 1; j <= cols ; j++)
                    color = (j % 2 == 0) ? "light" : "dark";
            }
        }

        System.out.println(color);

    }

    private static void fakeInput() {
        String test = "a\n" +
                "1";

        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

}
