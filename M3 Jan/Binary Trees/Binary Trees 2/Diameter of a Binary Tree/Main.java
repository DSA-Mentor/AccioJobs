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
    /*
     * faith: returns height of the binary tree starting from given root
     * 
     * TC: O(N), SC: O(H)
     **/
    // public static int heightOfTree(Node root) {
    // // base case
    // if (root == null) {
    // return 0;
    // }

    // // height of LST
    // int lstHeight = heightOfTree(root.left);

    // // height of RST
    // int rstHeight = heightOfTree(root.right);

    // // height of the binary tree = 1 (for you) + max {height of LST, height of
    // RST}
    // int height = 1 + Math.max(lstHeight, rstHeight);

    // return height;
    // }

    /**
     * faith: returns diameter of the binary tree starting from given root
     * 
     * TC: O(N^2), SC: O(H)
     */
    // public static int diameter(Node root) {
    // // base case
    // if (root == null) {
    // return 0;
    // }

    // // LST diameter
    // int lstDiameter = diameter(root.left);

    // // RST diameter
    // int rstDiameter = diameter(root.right);

    // // diameter passing through root
    // // diameterThroughRoot = hLST + hRST + 1
    // int lstHeight = heightOfTree(root.left);
    // int rstHeight = heightOfTree(root.right);
    // int diameterThroughRoot = lstHeight + 1 + rstHeight;

    // // diameter of the tree
    // return Math.max(diameterThroughRoot, Math.max(lstDiameter, rstDiameter));
    // }

    static class Pair {
        int diameter;
        int height;

        Pair(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    /**
     * faith: returns {diameter, height} of the binary tree starting from given root
     * 
     * TC: O(N), SC: O(H)
     */
    public static Pair helper(Node root) {
        // base case
        if (root == null) {
            return new Pair(0, 0);
        }

        // height and diameter of LST
        Pair LST = helper(root.left);

        // height and diameter of RST
        Pair RST = helper(root.right);

        // diameter passing through root
        // diameterThroughRoot = hLST + hRST + 1
        int lstHeight = LST.height;
        int rstHeight = RST.height;
        int diameterThroughRoot = lstHeight + 1 + rstHeight;

        int diameterOfTree = Math.max(diameterThroughRoot, Math.max(LST.diameter, RST.diameter));

        int heightOfTree = Math.max(LST.height, RST.height) + 1;

        return new Pair(diameterOfTree, heightOfTree);
    }

    public static int diameter(Node root) {
        Pair ans = helper(root);
        return ans.diameter;
    }
}