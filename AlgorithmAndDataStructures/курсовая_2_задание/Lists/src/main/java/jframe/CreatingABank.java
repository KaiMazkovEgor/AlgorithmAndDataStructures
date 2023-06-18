package jframe;



import util.NewWindows;

import javax.swing.*;
import java.awt.*;

public class CreatingABank extends JFrame {

    NewWindows windows = new NewWindows();

    public String bankName = "";

    JLabel enterNameBank = new JLabel("Введите название банка");
    JTextField nameBank = new JTextField();
    JButton save = new JButton("Создать банк");
    public CreatingABank() throws HeadlessException {
        JPanel jPanel = new JPanel(new GridLayout(2, 2));

        jPanel.add(enterNameBank);
        jPanel.add(nameBank);
        jPanel.add(save);

        add(jPanel);

        save.addActionListener(e -> {
            bankName = nameBank.getText();
            setVisible(false);
            windows.startWindow();
        });
    }
}
