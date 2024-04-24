import java.io.*;
import java.util.*;

class Solution {
    // faith: returns number of employees under this employee emp
    public int getEmpUnder(String emp, HashMap<String, ArrayList<String>> directReportMap, 
            TreeMap<String, Integer> empCount) {
        if (directReportMap.containsKey(emp) == false) {
            empCount.put(emp, 0);
            return 0;
        }

        int totalCount = 0;
        for (String directs : directReportMap.get(emp)) {
            int count = getEmpUnder(directs, directReportMap, empCount);
            // number of employees under this direct and +1 for him
            totalCount += (count + 1);
        }

        empCount.put(emp, totalCount);

        return totalCount;
    }

    public void EmpUnderManager(Map<String, String> map) {
        HashMap<String, ArrayList<String>> directReportMap = new HashMap<>();
        String ceo = "";

        for (String emp : map.keySet()) {
            String mngr = map.get(emp);

            if (mngr.equals(emp) == true) {
                ceo = mngr;
                continue;
            }

            if (directReportMap.containsKey(mngr) == true) {
                // update prev direct reportees
                ArrayList<String> prevEmp = directReportMap.get(mngr);
                prevEmp.add(emp);
                directReportMap.put(mngr, prevEmp);
            } else {
                // make him as a new manager and put first emp under him
                ArrayList<String> newEmp = new ArrayList<>();
                newEmp.add(emp);
                directReportMap.put(mngr, newEmp);
            }
        }

        TreeMap<String, Integer> empCount = new TreeMap<>();
        getEmpUnder(ceo, directReportMap, empCount);

        for (String emp : empCount.keySet()) {
            System.out.println(emp + " " + empCount.get(emp));
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