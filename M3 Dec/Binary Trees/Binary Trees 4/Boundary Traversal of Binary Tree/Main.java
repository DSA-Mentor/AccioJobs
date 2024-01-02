import java.util.*;

class Node {
    int data;
    Node left, right;
}

class Solution {
    static void printLeftBoundary(Node root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            return;
        }

        System.out.print(root.data + " ");

        if (root.left != null) {
            printLeftBoundary(root.left);
        } else {
            printLeftBoundary(root.right);
        }
    }

    static void printLeafNode(Node root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            System.out.print(root.data + " ");
        }

        printLeafNode(root.left);
        printLeafNode(root.right);
    }

    static void printRightBoundary(Node root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            return;
        }

        if (root.right != null) {
            printRightBoundary(root.right);
        } else {
            printRightBoundary(root.left);
        }

        System.out.print(root.data + " ");
    }
    
    static void printBoundary(Node root) {
        // print the root
        System.out.print(root.data + " ");
        
        // print left boundary
        printLeftBoundary(root.left);
        
        // print leaf nodes
        if (root.left != null || root.right != null) {
             printLeafNode(root);   
        }
        
        // print right boundary
        printRightBoundary(root.right);
    }
}
public class Main {

    static Node getNode(int data) {
        // Allocate memory
        Node newNode = new Node();

        // put in the data
        newNode.data = data;
        newNode.left = newNode.right = null;
        return newNode;
    }

    static Node LevelOrder(Node root, int data) {
        if (root == null) {
            root = getNode(data);
            return root;
        }
        if (data <= root.data) root.left =
            LevelOrder(root.left, data);
        else root.right =
            LevelOrder(root.right, data);
        return root;
    }

    static Node constructBst(int arr[], int n) {
        if (n == 0) return null;
        Node root = null;

        for (int i = 0; i < n; i++) root = LevelOrder(root, arr[i]);

        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] tree = new int[n];
        for (int i = 0; i < n; i++) tree[i] = sc.nextInt();
        sc.close();
        Node root = constructBst(tree, n);
        Solution.printBoundary(root);
    }
}