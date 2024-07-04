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
    class Pair {
        TreeNode node;
        int vLevel;

        Pair(TreeNode node, int vLevel) {
            this.node = node;
            this.vLevel = vLevel;
        }
    }

    class Pair2 implements Comparable<Pair2> {
        TreeNode node;
        int vLevel;

        Pair2(TreeNode node, int vLevel) {
            this.node = node;
            this.vLevel = vLevel;
        }

        public int compareTo(Pair2 o) {
            if (this.vLevel == o.vLevel) {
                return this.node.data - o.node.data;
            }

            return this.vLevel - o.vLevel;
        }
    }

    List<List<Integer>> VerticalTraversal(TreeNode root) {
        int minVLevel = 0;
        int maxVLevel = 0;

        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(root, 0));

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                Pair rpair = que.remove();
                TreeNode rnode = rpair.node;
                int vLevel = rpair.vLevel;

                minVLevel = Math.min(minVLevel, vLevel);
                maxVLevel = Math.max(maxVLevel, vLevel);

                if (rnode.left != null) {
                    que.add(new Pair(rnode.left, vLevel - 1));
                }

                if (rnode.right != null) {
                    que.add(new Pair(rnode.right, vLevel + 1));
                }
            }
        }

        int noOfVLevel = maxVLevel - minVLevel + 1;
        int vLevelRoot = 0 + Math.abs(minVLevel);

        List<List<Integer>> vw = new ArrayList<>();
        for (int i = 0; i < noOfVLevel; i++) {
            vw.add(new ArrayList<>());
        }

        Queue<Pair2> que2 = new LinkedList<>();
        que2.add(new Pair2(root, vLevelRoot));

        while (que2.size() != 0) {
            int size = que2.size();

            Queue<Pair2> childQue = new LinkedList<>();
            while (size-- > 0) {
                Pair2 rpair = que2.remove();
                TreeNode rnode = rpair.node;
                int vLevel = rpair.vLevel;

                vw.get(vLevel).add(rnode.data);

                if (rnode.left != null) {
                    childQue.add(new Pair2(rnode.left, vLevel - 1));
                }

                if (rnode.right != null) {
                    childQue.add(new Pair2(rnode.right, vLevel + 1));
                }
            }

            que2 = childQue;
        }

        return vw;
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