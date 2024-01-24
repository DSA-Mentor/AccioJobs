
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

    public static void traverse(Node root, HashMap<Node, Node> map) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            map.put(root.left, root);
        }

        if (root.right != null) {
            map.put(root.right, root);
        }

        traverse(root.left, map);
        traverse(root.right, map);
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
        HashMap<Node, Node> map = new HashMap<>();
        traverse(root, map);

        Node src = find(root, target);

        Queue<Node> que = new ArrayDeque<>();
        que.add(src);

        HashSet<Node> set = new HashSet<>();
        set.add(src);

        int time = 0;
        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                Node rnode = que.remove();

                if (rnode.left != null && set.contains(rnode.left) == false) {
                    set.add(rnode.left);
                    que.add(rnode.left);
                }

                if (rnode.right != null && set.contains(rnode.right) == false) {
                    set.add(rnode.right);
                    que.add(rnode.right);
                }

                if (map.get(rnode) != null && set.contains(map.get(rnode)) == false) {
                    set.add(map.get(rnode));
                    que.add(map.get(rnode));
                }
            }
            time++;
        }

        if (time == 0) {
            return 0;
        }

        return time - 1;
    }
}