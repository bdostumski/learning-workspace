/*

        Problem 5. Quadratic Equation
        Write a program that reads the coefficients a, b and c of a quadratic equation ax2 + bx + c = 0
        and solves it (prints its real roots). Asume there always will be one or two real roots (b2 - 4ac >= 0)


        Examples:
        a          	b          	c          	roots
        2	        5	        -3	        x1=-3; x2=0.5
        -1	        3	        0	        x1=3; x2=0
        -0.5	    4	        -8      	x1=4; x2=4

 */

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class QuadraticEquision {

    public static void main(String[] args) {

//        fakeInput();

        Scanner cin = new Scanner(System.in);

        double a = Double.parseDouble(cin.nextLine());
        double b = Double.parseDouble(cin.nextLine());
        double c = Double.parseDouble(cin.nextLine());

        double disc = b * b - 4 * a * c;
        disc = Math.sqrt(disc);

        if(disc >= 0) {

            double x1 = (-b - disc) / (2 * a);
            double x2 = (-b + disc) / (2 * a);

            printer(x1, x2);
        }

    }

    public static void printer(double x1, double x2) {
        if(x1 == (long)x1) {
            int X1 = Integer.parseInt(String.format("%d", (long)x1));
            System.out.printf("x1=%d; ", X1);
        } else {
            System.out.printf("x1=%.1f; ", x1);
        }

        if(x2 == (long)x2) {
            int X2 = Integer.parseInt(String.format("%d", (long)x2));
            System.out.printf("x2=%d", X2);
        } else {
            System.out.printf("x2=%.1f", x2);
        }
    }

    private static void fakeInput() {

        String test = "2 5 -3";

        System.setIn(new ByteArrayInputStream(test.getBytes()));

    }

}
