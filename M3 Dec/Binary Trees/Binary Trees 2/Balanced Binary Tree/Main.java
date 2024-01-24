import java.util.*;

class Node {
    int data;
    Node left, right;
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

    // function to construct a BST from
    // its level order traversal
    static Node LevelOrder(Node root, int data) {
        if (root == null) {
            root = getNode(data);
            return root;
        }
        if (data <= root.data)
            root.left = LevelOrder(root.left, data);
        else
            root.right = LevelOrder(root.right, data);
        return root;
    }

    static Node constructBst(int arr[], int n) {
        if (n == 0)
            return null;
        Node root = null;

        for (int i = 0; i < n; i++)
            root = LevelOrder(root, arr[i]);

        return root;
    }

    static class Pair {
        boolean isBalanced;
        int height;

        Pair(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    // TC: O(N), SC: O(H)
    // Faith: return is balanced and height of the binary tree starting from root
    public static Pair helperFun(Node root) {
        // base case
        if (root == null) {
            return new Pair(true, 0);
        }

        // get isBalanced and height of LST
        Pair LST = helperFun(root.left);

        // get isBalanced and height of RST
        Pair RST = helperFun(root.right);

        // verify is root balanced
        boolean isRootBalanced = false;
        int absDiffOfHeight = Math.abs(LST.height - RST.height);
        if (absDiffOfHeight <= 1) {
            isRootBalanced = true;
        }

        // height of the tree
        int height = Math.max(LST.height, RST.height) + 1;

        if (LST.isBalanced == false || RST.isBalanced == false || isRootBalanced == false) {
            return new Pair(false, height);
        }

        return new Pair(true, height);
    }

    public static boolean isBalanced(Node root) {
        // your code here
        return helperFun(root).isBalanced;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] tree = new int[n];
        for (int i = 0; i < n; i++)
            tree[i] = sc.nextInt();
        sc.close();
        Node root = constructBst(tree, n);
        if (isBalanced(root))
            System.out.println("true");
        else
            System.out.println(
                    "false");
    }
}