package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1,"Tolunay","Yılmaz"));
        employees.add(new Employee(1,"Tolunay","Yılmaz"));
        employees.add(new Employee(1,"Tolunay","Yılmaz"));
        employees.add(new Employee(2,"Varol","Yılmaz"));
        employees.add(null);

       System.out.println(removeDuplicates(employees));


    }
    public static List<Employee> findDuplicates(List<Employee> employees){
        Set<Employee> seen = new HashSet<>();
        List<Employee> duplicates = new ArrayList<>();

        for (Employee emp : employees) {
            if (!seen.add(emp)) {
                duplicates.add(emp);
            }
        }

        return duplicates;

    }
    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        Map<Employee, Integer> frequencyMap = new HashMap<>();
        Map<Integer, Employee> resultMap = new HashMap<>();

        for (Employee emp : employees) {
            if (emp != null) {
                frequencyMap.put(emp, frequencyMap.getOrDefault(emp, 0) + 1);
            }
        }

        for (Employee emp : frequencyMap.keySet()) {
            if (emp != null) {
                int freq = frequencyMap.get(emp);
                if (freq >= 1) {
                    resultMap.put(emp.getId(), emp);
                }
            }
        }

        return resultMap;
    }


    public static List<Employee> removeDuplicates(List<Employee> employees) {
        Map<Employee, Integer> frequencyMap = new HashMap<>();


        for (Employee emp : employees) {
            frequencyMap.put(emp, frequencyMap.getOrDefault(emp, 0) + 1);
        }

        List<Employee> uniqueEmployees = new LinkedList<>();
        for (Employee emp : employees) {

            if (emp != null && frequencyMap.get(emp) == 1) {
                uniqueEmployees.add(emp);
            }
        }

        return uniqueEmployees;
    }




}