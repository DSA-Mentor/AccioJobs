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
    public static Node construct(int[] inorder, int isi, int iei, int[] preorder, int psi, int pei) {
        if (psi > pei || isi > iei) {
            return null;
        }
        
        Node root = new Node(preorder[psi]);
        int LSTCount = 0;
        int i = isi;
        for (; i < iei; i++) {
            if (inorder[i] == preorder[psi]) {
                break;
            } else {
                LSTCount++;
            }
        }

        root.left = construct(inorder, isi, i - 1, preorder, psi + 1, psi + LSTCount);
        root.right = construct(inorder, i + 1, iei, preorder, psi + LSTCount + 1, pei);

        return root;
        
    }
    
    public static Node buildTree(int inorder[], int preorder[], int n) {
        //Your code here 
        return construct(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }
}