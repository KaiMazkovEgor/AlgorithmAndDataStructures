package util;

import jframe.*;
import jframe.Window;

import java.awt.*;

public class NewWindows {
    static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private static final int screenWidth = dim.width;
    private static final int screenHeight = dim.height - 45;
    private static final int x = 0;
    private static final int y = 0;


    public void startWindow() {
        jframe.Window window = new Window();
        window.setBounds(x, y, screenWidth, screenHeight);
        window.setVisible(true);
    }

    public void startCreatingABank() {
        CreatingABank creatingABank = new CreatingABank();
        creatingABank.setBounds(500, 400, 400, 400);
        creatingABank.setVisible(true);
    }

    public void startNewDepartment() {
        NewDepartment department = new NewDepartment();
        department.setBounds(x, y, screenWidth, screenHeight);
        department.setVisible(true);
    }

    public void startAddEmployee() {
        AddEmployee employee = new AddEmployee();
        employee.setBounds(x, y, screenWidth, screenHeight);
        employee.setVisible(true);
    }

    public void startDepartmentIndex() {
        DepartmentIndex dep = new DepartmentIndex();
        dep.setBounds(x, y, screenWidth, screenHeight);
        dep.setVisible(true);
    }

    public void startDeleteIndexDepartment() {
        InfoIndexDepartment departmentIndex = new InfoIndexDepartment();
        departmentIndex.setBounds(x, y, screenWidth, screenHeight);
        departmentIndex.setVisible(true);
    }
}
