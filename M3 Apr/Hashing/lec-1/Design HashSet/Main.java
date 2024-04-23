import java.util.*;

class Solution {
    // Range 0 - 1000000
    // 75% of range = 750000
    int size = 750000;
    List<Integer>[] hashTable;

    Solution() {
        hashTable = new LinkedList[size];
    }

    private int getHashValue(int key) {
        return key % size;
    }

    public void add(int key) {
        int hv = getHashValue(key);

        if (hashTable[hv] == null) {
            hashTable[hv] = new LinkedList<>();
            hashTable[hv].add(key);
        } else {
            // collision
            if (hashTable[hv].indexOf(key) == -1) {
                hashTable[hv].add(key);
            }
        }
    }

    public void remove(int key) {
        int hv = getHashValue(key);

        if (hashTable[hv] == null) {
            return;
        } else {
            if (hashTable[hv].indexOf(key) != -1) {
                hashTable[hv].remove(hashTable[hv].indexOf(key));
            }
        }
    }

    public boolean contains(int key) {
        int hv = getHashValue(key);

        if (hashTable[hv] != null) {
            if (hashTable[hv].indexOf(key) != -1) {
                return true;
            }
        }

        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        Solution Obj = new Solution();
        for (int i = 0; i < q; i++) {
            int choice = sc.nextInt();
            int key = sc.nextInt();
            if (choice == 1) {
                // Add
                Obj.add(key);
            } else if (choice == 2) {
                // contains
                if (Obj.contains(key)) {
                    System.out.print("True ");
                } else {
                    System.out.print("False ");
                }
            } else if (choice == 3) {
                // remove
                Obj.remove(key);
            }
        }
        System.out.println();
        sc.close();
    }
}