package jframe;

import jframe.print.PrintInfo;
import util.NewWindows;
import util.Utils;

import javax.swing.*;
import java.awt.*;

public class AddEmployee extends JFrame {
    Utils utils = new Utils();
    NewWindows windows = new NewWindows();
    JLabel department = new JLabel("Выберите отдел:");
    JComboBox listDepartmnent;

    JLabel surname = new JLabel("Введите Фамилию сотрудника:");
    JTextField enterSurname = new JTextField();

    JLabel position = new JLabel("Введите должность:");
    JTextField enterPosition = new JTextField();
    JButton exit = new JButton("Вернуться назад");

    JButton save = new JButton("Записать в отдел сотрудника:");
    public AddEmployee() throws HeadlessException {

        listDepartmnent = new JComboBox(utils.splitNameDepartments());

        JPanel jPanel = new JPanel(new GridLayout(4, 2));

        jPanel.add(department);
        jPanel.add(listDepartmnent);
        jPanel.add(surname);
        jPanel.add(enterSurname);
        jPanel.add(position);
        jPanel.add(enterPosition);
        jPanel.add(save);
        jPanel.add(exit);

        add(jPanel);

        save.addActionListener(e -> {
            setVisible(false);
            if (utils.checkFullEmployee((String) listDepartmnent.getSelectedItem()) == -1) {
                PrintInfo printInfo = new PrintInfo("В отделе нет мест");
                windows.startAddEmployee();
            } else {
                utils.addEmployeeForDepartment((String) listDepartmnent.getSelectedItem(), enterSurname.getText(), enterPosition.getText());
                windows.startWindow();
            }
        });

        exit.addActionListener(e -> {
            setVisible(false);
            windows.startWindow();
        });
    }
}
