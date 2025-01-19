import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/*
Stack: Stack class models and implements the Stack data structure.
The class is based on the basic principle of last-in-first-out.
In addition to the basic push and pop operations, the class provides three more functions of empty, search and peek.
The class can also be referred to as the subclass of Vector. Let’s understand the stack with an example:
 */

public class StackExample {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();

        stack.push("Borislav");
        stack.push("Alexandrov");
        stack.push("Dostumski");
        stack.push("Borislav");

        Iterator<String> iterator = stack.iterator();

        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println();

        stack.pop();

        iterator = stack.iterator();

        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println();
        System.out.println(stack.search("Borislav"));
    }

}
