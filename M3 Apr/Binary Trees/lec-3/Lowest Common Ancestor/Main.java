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
    public static Node find(Node root, int target, ArrayList<Node> n2r) {
        if (root == null) {
            return null;
        }

        if (root.data == target) {
            n2r.add(root);
            return root;
        }

        Node filc = find(root.left, target, n2r);

        if (filc != null) {
            n2r.add(root);
            return filc;
        }

        Node firc = find(root.right, target, n2r);

        if (firc != null) {
            n2r.add(root);
            return firc;
        }

        return null;
    }

    public static Node findLCA(Node root, int n1, int n2) {
        ArrayList<Node> n2rfn1 = new ArrayList<>();

        find(root, n1, n2rfn1);

        ArrayList<Node> n2rfn2 = new ArrayList<>();

        find(root, n2, n2rfn2);

        Node LCA = null;

        int i = n2rfn1.size() - 1;

        int j = n2rfn2.size() - 1;

        while (i >= 0 && j >= 0) {
            if (n2rfn1.get(i) == n2rfn2.get(j)) {
                LCA = n2rfn1.get(i);
            } else {
                break;
            }

            i--;
            j--;
        }

        return LCA;
    }
}