package service;

import entity.Department;

public interface DepartmentServices {
    Department create(final Department department);

    void update();

    Department[] findAll();

    boolean checkDepartmentName(String departmentName);

    boolean checkNumOfEmployees(int newNum);

    Department findByName(String name);
}
