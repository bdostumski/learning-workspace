import java.util.Iterator;
import java.util.TreeSet;

/*
TreeSet: The TreeSet class uses a Tree for storage.
The ordering of the elements is maintained by a set using their natural ordering whether or not an explicit comparator is provided.
This must be consistent with equals if it is to correctly implement the Set interface.
It can also be ordered by a Comparator provided at set creation time, depending on which constructor is used.
Let’s understand TreeSet with an example:
 */

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<String>();

        ts.add("Borislav");
        ts.add("Alexandrov");
        ts.add("Dostumski");
        ts.add("Borislav");

        Iterator<String> iter = ts.iterator();

        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
