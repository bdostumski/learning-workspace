package designpatterns.creational.builder;

import java.util.function.Consumer;

public class BuilderPatternWithFunctionalInterface {

    public static void main(String[] args) {

        Person person = new PersonBuilder()
                .with($ -> $.firstName = "Borislav")
                .with($ -> $.lastName = "Dostumski")
                .build();

        System.out.println(person);

    }

}


class Person {
    private final String firstName;
    private final String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

class PersonBuilder {
    public String firstName;
    public String lastName;

    public PersonBuilder with(Consumer<PersonBuilder> builderFunction) {
        builderFunction.accept(this);
        return this;
    }

    public Person build() {
        return new Person(firstName, lastName);
    }
}
