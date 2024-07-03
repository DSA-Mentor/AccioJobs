import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Main {
    static Node buildTree(String str) {
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        Node root1 = buildTree(s1);
        Solution g = new Solution();
        System.out.println(g.sizeOfTree(root1));
        System.out.println(g.sumOfTree(root1));
        System.out.println(g.maxOfTree(root1));
        System.out.println(g.heightOfTree(root1));
    }
}

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

class Solution {
    // faith: returns size of BT from given root
    public int sizeOfTree(Node root) {
        // base case
        if (root == null) {
            return 0;
        }

        int sizeOfLST = sizeOfTree(root.left);
        int sizeOfRST = sizeOfTree(root.right);

        return sizeOfLST + 1 + sizeOfRST;
    }

    public int sumOfTree(Node root) {
        if (root == null) {
            return 0;
        }

        int sumOfLST = sumOfTree(root.left);
        int sumOfRST = sumOfTree(root.right);

        return sumOfLST + root.data + sumOfRST;
    }

    public int maxOfTree(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int maxOfLST = maxOfTree(root.left);
        int maxOfRST = maxOfTree(root.right);

        return Math.max(root.data, Math.max(maxOfLST, maxOfRST));
    }

    public int heightOfTree(Node root) {
        if (root == null) {
            return 0;
        }

        int heightOfLST = heightOfTree(root.left);
        int heightOfRST = heightOfTree(root.right);

        return Math.max(heightOfLST, heightOfRST) + 1;
    }
}