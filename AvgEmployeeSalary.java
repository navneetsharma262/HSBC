package com.nav.myapplication;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

class Employee {
    private String firstName;
    private String lastName;
    private String department;
    private String officeLocation;
    private String designation;
    private Double salary;

    public Employee(String firstName, String lastName, String department, String officeLocation, String designation, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.officeLocation = officeLocation;
        this.designation = designation;
        this.salary = salary;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    public String getDesignation() {
        return designation;
    }

    public Double getSalary() {
        return salary;
    }
}

class FindAverageSalaryApp {

    public void findAverageSalary(List<Employee> employees) {
        Map<String, Map<String, List<Double>>> officeLocationDesignationSalaryMap = new ConcurrentHashMap<>();

        employees.parallelStream().forEach(employee -> {
            officeLocationDesignationSalaryMap
                    .computeIfAbsent(employee.getOfficeLocation(), k -> new ConcurrentHashMap<>())
                    .computeIfAbsent(employee.getDesignation(), k -> new ArrayList<>())
                    .add(employee.getSalary());
        });

        officeLocationDesignationSalaryMap.forEach((officeLocation, designationSalaryMap) -> {
            System.out.println(officeLocation + " -->");
            designationSalaryMap.forEach((designation, salaries) -> {
                double averageSalary = salaries.stream().mapToDouble(Double::doubleValue).average().orElse(0);
                System.out.println("\t" + designation + " --> " + averageSalary);
            });
        });
    }
}

public class AvgEmployeeSalary {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Ashish", "A", "IT", "Pune", "Software Engineer", 10000.0));
        employees.add(new Employee("Amit", "R", "HR", "Pune", "Recruiter", 12000.0));
        employees.add(new Employee("Ramesh", "D", "HR", "Pune", "Senior Recruiter", 14000.0));
        employees.add(new Employee("Jaya", "S", "IT", "Pune", "Tech Lead", 15000.0));
        employees.add(new Employee("Smita", "M", "IT", "Bangalore", "Recruiter", 16000.0));
        employees.add(new Employee("Umesh", "A", "IT", "Bangalore", "Software Engineer", 12000.0));
        employees.add(new Employee("Pooja", "R", "HR", "Bangalore", "Software Engineer", 12000.0));
        employees.add(new Employee("Ramesh", "D", "HR", "Pune", "Recruiter", 16000.0));
        employees.add(new Employee("Bobby", "S", "IT", "Bangalore", "Tech Lead", 20000.0));
        employees.add(new Employee("Vipul", "M", "IT", "Bangalore", "Software Engineer", 14000.0));

        FindAverageSalaryApp app = new FindAverageSalaryApp();
        app.findAverageSalary(employees);

    }
}
