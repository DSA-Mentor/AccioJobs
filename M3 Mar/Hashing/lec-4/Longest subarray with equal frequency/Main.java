import java.util.*;

class Solution {
    // TC: O(N), SC: O(N)
    public static int longestSubarray(int[] arr) {
        // Initialize a hashmap to store the difference between counts as key and index
        // as value
        HashMap<String, Integer> map = new HashMap<>();

        // Variables to count occurrences of 0s, 1s, and 2s
        int x = 0; // Count of 0s
        int y = 0; // Count of 1s
        int z = 0; // Count of 2s

        // Encode the initial difference between the counts. The initial difference is
        // set before the array iteration starts.
        String encoded = y - x + "#" + z - y;

        // Store the encoded string with the index -1 to handle the case where whole
        // array is the answer
        map.put(encoded, -1);

        // Initialize variable to keep track of the maximum length of the subarray found
        // so far
        int maxLen = 0;

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            // Increment count variables based on the value of the current array element
            if (arr[i] == 0)
                x++;
            else if (arr[i] == 1)
                y++;
            else if (arr[i] == 2)
                z++;

            // Encode the current difference between the counts after processing the current
            // element
            encoded = y - x + "#" + z - y;

            // Check if this encoded string has already been seen (which would imply a
            // subarray where the difference between counts is constant)
            if (map.containsKey(encoded)) {
                // If it has been seen, calculate the length of this subarray and update maxLen
                // if this subarray is longer
                int len = i - map.get(encoded);
                maxLen = Math.max(maxLen, len);
            } else {
                // If it has not been seen, store the current index associated with this encoded
                // string
                map.put(encoded, i);
            }
        }

        // Return the length of the longest subarray found
        return maxLen;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.longestSubarray(arr));
    }
}
