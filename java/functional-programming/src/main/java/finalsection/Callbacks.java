package finalsection;

import java.util.function.Consumer;

public class Callbacks {

    public static void main(String[] args) {

        hello("Borislav", "Dostumski", null);

        System.out.println("Callback example:");

        hello("Borislav", null, value -> {
            System.out.println("no lastName provided for " + value);
        });

    }

    static void hello(String firstName, String lastName, Consumer<String> callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.accept(firstName);
        }
    }

}
