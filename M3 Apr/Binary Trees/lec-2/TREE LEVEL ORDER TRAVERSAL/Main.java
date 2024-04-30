import java.util.*;

class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

class BST {
    Node root = null;

    BST() {
    }

    Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }
}

public class Main {
    // public static void levelOrderTraversal(Node root) {
    // Queue < Node > que = new ArrayDeque <>();
    // que.add(root);

    // int level = 0;
    // while (que.size() != 0) {
    // int size = que.size();

    // System.out.print(level + ": ");
    // while (size-->0) {
    // Node rnode = que.remove();

    // System.out.print(rnode.val + " ");

    // if (rnode.left != null) {
    // que.add(rnode.left);
    // }
    // if (rnode.right != null) {
    // que.add(rnode.right);
    // }
    // }
    // System.out.println();

    // level++;
    // }
    // }

    // TC: O(N), SC: O(2^H)
    public static void levelOrderTraversal(Node root) {
        Queue<Node> que = new ArrayDeque<>();
        que.add(root);

        while (que.size() != 0) {
            int size = que.size();

            while (size-- > 0) {
                Node rnode = que.remove();

                System.out.print(rnode.val + " ");

                if (rnode.left != null) {
                    que.add(rnode.left);
                }
                if (rnode.right != null) {
                    que.add(rnode.right);
                }
            }
        }
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        BST t = new BST();
        for (int i = 0; i < n; i++) {
            t.root = t.insert(t.root, input.nextInt());
        }

        levelOrderTraversal(t.root);
    }
}