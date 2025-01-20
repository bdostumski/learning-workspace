import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetExample1 {
    public static void main(String[] args) {
        LinkedHashSet<String> set = new LinkedHashSet<String>();

        set.add("Alexandrov");
        set.add("Dostumski");
        set.add("Alexandrov");
        set.add("Borislav");

        System.out.println(set);

        Iterator<String> iterator = set.iterator();

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
