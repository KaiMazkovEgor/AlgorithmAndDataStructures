package jframe;

import util.NewWindows;
import util.Utils;

import javax.swing.*;
import java.awt.*;

public class DepartmentIndex extends JFrame {

    //Utils utils;
    private static final Utils utils = new Utils();
    NewWindows windows = new NewWindows();

    JLabel dep = new JLabel("Выберите какой отдел нужно удалить");
    JComboBox comboBox;
    JButton del = new JButton("Удалить выбранный отдел");
    JButton exit = new JButton("Вернуться назад");
    public DepartmentIndex() throws HeadlessException {

        comboBox = new JComboBox(utils.splitNameDepartments());

        JPanel jPanel = new JPanel(new GridLayout(2, 2));

        jPanel.add(dep);
        jPanel.add(comboBox);
        jPanel.add(del);
        jPanel.add(exit);

        add(jPanel);

        del.addActionListener(e -> {
            setVisible(false);
            utils.delIndex((String) comboBox.getSelectedItem());
            windows.startWindow();
        });

        exit.addActionListener(e -> {
            setVisible(false);
            windows.startWindow();
        });



    }
}
