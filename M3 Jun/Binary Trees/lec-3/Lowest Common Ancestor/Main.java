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
            if (!currVal.equals("-1")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if (i >= ip.length)
                break;
            currVal = ip[i];
            if (!currVal.equals("-1")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Node root = buildTree(s);
        int x = sc.nextInt();
        int y = sc.nextInt();
        Solution g = new Solution();
        Node ans = g.findLCA(root, x, y);
        System.out.println(ans.data);
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
    public static Node find(Node root, int tar, ArrayList<Node> ntr) {
        if (root == null) {
            return null;
        }

        if (root.data == tar) {
            ntr.add(root);
            return root;
        }

        Node filc = find(root.left, tar, ntr);
        if (filc != null) {
            ntr.add(root);
            return filc;
        }

        Node firc = find(root.right, tar, ntr);
        if (firc != null) {
            ntr.add(root);
            return firc;
        }

        return null;
    }

    public static Node findLCA(Node node, int n1, int n2) {
        ArrayList<Node> ntrn1 = new ArrayList<>();
        find(node, n1, ntrn1);

        ArrayList<Node> ntrn2 = new ArrayList<>();
        find(node, n2, ntrn2);

        Node LCA = node;
        int i = ntrn1.size() - 1;
        int j = ntrn2.size() - 1;

        while (i >= 0 && j >= 0) {
            if (ntrn1.get(i) == ntrn2.get(j)) {
                LCA = ntrn1.get(i);
            } else {
                break;
            }

            i--;
            j--;
        }

        return LCA;
    }
}