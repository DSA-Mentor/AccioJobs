import java.util.HashMap;

public class Main {
    public static void printMap(HashMap<String, Integer> myMap) {
        // print hash map
        for (String key : myMap.keySet()) {
            int value = myMap.get(key);
            System.out.println(key + " ----> " + value);
        }

        System.out.println("----------------------------");
    }

    public static void main(String[] args) {
        // intitialize Hash Map <Key, Value>
        // Key -> unique entity
        HashMap<String, Integer> myMap = new HashMap<>();

        // add people in hashmap
        myMap.put("pen", 20);
        myMap.put("apples", 3);
        myMap.put("eggs", 6);
        myMap.put("lays", 5);

        printMap(myMap);

        // re-initialize
        myMap.put("pen", 25);

        printMap(myMap);

        // update
        // int val = myMap.get("pen");
        // myMap.put("pen", val + 5);
        myMap.put("pen", myMap.get("pen") + 5);

        printMap(myMap);

        System.out.println(myMap.get("oranges"));

        // add 7 more oranges
        if (myMap.containsKey("oranges") == true) {
            myMap.put("oranges", myMap.get("oranges") + 7);
        } else {
            myMap.put("oranges", 7);
        }

        printMap(myMap);

        // getOrDefault -> try to get value against this key, else return a default
        // value
        // System.out.println(myMap.getOrDefault("banana", 23));

        // add 7 more oranges
        int val = myMap.getOrDefault("oranges", 0);
        myMap.put("oranges", val + 7);

        printMap(myMap);

        // remove
        // remove by key
        myMap.remove("pen");
        printMap(myMap);

        // remove by key->value
        myMap.remove("oranges", 14);
        printMap(myMap);

        myMap.remove("eggs", 7);
        printMap(myMap);

        System.out.println("size: " + myMap.size());
    }
}
