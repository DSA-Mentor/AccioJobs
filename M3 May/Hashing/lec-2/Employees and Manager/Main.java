import java.io.*;
import java.util.*;

class Solution {
    public int numOfEmpUnderMe(String e, HashMap<String, ArrayList<String>> dr, TreeMap<String, Integer> ans) {
        if (dr.containsKey(e) == false) {
            ans.put(e, 0);
            return 0;
        }

        int cnt = 0;

        for (String d : dr.get(e)) {
            int x = numOfEmpUnderMe(d, dr, ans);
            cnt += (x + 1);
        }

        ans.put(e, cnt);

        return cnt;
    }

    public void EmpUnderManager(Map<String, String> emp) {
        HashMap<String, ArrayList<String>> dr = new HashMap<>();

        String ceo = "";
        for (String e : emp.keySet()) {
            String m = emp.get(e);

            if (e.equals(m) == true) {
                ceo = e;
            } else {
                if (dr.containsKey(m) == true) {
                    ArrayList<String> team = dr.get(m);
                    team.add(e);
                    dr.put(m, team);
                } else {
                    ArrayList<String> team = new ArrayList<>();
                    team.add(e);
                    dr.put(m, team);
                }
            }
        }

        TreeMap<String, Integer> ans = new TreeMap<>();
        numOfEmpUnderMe(ceo, dr, ans);

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