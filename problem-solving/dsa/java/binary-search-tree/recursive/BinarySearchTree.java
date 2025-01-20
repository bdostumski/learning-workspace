import java.util.List;

public interface BinarySearchTree extends Iterable<BinaryTreeNode> {

    BinaryTreeNode getRoot();

    void insert(int value);

    BinaryTreeNode search(int value);

    List<Integer> inOrder();

    List<Integer> postOrder();

    List<Integer> preOrder();

    List<Integer> bfs();

    int height();

    // Advanced task: implement remove method. To test, uncomment the commented tests in BinaryTreeImplTests
    BinaryTreeNode remove(int value);

}
