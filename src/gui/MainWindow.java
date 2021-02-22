package gui;

import tools.MullerMethod;
import tools.ParabolicInterpolation;

import java.awt.*;
import  java.awt.event.*;
import javax.swing.*;

public class MainWindow extends JFrame{

    public MainWindow() {
        super("Find roots of equation");
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        JTextField inputWidth = new JTextField("200", 10);
        JTextField inputHeight = new JTextField("600", 10);
        JButton drawButton = new JButton("Draw plot");

        JTextField inputX1 = new JTextField("-2", 5);
        JTextField inputX2 = new JTextField("0", 5);
        JTextField inputX3 = new JTextField("2", 5);
        JTextField inputResidual = new JTextField("0.01", 5);
        JButton findRoot = new JButton("Find Root");

        JLabel rootOutputInverseParabolic = new JLabel("Root 1");
        JLabel rootOutputMullerMethod = new JLabel("Root 2");

        this.add(inputX1);
        this.add(inputX2);
        this.add(inputX3);

        this.add(findRoot);
        this.add(rootOutputInverseParabolic);
        this.add(rootOutputMullerMethod);

        this.add(inputWidth);
        this.add(inputHeight);
        this.add(drawButton);


        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int width = inputWidth.getText().matches("\\d+") ? Integer.parseInt(inputWidth.getText()) : 300;
                int height = inputHeight.getText().matches("\\d+") ? Integer.parseInt(inputHeight.getText()) : 300;

                PlotWindow window = new PlotWindow(width, height);
                window.draw();
            }
        });

        findRoot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double[] x = new double[3];
                x[0] = inputX1.getText().matches("[\\d.-]+") ? Double.parseDouble(inputX1.getText()) : -2;
                x[1] = inputX2.getText().matches("[\\d.-]+") ? Double.parseDouble(inputX2.getText()) : 0;
                x[2] = inputX3.getText().matches("[\\d.-]+") ? Double.parseDouble(inputX3.getText()) : 2;
                double residual = inputResidual.getText().matches("[\\d.]+") ? Double.parseDouble(inputResidual.getText()) : 0.01;

                rootOutputInverseParabolic.setText(new ParabolicInterpolation().findRoots(x.clone(), residual) + "");
                rootOutputMullerMethod.setText(new MullerMethod().findRoots(x.clone(), residual) + "");
            }
        });
    }
}
