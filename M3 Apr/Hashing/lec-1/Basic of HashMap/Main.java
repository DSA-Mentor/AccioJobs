import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // initialize a hashMap
        HashMap<String, Integer> cart = new HashMap<>();

        // add key, value pairs in the cart
        cart.put("Lays", 10);
        cart.put("Eggs", 6);
        cart.put("Oranges", 10);

        // print hashMap
        // method: keySet() => returns all the keys in the map
        for (String key : cart.keySet()) {
            // method: get() => returns value against a key
            System.out.println("entries: " + key + " ------> " + cart.get(key));
        }
        System.out.println("==============================");
        
        // re-initialize a key
        cart.put("Eggs", 12);

        // print hashMap
        // method: keySet() => returns all the keys in the map
        for (String key : cart.keySet()) {
            // method: get() => returns value against a key
            System.out.println("entries: " + key + " ------> " + cart.get(key));
        }
        System.out.println("==============================");

        // update a key
        cart.put("Eggs", cart.get("Eggs") + 6);

        // print hashMap
        // method: keySet() => returns all the keys in the map
        for (String key : cart.keySet()) {
            // method: get() => returns value against a key
            System.out.println("entries: " + key + " ------> " + cart.get(key));
        }
        System.out.println("==============================");

        // find an entry
        if (cart.containsKey("Eggs") == true) {
            System.out.println("you have " + cart.get("Eggs") + " Eggs in your cart");
        } else {
            System.out.println("there are no Eggs present in the cart");
        }

        // number of entries
        System.out.println("size: " + cart.size());

        // remove from the map
        // way 1: using key, value pair
        cart.remove("Eggs", 18);

        // print hashMap
        // method: keySet() => returns all the keys in the map
        for (String key : cart.keySet()) {
            // method: get() => returns value against a key
            System.out.println("entries: " + key + " ------> " + cart.get(key));
        }
        System.out.println("==============================");

        cart.put("Eggs", 18);

        // way 2: using key only
        cart.remove("Eggs");
        
        // print hashMap
        // method: keySet() => returns all the keys in the map
        for (String key : cart.keySet()) {
            // method: get() => returns value against a key
            System.out.println("entries: " + key + " ------> " + cart.get(key));
        }
        System.out.println("==============================");

        // method: getOrDefault
        System.out.println("Value of Apples: " + cart.get("Apple"));
        System.out.println("Value of Apples: " + cart.getOrDefault("Apple", 0));

    }    
}
