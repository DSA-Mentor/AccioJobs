import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // initialize a hashmap
        HashMap<String, Integer> myMap = new HashMap<>();

        // insert key, value pairs
        myMap.put("Lays", 2);
        myMap.put("Coke", 5);
        myMap.put("Eggs", 2);
        myMap.put("Oranges", 4);

        // get value against a key
        System.out.println("key: " + "Lays" + ", value: " + myMap.get("Lays"));
        System.out.println();

        // print a hashmap
        // keySet() : returns each key one by one
        for (String key : myMap.keySet()) {
            System.out.println("key: " + key + ", value: " + myMap.get(key));
        }
        System.out.println();

        // update
        myMap.put("Eggs", 5);
        for (String key : myMap.keySet()) {
            System.out.println("key: " + key + ", value: " + myMap.get(key));
        }
        System.out.println();

        myMap.put("Eggs", myMap.get("Eggs") + 4);
        for (String key : myMap.keySet()) {
            System.out.println("key: " + key + ", value: " + myMap.get(key));
        }
        System.out.println();

        // getOrDefault
        System.out.println(myMap.getOrDefault("Apples", -1));
        System.out.println();

        // search
        if (myMap.containsKey("Eggs") == true) {
            System.out.println("Eggs: " + myMap.get("Eggs"));
        } else {
            System.out.println("No Eggs");
        }
        System.out.println();

        // remove
        // remove by key name
        myMap.remove("Eggs");
        for (String key : myMap.keySet()) {
            System.out.println("key: " + key + ", value: " + myMap.get(key));
        }
        System.out.println();

        // remove by key value pair
        myMap.remove("Coke", 5);
        for (String key : myMap.keySet()) {
            System.out.println("key: " + key + ", value: " + myMap.get(key));
        }
        System.out.println();

        // search
        if (myMap.containsKey("Eggs") == true) {
            System.out.println("Eggs: " + myMap.get("Eggs"));
        } else {
            System.out.println("No Eggs");
        }
        System.out.println();

        // size
        System.out.println("size: " + myMap.size());
    }
}
