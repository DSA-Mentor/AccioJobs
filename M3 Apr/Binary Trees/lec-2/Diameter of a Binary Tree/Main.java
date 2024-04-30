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
    // private static int height(Node root) {
    // if (root == null) return 0;
    // return Math.max(height(root.left), height(root.right)) + 1;
    // }

    // // TC: O(N^2)
    // // faith: returns diameter of the binary tree
    // public static int diameter(Node root) {
    // if (root == null) {
    // return 0;
    // }

    // int diaOfLST = diameter(root.left);
    // int diaOfRST = diameter(root.right);

    // // diameter passing through to root
    // int hLST = height(root.left);
    // int hRST = height(root.right);
    // int diameterPassingThroughRoot = hLST + 1 + hRST;

    // return Math.max(diameterPassingThroughRoot, Math.max(diaOfLST, diaOfRST));
    // }

    static class Pair {
        int d;
        int h;

        Pair(int d, int h) {
            this.d = d;
            this.h = h;
        }
    }

    // TC: O(N)
    // faith: return Pair of diameter and height of the binary tree
    public static Pair helper(Node root) {
        // Base case
        if (root == null) {
            return new Pair(0, 0);
        }

        Pair LST = helper(root.left);
        Pair RST = helper(root.right);

        int h = Math.max(LST.h, RST.h) + 1;

        int dPassindThroughRoot = LST.h + 1 + RST.h;
        int d = Math.max(dPassindThroughRoot, Math.max(LST.d, RST.d));

        return new Pair(d, h);
    }

    public static int diameter(Node root) {
        Pair ans = helper(root);
        return ans.d;
    }
}