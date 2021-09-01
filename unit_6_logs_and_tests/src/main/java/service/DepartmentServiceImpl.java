package service;

import dao.InMemoryDepartmentDao;
import entity.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;
import java.util.regex.Pattern;

public class DepartmentServiceImpl implements DepartmentServices {
    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");
    private static final Scanner IN = new Scanner(System.in);
    InMemoryDepartmentDao departmentDao = new InMemoryDepartmentDao();

    @Override
    public Department create(Department department) {

        LOGGER_INFO.info("Settled new department name: " + department.getDepartmentName());
        if (!checkDepartmentName(department.getDepartmentName())) {
            LOGGER_WARN.warn("invalid name: " + department.getDepartmentName());
            return null;
        } else
            return departmentDao.create(department);

    }

    @Override
    public void update() {
        try {
            System.out.println("Enter name of department to be updated: ");
            Department department = findByName(IN.nextLine());
            String[] employeesId = new String[department.getNumOfEmployees()];
            System.out.println("Enter employees id`s to add to department:");
            for (int i = 0; i < department.getNumOfEmployees(); i++) {
                String employeeId = IN.nextLine();
                LOGGER_INFO.info("update department: " + department.getDepartmentName());
                employeesId[i] = employeeId;
                LOGGER_WARN.info("There`s no employees with that id " + employeeId);
            }
            departmentDao.update(department, employeesId);
        } catch (NullPointerException e) {
            LOGGER_ERROR.error("department doesn`t exist");
        }
    }

    @Override
    public boolean checkNumOfEmployees(int newNum) {
        return Pattern.matches("\\d+", "" + newNum);
    }

    @Override
    public Department findByName(String name) {
        LOGGER_INFO.info("finding department by name: " + name);
        return departmentDao.findDepartmentByName(name);

    }

    public void deleteByName(String name) {
        LOGGER_INFO.info("delete department by name: " + name);
        departmentDao.delete(name);
    }


    @Override
    public Department[] findAll() {
        LOGGER_INFO.info("finding all departments ");
        return departmentDao.findAllDepartments();
    }

    @Override
    public boolean checkDepartmentName(String departmentName) {
        return Pattern.matches("^[\\p{L} .'-]*$", departmentName);
    }

}
