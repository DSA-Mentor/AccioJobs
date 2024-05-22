import java.util.*;

public class Main {
    // TC: O(N), SC: O(N)
    public static List<Integer> asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                // moving towards right
                st.push(asteroid);
            } else {
                // moving towards left

                // in stable universe are people moving towards right and are they smaller than
                // me, so I can destroy them
                while (st.size() > 0 && st.peek() > 0 && st.peek() < Math.abs(asteroid)) {
                    // destroy these right moving smaller asteroids
                    st.pop();
                }

                if (st.size() > 0 && st.peek() > 0 && st.peek() == Math.abs(asteroid)) {
                    // if in stable universe asteroid is same size and moving towards right
                    // I and person in stable universe will get destroyed
                    st.pop();
                } else if (st.size() > 0 && st.peek() > 0 && st.peek() > Math.abs(asteroid)) {
                    // if in stable universe asteroid bigger than me
                    // I'll destroyed
                    // don't add anything in stable universe
                } else {
                    // cases left: no one in universe or everyone is mpving towards left
                    st.push(asteroid);
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        while (st.size() != 0) {
            list.add(st.pop());
        }

        Collections.reverse(list);

        return list;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] asteroids = new int[n];

        for (int i = 0; i < n; i++) {
            asteroids[i] = scanner.nextInt();
        }

        List<Integer> ans = asteroidCollision(asteroids);

        if (ans.size() == 0) {
            System.out.print(-1);
        } else {
            for (int asteroid : ans) {
                System.out.print(asteroid + " ");
            }
        }
    }
}
