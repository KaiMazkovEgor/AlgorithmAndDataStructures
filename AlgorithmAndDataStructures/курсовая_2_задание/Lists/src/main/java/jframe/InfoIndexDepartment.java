package jframe;

import jframe.print.PrintInfo;
import util.NewWindows;
import util.Utils;

import javax.swing.*;
import java.awt.*;

public class InfoIndexDepartment extends JFrame {
    JLabel deleteDep = new JLabel("Выберите какой отдел");
    JComboBox comboBox;
    JButton del = new JButton("Получить информацию");
    Utils utils = new Utils();
    NewWindows windows = new NewWindows();
    JButton exit = new JButton("Вернуться назад");
    public InfoIndexDepartment() throws HeadlessException {
        JPanel jPanel = new JPanel(new GridLayout(3,2 ));

        comboBox = new JComboBox(utils.splitNameDepartments());

        jPanel.add(deleteDep);
        jPanel.add(comboBox);
        jPanel.add(del);
        jPanel.add(exit);

        add(jPanel);

        exit.addActionListener(e -> {
            setVisible(false);
            windows.startWindow();
        });

        del.addActionListener(e -> {
            setVisible(false);
            PrintInfo printInfo = new PrintInfo(utils.printDepIndex((String) comboBox.getSelectedItem()));
            windows.startWindow();
        });
    }
}
