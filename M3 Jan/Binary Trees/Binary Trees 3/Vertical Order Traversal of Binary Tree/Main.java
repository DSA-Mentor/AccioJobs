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
    int minPos = 0;
    int maxPos = 0;

    void getPosition(TreeNode root, int pos) {
        if (root == null) {
            return;
        }

        minPos = Math.min(minPos, pos);
        maxPos = Math.max(maxPos, pos);

        getPosition(root.left, pos - 1);
        getPosition(root.right, pos + 1);
    }

    // this, other
    // this - other -> defualt scernrio increasing
    // other - this -> reverse of default decreasing

    class Pair implements Comparable<Pair> {
        TreeNode node;
        int vLevel;

        Pair(TreeNode node, int vLevel) {
            this.node = node;
            this.vLevel = vLevel;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.vLevel != other.vLevel) {
                return this.vLevel - other.vLevel;
            } else {
                return this.node.data - other.node.data;
            }
        }
    }

    List<List<Integer>> VerticalTraversal(TreeNode root) {
        getPosition(root, 0);

        int numberOfVLevel = maxPos - minPos + 1;
        int vLevelOfRoot = Math.abs(minPos);

        List<List<Integer>> vo = new ArrayList<>();
        for (int i = 0; i < numberOfVLevel; i++) {
            vo.add(new ArrayList<>());
        }

        PriorityQueue<Pair> PPQ = new PriorityQueue<>();
        PPQ.add(new Pair(root, vLevelOfRoot));

        while (PPQ.size() != 0) {
            int size = PPQ.size();

            PriorityQueue<Pair> CPQ = new PriorityQueue<>();
            while (size-- > 0) {
                Pair rpair = PPQ.remove();

                TreeNode rnode = rpair.node;
                int vLevel = rpair.vLevel;

                vo.get(vLevel).add(rnode.data);

                if (rnode.left != null) {
                    CPQ.add(new Pair(rnode.left, vLevel - 1));
                }
                if (rnode.right != null) {
                    CPQ.add(new Pair(rnode.right, vLevel + 1));
                }
            }

            PPQ = CPQ;
        }

        return vo;
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