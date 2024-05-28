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
    public int sizeOfTree(Node root) {
        if (root == null) {
            return 0;
        }

        int x = sizeOfTree(root.left);
        int y = sizeOfTree(root.right);

        return x + 1 + y;
    }

    public int sumOfTree(Node root) {
        if (root == null) {
            return 0;
        }

        int x = sumOfTree(root.left);
        int y = sumOfTree(root.right);

        return x + root.data + y;
    }

    public int maxOfTree(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int x = maxOfTree(root.left);
        int y = maxOfTree(root.right);

        return Math.max(root.data, Math.max(x, y));
    }

    public int heightOfTree(Node root) {
        if (root == null) {
            return 0;
        }

        int hLST = heightOfTree(root.left);
        int hRST = heightOfTree(root.right);

        return Math.max(hLST, hRST) + 1;
    }
}