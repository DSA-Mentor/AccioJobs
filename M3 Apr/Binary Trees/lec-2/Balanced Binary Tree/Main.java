import java.util.*;

public class Main {
    static Node getNode(int data) {
        // Allocate memory
        Node newNode = new Node();

        // put in the data
        newNode.data = data;
        newNode.left = newNode.right = null;
        return newNode;
    }

    // function to construct a BST from
    // its level order traversal
    static Node LevelOrder(Node root, int data) {
        if (root == null) {
            root = getNode(data);
            return root;
        }

        if (data <= root.data) {
            root.left = LevelOrder(root.left, data);
        } else {
            root.right = LevelOrder(root.right, data);
        }

        return root;
    }

    static Node constructBst(int arr[], int n) {
        if (n == 0) {
            return null;
        }

        Node root = null;

        for (int i = 0; i < n; i++) {
            root = LevelOrder(root, arr[i]);
        }

        return root;
    }

    // private static int height(Node root) {
    // if (root == null) return 0;
    // return Math.max(height(root.left), height(root.right)) + 1;
    // }

    // // TC: O(N^2), SC: O(H)
    // // faith: return is given binary is balanced or not?
    // public static boolean isBalanced(Node root) {
    // if (root == null) {
    // return true;
    // }

    // boolean isLSTBalanced = isBalanced(root.left);
    // boolean isRSTBalanced = isBalanced(root.right);

    // // check is root node balanced
    // int hLST = height(root.left);
    // int hRST = height(root.right);

    // boolean isRootBalanced = Math.abs(hLST - hRST) <= 1 ? true : false;

    // if (isLSTBalanced == true && isRSTBalanced == true && isRootBalanced == true)
    // {
    // return true;
    // }

    // return false;
    // }

    static class Pair {
        boolean ib;
        int h;

        Pair(boolean ib, int h) {
            this.ib = ib;
            this.h = h;
        }
    }

    // faith: returns isBalanced, and height and of thr given binary tree
    public static Pair helper(Node root) {
        if (root == null) {
            return new Pair(true, 0);
        }

        Pair LST = helper(root.left);
        Pair RST = helper(root.right);

        // height of the binary tree
        int h = Math.max(LST.h, RST.h) + 1;

        // check is root node balanced
        boolean isRootBalanced = Math.abs(LST.h - RST.h) <= 1 ? true : false;

        if (isRootBalanced == true && LST.ib == true && RST.ib == true) {
            return new Pair(true, h);
        }

        return new Pair(false, h);
    }

    public static boolean isBalanced(Node root) {
        return helper(root).ib;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] tree = new int[n];
        for (int i = 0; i < n; i++) {
            tree[i] = sc.nextInt();
        }
        sc.close();
        Node root = constructBst(tree, n);
        if (isBalanced(root)) {
            System.out.println("true");
        } else
            System.out.println(
                    "false");
    }
}

class Node {
    int data;
    Node left, right;
}