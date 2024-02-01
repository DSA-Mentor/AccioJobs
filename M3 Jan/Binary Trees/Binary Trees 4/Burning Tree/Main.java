
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

    public static void getParent(Node root, HashMap<Node, Node> map) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            map.put(root.left, root);
        }

        if (root.right != null) {
            map.put(root.right, root);
        }

        getParent(root.left, map);
        getParent(root.right, map);
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
        // Your code goes here
        HashMap<Node, Node> map = new HashMap<>();
        getParent(root, map);

        Node src = find(root, target);

        // BFS
        Queue<Node> que = new ArrayDeque<>();
        que.add(src);

        int level = 0;

        HashSet<Node> vis = new HashSet<>();
        vis.add(src);

        while (que.size() != 0) {
            int size = que.size();

            while (size-- > 0) {
                Node rnode = que.remove();

                if (rnode.left != null && vis.contains(rnode.left) == false) {
                    que.add(rnode.left);
                    vis.add(rnode.left);
                }

                if (rnode.right != null && vis.contains(rnode.right) == false) {
                    que.add(rnode.right);
                    vis.add(rnode.right);
                }

                if (map.containsKey(rnode) == true && vis.contains(map.get(rnode)) == false) {
                    que.add(map.get(rnode));
                    vis.add(map.get(rnode));
                }
            }

            level++;
        }

        return level - 1;
    }
}