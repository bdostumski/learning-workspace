import com.company.BinarySearchTree;
import com.company.BinarySearchTreeImpl;

public class Main {

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTreeImpl();

        tree.insert(5);
        tree.insert(4);
        tree.insert(8);
        tree.insert(2);
        tree.insert(10);
        tree.insert(9);
        tree.remove(9);

        System.out.println(tree.inOrder());
        System.out.println(tree.preOrder());
        System.out.println(tree.postOrder());

    }

}
