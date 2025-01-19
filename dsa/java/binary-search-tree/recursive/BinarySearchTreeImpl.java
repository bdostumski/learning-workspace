import java.util.*;

public class BinarySearchTreeImpl implements BinarySearchTree {

    private BinaryTreeNode root;

    public BinarySearchTreeImpl() {
    }

    public BinarySearchTreeImpl(Integer... values) {
        for (Integer value : values)
            insert(value);
    }

    @Override
    public BinaryTreeNode getRoot() {
        return root;
    }

    @Override
    public void insert(int value) {
        this.root = insert(value, this.root);
    }


    @Override
    public BinaryTreeNode search(int value) {
        return search(value, this.root);
    }

    @Override
    public List<Integer> inOrder() {
        List<Integer> result = new ArrayList<>();
        inOrder(this.root, result);
        return result;
    }

    @Override
    public List<Integer> postOrder() {
        List<Integer> result = new ArrayList<>();
        postOrder(this.root, result);
        return result;
    }

    @Override
    public List<Integer> preOrder() {
        List<Integer> result = new ArrayList<>();
        preOrder(this.root, result);
        return result;
    }

    @Override
    public List<Integer> bfs() {
        List<Integer> result = new ArrayList<>();
        Queue<BinaryTreeNode> queue = new LinkedList<>();

        if (this.root != null) {
            queue.offer(this.root);

            while (!queue.isEmpty()) {
                BinaryTreeNode current = queue.remove();
                result.add(current.getValue());

                if (current.hasLeftChild()) queue.offer(current.getLeftChild());
                if (current.hasRightChild()) queue.offer(current.getRightChild());
            }
        }

        return result;
    }

    @Override
    public int height() {
        return height(this.root);
    }

    @Override
    public BinaryTreeNode remove(int value) {
        this.root = remove(this.root, value);
        return this.root;
    }

    private BinaryTreeNode remove(BinaryTreeNode current, int value) {
        if (current == null) return null;

        /* search for node */
        if (current.getValue() > value)
            current.setLeftChild(remove(current.getLeftChild(), value));

        /* search for node */
        else if (current.getValue() < value)
            current.setRightChild(remove(current.getRightChild(), value));

        /* we found the node to remove */
        /* if it's a leaf, return null */
        else if (current.isLeaf()) return null;

        /* if it's not a leaf and has 1 child */
        /* if there is no right child, go left */
        if (!current.hasRightChild()) return current.getLeftChild();

        /* if there is no left child, go right */
        if (!current.hasLeftChild()) return current.getRightChild();

        /* change the value of the node to remove with the smallest in the right sub-tree */
        current.setValue(findSmallestNode(current.getRightChild()));

        /* erase all old connections to the new node */
        current.setRightChild(remove(current.getRightChild(), current.getValue()));

        return current;
    }

    private int findSmallestNode(BinaryTreeNode current) {
        int min = current.getValue();
        while (current.hasLeftChild()) {
            current = current.getLeftChild();
            min = current.getValue();
        }
        return min;
    }

    @Override
    public Iterator<BinaryTreeNode> iterator() {
        List<BinaryTreeNode> result = new ArrayList<>();
        inOrderObjects(root, result);
        return result.iterator();
    }

    private void preOrder(BinaryTreeNode current, List<Integer> result) {
        if (current != null) {
            result.add(current.getValue());
            preOrder(current.getLeftChild(), result);
            preOrder(current.getRightChild(), result);
        }
    }

    private void postOrder(BinaryTreeNode current, List<Integer> result) {
        if (current != null) {
            postOrder(current.getLeftChild(), result);
            postOrder(current.getRightChild(), result);
            result.add(current.getValue());
        }
    }

    private void inOrder(BinaryTreeNode current, List<Integer> result) {
        if (current != null) {
            inOrder(current.getLeftChild(), result);
            result.add(current.getValue());
            inOrder(current.getRightChild(), result);
        }
    }

    private void inOrderObjects(BinaryTreeNode current, List<BinaryTreeNode> result) {
        if (current != null) {
            inOrderObjects(current.getLeftChild(), result);
            result.add(current);
            inOrderObjects(current.getRightChild(), result);
        }
    }

    private int height(BinaryTreeNode current) {
        if (current == null)
            return -1;

        int left = height(current.getLeftChild());
        int right = height(current.getRightChild());

        return left > right ? left + 1 : right + 1;
    }

    private BinaryTreeNode search(int value, BinaryTreeNode current) {
        if (current == null || current.getValue() == value)
            return current;

        if (current.getValue() > value)
            return search(value, current.getLeftChild());

        return search(value, current.getRightChild());
    }

    private BinaryTreeNode insert(int value, BinaryTreeNode current) {
        if (current == null)
            return new BinaryTreeNode(value);

        if (value < current.getValue())
            current.setLeftChild(insert(value, current.getLeftChild()));

        if (value >= current.getValue())
            current.setRightChild(insert(value, current.getRightChild()));

        return current;
    }
}

