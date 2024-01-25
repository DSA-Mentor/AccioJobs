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
    int data;
    Node prev;
    Node next;

    Node() {

    }

    Node(int key, int data) {
        this.key = key;
        this.data = data;
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

    public void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        node.next = null;
        node.prev = null;
    }

    public void addLast(Node node) {
        Node tailsPrev = dt.prev;

        tailsPrev.next = node;
        node.next = dt;

        dt.prev = node;
        node.prev = tailsPrev;
    }

    public void moveToLast(Node node) {
        removeNode(node);
        addLast(node);
    }

    public int get(int key) {
        if (map.containsKey(key) == true) {
            Node node = map.get(key);
            moveToLast(node);
            return node.data;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        if (map.containsKey(key) == true) {
            Node node = map.get(key);
            node.data = value;
            moveToLast(node);
        } else {
            Node node = new Node(key, value);

            if (map.size() == cap) {
                // remove LRU
                Node LRU_NODE = dh.next;
                removeNode(LRU_NODE);
                map.remove(LRU_NODE.key);
            }

            addLast(node);
            map.put(key, node);
        }
    }

}