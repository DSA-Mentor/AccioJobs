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

    static class Pair {
        boolean balanced;
        int height;

        Pair(boolean b, int h) {
            balanced = b;
            height = h;
        }
    }

    // faith: returns {isBalanced, height} of the BT
    public static Pair helperFun(Node root) {
        if (root == null) {
            return new Pair(true, 0);
        }

        Pair LST = helperFun(root.left);
        Pair RST = helperFun(root.right);

        int heightOfTree = Math.max(LST.height, RST.height) + 1;

        // is root node balanced
        boolean isRootBalanced = Math.abs(LST.height - RST.height) <= 1;

        if (LST.balanced == true && RST.balanced == true && isRootBalanced == true) {
            return new Pair(true, heightOfTree);
        } else {
            return new Pair(false, heightOfTree);
        }
    }

    public static boolean isBalanced(Node root) {
        // your code here
        Pair ans = helperFun(root);
        return ans.balanced;
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
            System.out.println("false");
    }
}

class Node {
    int data;
    Node left, right;
}