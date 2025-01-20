import java.util.Scanner;

public class ConvertDegrees {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);

        String[] rawInput = cin.nextLine().split(" ");
        int[] celsius = new int[rawInput.length];

        for (int i = 0; i < celsius.length; i++) {
            celsius[i] = Integer.parseInt(rawInput[i]);
        }

        for (int i = 0; i < celsius.length; i++) {
            System.out.println(Math.round(celsius[i] * 1.8 + 32));
        }

    }

}
