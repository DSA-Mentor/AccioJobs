import java.util.HashMap;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        // initialize a HashMap <key, value>
        // TreeMap<String, Integer> cart = new TreeMap<>();
        HashMap<String, Integer> cart = new HashMap<>();

        // add data in the cart
        cart.put("Lays", 5);
        cart.put("Mobile", 1);
        cart.put("PS5", 1);
        cart.put("Oranges", 4);

        // size of the cart
        System.out.println("size: " + cart.size());

        // keys are unique entities, put same Key will update the prev record
        cart.put("Lays", 10);

        // get value against a Key
        System.out.println("Lays: " + cart.get("Lays"));

        // Print the HashMap
        // keySet() -> return set of all the keys
        for (String key : cart.keySet()) {
            System.out.println("Key: " + key + " value: " + cart.get(key));
        }
        System.out.println("=========================");

        // upsert
        int value = cart.get("Lays");
        cart.put("Lays", value + 6);

        // Print the HashMap
        for (String key : cart.keySet()) {
            System.out.println("Key: " + key + " value: " + cart.get(key));
        }
        System.out.println("=========================");

        // getOrDefault method
        System.out.println("Apples: " + cart.get("Apples"));
        System.out.println("Apples: " + cart.getOrDefault("Apples", 0));

        // upsert (new version)
        cart.put("Oranges", cart.getOrDefault("Oranges", 0) + 10);
        System.out.println("Oranges: " + cart.get("Oranges"));

        // Searching
        if (cart.containsKey("Ps5") == true) {
            System.out.println("Yes Ps5 is present");
        } else {
            System.out.println("No, Ps5 is not present");
        }

        if (cart.containsKey("PS5") == true) {
            System.out.println("Yes PS5 is present");
        } else {
            System.out.println("No, PS5 is not present");
        }
        System.out.println("=========================");

        // remove/delete records
        // approach 1: give whole key, value pair record
        cart.remove("PS5", 2);
        // Print the HashMap
        for (String key : cart.keySet()) {
            System.out.println("Key: " + key + " value: " + cart.get(key));
        }
        System.out.println("=========================");

        cart.remove("PS5", 1);
        // Print the HashMap
        for (String key : cart.keySet()) {
            System.out.println("Key: " + key + " value: " + cart.get(key));
        }
        System.out.println("=========================");

        // approach 2: give only Key name
        cart.remove("Mobile");
        // Print the HashMap
        for (String key : cart.keySet()) {
            System.out.println("Key: " + key + " value: " + cart.get(key));
        }
        System.out.println("=========================");

        // getOrDefault: try to get value against a Key, if Key is not present return the default value
        System.out.println(cart.get("Mobile"));
        System.out.println(cart.getOrDefault("Mobile", 0));
    }
}
