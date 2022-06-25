import jframe.BankJFrame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class App {
    public static void main(String[] args) {
        BankJFrame bankJFrame = new BankJFrame();
        bankJFrame.setVisible(true);
        bankJFrame.pack(); //Эта команда подбирает оптимальный размер в зависимости от содержимого окна
    }
}