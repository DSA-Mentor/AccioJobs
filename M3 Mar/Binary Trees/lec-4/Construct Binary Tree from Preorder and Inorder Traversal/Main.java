import java.util.*;
import java.io.*;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node root = null;
        int inorder[] = new int[n];
        int preorder[] = new int[n];
        for (int i = 0; i < n; i++)
            preorder[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            inorder[i] = sc.nextInt();
        Solution ob = new Solution();
        root = ob.buildTree(inorder, preorder, n);
        postOrdrer(root);
        System.out.println();
    }

    public static void postOrdrer(Node root) {
        if (root == null)
            return;
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}

class Solution {
    public static Node construct(int[] in, int isi, int iei, int[] pre, int psi, int pei) {
        if (iei < isi || pei < psi) {
            return null;
        }

        Node root = new Node(pre[psi]);

        int numberOfPeopleInLST = 0;
        int itr = isi;
        while (in[itr] != pre[psi]) {
            itr++;
            numberOfPeopleInLST++;
        }

        root.left = construct(in, isi, itr - 1, pre, psi + 1, psi + numberOfPeopleInLST);
        root.right = construct(in, itr + 1, iei, pre, psi + numberOfPeopleInLST + 1, pei);

        return root;
    }

    public static Node buildTree(int inorder[], int preorder[], int n) {
        return construct(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }
}
