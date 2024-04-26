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
    int value;

    Node next;
    Node prev;

    Node() {
        this.key = 0;
        this.value = 0;
        this.next = null;
        this.prev = null;
    }

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {

    Node dh;
    Node dt;

    HashMap<Integer, Node> map;

    int maxCap;

    public LRUCache(int capacity) {
        dh = new Node();
        dt = new Node();

        dh.next = dt;
        dt.prev = dh;

        maxCap = capacity;

        map = new HashMap<>();
    }

    public void addLast(Node node) {
        Node p = dt.prev;
        p.next = node;
        node.prev = p;

        node.next = dt;
        dt.prev = node;
    }

    public void removeNode(Node node) {
        Node p = node.prev;
        Node n = node.next;

        p.next = n;
        n.prev = p;

        node.prev = null;
        node.next = null;
    }

    public void moveToEnd(Node node) {
        removeNode(node);
        addLast(node);
    }

    public int get(int key) {
        if (map.containsKey(key) == false) {
            return -1;
        } else {
            Node node = map.get(key);

            int value = node.value;
            moveToEnd(node);

            return value;
        }
    }

    public void set(int key, int value) {
        if (map.containsKey(key) == false) {
            Node node = new Node(key, value);

            if (map.size() == maxCap) {
                Node LRU_Node = dh.next;
                removeNode(LRU_Node);
                map.remove(LRU_Node.key);
            }

            addLast(node);
            map.put(key, node);
        } else {
            Node node = map.get(key);
            node.value = value;

            moveToEnd(node);
        }
    }
}