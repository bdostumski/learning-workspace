import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class ArraySearch {

    public static void main(String[] args) {

        fakeInput();

        Scanner cin = new Scanner(System.in);

        String[] rawInput = cin.nextLine().split(",");
        int[] array = new int[rawInput.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(rawInput[i]);
        }

        int[] map = new int[array.length + 1];
        for (int x : array) {
            map[x] = 1;
        }

        String join = "";
        for (int i = 1; i < map.length; i++) {
            if(map[i] == 0) {
                join += String.valueOf(i) + ",";
            }
        }

        String[] input = join.split(",");
        String joinResult = String.join(",", input);

        System.out.println(joinResult);

//        System.out.println(Arrays.toString(map));
//        System.out.println(Arrays.toString(array));

    }

    private static void fakeInput() {
//        String test = "1,2,3,3,5";
        String test = "4,3,2,7,8,2,3,1";
//        String test = "1,1,1,1,1,1,1,1";

        System.setIn(new ByteArrayInputStream(test.getBytes()));

    }

}
