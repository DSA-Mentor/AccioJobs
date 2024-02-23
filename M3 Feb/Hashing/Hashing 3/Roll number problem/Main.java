import java.util.*;

class Solution {
    static int[] findRepeatingAndMissingNumbers(int[] nums) {
        // Write code here and print output
        HashMap<Integer, Integer> fmap = new HashMap<>();
        for (int num : nums) {
            fmap.put(num, fmap.getOrDefault(num, 0) + 1);
        }

        int missingNumber = 0;
        int repeatingNumber = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (fmap.containsKey(i) == true) {
                if (fmap.get(i) == 2) {
                    repeatingNumber = i;
                }
            } else {
                missingNumber = i;
            }
        }

        return new int[] { repeatingNumber, missingNumber };
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int[] ans = Solution.findRepeatingAndMissingNumbers(nums);
        System.out.print(ans[0] + " " + ans[1] + "\n");
    }
}