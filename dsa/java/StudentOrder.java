/*
        Students order
        Alpha students love learning new stuff.
        They also know that in order to better understand and remember new stuff students should change their seats in the room.
        You are given the names of N Alpha students and K changes of seats.
        Your task is to implement an algorithm which displays the final ordering of the students
        after applying all seat changes.

        Input
        Read from the standard input
        On the first line, find the number N and K
        N - students count
        K - the count of seat changes
        On the next line there will be N names
        On the next K lines there will be pair of names separated by white space
        The first name takes the seat next to the second name (first is left, second is right)
        See sample tests for explanation
        Output
        Print on the standard output
        On a single line, print the final order of the student names
        Constraints
        1 <= N <= 2000
        1 <= K <= 100 000
        each name contains only alphanumeric characters
        Sample tests
        Input
        5 3
        Gosho Tosho Penka Miro Stanka
        Miro Gosho
        Gosho Stanka
        Stanka Miro
        Output
        Stanka Miro Tosho Penka Gosho
        Explanation
        First Miro seats next to Gosho, so the order is - Miro Gosho Tosho Penka Stanka
        Next Gosho seats next to Stanka, so the order is - Miro Tosho Penka Gosho Stanka
        At last Stanka seats next to Miro, so the final order is Stanka Miro Tosho Penka Gosho
        Input
        7 4
        Emo Misho Ivanka Ginka Vancho Stancho Sashka
        Emo Misho
        Misho Emo
        Misho Sashka
        Sashka Stancho
        Output
        Emo Ivanka Ginka Vancho Sashka Stancho Misho
 */

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

//class Node {
//
//    Integer value;
//    Node prev;
//    Node next;
//
//    Node(Integer value, Node prev) {
//        this.value = value;
//        this.next = null;
//        this.prev = prev; // || null
//
//        if (prev == null) {
//            prev.next = this;
//        }
//    }
//
//   public static void detach(Node node) {
//        if (node.prev == null) {
//            node.prev.next = node.next;
//        }
//
//        if (node.next == null) {
//            node.next.prev = node.prev;
//        }
//
//        node.next = null;
//        node.prev = null;
//    }
//
//    static void attach(Node node, Node next) {
//            Node prev = next.prev; // null
//
//        if (prev == null) {
//            prev.next = node;
//        }
//
//        next.prev = node;
//        node.next = next;
//        node.prev = prev;
//    }
//}

public class StudentOrder {

    public static void main(String[] args) {

        fakeInput();

        Scanner scanner = new Scanner(System.in);
        String[] counts = scanner.nextLine().split(" ");
        int n = Integer.parseInt(counts[0]);
        int k = Integer.parseInt(counts[1]);

        String[] students = scanner.nextLine().split(" ");
        LinkedList<String> studentsList = new LinkedList<>(Arrays.asList(students));

        for (int i = 0; i < k; i++) {
            String[] change = scanner.nextLine().split(" ");
            studentsList.remove(change[0]);
            int insertPosition = studentsList.indexOf(change[1]);
            studentsList.add(insertPosition, change[0]);
        }

        System.out.println(String.join(" ", studentsList));
    }

    public static void fakeInput() {
//        String test = "5 3\n" +
//                "Gosho Tosho Penka Miro Stanka\n" +
//                "Miro Gosho\n" +
//                "Gosho Stanka\n" +
//                "Stanka Miro";

        String test = "7 4\n" +
                "Emo Misho Ivanka Ginka Vancho Stancho Sashka\n" +
                "Emo Misho\n" +
                "Misho Emo\n" +
                "Misho Sashka\n" +
                "Sashka Stancho";

        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

}

/*
    class Node {
        constructor(value, prev) {
            this.value = value;
            this.next = null;
            this.prev = prev || null;

            if (prev) {
                prev.next = this;
            }
        }

        static detach(node) {
            if (node.prev) {
                node.prev.next = node.next;
            }

            if (node.next) {
                node.next.prev = node.prev;
            }

            node.next = null;
            node.prev = null;
        }

        static attach(node, next) {
            const prev = next.prev || null;

            if (prev) {
                prev.next = node;
            }

            next.prev = node;
            node.next = next;
            node.prev = prev;
        }
    }

    -------------------------------------

    import java.io.ByteArrayInputStream;
    import java.util.*;

    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String[] counts = scanner.nextLine().split(" ");
            int n = Integer.parseInt(counts[0]);
            int k = Integer.parseInt(counts[1]);

            String[] students = scanner.nextLine().split(" ");
            LinkedList<String> studentsList = new LinkedList<>(Arrays.asList(students));

            for (int i = 0; i < k; i++) {
                String[] change = scanner.nextLine().split(" ");
                studentsList.remove(change[0]);
                int insertPosition = studentsList.indexOf(change[1]);
                studentsList.add(insertPosition, change[0]);
            }

            System.out.println(String.join(" ", studentsList));
        }
    }
 */
