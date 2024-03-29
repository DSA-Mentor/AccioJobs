
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
        tree.inorderTraversal(root);

    }
}

class Solution {
    // TC: O(N), SC: O(H)
    // This function performs an inorder traversal on a binary tree.
    // In inorder traversal, we visit the left subtree first, then the root, and
    // finally the right subtree.
    public static void inorderTraversal(Node root) {
        // Expectation for the simplest input: If the current node is null (base case),
        // we expect nothing to be done, so we return immediately.
        if (root == null) {
            return;
        }

        // Faith on the left subtree: We have faith that calling inorderTraversal
        // on the left child will correctly traverse the left subtree in inorder.
        // We don't concern ourselves with how this happens, just that it will.
        inorderTraversal(root.left);

        // Now, after the left subtree has been visited, we process the current node.
        // This fulfills the "Root" part of the Left-Root-Right order of inorder
        // traversal.
        System.out.print(root.data + " ");

        // Faith on the right subtree: Similarly, we trust that calling inorderTraversal
        // on the right child will correctly traverse the right subtree in inorder.
        // Again, our focus is on the expectation that this action will be completed
        // correctly,
        // without needing to know the specifics of the operation.
        inorderTraversal(root.right);
    }
}