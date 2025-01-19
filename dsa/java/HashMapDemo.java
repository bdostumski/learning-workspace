import java.util.HashMap;
import java.util.Map;

/*
HashMap: HashMap provides the basic implementation of the Map interface of Java.
It stores the data in (Key, Value) pairs. To access a value in a HashMap, we must know its key.
HashMap uses a technique called Hashing.
Hashing is a technique of converting a large String to small String that represents the same
String so that the indexing and search operations are faster. HashSet also uses HashMap internally.
Let’s understand the HashMap with an example:
 */

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Integer, String> hm = new HashMap<Integer, String>();

        hm.put(1, "Borislav");
        hm.put(2, "Alexandrov");
        hm.put(3, "Dostumski");
        hm.put(4, "Borislav");

        for(Map.Entry<Integer, String> entry : hm.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
