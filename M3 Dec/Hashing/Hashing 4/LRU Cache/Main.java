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

    Node next;
    Node prev;

    Node (int key, int data) {
        this.key = key;
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    Node () {
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {
    // your code here
    Node head;
    Node tail;
    int limit;

    HashMap<Integer, Node> map;
    
    public LRUCache (int capacity) {
        // your code here
        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;

        limit = capacity;

        map = new HashMap<>();
    }

    // TC: O(1), SC: O(1)
    public void addLast (Node node) {
        Node prevNode = tail.prev;

        node.next = tail;
        tail.prev = node;

        node.prev = prevNode;
        prevNode.next = node;
    }

    // TC: O(1), SC: O(1)
    public void removeNode (Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        node.prev = null;
        node.next = null;
    }

    // TC: O(1), SC: O(1)
    public void moveToLast (Node node) {
        removeNode(node);
        addLast(node);
    }

    public int get(int key) {
        // your code here
        if (map.containsKey(key) == false) {
            return -1;
        }
        
        Node node = map.get(key);
        moveToLast(node);
        return node.data;
    }

    public void set(int key, int value) {
        // your code here
        if (map.containsKey(key) == true) {
            Node node = map.get(key);
            node.data = value;
            moveToLast(node);
        } else {
            // do you have space
            if (map.size() == limit) {
                // don't have space
                Node LRU_Node = head.next;
                removeNode(LRU_Node);
                map.remove(LRU_Node.key);
            }

            Node node = new Node(key, value);
            addLast(node);
            map.put(key, node);
        }
    }

}