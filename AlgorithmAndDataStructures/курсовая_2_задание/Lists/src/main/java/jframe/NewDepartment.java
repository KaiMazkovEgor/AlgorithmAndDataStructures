package jframe;

import util.NewWindows;
import util.Utils;

import javax.swing.*;
import java.awt.*;

public class NewDepartment extends JFrame {
    NewWindows windows = new NewWindows();
    Utils utils = new Utils();
    JLabel nameDepartment = new JLabel("Введите название отдела");
    JTextField enterNameDepartment = new JTextField();
    JButton save = new JButton("Создать отдел");

    public NewDepartment() throws HeadlessException {
        JPanel jPanel = new JPanel(new GridLayout(2, 2));

        jPanel.add(nameDepartment);
        jPanel.add(enterNameDepartment);
        jPanel.add(save);

        add(jPanel);

        save.addActionListener(e -> {
            utils.getSetLists(enterNameDepartment.getText());
            setVisible(false);
            windows.startWindow();
        });
    }
}
