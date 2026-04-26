import java.util.*;

// Binary Tree Node with Traversals
class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    // Pre-order Traversal (Root, Left, Right)
    public static <T> void preOrder(BinaryTreeNode<T> root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // In-order Traversal (Left, Root, Right)
    public static <T> void inOrder(BinaryTreeNode<T> root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    // Post-order Traversal (Left, Right, Root)
    public static <T> void postOrder(BinaryTreeNode<T> root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    // Level-order Traversal (Breadth-First)
    public static <T> void levelOrder(BinaryTreeNode<T> root) {
        if (root == null) return;

        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode<T> current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }
}

// Binary Search Tree
class BST<T extends Comparable<T>> {
    private BinaryTreeNode<T> root;

    public BST() {
        root = null;
    }

    // Insert a value
    public void insert(T value) {
        root = insertRecursive(root, value);
    }

    private BinaryTreeNode<T> insertRecursive(BinaryTreeNode<T> node, T value) {
        if (node == null) {
            return new BinaryTreeNode<>(value);
        }

        if (value.compareTo(node.data) < 0) {
            node.left = insertRecursive(node.left, value);
        } else if (value.compareTo(node.data) > 0) {
            node.right = insertRecursive(node.right, value);
        }

        return node;
    }

    // Search for a value
    public boolean search(T value) {
        return searchRecursive(root, value);
    }

    private boolean searchRecursive(BinaryTreeNode<T> node, T value) {
        if (node == null) return false;

        if (value.compareTo(node.data) == 0) return true;

        if (value.compareTo(node.data) < 0) {
            return searchRecursive(node.left, value);
        } else {
            return searchRecursive(node.right, value);
        }
    }

    public BinaryTreeNode<T> getRoot() {
        return root;
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();

        // Insert the values
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        BinaryTreeNode<Integer> root = tree.getRoot();

        System.out.print("Pre-order: ");
        BinaryTreeNode.preOrder(root);
        System.out.println();

        System.out.print("In-order: ");
        BinaryTreeNode.inOrder(root);
        System.out.println();

        System.out.print("Post-order: ");
        BinaryTreeNode.postOrder(root);
        System.out.println();

        System.out.print("Level-order: ");
        BinaryTreeNode.levelOrder(root);
        System.out.println();

        // Search tests
        System.out.println("Search 40: " + tree.search(40)); // for true
        System.out.println("Search 100: " + tree.search(100)); // for false
    }
}
