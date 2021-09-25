package service;

import entity.Department;

public interface DepartmentServices {
    Department create(final Department department);

    void update(String nameToFind);

    Department[] findAll();

    boolean checkDepartmentName(String departmentName);

    boolean checkNumOfEmployees(int newNum);

    Department findByName(String name);
}
