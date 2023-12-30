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
        Queue < Node > queue = new LinkedList < > ();
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
            if (i >= ip.length) break;
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
    // // Approach 1: TC: O(N^2), SC: O(H)
    // // Faith: return height of the tree starting from root
    // public static int heightOfTree(Node root) {
    //     // base case
    //     if (root == null) {
    //         return 0;
    //     }
        
    //     // get height of left subtree
    //     int leftHeight = heightOfTree(root.left);

    //     // get height of right subtree
    //     int rightHeight = heightOfTree(root.right);

    //     // overall height of the tree = max(leftHeight, rightHeight) + 1 (for root node)
    //     return Math.max(leftHeight, rightHeight) + 1;
    // }
    
    // // Faith: return diameter of the binary tree starting from root
    // public static int diameter(Node root) {
    //     // base case
    //     if (root == null) {
    //         return 0;
    //     }
        
    //     // get best diameter of left subtree
    //     int diaLST = diameter(root.left);

    //     // get best diameter of right subtree
    //     int diaRST = diameter(root.right);

    //     // get diameter passing through root
    //     int heightLST = heightOfTree(root.left);
    //     int heightRST = heightOfTree(root.right);
    //     int diaThroughRoot = heightLST + 1 + heightRST;

    //     // overall diameter of the tree
    //     return Math.max(diaThroughRoot, Math.max(diaRST, diaLST));
    // }

    // Approach 2: TC: O(N), SC: O(H)
    static class Pair {
        int diameter;
        int height;

        Pair (int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }
    
    // Faith: return diameter and height of the binary tree starting root
    public static Pair helperFun(Node root) {
        // base case
        if (root == null) {
            return new Pair(0, 0);
        }
        
        // get the diameter and height of LST
        Pair LST = helperFun(root.left);

        // get the diameter and height of RST
        Pair RST = helperFun(root.right);

        // diameter of the tree -> Max(best in LST, best in RST, diameter through root)
        int diameterThroughRoot = LST.height + 1 + RST.height;
        int diameterOfTheTree = Math.max(diameterThroughRoot, Math.max(LST.diameter, RST.diameter));

        // height of the tree -> max (height of LST, height of RST) + 1
        int heighOfTheTree = Math.max(LST.height, RST.height) + 1;

        return new Pair(diameterOfTheTree, heighOfTheTree);
    }

    public static int diameter(Node root) {
        Pair ans = helperFun(root);
        return ans.diameter;
    }
    
}