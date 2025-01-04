package streams;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class _Stream {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Borislav", Gender.MALE),
                new Person("Desislava", Gender.FEMALE),
                new Person("Alexander", Gender.MALE),
                new Person("Violina", Gender.FEMALE)
        );

        System.out.println("Genders");
        Set<Gender> genders = people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet());

        genders.forEach(System.out::println);

        System.out.println("Names");
        people.stream()
                .map(person -> person.name)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("Names length");
        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);

        boolean containsOnlyFemales = people.stream()
                .allMatch(person -> Gender.FEMALE.equals(person.gender));
        System.out.println("Is the list contains only females: " + containsOnlyFemales);

        boolean containsOnlyOneFemale = people.stream()
                .anyMatch(person -> Gender.FEMALE.equals(person.gender));
        System.out.println("Is the list contains only one female: " + containsOnlyOneFemale);

        boolean notContainsFemale = people.stream()
                .noneMatch(person -> Gender.FEMALE.equals(person.gender));
        System.out.println("Is the list not contains female: " + notContainsFemale + ". It contains at least one female.");
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