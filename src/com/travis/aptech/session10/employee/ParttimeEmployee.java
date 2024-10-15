package com.travis.aptech.session10.employee;

public class ParttimeEmployee extends Employee {
    String shift;

    public ParttimeEmployee(String id, String name, int sal, String shift) {
        super(id, name, sal);
        this.shift = shift;
    }
}
