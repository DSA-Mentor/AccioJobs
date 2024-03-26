import java.io.*;
import java.util.*;

class Solution {
    public int numberOfEmpUnderMe(HashMap<String, ArrayList<String>> map, String emp, TreeMap<String, Integer> ans) {
        if (map.containsKey(emp) == false) {
            ans.put(emp, 0);
            return 0;
        }

        int count = 0;
        for (String str : map.get(emp)) {
            int c = numberOfEmpUnderMe(map, str, ans);
            count += (c + 1);
        }

        ans.put(emp, count);

        return count;
    }

    public void EmpUnderManager(Map<String, String> emp) {
        // direct repoertees map
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        String CEO = "";

        for (String str : emp.keySet()) {
            String mngr = emp.get(str);

            if (mngr.equals(str) == true) {
                CEO = mngr;
                continue;
            }

            if (map.containsKey(mngr) == true) {
                ArrayList<String> team = map.get(mngr);
                team.add(str);
                map.put(mngr, team);
            } else {
                ArrayList<String> team = new ArrayList<>();
                team.add(str);
                map.put(mngr, team);
            }
        }

        TreeMap<String, Integer> ans = new TreeMap<>();
        numberOfEmpUnderMe(map, CEO, ans);

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