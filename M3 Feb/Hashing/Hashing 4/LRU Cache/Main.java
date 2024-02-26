import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cap = sc.nextInt(), q = sc.nextInt();
        String[] queries = new String[q];
        for (int i = 0; i < q; i++) {
            String s = sc.next();
            if (s.equals("GET"))
                s += " " + sc.nextInt();
            else
                s += " " + sc.nextInt() + " " + sc.nextInt();
            queries[i] = s;
        }
        sc.close();
        LRUCache lruCache = new LRUCache(cap);
        for (String s : queries) {
            String[] arr = s.split(" ");
            if (arr.length == 3)
                lruCache.set(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
            else
                System.out.println(lruCache.get(Integer.parseInt(arr[1])));
        }
    }
}

class Node {
    int key;
    int val;

    Node next;
    Node prev;

    Node() {
        this.key = -1;
        this.val = -1;
    }

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    Node dh;
    Node dt;
    int cap;
    HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        dh = new Node();
        dt = new Node();
        dh.next = dt;
        dt.prev = dh;
        cap = capacity;
        map = new HashMap<>();
    }

    public void addLast(Node node) {
        Node prevNode = dt.prev;

        node.next = dt;
        dt.prev = node;

        node.prev = prevNode;
        prevNode.next = node;
    }

    public void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        node.prev = null;
        node.next = null;
    }

    public void moveToLast(Node node) {
        removeNode(node);
        addLast(node);
    }

    // TC: O(1)
    public int get(int key) {
        if (map.containsKey(key) == true) {
            Node node = map.get(key);
            int val = node.val;
            moveToLast(node);
            return val;
        } else {
            return -1;
        }
    }

    // TC: O(1)
    public void set(int key, int value) {
        if (map.containsKey(key) == false) {
            Node node = new Node(key, value);

            if (map.size() == cap) {
                // remove LRU
                Node LRUNode = dh.next;
                removeNode(LRUNode);
                map.remove(LRUNode.key);
            }

            addLast(node);
            map.put(key, node);
        } else {
            // you are already in cache memory
            Node node = map.get(key);
            node.val = value;
            moveToLast(node);
        }
    }

}