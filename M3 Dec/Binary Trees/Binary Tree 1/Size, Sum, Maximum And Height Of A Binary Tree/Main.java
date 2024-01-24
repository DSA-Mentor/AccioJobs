import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

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
    // Faith: return size of the tree starting from the root
    public int sizeOfTree(Node root) {
        // base base
        if (root == null) {
            return 0;
        }

        // get size of the left subtree
        int leftSize = sizeOfTree(root.left);

        // get size of the right subtree
        int rightSize = sizeOfTree(root.right);

        // overall size of the tree = size of LST + 1 (for root) + size of RST
        return leftSize + 1 + rightSize;
    }

    // Faith: return sum of the tree starting from the root
    public int sumOfTree(Node root) {
        // base case
        if (root == null) {
            return 0;
        }

        // get the sum of left subtree
        int leftSum = sumOfTree(root.left);

        // get the sum of right subtree
        int rightSum = sumOfTree(root.right);

        // overall sum of the tree = leftSum + root.data + rightSum
        return leftSum + root.data + rightSum;
    }

    // Faith: return maximum value of the tree starting from the root
    public int maxOfTree(Node root) {
        // base case
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        // get maximum value in left subtree
        int leftMax = maxOfTree(root.left);

        // get maximum value in right subtree
        int rightMax = maxOfTree(root.right);

        // maximum value of the tree
        // Max of {leftMax, rightMax, root.data}
        return Math.max(root.data, Math.max(leftMax, rightMax));
    }

    // Faith: return height of the tree starting from root
    public int heightOfTree(Node root) {
        // base case
        if (root == null) {
            return 0;
        }

        // get height of left subtree
        int leftHeight = heightOfTree(root.left);

        // get height of right subtree
        int rightHeight = heightOfTree(root.right);

        // overall height of the tree = max(leftHeight, rightHeight) + 1 (for root node)
        return Math.max(leftHeight, rightHeight) + 1;
    }
}