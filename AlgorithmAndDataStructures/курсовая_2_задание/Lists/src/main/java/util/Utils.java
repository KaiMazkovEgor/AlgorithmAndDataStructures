package util;

import bank.BankEmployee;
import bank.Department;
import jframe.Window;
import list.Lists;

import java.util.Collections;


public class Utils extends Window {
    public void getSetLists(String nameDepartment) {
        Lists<Department> lists = getDepartmentLists();
        lists.add(new Department(nameDepartment, new BankEmployee[20]));
        setDepartmentLists(lists);
    }

    public String nameDepartmentAndEmployees() {
        StringBuilder nameDepartment = new StringBuilder("---------------------------------------\n");
        for (int i = 0; i < getDepartmentLists().size(); i++) {
            Department department;
            try {
                department = getDepartmentLists().getIndx(i);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            nameDepartment.append("Название отдела: ")
                    .append(department.getName()).append("\n");
            BankEmployee[] employees = department.getEmployees();
            for (int j = 0; employees[j] != null; j++) {
                String name = employees[j].getSurname();
                nameDepartment.append("    surname: ")
                        .append(employees[j].getSurname()).append("\n")
                        .append("    position: ")
                        .append(employees[j].getPosition())
                        .append("\n");
            }

            nameDepartment.append("---------------------------------------\n");
        }
        return nameDepartment.toString();
    }

    public String nameDepartment() {
        StringBuilder nameDepartment = new StringBuilder("Название отделов:\n");
        for (int i = 0; i < getDepartmentLists().size(); i++) {
            Department department;
            try {
                department = getDepartmentLists().getIndx(i);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            nameDepartment.append("Название отдела: ").append(department.getName()).append("\n");
        }
        return nameDepartment.toString();
    }

    public String[] splitNameDepartments() {
        Lists<Department> departmentLists = getDepartmentLists();
        String[] splitName = new String[departmentLists.size()];

        for (int i = 0; i < departmentLists.size(); i++) {
            Department department;
            try {
                department = departmentLists.getIndx(i);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            splitName[i] = department.getName();
        }
        return splitName;
    }

    public int checkFullEmployee(String name) {
        int i = 0;
        Lists<Department> departmentLists = getDepartmentLists();
        for (; i < departmentLists.size(); i++) {
            Department department;

            try {
                department = departmentLists.getIndx(i);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            if (name.equals(department.getName()))
                break ;
        }
        BankEmployee[] employees;
        try {
            employees = departmentLists.getIndx(i).getEmployees();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        if (employees[19] == null) {
            return 1;
        } else {
            return -1;
        }
    }

    public void addEmployeeForDepartment(String nameDepartment, String surname, String position) {
        Lists<Department> departmentLists = getDepartmentLists();
        int i = 0;
        Department department = null;

        for (; i < departmentLists.size(); i++) {
            try {
                department = departmentLists.getIndx(i);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            if (department.getName().equals(nameDepartment)) {
                BankEmployee[] bankEmployees = department.getEmployees();

                int j = 0;
                for (; j < bankEmployees.length; j++) {
                    if (bankEmployees[j] == null) {
                        break;
                    }
                }
                bankEmployees[j] = new BankEmployee(surname, position);
                break ;
            }
        }
        setDepartmentLists(departmentLists);
    }

    public void delAllDepartment() {
        Lists<Department> departmentLists = getDepartmentLists();
        try {
            departmentLists.retainAll(Collections.singleton(departmentLists));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        setDepartmentLists(departmentLists);
    }

    public void delIndex(String selectedItem) {
        int index = getDepartmentLists().indexOf(Integer.parseInt(selectedItem));
        getDepartmentLists().remove(index);
    }

    public String printDepIndex(String names) {
        Department department;
        int index = 0;
        for (int i = 0; i < getDepartmentLists().size(); i++) {
            try {
                if (getDepartmentLists().getIndx(i).getName().equals(names)) {
                    index = i;
                    break;
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        String name;
        try {
            department = getDepartmentLists().getIndx(index);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        name = "Название отдела:" + department.getName() + "\n";
        BankEmployee[] bankEmployees = department.getEmployees();
        for (int i = 0; bankEmployees[i] != null; i++) {
            name += (i + 1) + ": surname - " + bankEmployees[i].getSurname() + ", position - " + bankEmployees[i].getPosition() + "\n";
        }
        return name;

    }
}

