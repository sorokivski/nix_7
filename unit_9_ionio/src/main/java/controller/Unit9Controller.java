package controller;

import entity.Department;
import entity.Employee;
import service.DepartmentServiceImpl;
import service.EmployeeServiceImpl;

import java.util.Arrays;
import java.util.Scanner;

public class Unit9Controller {

    private static final Scanner IN = new Scanner(System.in);
    private static final DepartmentServiceImpl DEPARTMENT_SERVICES = new DepartmentServiceImpl();
    private static final EmployeeServiceImpl EMPLOYEE_SERVICES = new EmployeeServiceImpl();

    public void startUnit9() {
        int choice = 11;
        while (choice != 0) {
            System.out.println("*****************************************************************************************************************************************************");
            System.out.println("Press 1 to add new department\n" +
                    "2 to find departmentByName\n3 to delete department\n" +
                    "4 to add Employee\n5 to find Employee\n" +
                    "6 to remove Employee\n" +
                    "7 to find all departments\n" +
                    "8 to find all employees\n" +
                    "9 to add Employees to Department\n" +
                    "10 to update Employee\n0 to EXIT: ");
            try {
                if (IN.hasNextInt()) choice = IN.nextInt();
            } catch (Exception e) {
                System.out.println("Incorrect input");
                if (IN.hasNextInt()) choice = IN.nextInt();
            }

            switch (choice) {
                case 1:
                    createDepartment();
                    break;
                case 2:
                    findDepartmentByName();
                    break;
                case 3:
                    deleteDepartmentByName();
                    break;
                case 4:
                    createEmployee();
                    break;
                case 5:
                    findEmployeeByName();
                    break;
                case 6:
                    deleteEmployeeByName();
                    break;
                case 7:
                    findAllDepartments();
                    break;
                case 8:
                    findAllEmployees();
                    break;
                case 9:
                    updateDepartment();
                    break;
                case 10:
                    updateEmployee();
                    break;
                case 0:
                    choice = 0;
                    break;
                default:
                    System.out.println("WRONG CHOICE, PEEK ONE FROM NEXT LIST: ");
                    break;
            }
            System.out.println("*****************************************************************************************************************************************************");
        }
    }

    private void updateEmployee() {

        System.out.println("Enter fullname for employee which should be updated: ");
        String name = IN.nextLine();
        System.out.println("Enter new position and salary for employee:" + name);
        String newPosition = IN.nextLine();
        String newSalary = IN.nextLine();
        EMPLOYEE_SERVICES.update(name, newPosition, newSalary);
    }

    private void updateDepartment() {
        System.out.println("Enter name of department to be updated: ");
        DEPARTMENT_SERVICES.update(IN.nextLine());
    }

    private void findDepartmentByName() {
        IN.nextLine();
        System.out.println("Enter department name to find: ");
        System.out.println(DEPARTMENT_SERVICES.findByName(IN.nextLine()));
    }

    private void createDepartment() {
        IN.nextLine();
        System.out.println("Enter data about new department (departmentName and numberOfEmployees):");
        Department temp = DEPARTMENT_SERVICES.create(new Department(IN.nextLine(), IN.nextInt()));

    }


    public void deleteDepartmentByName() {
        IN.nextLine();
        System.out.println("Enter department name to delete: ");
        DEPARTMENT_SERVICES.deleteByName(IN.nextLine());
    }

    public void findAllDepartments() {
        System.out.println(Arrays.toString(DEPARTMENT_SERVICES.findAll()));
    }

    private void createEmployee() {
        IN.nextLine();
        System.out.println("Enter data about new employee (fullname,salary, position, age, departmentId):");
        String newName = IN.nextLine();
        String newSalary = IN.nextLine();
        String newPosition = IN.nextLine();
        int age;
        try {
            age = IN.nextInt();
        } catch (Exception e) {
            System.out.println("Incorrect input");
            IN.nextLine();
            age = IN.nextInt();
        }
        IN.nextLine();
        EMPLOYEE_SERVICES.create(new Employee(newName, newSalary, newPosition, age, IN.nextLine()));
    }

    public void deleteEmployeeByName() {
        IN.nextLine();
        System.out.println("Enter employee name to delete: ");
        EMPLOYEE_SERVICES.deleteByName(IN.nextLine());
    }

    public void findEmployeeByName() {
        IN.nextLine();
        System.out.println("Enter employee name to find: ");
        System.out.println(EMPLOYEE_SERVICES.findByName(IN.nextLine()));
    }

    public void findAllEmployees() {
        System.out.println(Arrays.toString(EMPLOYEE_SERVICES.findAll()));
    }
}

