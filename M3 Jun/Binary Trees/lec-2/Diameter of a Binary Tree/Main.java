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
        System.out.println(g.diameter(root1));
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
    // public int heightOfTree(Node root) {
    // if (root == null) {
    // return 0;
    // }

    // int heightOfLST = heightOfTree(root.left);
    // int heightOfRST = heightOfTree(root.right);

    // return Math.max(heightOfLST, heightOfRST) + 1;
    // }

    // // TC: O(N^2)
    // // returns diameter of the BT from root
    // public static int diameter(Node root) {
    // if (root == null) {
    // return 0;
    // }

    // int diaLST = diameter(root.left);
    // int diaRST = diameter(root.right);

    // // diameter through root
    // int hLST = heightOfTree(root.left);
    // int hRST = heightOfTree(root.right);
    // int diaThroughRoot = hLST + 1 + hRST;

    // return Math.max(diaThroughRoot, Math.max(diaLST, diaRST));
    // }

    static class Pair {
        int diameter;
        int height;

        Pair(int d, int h) {
            diameter = d;
            height = h;
        }
    }

    // faith: return Pair of diameter and height of BT from root
    public static Pair helper(Node root) {
        // base case
        if (root == null) {
            return new Pair(0, 0);
        }

        Pair LST = helper(root.left);
        Pair RST = helper(root.right);

        // diameter passing through root
        int diaThroughRoot = LST.height + 1 + RST.height;

        int diaOfTree = Math.max(diaThroughRoot, Math.max(LST.diameter, RST.diameter));

        // height of the BT
        int height = Math.max(LST.height, RST.height) + 1;

        return new Pair(diaOfTree, height);
    }

    public static int diameter(Node root) {
        return helper(root).diameter;
    }
}