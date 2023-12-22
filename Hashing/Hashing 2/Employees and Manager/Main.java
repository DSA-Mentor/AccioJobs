import java.io.*;
import java.util.*;

class Solution {

    // Faith: returns number of a employees under a manager
    public int getAllEmpUnderMe(String mngr, HashMap<String, ArrayList<String>> directReportees, TreeMap<String, Integer> map) {
        if (directReportees.containsKey(mngr) == false) {
            map.put(mngr, 0);
            return 0;
        }
        
        int totalEmployees = 0;

        for (String direct : directReportees.get(mngr)) {
            int employeesUnderYou = getAllEmpUnderMe(direct, directReportees, map);
            totalEmployees += (employeesUnderYou + 1);
        }

        map.put(mngr, totalEmployees);

        return totalEmployees;
    }
    
    public void EmpUnderManager(Map<String, String> emp) {
		// create a hashmap for direct reportees, and also identify CEO
        HashMap<String, ArrayList<String>> directReportees = new HashMap<>();
        String CEO = "";

        for (String employee : emp.keySet()) {
            String manager = emp.get(employee);

            if (manager.equals(employee) == true) {
                // term him/her as CEO
                CEO = employee;
            } else {
                ArrayList<String> directs = directReportees.getOrDefault(manager, new ArrayList<String>());
                directs.add(employee);
                directReportees.put(manager, directs);
            }
        }

        TreeMap<String, Integer> map = new TreeMap<>();
        getAllEmpUnderMe(CEO, directReportees, map);

        for (String mngr : map.keySet()) {
            System.out.println(mngr + " " + map.get(mngr));
        }
	}
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        Map<String,String> emp = new HashMap<String, String>();
        for(int i=0;i<n;++i){
			emp.put(sc.next(),sc.next());
        }
        Solution Obj = new Solution();
        Obj.EmpUnderManager(emp); 
    }
}