package finalsection;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdas {

    public static void main(String[] args) {

        Function<String, String> upperCaseName = String::toUpperCase;

        Function<String, String> upperCaseNameV1 = name -> {
            // logic
            if(name.isBlank())
                throw new IllegalStateException("");
            return name.toUpperCase();
        };

        BiFunction<String, Integer, String> upperCaseNameV2 = (name, age) -> {
            // logic
            if(name.isBlank())
                throw new IllegalStateException("");
            System.out.println(age);
            return name.toUpperCase();
        };
         
        System.out.println(upperCaseNameV2.apply("Alex", 20));

    }

}
