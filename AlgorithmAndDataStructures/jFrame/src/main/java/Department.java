import jframe.BankJFrame;

import java.util.Arrays;

public class Department {
    private String name;
    private BankJFrame[] employees;

    public Department() {
    }

    public Department(String name, BankJFrame[] employees) {
        this.name = name;
        this.employees = employees;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BankJFrame[] getEmployees() {
        return this.employees;
    }

    public String toString() {
        return "Department " + this.name + ", employees=" + Arrays.toString(this.employees);
    }

    public void setEmployees(BankJFrame[] employees) {
        this.employees = employees;
    }
}
