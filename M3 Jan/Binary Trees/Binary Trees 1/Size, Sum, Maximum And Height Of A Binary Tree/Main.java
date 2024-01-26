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
    /*
     * faith: returns size of the binary tree starting from given root
     * 
     * TC: O(N), SC: O(H)
     **/
    public int sizeOfTree(Node root) {
        // base case
        if (root == null) {
            return 0;
        }

        // size of LST
        int lstSize = sizeOfTree(root.left);

        // size of RST
        int rstSize = sizeOfTree(root.right);

        // size of the binary tree = (size of LST) + (1 for root node) + (size of RST)
        int size = lstSize + 1 + rstSize;

        return size;

    }

    /*
     * faith: returns sum of the binary tree starting from given root
     * 
     * TC: O(N), SC: O(H)
     **/
    public int sumOfTree(Node root) {
        // base case
        if (root == null) {
            return 0;
        }

        // sum of LST
        int lstSum = sumOfTree(root.left);

        // sum of RST
        int rstSum = sumOfTree(root.right);

        // sum of the binary tree = (sum of LST) + (root's data) + (sum of RST)
        int sum = lstSum + root.data + rstSum;

        return sum;
    }

    /*
     * faith: returns max value of the binary tree starting from given root
     * 
     * TC: O(N), SC: O(H)
     **/
    public int maxOfTree(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        // max value in LST
        int lstMax = maxOfTree(root.left);

        // max value in RST
        int rstMax = maxOfTree(root.right);

        // max of the tree = Math.max(me, max in child)
        int maxChild = Math.max(lstMax, rstMax);
        int max = Math.max(root.data, maxChild);

        return max;

    }

    /*
     * faith: returns height of the binary tree starting from given root
     * 
     * TC: O(N), SC: O(H)
     **/
    public int heightOfTree(Node root) {
        // base case
        if (root == null) {
            return 0;
        }

        // height of LST
        int lstHeight = heightOfTree(root.left);

        // height of RST
        int rstHeight = heightOfTree(root.right);

        // height of the binary tree = 1 (for you) + max {height of LST, height of RST}
        int height = 1 + Math.max(lstHeight, rstHeight);

        return height;
    }
}