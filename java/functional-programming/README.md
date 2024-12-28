# Functional Programming
1. Imperative programming FOREACH AND OTHER CICLES (An imperative approach would provide step by step instructions on how to arrive at a given destination)
2. Declarative programming STREAM API (A declarative approach would provide the address of the destination, without concern about how it's found)
3. Functional Interface (java.util.function, each functional interface has single abstract method, and can hava multiple default methods)
   1. Chaining functions with andThen create three functions f1(sum), f2(multi) and f3 and say. f3 = f1.andThen(f2); f3.apply(10); will combine functions f1 and f2 and the result will be in f3;
   3. Function<T, R> [T - input type, R - output type, Represents a function that accepts one argument and produces a result]
   4. BiFunction<T, U, R> [T - input type, U - input type, R - output type, Represents a function that accepts two arguments and produces a result]
   5. Consumer<T> [T -input type, Represents an operation that accepts a single input argument and returns no result]
   6. BiConsumer<T, U> [T - input type, U - input type, Represents an operation that accepts two input arguments and returns no result]
   7. Predicate<T> [T - input type, Represents a predicate (boolean-valued function) of one argument]
   8. BiPredicate<T, U> [T - input type, U - input type, Represents a predicate (boolean-valued function) of two arguments]
   9. Suplier<T> [T - return type, Represents a supplier of results]
4.  Stream & Optaionals
    1. Functional interfaces are very useful in the streams, and if we work mostly with streams we can make our own functional interfaces if nessecery to perform out tasks.
    2. Optionals is useful to deal with NullPointerExceptions 
5. Combinator Design Pattern with Functions
   1. Combinator design patter is verry cool must see it in the code example.
   2. This is interface which extends Function<T, R>, has static methods where the logic will be implemented, and one default method that will be called and() where all the validation will be perform, also it can have enumerator to return predefined results.  
   3. In more details we have interface from specific type, and enumerator in this interface with predefined validation statuses. The interface extends Function<T (input type), R (enum type)> will get T type and will return predefined status from the enumerator. It can have as it is needed static methods with validation logic which will return predefined status from the enumerator, the method need to return the type of the interface. It is important to have method where all the logil will be perform it will get and return the interface type.
6. Beyond Functions
   1. Callbacks like JS check the code example
   2. Lambdas
      1. firstName -> firstName.toUpperCase(); // single line lambda
      2. firstName -> { someLogic; anotherLogic }; // multiline lambda
   3. Primitives (we can not pass primitive types in functions)
   4. static keyword (it is bad practice to use static keyword for functional interfaces, it is better idea to use our functional interfaces in the specific class only)
7. Functional Programming Rules (Pure functional programming has a set of rules to follow)
   1. No state
   2. Pure Functions (they shouldn't depend on any other state, for example if we have global state or global variable. The function should not depend on that global state or variable)
   3. No Side Effects (function should not have external side efects instead the side effects in the body of the function)
   4. Higher Order Funcitons
      1. The function takes one or more functions as parameters.
      2. The function returns another function as result.