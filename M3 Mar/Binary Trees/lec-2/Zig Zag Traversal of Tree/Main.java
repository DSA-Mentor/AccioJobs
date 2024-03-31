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
        g.binaryTreeZigZagTraversal(root1);
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
    public static void binaryTreeZigZagTraversal(Node root) {
        // Initialize a queue to hold the nodes of the tree
        Queue<Node> que = new ArrayDeque<>();

        // Add the root node to the queue to start the traversal
        que.add(root);

        // Initialize level counter to track the current level
        int level = 0;
        // Loop until the queue is empty
        while (que.size() != 0) {
            // Determine the number of nodes at the current level
            int size = que.size();

            ArrayList<Integer> currLevel = new ArrayList<>();

            // Process all nodes at the current level
            while (size-- > 0) {
                // Remove the next node from the queue
                Node rnode = que.remove();

                currLevel.add(rnode.data);

                // If the current node has a left child, add it to the queue
                if (rnode.left != null) {
                    que.add(rnode.left);
                }

                // If the current node has a right child, add it to the queue
                if (rnode.right != null) {
                    que.add(rnode.right);
                }
            }

            if (level % 2 != 0) {
                Collections.reverse(currLevel);
            }

            for (int e : currLevel) {
                System.out.print(e + " ");
            }

            // Increment the level counter
            level++;
        }
    }
}