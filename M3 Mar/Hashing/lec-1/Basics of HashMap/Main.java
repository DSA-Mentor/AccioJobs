import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // initialize a hashMap
        HashMap<String, Integer> cart = new HashMap<>();

        // add things in cart
        cart.put("Milk", 2);
        cart.put("Eggs", 6);
        cart.put("Oranges", 1);
        cart.put("Curd", 2);

        // print the cart
        for (String key : cart.keySet()) {
            System.out.println(key + " --------> " + cart.get(key));
        }

        System.out.println();

        // rewrite the prev key value
        cart.put("Eggs", 5);

        // print the cart
        for (String key : cart.keySet()) {
            System.out.println(key + " --------> " + cart.get(key));
        }

        System.out.println();

        // update 
        int currEggs = cart.get("Eggs");
        cart.put("Eggs", currEggs + 5);

        // print the cart
        for (String key : cart.keySet()) {
            System.out.println(key + " --------> " + cart.get(key));
        }

        System.out.println();

        // remove something
        // remove by key name
        cart.remove("Eggs");

        // print the cart
        for (String key : cart.keySet()) {
            System.out.println(key + " --------> " + cart.get(key));
        }

        System.out.println();

        // remove by key value pair
        cart.remove("Milk", 2);

        // print the cart
        for (String key : cart.keySet()) {
            System.out.println(key + " --------> " + cart.get(key));
        }

        System.out.println();

        // size of hashMap
        System.out.println("size: " + cart.size());

        // get of some key not present
        System.out.println("get Eggs: " + cart.get("Eggs"));

        // getOrDefault
        System.out.println("getOrDefault Eggs: " + cart.getOrDefault("Eggs", 0));

        // searching in hashMap
        if (cart.containsKey("Oranges") == true) {
            System.out.println("true");
        }
    }    
}
