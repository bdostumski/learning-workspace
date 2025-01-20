import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.stream.Stream;

public class VectorExample1 {

    public static void main(String[] args) {

        Vector<String> vector = new Vector<String>();

        vector.add("Borislav");
        vector.add("Alexandrov");
        vector.add("Dostumski");

        System.out.println(vector);

        Iterator<String> iterator = vector.iterator();

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

}
