import entity.Department;

public class DepartmentGenerationUtil {

    public static final String NAME = "test DepartmentName";
    public static final String ID = "test ID";

    public static Department generateDepartment() {
        Department department = new Department();
        department.setDepartmentName(NAME);
        department.setDepartmentId(ID);
        return department;
    }

    public static Department generateDepartment(String name, String id) {
        Department department = new Department();
        department.setDepartmentName(name);
        department.setDepartmentId(id);
        return department;
    }

}
