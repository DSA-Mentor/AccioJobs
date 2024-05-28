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

class Pair {
    int d;
    int h;

    Pair(int d, int h) {
        this.d = d;
        this.h = h;
    }
}

class Solution {
    // return a Pair of diameter and height of the tree
    public static Pair helper(Node root) {
        if (root == null) {
            return new Pair(0, 0);
        }

        Pair LST = helper(root.left);
        Pair RST = helper(root.right);

        int d = Math.max(Math.max(LST.d, RST.d), LST.h + 1 + RST.h);
        int h = Math.max(LST.h, RST.h) + 1;

        return new Pair(d, h);
    }

    public static int diameter(Node root) {
        return helper(root).d;
    }
}