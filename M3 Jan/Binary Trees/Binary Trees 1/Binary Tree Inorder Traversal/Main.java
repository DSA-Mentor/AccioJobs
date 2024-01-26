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
    /*
     * inorder Binary tree = inorder (LST) + print (root's data) + inorder (RST)
     * 
     * Faith: prints inorder of a binary tree starting from given root
     * 
     * TC: O(N), SC: O(H)
     * where, N is number of nodes, and H is height of the binary tree
     **/
    public static void inorderTraversal(Node root) {
        // base case
        if (root == null) {
            return;
        }

        // inorder of LST
        inorderTraversal(root.left);

        System.out.print(root.data + " ");

        // inorder of RST
        inorderTraversal(root.right);
    }
}