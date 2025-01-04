package imperative;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Borislav", Gender.MALE),
                new Person("Desislava", Gender.FEMALE),
                new Person("Alexander", Gender.MALE),
                new Person("Violina", Gender.FEMALE)
        );

        // Imperative approach
        System.out.println("// Imperative approach");
        List<Person> females = new ArrayList<>();

        for(Person person : people) {
            if(Gender.FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }

        for(Person female : females) {
            System.out.println(female);
        }

        // Declarative approach
        System.out.println("// Declarative approach");
        List<Person> femalesList = people.stream()
                .filter(person -> Gender.FEMALE.equals(person.gender)).toList();
        femalesList.forEach(System.out::println);


    }

    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }

}
