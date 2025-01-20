import java.util.*;

public class BinarySearchTreeImpl<T> implements BinarySearchTree<Number> {

    private BinaryTreeNode<T> root;

    @Override
    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    @Override
    public void insert(int value) {

        BinaryTreeNode<T> newNode = new BinaryTreeNode<>(value);

        if(getRoot() == null) {
            root = newNode;
            return;
        }

        BinaryTreeNode<T> current = root;
        BinaryTreeNode<T> parrent;

        while(true) {
            parrent = current;
            if(value < current.getValue()) {
                current = current.getLeftChild();
                if(current == null) {
                    parrent.setLeftChild(newNode);
                    return;
                }
            } else {
                current = current.getRightChild();
                if(current == null) {
                    parrent.setRightChild(newNode);
                    return;
                }
            }
        }
    }

    @Override
    public BinaryTreeNode<T> search(int value) {
        BinaryTreeNode<T> current = root;

        while(current != null) {
            if(current.getValue() == value) {
                return current;
            } else if(current.getValue() > value) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }

        return null;
    }

    @Override
    public List<Integer> inOrder() {
        List<Integer> list = new ArrayList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();

        BinaryTreeNode current = root;

        while(current != null) {
            stack.push(current);
            current = current.getLeftChild();
        }

        while(!stack.isEmpty()) {
            BinaryTreeNode point = stack.pop();

            list.add(point.getValue());
            point = point.getRightChild();

            while(point != null) {
                stack.push(point);
                point = point.getLeftChild();
            }
        }

        return list;
    }

    @Override
    public List<Integer> postOrder() {

        List<Integer> list = new ArrayList<>();

        if(root == null)
            return list;

        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);

        BinaryTreeNode prev = null;

        while(!stack.isEmpty()) {
            BinaryTreeNode current = stack.peek();

            if(prev == null || prev.getLeftChild() == current || prev.getRightChild() == current) {
                if(current.getLeftChild() != null) {
                    stack.push(current.getLeftChild());
                } else if (current.getRightChild() != null) {
                    stack.push(current.getRightChild());
                } else {
                    stack.pop();
                    list.add(current.getValue());
                }
            } else if(current.getLeftChild() == prev) {
                if(current.getRightChild() != null) {
                    stack.push(current.getRightChild());
                } else {
                    stack.pop();
                    list.add(current.getValue());
                }
            } else if(current.getRightChild() == prev) {
                stack.pop();
                list.add(current.getValue());
            }
            prev = current;
        }

        return list;

    }

    @Override
    public List<Integer> preOrder() {
        List<Integer> list = new ArrayList<>();
        BinaryTreeNode current = root;

        if(current == null)
            return list;

        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(current);

        while(!stack.isEmpty()) {
            BinaryTreeNode point = stack.pop();

            list.add(point.getValue());

            if(point.getRightChild() != null)
                stack.push(point.getRightChild());

            if(point.getLeftChild() != null)
                stack.push(point.getLeftChild());
        }

        return list;
    }

    @Override
    public List<Integer> bfs() {
        List<Integer> list = new ArrayList<>();

        BinaryTreeNode current = root;

        if(current == null) {
            return list;
        }

        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.offer(current);

        while (!queue.isEmpty()) {
            BinaryTreeNode<T> point = queue.poll();

            list.add(point.getValue());

            if (point.getLeftChild() != null) queue.offer(point.getLeftChild());
            if (point.getRightChild() != null) queue.offer(point.getRightChild());
        }

        return list;
    }

    @Override
    public boolean remove(int value){

        BinaryTreeNode parent = root;
        BinaryTreeNode current = root;
        boolean isLeftChild = false;

        while(current.getValue()!=value){

            parent = current;

            if (current.getValue()>value) {
                isLeftChild = true;
                current = current.getLeftChild();
            } else {
                isLeftChild = false;
                current = current.getRightChild();
            }

            if(current ==null)
                return false;
        }

        if(current.getLeftChild()==null && current.getRightChild()==null) {

            if(current==root)
                root = null;

            if(isLeftChild ==true)
                parent.setLeftChild(null);
            else
                parent.setRightChild(null);

        }

        else if(current.getRightChild()==null){
            if(current==root)
                root = current.getLeftChild();
            else if(isLeftChild)
                parent.setLeftChild(current.getLeftChild());
            else
                parent.setRightChild(current.getLeftChild());
        }

        else if(current.getLeftChild()==null){
            if(current==root)
                root = current.getRightChild();
            else if(isLeftChild)
                parent.setLeftChild(current.getRightChild());
            else
                parent.setRightChild(current.getRightChild());
        }

        else if(current.getLeftChild() != null && current.getRightChild() != null) {

            BinaryTreeNode successor = getSuccessor(current);

            if(current==root)
                root = successor;
            else if(isLeftChild)
                parent.setLeftChild(successor);
            else
                parent.setRightChild(successor);

            successor.setLeftChild(current.getLeftChild());
        }
        return true;
    }

    public BinaryTreeNode getSuccessor(BinaryTreeNode deleleNode){

        BinaryTreeNode successsor =null;
        BinaryTreeNode successsorParent =null;
        BinaryTreeNode current = deleleNode.getRightChild();

        while(current!=null){
            successsorParent = successsor;
            successsor = current;
            current = current.getLeftChild();
        }

        if(successsor!=deleleNode.getRightChild()){
            successsorParent.setLeftChild(successsor.getRightChild());
            successsor.setRightChild(deleleNode.getRightChild());
        }

        return successsor;
    }

    @Override
    public int height() {

        BinaryTreeNode node = root;

        Queue<BinaryTreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> lengthQueue = new LinkedList<>();

        if(node == null)
            return -1;

        nodeQueue.add(node);
        lengthQueue.add(0);
        int height = 0;

        while(!nodeQueue.isEmpty()) {

            BinaryTreeNode curr = nodeQueue.remove();
            int currLen = lengthQueue.remove();

            if(curr.getLeftChild() != null) {
                nodeQueue.add(curr.getLeftChild());
                lengthQueue.add(currLen + 1);
            }

            if(curr.getRightChild() != null) {
                nodeQueue.add(curr.getRightChild());
                lengthQueue.add(currLen + 1);
            }

            height = Math.max(currLen, height);
        }

        return height;
    }

}
