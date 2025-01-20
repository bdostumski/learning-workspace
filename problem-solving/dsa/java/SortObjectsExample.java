import java.util.ArrayList;
import java.util.Collections;

class Student implements Comparable<Student> {
    public String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Student person) {
        return name.compareTo(person.name);
    }
}

public class SortObjectsExample {

    public static void main(String[] args) {

        ArrayList<Student> list = new ArrayList<Student>();
        list.add(new Student("Borislav"));
        list.add(new Student("Alexandrov"));
        list.add(new Student("Dostumski"));

        Collections.sort(list);

        for(Student s : list)
            System.out.println(s.name);

        System.out.println();

        Collections.sort(list, Collections.reverseOrder());

        for(Student s : list)
            System.out.println(s.name);

    }

}
