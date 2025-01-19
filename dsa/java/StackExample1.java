import java.util.Iterator;
import java.util.Stack;

public class StackExample1 {

    public static void main(String[] args) {

        Stack<String> stack = new Stack<String>();

        stack.push("Borislav");
        stack.push("Alexandrov");
        stack.push("Dostumski");
        stack.push("Dostumski");

        System.out.println(stack);
        System.out.println(stack.peek());

        stack.pop();

        System.out.println();

        Iterator<String> iterator = stack.iterator();

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

}
