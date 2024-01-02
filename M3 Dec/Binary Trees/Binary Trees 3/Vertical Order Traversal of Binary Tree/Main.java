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
    int leftMostPos = 0;
    int rightMostPos = 0;

    void getPos(TreeNode root, int pos) {
        if (root == null) {
            return;
        }

        getPos(root.left, pos - 1);
        getPos(root.right, pos + 1);

        leftMostPos = Math.min(leftMostPos, pos);
        rightMostPos = Math.max(rightMostPos, pos);
    }

    class Pair implements Comparable<Pair> {
        TreeNode node;
        int vLevel;

        Pair(TreeNode node, int vLevel) {
            this.node = node;
            this.vLevel = vLevel;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.vLevel == o.vLevel) {
                return this.node.data - o.node.data;
            }
            
            return this.vLevel - o.vLevel;
        }
    }
    
    List < List < Integer >> VerticalTraversal(TreeNode root) {
        getPos(root, 0);

        int noOfVLevel = rightMostPos - leftMostPos + 1;
        int rootsVLevel = 0 + Math.abs(leftMostPos);

        PriorityQueue<Pair> MQue = new PriorityQueue<>();
        MQue.add(new Pair(root, rootsVLevel));

        List<List<Integer>> vv = new ArrayList<>();
        for (int i = 0; i < noOfVLevel; i++) {
            vv.add(new ArrayList<>());
        }
        
        
        while (MQue.size() != 0) {
            int size = MQue.size();
            PriorityQueue<Pair> CQue = new PriorityQueue<>();

            while (size-- > 0) {
                Pair rpair = MQue.remove();

                TreeNode node = rpair.node;
                int vLevel = rpair.vLevel;

                vv.get(vLevel).add(node.data);

                if (node.left != null) {
                    CQue.add(new Pair(node.left, vLevel - 1));
                }

                if (node.right != null) {
                    CQue.add(new Pair(node.right, vLevel + 1));
                }
            }

            MQue = CQue;
        }

        return vv;
    }
}

class Main {

    static TreeNode buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N')
            return null;

        String ip[] = str.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(ip[0]));
        Queue < TreeNode > queue = new LinkedList < > ();
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
            List < List < Integer >> ans = ob.VerticalTraversal(root);
            for (int i = 0; i < ans.size(); i++) {
                for (int a: ans.get(i)) {
                    System.out.print(a + " ");
                }
                System.out.println();
            }
            t--;
        }
    }
}