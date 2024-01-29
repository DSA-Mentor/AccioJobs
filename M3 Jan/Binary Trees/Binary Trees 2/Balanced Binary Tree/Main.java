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

    /**
     * faith: is binary tree balanced starting from given root
     * 
     * TC: O(N^2), SC: O(H)
     */
    // public static boolean isBalanced(Node root) {
    // if (root == null) {
    // return true;
    // }

    // boolean isLstBalanced = isBalanced(root.left);

    // boolean isRstBalanced = isBalanced(root.right);

    // // is root balanced
    // int hLST = height(root.left);
    // int hRST = height(root.right);
    // int diff = Math.abs(hLST - hRST);
    // boolean isRootBalanced = false;
    // if (diff <= 1) {
    // isRootBalanced = true;
    // }

    // if (isLstBalanced == false || isRstBalanced == false || isRootBalanced ==
    // false) {
    // return false;
    // }

    // return true;
    // }

    static class Pair {

        int height;
        boolean isBalanced;

        Pair(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    /**
     * faith: returns {isBalanced, height} of the BT starting from given root
     * 
     * TC: O(N), SC: O(H)
     */
    public static Pair helper(Node root) {
        if (root == null) {
            return new Pair(true, 0);
        }

        Pair LST = helper(root.left);

        Pair RST = helper(root.right);

        // height of the binary tree
        int heightOfTree = Math.max(LST.height, RST.height) + 1;

        // isRootBalanced
        int hLST = LST.height;
        int hRST = RST.height;
        int diff = Math.abs(hLST - hRST);
        boolean isRootBalanced = false;
        if (diff <= 1) {
            isRootBalanced = true;
        }

        if (LST.isBalanced == false || RST.isBalanced == false || isRootBalanced == false) {
            return new Pair(false, heightOfTree);
        }

        return new Pair(true, heightOfTree);
    }

    public static boolean isBalanced(Node root) {
        Pair ans = helper(root);
        return ans.isBalanced;
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

class Node {

    int data;
    Node left, right;
}