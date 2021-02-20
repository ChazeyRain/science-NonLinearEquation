package gui;

import java.awt.*;
import  java.awt.event.*;
import javax.swing.*;

public class MainWindow extends JFrame{

    public MainWindow() {
        super("Find roots of equation");
        this.setSize(100, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton computeButton = new JButton("Compute");
        this.add(computeButton);

        computeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlotWindow window = new PlotWindow();
                window.draw();
            }
        });
    }
}
