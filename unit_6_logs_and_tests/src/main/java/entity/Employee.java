package entity;

import lombok.Data;

public @Data
class Employee {
    private String id;
    private String fullname;
    private String salary;
    private String position;
    private int age;
    private String departmentId;

    public Employee() {
    }

    public Employee(String fullname, String salary, String position, int age, String departmentID) {
        this.age = age;
        this.fullname = fullname;
        this.position = position;
        this.salary = salary;
        this.departmentId = departmentID;
    }


}
