import java.util.Scanner;

public class NumbersAsWords {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);

        int number = Integer.parseInt(cin.nextLine());

        String[] digits = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
                "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
        String[] digitsOverTwenty = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
                "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
        String[] tens = { "", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"  };
        String[] hundreds = { "", "one hundred", "two hundred", "three hundred", "four hundred", "five hundred", "six hundred",
                "seven hundred", "eight hundred", "nine hundred"};


        if (number < 20) {
            // If number is less then 20
            System.out.println(digits[number].substring(0, 1).toUpperCase() + digits[number].substring(1));

        } else if (number < 100) {
            // If number is less then 100
            System.out.println(tens[number / 10].substring(0,1).toUpperCase() + tens[number / 10].substring(1) + " " + digitsOverTwenty[number % 10]);

        } else if (number < 1000) {
            // If number is less then 1000
            if((number%100) < 20) {
                // If last two digits is less then 20
                String first = hundreds[number / 100];
                String and = ((number%100)/10 == 0 && (number%10) == 0) ? "" :  " and ";
                String mid = ((number%100)/10 == 0) ? "" :  digits[(number % 100)];
                String last = (mid.equals("")) ? (number%10 == 0) ? "" : digits[number % 10] : "" ;

                System.out.println(first.substring(0,1).toUpperCase() + first.substring(1) + and + mid + last);

            } else {
                // Else is more then 20
                String first = hundreds[number / 100];
                String and = ((number%100)/10 == 0 && (number%10) == 0) ? "" :  " and ";
                String mid = ((number%100)/10 == 1) ? digits[number%100] : tens[(number % 100) / 10];
                String last = (number%10 == 0) ? "" : digits[number % 10];

                System.out.println(first.substring(0,1).toUpperCase()+first.substring(1) + and + mid + " " + last);
            }
        }

    }

}
