import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // add key, value pair to a hashSet
        map.put("Bananas", 6);
        map.put("Apples", 4);
        map.put("Lays", 10);
        map.put("Grapes", 3);

        // print this HashMap
        System.out.println(map);

        // update Bananas
        map.put("Bananas", 12);

        // print this HashMap
        System.out.println(map);

        // update the prev value
        int prevValue = map.get("Bananas");
        map.put("Bananas", prevValue + 6);

        // print this HashMap
        System.out.println(map);

        // iterate over a HashMap
        for (String key : map.keySet()) {
            System.out.println("Key: " + key + " Value: " + map.get(key));
        }

        // searching
        if (map.containsKey("Bananas") == true) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

        // remove from HashMap
        map.remove("Grapes");
        System.out.println(map);

        map.remove("Bananas", 24);
        System.out.println(map);

        map.remove("Bananas", 18);
        System.out.println(map);

        System.out.println(map.get("Bananas"));

        // getOrDefault
        System.out.println(map.getOrDefault("Bananas", 0));
    }    
}
