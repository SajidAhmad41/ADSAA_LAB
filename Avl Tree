import java.util.Scanner;

class Node {
    int data;
    int h;  // height
    Node leftChild;
    Node rightChild;

    public Node() {
        data = 0;
        h = 0;
        leftChild = null;
        rightChild = null;
    }

    public Node(int value) {
        this.data = value;
        h = 0;
        leftChild = null;
        rightChild = null;
    }
}

class ConstructAVLTree {
    private Node root;

    public ConstructAVLTree() {
        root = null;
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private int getHeight(Node node) {
        return node == null ? -1 : node.h;
    }

    private int max(int l, int r) {
        return l > r ? l : r;
    }

    private Node insert(Node node, int value) {
        if (node == null)
            node = new Node(value);
        else if (value < node.data) {
            node.leftChild = insert(node.leftChild, value);
            if (getHeight(node.leftChild) - getHeight(node.rightChild) == 2)
                if (value < node.leftChild.data)
                    node = rotateWithLeftChild(node);
                else
                    node = doubleWithLeftChild(node);
        } else if (value > node.data) {
            node.rightChild = insert(node.rightChild, value);
            if (getHeight(node.rightChild) - getHeight(node.leftChild) == 2)
                if (value > node.rightChild.data)
                    node = rotateWithRightChild(node);
                else
                    node = doubleWithRightChild(node);
        }
        node.h = max(getHeight(node.leftChild), getHeight(node.rightChild)) + 1;
        return node;
    }

    private Node rotateWithLeftChild(Node node) {
        Node left = node.leftChild;
        node.leftChild = left.rightChild;
        left.rightChild = node;
        node.h = max(getHeight(node.leftChild), getHeight(node.rightChild)) + 1;
        left.h = max(getHeight(left.leftChild), getHeight(left.rightChild)) + 1;
        return left;
    }

    private Node rotateWithRightChild(Node node) {
        Node right = node.rightChild;
        node.rightChild = right.leftChild;
        right.leftChild = node;
        node.h = max(getHeight(node.leftChild), getHeight(node.rightChild)) + 1;
        right.h = max(getHeight(right.leftChild), getHeight(right.rightChild)) + 1;
        return right;
    }

    private Node doubleWithLeftChild(Node node) {
        node.leftChild = rotateWithRightChild(node.leftChild);
        return rotateWithLeftChild(node);
    }

    private Node doubleWithRightChild(Node node) {
        node.rightChild = rotateWithLeftChild(node.rightChild);
        return rotateWithRightChild(node);
    }

    // Preorder Traversal
    public void preorderTraversal() {
        preorderTraversal(root);
    }

    private void preorderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderTraversal(node.leftChild);
            preorderTraversal(node.rightChild);
        }
    }

    // Postorder Traversal
    public void postorderTraversal() {
        postorderTraversal(root);
    }

    private void postorderTraversal(Node node) {
        if (node != null) {
            postorderTraversal(node.leftChild);
            postorderTraversal(node.rightChild);
            System.out.print(node.data + " ");
        }
    }

    // Inorder Traversal
    public void inorderTraversal() {
        inorderTraversal(root);
    }

    private void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.leftChild);
            System.out.print(node.data + " ");
            inorderTraversal(node.rightChild);
        }
    }

    // Search
    public void search(int key) {
        Node n = search(root, key);
        if (n == null)
            System.out.println("Key is not found in the Tree");
        else
            System.out.println("Key is found");
    }

    private Node search(Node node, int key) {
        if (node == null || node.data == key)
            return node;
        else if (key < node.data)
            return search(node.leftChild, key);
        else
            return search(node.rightChild, key);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ConstructAVLTree avl = new ConstructAVLTree();
        while (true) {
            System.out.println("1. Insert an element");
            System.out.println("2. Search for an element");
            System.out.println("3. Inorder Traversal");
            System.out.println("4. Preorder Traversal");
            System.out.println("5. Postorder Traversal");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter element:");
                    int item = sc.nextInt();
                    avl.insert(item);
                    break;
                case 2:
                    System.out.println("Enter the key element to search");
                    int key = sc.nextInt();
                    avl.search(key);
                    break;
                case 3:
                    System.out.println("Inorder Traversal:");
                    avl.inorderTraversal();
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Preorder Traversal:");
                    avl.preorderTraversal();
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Postorder Traversal:");
                    avl.postorderTraversal();
                    System.out.println();
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }
}
