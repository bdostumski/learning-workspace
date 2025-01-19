/*
        Phone Bill
        A phone bill plan includes 1 hour of free calls and 20 text messages for 12.00 levas.
        Each additional minute costs 0.10 levas and each additional message costs 0.06 levas.
        Also, any additional minutes/text messages are subject to 20% sales tax.
        Write a program that calculates the additional charge for text, the additional charge for minutes,
        and the sales tax charge for both. Also, display the total amount paid.

        Input
        On the first line, you will receive the total amount of text messages.
        On the second line, you will receive the total amount of minutes.

        Output
        1st line - number of additional messages and additional amount paid
        2nd line - number of additional minutes and additional amount paid
        3rd line - amount paid in taxes
        4th line - total bill

        Input
        31
        115

        Output
        11 additional messages for 0.66 levas
        55 additional minutes for 5.50 levas
        1.23 additional taxes
        19.39 total bill

        Input
        18
        44

        Output
        0 additional messages for 0.00 levas
        0 additional minutes for 0.00 levas
        0.00 additional taxes
        12.00 total bill
 */

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class PhoneBill {

    public static void main(String[] args) {

        fakeInput();

        Scanner cin = new Scanner(System.in);

        // 1 hour of free calls and 20 text messages for 12.00 levas.
        // Each additional minute costs 0.10 levas and each additional message costs 0.06 levas.
        // Also, any additional minutes/text messages are subject to 20% sales tax.

        /*
            Write a program that calculates the additional charge for text, the additional charge for minutes,
            and the sales tax charge for both. Also, display the total amount paid.
         */


        int totalAmountOfTextMessages = Integer.parseInt(cin.nextLine());
        int totalAmountOfMinutes = Integer.parseInt(cin.nextLine());

        double monthTax = 12.00; // 1 hour free calls and 20 text messages
        int freeCalls = 60; // 1 hour -> 60 min free cals
        int freeMessages = 20; // 20 text messages

        double additionalMessagesPrice = 0.06;
        double additionalMinutesPrice = 0.10;
//        int tax = 20; // additional minutes/text messages are subject to 20% sales tax

        int additionalMessages = totalAmountOfTextMessages > freeMessages ? totalAmountOfTextMessages - freeMessages : 0;
        int additionalMinutes = totalAmountOfMinutes > freeCalls ? totalAmountOfMinutes - freeCalls : 0;

        double priceAdditionalMessages = additionalMessagesPrice * additionalMessages;
        double priceAdditionalMinutes = additionalMinutesPrice * additionalMinutes;

        System.out.printf("%d additional messages for %.2f levas%n", additionalMessages, priceAdditionalMessages);
        System.out.printf("%d additional minutes for %.2f levas%n", additionalMinutes, priceAdditionalMinutes);

        double additionalTaxex = ((priceAdditionalMessages + priceAdditionalMinutes) / 100) * 20;
        System.out.printf("%.2f additional taxes%n", additionalTaxex);


        double totalBill = additionalTaxex + priceAdditionalMessages + priceAdditionalMinutes + monthTax;
        System.out.printf("%.2f total bill", totalBill);
//        System.out.println(totalAmountOfMinutes);

        /*
            Output
            1st line - number of additional messages and additional amount paid
            2nd line - number of additional minutes and additional amount paid
            3rd line - amount paid in taxes
            4th line - total bill
         */


    }

    public static void fakeInput() {

        String test = "31\n" +
                "115";

//        String test = "18\n" +
//                "44";

        System.setIn(new ByteArrayInputStream(test.getBytes()));

    }

}
