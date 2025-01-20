import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        fakeInput();

        // abc
        // +, * between the a, b, c
        // find the biggest number

        Scanner cin = new Scanner(System.in);

        int num = Integer.parseInt(cin.nextLine());

        int a = num / 100;
        int b = (num / 10) % 10;
        int c = num % 10;

        int sum = a + b + c;
        int mul = a * b * c;
        int sumMul = a + b * c;
        int mulSum = a * b + c;

        int max = 0;

        if(sum > mul) {
            max = sum;
        } else if (mul > sumMul) {
            max = mul;
        } else if (sumMul > mulSum) {
            max = sumMul;
        } else {
            max = mulSum;
        }

        System.out.println(max);

    }

    private static void fakeInput() {

//        String test = "185";
        String test = "111";

        System.setIn(new ByteArrayInputStream(test.getBytes()));

    }

}
