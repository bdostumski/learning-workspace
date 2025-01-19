import java.util.Iterator;
import java.util.LinkedHashSet;

/*
LinkedHashSet: A LinkedHashSet is very similar to a HashSet.
The difference is that this uses a doubly linked list to store the data and retains the ordering of the elements.
Let’s understand the LinkedHashSet with an example:
 */

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        LinkedHashSet<String> lhs = new LinkedHashSet<String>();

        lhs.add("Borislav");
        lhs.add("Dostumski");
        lhs.add("Borislav");

        Iterator<String> iter = lhs.iterator();

        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
