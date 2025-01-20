import java.util.Comparator;

public class NameComparator implements Comparator<Student> {

    @Override
    public int compare(Student person1, Student person2) {
        return person1.name.compareTo(person2.name);
    }
}
