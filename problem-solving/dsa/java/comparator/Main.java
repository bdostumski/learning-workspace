import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        ArrayList<Student> al = new ArrayList<Student>();
        al.add(new Student(105, "Dostumski", 21));
        al.add(new Student(106, "Alexandrov", 20));
        al.add(new Student(101, "Borislav", 55));

        for(Student s : al)
            System.out.println(s.rollno + " " + s.name + " " + s.age);

        System.out.println();

        Collections.sort(al, new NameComparator());

        for(Student s : al)
            System.out.println(s.rollno + " " + s.name + " " + s.age);


        System.out.println();

        Collections.sort(al, new AgeComparator());

        for(Student s : al)
            System.out.println(s.rollno + " " + s.name + " " + s.age);

    }

}
