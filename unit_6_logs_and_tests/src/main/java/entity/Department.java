package entity;

import lombok.Data;

public @Data
class Department {

    private String departmentId;
    private String departmentName;
    private int numOfEmployees;
    private String[] employeesId;

    public Department() {
    }

    public Department(String name, int numOfEmployees) {
        this.departmentName = name;
        this.numOfEmployees = numOfEmployees;
        employeesId = new String[numOfEmployees];
    }

}
