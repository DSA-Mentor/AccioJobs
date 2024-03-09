public class Main {
    class Node {
        int data;
        Node left;
        Node right;
    }

    public Node find(Node root, int target) {
        if (root == null) {
            return null;
        }

        // check are you the target
        if (root.data == target) {
            return root;
        }

        // try to find in left child
        Node filc = find(root.left, target);

        if (filc != null) {
            return filc;
        }

        // try to find in right child
        Node firc = find(root.right, target);

        if (firc != null) {
            return firc;
        }

        return null;
    }
}
