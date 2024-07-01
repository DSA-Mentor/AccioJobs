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

    Node next = null;
    Node prev = null;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    Node dh;
    Node dt;

    HashMap<Integer, Node> map;

    int maxCap;

    // your code here
    public LRUCache(int capacity) {
        dh = new Node(0, 0);
        dt = new Node(0, 0);

        dt.prev = dh;
        dh.next = dt;

        map = new HashMap<>();

        maxCap = capacity;
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
        Node currLast = dt.prev;

        currLast.next = node;
        node.prev = currLast;

        node.next = dt;
        dt.prev = node;
    }

    public void moveToLast(Node node) {
        removeNode(node);
        addLast(node);
    }

    public int get(int key) {
        if (map.containsKey(key) == false) {
            return -1;
        } else {
            int val = map.get(key).value;
            moveToLast(map.get(key));
            return val;
        }
    }

    public void set(int key, int value) {
        if (map.containsKey(key) == false) {
            Node node = new Node(key, value);

            if (map.size() == maxCap) {
                Node LRU_NODE = dh.next;
                removeNode(LRU_NODE);
                map.remove(LRU_NODE.key);
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