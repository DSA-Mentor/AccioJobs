import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;
import java.lang.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    // Track the leftmost and rightmost horizontal distances from root.
    int leftMostPos;
    int rightMostPos;

    // Constructor initializes positions to zero, assuming root starts at horizontal
    // position 0.
    Solution() {
        this.leftMostPos = 0;
        this.rightMostPos = 0;
    }

    // Recursively find the leftmost and rightmost positions to determine the width
    // of the tree.
    void traversal(TreeNode root, int pos) {
        if (root == null) {
            return; // Base case: if current node is null, return.
        }

        // Update the leftmost and rightmost positions seen so far.
        this.leftMostPos = Math.min(leftMostPos, pos);
        this.rightMostPos = Math.max(rightMostPos, pos);

        // Recurse for left and right children with updated positions.
        traversal(root.left, pos - 1);
        traversal(root.right, pos + 1);
    }

    // Helper class to pair a TreeNode with its vertical level.
    class Pair implements Comparable<Pair> {
        TreeNode node;
        int vlevel; // Vertical level.

        Pair(TreeNode node, int vlevel) {
            this.node = node;
            this.vlevel = vlevel;
        }

        // Compare pairs primarily by vertical level, then by node data for ordering
        // within the same level.
        @Override
        public int compareTo(Pair o) {
            if (this.vlevel == o.vlevel) {
                return this.node.data - o.node.data;
            } else {
                return this.vlevel - o.vlevel;
            }
        }
    }

    // Perform the vertical order traversal of a binary tree.
    List<List<Integer>> VerticalTraversal(TreeNode root) {
        traversal(root, 0); // First, find the width of the tree.
        int vLevelOfRoot = Math.abs(this.leftMostPos); // Adjust the vertical level of root to start from 0 or positive.
        int vLevels = this.rightMostPos - this.leftMostPos + 1; // Calculate total vertical levels.

        // Initialize list of lists to hold the vertical levels.
        List<List<Integer>> vl = new ArrayList<>();
        for (int i = 0; i < vLevels; i++) {
            vl.add(new ArrayList<>());
        }

        // Priority queue for level order traversal, starting with the root.
        PriorityQueue<Pair> PPQ = new PriorityQueue<>();
        PPQ.add(new Pair(root, vLevelOfRoot));

        // Perform a level order traversal using a queue.
        while (!PPQ.isEmpty()) {
            int size = PPQ.size();
            PriorityQueue<Pair> CPQ = new PriorityQueue<>();
            while (size-- > 0) {
                Pair rpair = PPQ.remove(); // Remove and process the current pair.
                TreeNode rnode = rpair.node;
                int vpos = rpair.vlevel;

                // Add the node's data to its corresponding vertical level.
                vl.get(vpos).add(rnode.data);

                // Add left and right children to the queue if they exist.
                if (rnode.left != null) {
                    CPQ.add(new Pair(rnode.left, vpos - 1));
                }
                if (rnode.right != null) {
                    CPQ.add(new Pair(rnode.right, vpos + 1));
                }
            }

            // Update the main queue with the contents of the current level's queue.
            PPQ = CPQ;
        }

        return vl; // Return the list of vertical levels.
    }
}

class Main {

    static TreeNode buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N')
            return null;

        String ip[] = str.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(ip[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {
            TreeNode currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.left = new TreeNode(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if (i >= ip.length)
                break;
            currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.right = new TreeNode(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String s = br.readLine();
            TreeNode root = buildTree(s);
            Solution ob = new Solution();
            List<List<Integer>> ans = ob.VerticalTraversal(root);
            for (int i = 0; i < ans.size(); i++) {
                for (int a : ans.get(i)) {
                    System.out.print(a + " ");
                }
                System.out.println();
            }
            t--;
        }
    }
}