package com.travis.aptech.session10.employee;

public class TestEmployee {
    public static void main(String[] args) {
        Employee employee = new Employee("E001", "Maria Nemeth", 40000);
        employee.calcCommission(20000F);
        employee.displayDetails();
    }
}
