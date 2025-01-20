import java.util.Scanner;

public class WorddOrnumber1 {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);

        String input = cin.nextLine();

        boolean isNumber;

        try {
            Double.parseDouble(input);
            isNumber = true;
        } catch(Exception e) {
            isNumber = false;
        }

        if(isNumber) {

            double number = Double.parseDouble(input);

            if(number == (int)number) {
                int n = Integer.parseInt(String.format("%d", (int)number));
                System.out.println(n+1);
            } else {
                System.out.printf("%.2f%n", number+1);
            }

        } else {

            StringBuilder str = new StringBuilder();

            str.append(input);
            System.out.println(str.reverse());

        }

    }

}
