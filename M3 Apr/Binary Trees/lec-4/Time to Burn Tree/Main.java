import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.next();
        int k = sc.nextInt();
        sc.close();
        Node tree = levelOrderCreateTree(arr);
        System.out.println(timeToBurnTree(tree, k));
    }

    public static void traversal(Node root, HashMap<Node, Node> map) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            map.put(root.left, root);
        }

        if (root.right != null) {
            map.put(root.right, root);
        }

        traversal(root.left, map);
        traversal(root.right, map);
    }

    public static Node find(Node root, int target) {
        if (root == null) {
            return null;
        }

        if (root.data == target) {
            return root;
        }

        Node filc = find(root.left, target);
        if (filc != null) {
            return filc;
        }

        Node firc = find(root.right, target);
        if (firc != null) {
            return firc;
        }

        return null;
    }

    public static int timeToBurnTree(Node root, int start) {
        HashMap<Node, Node> map = new HashMap<>();
        traversal(root, map);

        Node src = find(root, start);

        if (src == null) {
            return 0;
        }

        HashSet<Node> burnt = new HashSet<>();

        Queue<Node> que = new ArrayDeque<>();
        que.add(src);
        burnt.add(src);

        int level = 0;
        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                Node rnode = que.remove();

                if (rnode.left != null && burnt.contains(rnode.left) == false) {
                    que.add(rnode.left);
                    burnt.add(rnode.left);
                }

                if (rnode.right != null && burnt.contains(rnode.right) == false) {
                    que.add(rnode.right);
                    burnt.add(rnode.right);
                }

                Node parent = map.get(rnode);
                if (parent != null && burnt.contains(parent) == false) {
                    que.add(parent);
                    burnt.add(parent);
                }
            }

            level++;
        }

        return level - 1;
    }

    static void createTree(Node node, int i, String[] arr) {
        if (node != null) {
            if (2 * i + 1 < arr.length) {
                if (arr[2 * i + 1].equals("null")) {
                    node.left = null;
                } else {
                    node.left = new Node(Integer.parseInt(arr[2 * i + 1]));
                }
                createTree(node.left, 2 * i + 1, arr);
            }
            if (2 * i + 2 < arr.length) {
                if (arr[2 * i + 2].equals("null")) {
                    node.right = null;
                } else {
                    node.right = new Node(Integer.parseInt((arr[2 * i + 2])));
                }
                createTree(node.right, 2 * i + 2, arr);
            }
        }
    }

    static Node levelOrderCreateTree(String[] arr) {
        if (arr.length == 0)
            return null;
        Node head = new Node(
                Integer.parseInt(arr[0]));
        createTree(head, 0, arr);
        return head;
    }
}

class Node {

    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}