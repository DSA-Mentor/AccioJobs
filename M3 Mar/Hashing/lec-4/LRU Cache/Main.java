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

// Definition for a doubly linked list node
class Node {
    int key;
    int data;
    Node next;
    Node prev;

    // Default constructor
    Node() {
        this.key = -1;
        this.data = -1;
        this.next = null;
        this.prev = null;
    }

    // Constructor with key and data
    Node(int key, int data) {
        this.key = key;
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

// LRUCache class definition
class LRUCache {
    Node dh; // Dummy head of the doubly linked list
    Node dt; // Dummy tail of the doubly linked list
    HashMap<Integer, Node> map; // Hashmap to store key and corresponding node for O(1) access
    int maxCapacity; // Maximum capacity of the cache

    // Constructor to initialize the LRU cache with a given capacity
    public LRUCache(int capacity) {
        this.maxCapacity = capacity;
        this.dh = new Node(); // Initialize dummy head
        this.dt = new Node(); // Initialize dummy tail
        // Link dummy head and tail to establish the doubly linked list
        dh.next = dt;
        dt.prev = dh;
        // Initialize the hashmap
        map = new HashMap<>();
    }

    // Adds a node to the end of the doubly linked list (just before the dummy tail)
    public void addLast(Node node) {
        Node prevNode = dt.prev;
        prevNode.next = node;
        node.prev = prevNode;
        node.next = dt;
        dt.prev = node;
    }

    // Removes a node from the doubly linked list
    public void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        // Clear the next and prev of removed node to avoid memory leak
        node.next = null;
        node.prev = null;
    }

    // Moves an existing node to the end of the doubly linked list to mark it as
    // recently used
    public void moveToLast(Node node) {
        removeNode(node);
        addLast(node);
    }

    // Retrieves the value for the specified key from the cache
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            int data = node.data;
            // Move the accessed node to the end to mark it as recently used
            moveToLast(node);
            return data;
        } else {
            return -1; // Return -1 if key is not found
        }
    }

    // Adds a new key-value pair to the cache or updates the value of an existing
    // key
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.data = value;
            // Move the node to the end to mark it as recently used
            moveToLast(node);
        } else {
            Node node = new Node(key, value);
            // If cache is at capacity, remove the least recently used item
            if (map.size() == maxCapacity) {
                Node LRU_NODE = dh.next; // The first real node (after dummy head) is the LRU
                removeNode(LRU_NODE);
                map.remove(LRU_NODE.key);
            }
            // Add the new node at the end and update the hashmap
            addLast(node);
            map.put(key, node);
        }
    }
}
