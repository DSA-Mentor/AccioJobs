import java.io.*;
import java.util.*;

class Solution {
    // faith: return number of employees under a person
    public int getNumberOfEmpUnderMe(String emp, HashMap<String, ArrayList<String>> directs,
            TreeMap<String, Integer> ans) {
        if (directs.containsKey(emp) == false) {
            ans.put(emp, 0);
            return 0;
        }

        int total = 0;
        for (String directReportee : directs.get(emp)) {
            int x = getNumberOfEmpUnderMe(directReportee, directs, ans);
            total += (x + 1);
        }

        ans.put(emp, total);
        return total;
    }

    public void EmpUnderManager(Map<String, String> emp) {
        HashMap<String, ArrayList<String>> directs = new HashMap<>();
        String ceo = "";
        for (String e : emp.keySet()) {
            String mngr = emp.get(e);

            if (e.equals(mngr) == true) {
                ceo = e;
                continue;
            }

            if (directs.containsKey(mngr) == true) {
                ArrayList<String> prevEmp = directs.get(mngr);
                prevEmp.add(e);
                directs.put(mngr, prevEmp);
            } else {
                ArrayList<String> empUnderMe = new ArrayList<>();
                empUnderMe.add(e);
                directs.put(mngr, empUnderMe);
            }
        }

        TreeMap<String, Integer> ans = new TreeMap<>();
        getNumberOfEmpUnderMe(ceo, directs, ans);

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