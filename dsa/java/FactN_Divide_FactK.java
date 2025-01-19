/*
    Additional NON-Required Problem: Calculate N! / K!
    Write a program that calculates n! / k! for given n and k (1 < k < n < 100).
    Use only one loop.


    Examples:
    n       k     	n! / k!
    5 	    2 	    60
    6 	    5 	    6
    8 	    3   	6720
 */

import java.util.Scanner;

public class FactN_Divide_FactK {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);

        int n = Integer.parseInt(cin.nextLine());
        int k = Integer.parseInt(cin.nextLine());

//        Write a program that calculates n! / k! for given n and k (1 < k < n < 100).

        int factN = 1;
        int factK = 1;

        for (int i = 1; i <= n; i++) {
            factN *= i;
            if(i <= k)
                factK *= i;
        }

        System.out.println(factN / factK);

    }

}
