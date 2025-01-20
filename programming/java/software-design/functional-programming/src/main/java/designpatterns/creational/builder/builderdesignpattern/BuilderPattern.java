package designpatterns.creational.builder.builderdesignpattern;

public class BuilderPattern {

    public static void main(String[] args) {

        Person person = new PersonBuilder().withFirstName("Borislav").withLastName("Dostumski").build();
        System.out.println(person);
    }

}

class Person {
    private String firstName;
    private String lastName;

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
    private String firstName;
    private String lastName;

    public PersonBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Person build() {
        return new Person(firstName, lastName);
    }
}
