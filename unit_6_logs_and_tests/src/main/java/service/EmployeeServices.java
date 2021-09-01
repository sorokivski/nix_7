package service;

import entity.Employee;

public interface EmployeeServices {

    void create(final Employee employee);

    void update();

    void deleteByName(final String name);

    Employee findByName(final String name);

    Employee[] findAll();

    boolean checkAge(int age);

    boolean checkSalary(String salary);

    boolean checkName(String name);

    boolean checkDepartmentId(String departmentId);

}
