package optionals;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Object value = Optional.ofNullable(null)
                .orElseGet(() -> "default value");
        System.out.println(value);

        Optional.ofNullable("john@email.com")
                .ifPresent(email -> {
                    // logic
                    System.out.println("Sending email to " + email);
                });


        Optional.ofNullable(null)
                .ifPresentOrElse(email -> {
                            // logic
                            System.out.println("Sending email to " + email);
                        },
                        () -> {
                            System.out.println("Cannot send email.");
                        }
                );

        Object exceptionWasThrown = Optional.ofNullable(null)
                .orElseThrow(() -> new IllegalArgumentException("exception was thrown"));
        System.out.println(exceptionWasThrown);
    }

}
