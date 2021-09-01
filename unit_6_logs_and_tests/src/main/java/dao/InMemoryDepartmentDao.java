package dao;

import entity.Department;
import lombok.Data;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public @Data
class InMemoryDepartmentDao {
    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");
    private int countOfDepartments = 0;
    private int SIZE = 1;
    private Department[] departments;

    public InMemoryDepartmentDao() {
        departments = new Department[SIZE];
    }

    public Department create(Department department) {

        SIZE = departments.length;
        if (department != null) {
            department.setDepartmentId(generateDepartmentId());
            if (countOfDepartments > SIZE - 1) {
                System.out.println("Upgrading of array");
                upgradeArray();
            }
            departments[countOfDepartments] = department;
            LOGGER_INFO.info("Added new department:\t" + departments[countOfDepartments].toString());
            countOfDepartments++;
            return departments[countOfDepartments - 1];
        }
        LOGGER_WARN.warn("Incorrect department-data");
        return null;
    }

    public void update(Department department, String[] employeesIds) {
        LOGGER_INFO.info("Updating department:\t" + department);
        int departmentNum = department.getNumOfEmployees() + 1;
        for (int i = 0; i < countOfDepartments; i++)
            if (department.getDepartmentName().equals(departments[i].getDepartmentName()))
                departmentNum = i;
        if (departmentNum != department.getNumOfEmployees() + 1)
            departments[departmentNum].setEmployeesId(employeesIds);
    }

    public void delete(String name) {
        try {
            for (int i = 0; i < departments.length; i++) {
                if (departments[i].getDepartmentName().contains(name)) {
                    departments = ArrayUtils.remove(departments, i);
                    break;
                }
            }
            countOfDepartments--;
            SIZE = departments.length;
            LOGGER_INFO.info("Deleted department:\t" + name);
        } catch (NullPointerException e) {
            LOGGER_ERROR.error("Department doesn`t exist");
        }
    }

    public Department findDepartmentByName(String name) {
        try {
            for (int i = 0; i < departments.length; i++) {
                if (departments[i].getDepartmentName().equals(name))
                    return departments[i];

                LOGGER_WARN.warn("department:\t" + name + " not founded");
            }
        } catch (NullPointerException e) {
            LOGGER_ERROR.error("Departments are not exist");
        }

        return null;
    }

    public Department[] findAllDepartments() {
        removeNulls();
        return departments;
    }

    private String generateDepartmentId() {
        return ("" + 1 + (int) (Math.random() * 15));
    }

    public void upgradeArray() {
        SIZE = departments.length * 2;
        Department[] newDepartment = new Department[SIZE];
        for (int i = 0; i < departments.length; i++)
            newDepartment[i] = departments[i];
        departments = newDepartment;
    }

    public void removeNulls() {
        int count = 0;
        for (int i = 0; i < departments.length; i++)
            if (departments[i] != null) count++;

        if (count != 0) {
            SIZE = count;
            Department[] newDepartment = new Department[SIZE];
            for (int i = 0; i < SIZE; i++) {
                newDepartment[i] = departments[i];
            }
            departments = newDepartment;
        }
    }
}