import dao.InMemoryEmployeeDao;
import entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class InMemoryEmployeeDaoTest {

    private final InMemoryEmployeeDao employeeDao = new InMemoryEmployeeDao();

    @Test
    public void create() {
        Employee[] employees = employeeDao.findAllemployees();
        Assertions.assertEquals(1, employees.length);
        Employee employee = EmployeeGenerationUtil.generateEmployee();
        employeeDao.create(employee);
        employees = employeeDao.findAllemployees();
        Assertions.assertEquals(1, employees.length);
        Assertions.assertNotNull(employees[0].getId());
    }
}

