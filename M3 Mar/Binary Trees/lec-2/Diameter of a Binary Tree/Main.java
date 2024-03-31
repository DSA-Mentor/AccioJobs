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
    // static int height(Node root) {
    // if (root == null) {
    // return 0;
    // }

    // return Math.max(height(root.left), height(root.right)) + 1;
    // }

    // // faith: returns diameter of the binary tree
    // public static int diameter(Node root) {
    // if (root == null) {
    // return 0;
    // }

    // int diaLST = diameter(root.left);
    // int diaRST = diameter(root.right);

    // // get diameter passing through root
    // int diaThroughRoot = height(root.left) + 1 + height(root.right);

    // return Math.max(diaThroughRoot, Math.max(diaLST, diaRST));
    // }

    static class Pair {
        int dia;
        int height;

        Pair(int d, int h) {
            dia = d;
            height = h;
        }
    }

    // faith: returns pair of diameter and height of the binary tree
    public static Pair helperFunction(Node root) {
        if (root == null) {
            return new Pair(0, 0);
        }

        Pair LST = helperFunction(root.left);
        Pair RST = helperFunction(root.right);

        int diaThroughRoot = LST.height + 1 + RST.height;

        int diaOfTree = Math.max(diaThroughRoot, Math.max(LST.dia, RST.dia));
        int heightOfTree = Math.max(LST.height, RST.height) + 1;

        return new Pair(diaOfTree, heightOfTree);
    }

    public static int diameter(Node root) {
        Pair ans = helperFunction(root);
        return ans.dia;
    }
}