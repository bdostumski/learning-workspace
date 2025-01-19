import java.util.HashSet;
import java.util.Iterator;

/*
HashSet: The HashSet class is an inherent implementation of the hash table data structure.
The objects that we insert into the HashSet do not guarantee to be inserted in the same order.
The objects are inserted based on their hashcode. This class also allows the insertion of NULL elements.
Let’s understand HashSet with an example:
 */

public class HashSetDemo {

    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();

        hs.add("Dostumski");
        hs.add("Alexandrov");
        hs.add("Borislav");
        hs.add("Borislav");

        Iterator<String> itr = hs.iterator();

        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
