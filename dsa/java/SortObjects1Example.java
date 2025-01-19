import java.util.ArrayList;
import java.util.Collections;

public class SortObjects1Example {
    private static class Student implements Comparable<Student> {

        int rollno;
        String name;
        int age;

        public Student(int rollno, String name, int age) {
            this.rollno = rollno;
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Student o) {
            if(age == o.age)
                return name.compareTo(o.name);
            return age - o.age;
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> al = new ArrayList<Student>();
        al.add(new Student(101, "Borislav", 33));
        al.add(new Student(103, "Alexandrov", 55));
        al.add(new Student(105, "Dostumski", 23));
        al.add(new Student(106, "Ddos", 23));


        for(Student s : al)
            System.out.println(s.rollno + " " + s.name + " " + s.age);

        System.out.println();

        Collections.sort(al);
        for(Student s : al)
            System.out.println(s.rollno + " " + s.name + " " + s.age);

        System.out.println();

        Collections.sort(al, Collections.reverseOrder());
        for(Student s : al)
            System.out.println(s.rollno + " " + s.name + " " + s.age);

    }
}
