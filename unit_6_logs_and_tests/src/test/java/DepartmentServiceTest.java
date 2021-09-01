import entity.Department;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import service.DepartmentServiceImpl;

public class DepartmentServiceTest {

    private final static DepartmentServiceImpl departmentService = new DepartmentServiceImpl();
    private final static int DEPARTMENTS_SIZE = 10;
    private final static String NAME = "TestName";

    @BeforeAll
    public static void setUp() {
        for (int i = 0; i < DEPARTMENTS_SIZE; i++) {
            Department department = DepartmentGenerationUtil.generateDepartment(NAME, "" + i * 8 + 3);
            departmentService.create(department);
        }
        Assertions.assertEquals(DEPARTMENTS_SIZE, departmentService.findAll().length);
    }

    @Test
    @Order(2)
    public void createDepartmentAndCheckNumOfEmployees() {
        Department d = DepartmentGenerationUtil.generateDepartment("Some Name", "+_+");
        departmentService.create(d);
        Assertions.assertTrue(departmentService.checkDepartmentName(d.getDepartmentName()));
        Assertions.assertTrue(departmentService.checkNumOfEmployees(d.getNumOfEmployees()));

        Department d1 = DepartmentGenerationUtil.generateDepartment("Actual Name", "121");
        departmentService.create(d1);
        Assertions.assertNotEquals(false, departmentService.checkDepartmentName(d1.getDepartmentName()));
        Assertions.assertNotEquals(false, departmentService.checkNumOfEmployees(d1.getNumOfEmployees()));
    }

    @Test
    @Order(4)
    public void findAll() {
        Department[] departments = departmentService.findAll();
        Assertions.assertEquals(DEPARTMENTS_SIZE, departments.length + 1);
    }

    @Test
    @Order(5)
    public void delete() {

        for (int i = 0; i < DEPARTMENTS_SIZE; i++) {
            Department d = DepartmentGenerationUtil.generateDepartment(NAME, "" + i * 3 + 20);
            departmentService.create(d);
        }
        Department[] departments = departmentService.findAll();
        Assertions.assertEquals(DEPARTMENTS_SIZE, departments.length);
        Department e = departments[0];
        departmentService.deleteByName(e.getDepartmentName());
        departments = departmentService.findAll();
        Assertions.assertEquals(DEPARTMENTS_SIZE - 1, departments.length);
    }

}
