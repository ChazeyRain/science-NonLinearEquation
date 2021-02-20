package gui;

import java.awt.*;
import  java.awt.event.*;
import javax.swing.*;

public class MainWindow extends JFrame{

    public MainWindow() {
        super("Find roots of equation");
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        JTextField inputWidth = new JTextField("300", 10);
        this.add(inputWidth);
        JTextField inputHeight = new JTextField("600", 10);
        this.add(inputHeight);

        JButton computeButton = new JButton("Compute");
        this.add(computeButton);

        computeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int width = inputWidth.getText().matches("\\d+") ? Integer.parseInt(inputWidth.getText()) : 300;
                int height = inputHeight.getText().matches("\\d+") ? Integer.parseInt(inputHeight.getText()) : 600;
                PlotWindow window = new PlotWindow(width, height);
                window.draw();
            }
        });
    }
}
