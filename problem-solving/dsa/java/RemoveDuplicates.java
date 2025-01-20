import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class RemoveDuplicates {

    public static void main(String[] args) {

        fakeInput();

        Scanner cin = new Scanner(System.in);
        String[] rawInput = cin.nextLine().split(",");

        LinkedHashSet<String> set = new LinkedHashSet<>();

        for (int i = 0; i < rawInput.length; i++) {
            set.add(rawInput[i]);
        }

        String result = String.valueOf(set).replace(" ", "");

        System.out.println(result.substring(1, result.length()-1));

    }

    private static void fakeInput() {
//        String  test = "1,2,2,2,2,18,3,12";
        String test = "c,c,a,b,a,a,b,c";

        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

}
