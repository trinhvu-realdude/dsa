package com.travis.aptech.session10.employee;

public class Employee {
    String empId;
    String empName;
    int salary;
    float commission;

    public Employee(String id, String name, int sal) {
        this.empId = id;
        this.empName = name;
        this.salary = sal;
    }

    public void calcCommission(float sales) {
        if (sales > 10000) {
            commission = (float) (salary * 20) / 100;
        } else {
            commission = 0;
        }
    }

    public void calcCommission(int overtime) {
        if (overtime > 8) {
            commission = (float) salary / 30;
        } else {
            commission = 0;
        }
    }

    public void displayDetails() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Employee Name: " + empName);
        System.out.println("Salary: " + salary);
        System.out.println("Commission: " + commission);
    }
}
