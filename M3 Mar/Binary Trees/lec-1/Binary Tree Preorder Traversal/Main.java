
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Main {
    static Node buildTree(String str) {
        // System.out.print(str);
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if (i >= ip.length)
                break;
            currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        // System.out.print(s);
        Node root = buildTree(s);
        Solution tree = new Solution();
        tree.preorderTraversal(root);

    }
}

class Solution {
    // TC: O(N), SC: O(H)
    // This function performs a preorder traversal of a binary tree.
    // In preorder traversal, we visit the root first, then the left subtree, and
    // finally the right subtree.
    public static void preorderTraversal(Node root) {
        // Base case: If the current node is null, we expect nothing to be done.
        // This is our expectation for the smallest or simplest input.
        if (root == null) {
            return;
        }

        // Our faith here is that we can process the current node.
        // So, we do exactly that by printing the node's value. This is the "root" part
        // of Root-Left-Right.
        System.out.print(root.data + " ");

        // By making a recursive call on the left child, we have faith that this call
        // will
        // correctly perform a preorder traversal of the left subtree. We don't need to
        // know
        // how it's done, we just expect that it will be done.
        preorderTraversal(root.left);

        // Similarly, we have faith that a recursive call on the right child will
        // correctly perform a preorder traversal of the right subtree. Again, our
        // expectation
        // is that the traversal will be completed without needing to understand the
        // specifics.
        preorderTraversal(root.right);
    }

}