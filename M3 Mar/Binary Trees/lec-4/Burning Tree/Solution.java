
//User function Template for Java

class Solution {
    /*
     * class Node {
     * int data;
     * Node left;
     * Node right;
     * 
     * Node(int data) {
     * this.data = data;
     * left = null;
     * right = null;
     * }
     * }
     */

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

    public static int minTime(Node root, int target) {
        // Key: Child, Value: Parent
        HashMap<Node, Node> map = new HashMap<>();

        traversal(root, map);

        Node targetNode = find(root, target);

        if (targetNode == null) {
            return 0;
        }

        HashSet<Node> burnt = new HashSet<>();

        Queue<Node> que = new ArrayDeque<>();
        que.add(targetNode);
        burnt.add(targetNode);

        int level = 0;
        while (que.size() != 0) {
            int size = que.size();

            while (size-- > 0) {
                Node rnode = que.remove();

                if (rnode.left != null && burnt.contains(rnode.left) == false) {
                    burnt.add(rnode.left);
                    que.add(rnode.left);
                }

                if (rnode.right != null && burnt.contains(rnode.right) == false) {
                    burnt.add(rnode.right);
                    que.add(rnode.right);
                }

                if (map.get(rnode) != null && burnt.contains(map.get(rnode)) == false) {
                    burnt.add(map.get(rnode));
                    que.add(map.get(rnode));
                }
            }

            level++;
        }

        return level - 1;
    }
}