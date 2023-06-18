package bank;

import java.util.Arrays;

public class Department {
    private String name;
    private BankEmployee[] employees;

    public Department() {
    }

    public Department(String name, BankEmployee[] employees) {
        this.name = name;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BankEmployee[] getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "bank.Department " + name +
                ", employees=" + Arrays.toString(employees);
    }

    public void setEmployees(BankEmployee[] employees) {
        this.employees = employees;
    }
}
