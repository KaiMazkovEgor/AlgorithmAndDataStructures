package jframe;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.MessageFormat;

public class BankJFrame extends JFrame {

    public BankJFrame() {
        super("Банк");
        //Подготавливаем компоненты объекта
        JLabel countLabel = new JLabel("label");
        JButton addCrow = new JButton("Добавить сотрудника");
        JButton removeCrow = new JButton("Удалить сотрудника");

        //Подготавливаем временные компоненты
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        //Расставляем компоненты по местам
        buttonsPanel.add(countLabel, BorderLayout.NORTH); //О размещении компонент поговорим позже

        buttonsPanel.add(addCrow);

        buttonsPanel.add(removeCrow);

        add(buttonsPanel, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addCrow.addActionListener(this::addAction);
        removeCrow.addActionListener(this::removeAction);
    }

    private void addAction(ActionEvent actionEvent) {
        JFrame jFrame = new JFrame();
        String name = JOptionPane.showInputDialog(jFrame, "enter name of employee");
        String surname = JOptionPane.showInputDialog(jFrame, "enter surname of employee");
        JOptionPane.showMessageDialog(jFrame, MessageFormat.format(
                "id employee with name {0}: {1}", name, 123
        ));
        System.out.println(name + "\n" + surname);
    }

    private void removeAction(ActionEvent actionEvent) {
        JFrame jFrame = new JFrame();
        try {
            long id = Long.parseLong(JOptionPane.showInputDialog(jFrame, "enter employee's id"));
            System.out.println("delete id " + id);
        } catch (NumberFormatException | HeadlessException ex) {
            JOptionPane.showMessageDialog(jFrame, "illegal id. enter number");
            removeAction(actionEvent);
        }
    }

}
