import dao.InMemoryDepartmentDao;
import entity.Department;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InMemoryDepartmentDaoTest {
    private final InMemoryDepartmentDao departmentDao = new InMemoryDepartmentDao();

    @Test
    public void create() {
        Department[] departments = departmentDao.findAllDepartments();
        Assertions.assertEquals(1, departments.length);
        Department department = DepartmentGenerationUtil.generateDepartment();
        departmentDao.create(department);
        departments = departmentDao.findAllDepartments();
        Assertions.assertEquals(1, departments.length);
        Assertions.assertNotNull(departments[0].getDepartmentId());
    }
}
