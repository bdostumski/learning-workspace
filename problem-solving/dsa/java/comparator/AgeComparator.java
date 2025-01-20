import java.util.Comparator;

public class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student person1, Student person2) {
        return person1.age - person2.age;
    }
}
