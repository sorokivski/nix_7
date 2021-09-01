import entity.Employee;
import org.junit.Test;
import org.junit.jupiter.api.*;
import service.EmployeeServiceImpl;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeServiceTest {

    private final static EmployeeServiceImpl emplService = new EmployeeServiceImpl();
    private final static int EMPLOYEE_SIZE = 10;

    @BeforeAll
    public static void setUp() {
        for (int i = 0; i < EMPLOYEE_SIZE; i++) {
            Employee employee = EmployeeGenerationUtil.generateEmployee(EmployeeGenerationUtil.NAME, i * 3 + 20, "" + i * 130);
            emplService.create(employee);
        }
        Assertions.assertEquals(EMPLOYEE_SIZE, emplService.findAll().length);
    }

    @Test
    @Order(2)
    public void createEmployeeAndCheckAge() {
        Employee employee = EmployeeGenerationUtil.generateEmployee(100);
        emplService.create(employee);
        Assertions.assertFalse(emplService.checkAge(employee.getAge()));

        Employee e = EmployeeGenerationUtil.generateEmployee(33);
        emplService.create(e);
        Assertions.assertTrue(emplService.checkAge(e.getAge()));
    }

    @Test
    @Order(3)
    public void createUserAndCheckSalary() {
        Employee employee = EmployeeGenerationUtil.generateEmployee("l2k3 45", 1001, "salary");
        emplService.create(employee);

        Assertions.assertFalse(emplService.checkAge(employee.getAge()));
        Assertions.assertFalse(emplService.checkSalary(employee.getSalary()));
        Assertions.assertFalse(emplService.checkName(employee.getFullname()));
        Employee e = EmployeeGenerationUtil.generateEmployee("Name", 22, "12000");
        emplService.create(e);
        Assertions.assertTrue(emplService.checkAge(e.getAge()));
        Assertions.assertTrue(emplService.checkSalary(e.getSalary()));
        Assertions.assertTrue(emplService.checkName(e.getFullname()));
    }


    @Test
    @Order(4)
    public void findAll() {
        Employee[] employees = emplService.findAll();
        Assertions.assertEquals(EMPLOYEE_SIZE, employees.length + 1);
    }

    @Test
    @Order(5)
    public void delete() {

        for (int i = 0; i < EMPLOYEE_SIZE; i++) {
            Employee employee = EmployeeGenerationUtil.generateEmployee(EmployeeGenerationUtil.NAME, i * 3 + 20, "" + i * 130);
            emplService.create(employee);
        }
        Employee[] employees = emplService.findAll();
        Assertions.assertEquals(EMPLOYEE_SIZE, employees.length);
        Employee e = employees[0];
        emplService.deleteByName(e.getFullname());
        employees = emplService.findAll();
        Assertions.assertEquals(EMPLOYEE_SIZE - 1, employees.length);
    }

}
