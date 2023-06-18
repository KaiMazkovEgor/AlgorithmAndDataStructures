package jframe;

import bank.BankEmployee;
import bank.Department;
import jframe.print.PrintInfo;
import list.Lists;
import util.NewWindows;
import util.Utils;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private static Lists<Department> departmentLists = new Lists<>();
    JButton addDepartment = new JButton("Создать Отдел");
    JButton addEmployee = new JButton("Создать сотрудника");
    JButton printTheNameOfDepartments = new JButton("Список всех отделов");
    JButton printTheNameOfDepartmentsAndTheirEmployees = new JButton("Список всех отделов и их сотрудников");
    JButton deleteEmployee = new JButton("Удаление сотрудника");
    JButton deleteDepartment = new JButton("Удаление отдела");
    JButton deleteAllDepartment = new JButton("Удаление всех отделов");
    JButton enterDep = new JButton("Получение информации о определенном отделе");

    JButton logout = new JButton("Завершение программы");

    private static final Utils utils = new Utils();
    public Window() throws HeadlessException {
        NewWindows newWindows = new NewWindows();
        JPanel jPanel = new JPanel(new GridLayout(4, 2));

        jPanel.add(addDepartment);

        if (departmentLists.size() != 0) {
            jPanel.add(addEmployee);
            jPanel.add(printTheNameOfDepartments);
            jPanel.add(printTheNameOfDepartmentsAndTheirEmployees);
            jPanel.add(deleteAllDepartment);
            jPanel.add(deleteDepartment);
            jPanel.add(enterDep);
        }
        jPanel.add(logout);

        add(jPanel);

        logout.addActionListener(e -> {
            System.exit(0);
        });

        addDepartment.addActionListener(e -> {
            newWindows.startNewDepartment();
            setVisible(false);
        });

        printTheNameOfDepartments.addActionListener(e -> {
            setVisible(false);
            PrintInfo text = new PrintInfo(utils.nameDepartment());
            newWindows.startWindow();
        });

        printTheNameOfDepartmentsAndTheirEmployees.addActionListener(e -> {
            setVisible(false);
            PrintInfo text = new PrintInfo(utils.nameDepartmentAndEmployees());
            newWindows.startWindow();
        });

        addEmployee.addActionListener(e -> {
            setVisible(false);
            newWindows.startAddEmployee();
        });

        deleteAllDepartment.addActionListener(e -> {
            utils.delAllDepartment();
            PrintInfo printInfo = new PrintInfo("Все отделы удалены!");
            setVisible(false);
            newWindows.startWindow();
        });

        enterDep.addActionListener(e -> {
            setVisible(false);
            newWindows.startDeleteIndexDepartment();
        });

        deleteDepartment.addActionListener(e -> {
            setVisible(false);
            newWindows.startDepartmentIndex();
        });
    }



    public Lists<Department> getDepartmentLists() {
        return departmentLists;
    }

    public void setDepartmentLists(Lists<Department> departmentLists) {
        Window.departmentLists = departmentLists;
    }

}
