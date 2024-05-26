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
        this.key = -1;
        this.value = -1;
    }

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    Node dh;
    Node dt;
    int maxCap;
    HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        dh = new Node();
        dt = new Node();
        dh.next = dt;
        dt.prev = dh;

        maxCap = capacity;

        map = new HashMap<>();
    }

    void addLast(Node node) {
        Node prevNode = dt.prev;

        prevNode.next = node;
        node.prev = prevNode;

        node.next = dt;
        dt.prev = node;
    }

    void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        node.next = null;
        node.prev = null;
    }

    void moveToLast(Node node) {
        removeNode(node);
        addLast(node);
    }

    public int get(int key) {
        if (map.containsKey(key) == false) {
            return -1;
        }

        Node node = map.get(key);
        int value = node.value;
        moveToLast(node);
        return value;
    }

    public void set(int key, int value) {
        if (map.containsKey(key) == false) {
            Node node = new Node(key, value);

            if (map.size() == maxCap) {
                Node LRUNode = dh.next;
                removeNode(LRUNode);
                map.remove(LRUNode.key);
            }

            addLast(node);
            map.put(key, node);
        } else {
            Node node = map.get(key);
            node.value = value;
            moveToLast(node);
        }
    }

}