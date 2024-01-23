import java.io.*;
import java.util.*;

class Solution {
    public int getNumberOfEmplyeesUnderMe(String employee, HashMap<String, ArrayList<String>> directReportees,
            TreeMap<String, Integer> map) {
        if (directReportees.containsKey(employee) == false) {
            map.put(employee, 0);
            return 0;
        }

        int totalEmployeesUnderMe = 0;
        for (String direct : directReportees.get(employee)) {
            int employeesUnderDirect = getNumberOfEmplyeesUnderMe(direct, directReportees, map);
            totalEmployeesUnderMe += (employeesUnderDirect + 1);
        }

        map.put(employee, totalEmployeesUnderMe);

        return totalEmployeesUnderMe;
    }

    // TC: O(N * log N), SC: O(N)
    public void EmpUnderManager(Map<String, String> emp) {
        HashMap<String, ArrayList<String>> directReportees = new HashMap<>();

        String ceo = "";
        for (String employee : emp.keySet()) {
            String manager = emp.get(employee);

            if (manager.equals(employee) == true) {
                ceo = manager;
                continue;
            }

            if (directReportees.containsKey(manager) == true) {
                ArrayList<String> directlyReporting = directReportees.get(manager);
                directlyReporting.add(employee);
                directReportees.put(manager, directlyReporting);
            } else {
                ArrayList<String> directlyReporting = new ArrayList<>();
                directlyReporting.add(employee);
                directReportees.put(manager, directlyReporting);
            }
        }

        TreeMap<String, Integer> map = new TreeMap<>();
        getNumberOfEmplyeesUnderMe(ceo, directReportees, map);

        for (String employee : map.keySet()) {
            System.out.println(employee + " " + map.get(employee));
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