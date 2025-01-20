import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class WordAnagrams {

    public static void main(String[] args) {

        fakeInput();

        Scanner cin = new Scanner(System.in);

        char[] word = cin.nextLine().toLowerCase().toCharArray();
        int n = Integer.parseInt(cin.nextLine());

        for (int i = 0; i < n; i++) {

            String words = cin.nextLine().toLowerCase();

            int[] alphabet = new int[26];

            for (char w : word) {
                alphabet[w-97]++;
            }

            for (char w : words.toCharArray()) {
                alphabet[w-97]--;
            }

            boolean isAnagram = true;
            for (int j = 0; j < alphabet.length; j++) {
                if(alphabet[j] != 0) {
                    isAnagram = false;
                    break;
                }
            }

            if (isAnagram) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
//            System.out.println(Arrays.toString(alphabet));

        }
        
    }

    private static void fakeInput() {
        String test = "anagram\n" +
                "6\n" +
                "gramana\n" +
                "aaagrnm\n" +
                "anagra\n" +
                "margana\n" +
                "abc\n" +
                "xy";

        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

}
