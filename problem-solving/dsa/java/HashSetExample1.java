import java.util.HashSet;

public class HashSetExample1 {

    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<String>();

        hashSet.add("Alexandrov");
        hashSet.add("Dostumski");
        hashSet.add("Borislav");
        hashSet.add("Dostumski");

        System.out.println(hashSet);
    }

}
