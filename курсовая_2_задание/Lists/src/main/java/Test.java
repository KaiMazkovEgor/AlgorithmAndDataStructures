import java.util.*;

public class Test {
    public static void main(String[] args) throws IllegalAccessException {
        Lists<Department> my_lists = new Lists<>();
        Department department = new Department();
        Department department_sec = new Department();
        department.setName("SaleBook");
        department_sec.setName("Facility");
        BankEmployee[] employees = new BankEmployee[4];
        BankEmployee[] employees_sec = new BankEmployee[4];
        for (int i = 0; i < 4; i++)
            employees[i] = new BankEmployee("Surname " + i, "Position " + i);
        department.setEmployees(employees);

        for (int j = 0; j < 4; j++)
            employees_sec[j] = new BankEmployee("Surname# " + j, "Position# " + j);
        department_sec.setEmployees(employees_sec);

        my_lists.add(department);
        my_lists.add(department_sec);
        System.out.println(my_lists);
    }
}
