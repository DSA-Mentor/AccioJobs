import java.io.*;
import java.util.*;

class Solution {
    public int fun(String e, HashMap<String, ArrayList<String>> map, TreeMap<String, Integer> ans) {
        if (map.containsKey(e) == false) {
            ans.put(e, 0);
            return 0;
        }

        int sum = 0;
        for (String de : map.get(e)) {
            int n = fun(de, map, ans);
            sum += (n + 1);
        }

        ans.put(e, sum);
        return sum;
    }

    public void EmpUnderManager(Map<String, String> emp) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        String ceo = "";

        for (String e : emp.keySet()) {
            String m = emp.get(e);

            if (m.equals(e) == true) {
                ceo = m;
                continue;
            }

            if (map.containsKey(m) == true) {
                ArrayList<String> list = map.get(m);
                list.add(e);
                map.put(m, list);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(e);
                map.put(m, list);
            }
        }

        TreeMap<String, Integer> ans = new TreeMap<>();
        fun(ceo, map, ans);

        for (String e : ans.keySet()) {
            System.out.println(e + " " + ans.get(e));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        Map<String, String> emp = new HashMap<String, String>();
        for (int i = 0; i < n; ++i) {
            emp.put(sc.next(), sc.next());
        }
        Solution Obj = new Solution();
        Obj.EmpUnderManager(emp);
    }
}