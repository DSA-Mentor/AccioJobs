import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // initialize a hashMap, (key, value)
        HashMap<String, Integer> map = new HashMap<>();

        // add key value pair in hashMap
        map.put("Lays", 2);
        map.put("Eggs", 12);
        map.put("Oranges", 12);
        map.put("Yogurt", 3);

        // size of hashMap (number of keys)
        System.out.println("size: " + map.size());

        // print a hashMap
        for (String key : map.keySet()) {
            // get value against a key
            int value = map.get(key);
            System.out.println("Key: " + key + " Value: " + value);
        }

        // re-write a key
        map.put("Lays", 5);

        // size of hashMap (number of keys)
        System.out.println("size: " + map.size());

        // print a hashMap
        for (String key : map.keySet()) {
            // get value against a key
            int value = map.get(key);
            System.out.println("Key: " + key + " Value: " + value);
        }

        // update a value against a key
        int val = map.get("Lays");
        map.put("Lays", val + 3);

        // size of hashMap (number of keys)
        System.out.println("size: " + map.size());

        // print a hashMap
        for (String key : map.keySet()) {
            // get value against a key
            int value = map.get(key);
            System.out.println("Key: " + key + " Value: " + value);
        }

        // remove
        // remove based on key value pair
        map.remove("Lays", 8);

        // size of hashMap (number of keys)
        System.out.println("size: " + map.size());

        // print a hashMap
        for (String key : map.keySet()) {
            // get value against a key
            int value = map.get(key);
            System.out.println("Key: " + key + " Value: " + value);
        }

        // remove based on key
        map.remove("Yogurt");

        // size of hashMap (number of keys)
        System.out.println("size: " + map.size());

        // print a hashMap
        for (String key : map.keySet()) {
            // get value against a key
            int value = map.get(key);
            System.out.println("Key: " + key + " Value: " + value);
        }

        // searching
        if (map.containsKey("Eggs") == true) {
            System.out.println("Found Eggs in the map");
        } else {
            System.out.println("Didn't find eggs in the map");
        }

        if (map.containsKey("Lays") == true) {
            System.out.println("Found Lays in the map");
        } else {
            System.out.println("Didn't find lays in the map");
        }

        // getOrDefault
        System.out.println("getOrDefault " + map.getOrDefault("Lays", -1));
    }
}
