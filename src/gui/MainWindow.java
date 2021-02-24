package gui;

import tools.function.MullerMethod;
import tools.function.NewtonIterationMethod;
import tools.function.ParabolicInterpolation;

import java.awt.*;
import  java.awt.event.*;
import javax.swing.*;

public class MainWindow {

    JFrame frame = new JFrame("Find roots of equation");

    Container inverseParabolic;
    Container mainMenu;
    Container newton;
    Container muller;

    //Main menu page container
    {
        mainMenu = new Container();

        JLabel  label               = new JLabel("Choose method: ");
        JButton buttonSetToInvPar   = new JButton("Inverse parabolic interpolation");
        JButton buttonNewton        = new JButton("Newton method");
        JButton drawButton          = new JButton("Draw plot");
        JButton buttonMuller        = new JButton("Muller method");

        GridBagLayout defaultLayout = new GridBagLayout();
        mainMenu.setLayout(defaultLayout);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        mainMenu.add(label, gbc);

        gbc.gridy = 1;
        mainMenu.add(buttonSetToInvPar, gbc);
        gbc.gridy = 2;
        mainMenu.add(buttonNewton, gbc);
        gbc.gridy = 3;
        mainMenu.add(buttonMuller, gbc);
        gbc.gridy = 4;
        mainMenu.add(drawButton, gbc);

        buttonSetToInvPar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(inverseParabolic);
                SwingUtilities.updateComponentTreeUI(frame);
            }
        });

        buttonNewton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(newton);
                SwingUtilities.updateComponentTreeUI(frame);
            }
        });

        buttonMuller.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(muller);
                SwingUtilities.updateComponentTreeUI(frame);
            }
        });

        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int width = 300;
                int height = 600;

                PlotWindow window = new PlotWindow(width, height);
                window.draw();
            }
        });
    }

    //Inverse parabolic method page container
    {
        inverseParabolic = new Container();
        JTextField      inputWidth                  = new JTextField("200", 10);
        JTextField      inputHeight                 = new JTextField("600", 10);
        JButton         drawButton                  = new JButton("Draw plot");

        JTextField      inputX1                     = new JTextField("-2", 5);
        JTextField      inputX2                     = new JTextField("0", 5);
        JTextField      inputX3                     = new JTextField("2", 5);
        JTextField      inputResidual               = new JTextField("0.01", 5);
        JLabel          labelX1                     = new JLabel("X1 = ");
        JLabel          labelX2                     = new JLabel("X2 = ");
        JLabel          labelX3                     = new JLabel("X3 = ");
        JLabel          labelResidual               = new JLabel("Residual = ");
        JButton         findRoot                    = new JButton("Find Root");

        JLabel          rootOutput                  = new JLabel("Root");
        JLabel          labelRootMsg                = new JLabel("Root = ");

        JButton         buttonToMainMenu            = new JButton("To menu");

        GridBagLayout defaultLayout = new GridBagLayout();
        inverseParabolic.setLayout(defaultLayout);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        inverseParabolic.add(labelX1, gbc);

        gbc.gridx = 1;
        inverseParabolic.add(inputX1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        inverseParabolic.add(labelX2, gbc);
        gbc.gridx = 1;
        inverseParabolic.add(inputX2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        inverseParabolic.add(labelX3, gbc);
        gbc.gridx = 1;
        inverseParabolic.add(inputX3, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        inverseParabolic.add(labelResidual, gbc);
        gbc.gridx = 1;
        inverseParabolic.add(inputResidual, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        inverseParabolic.add(labelRootMsg, gbc);
        gbc.gridx = 1;
        inverseParabolic.add(rootOutput, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        inverseParabolic.add(findRoot, gbc);

        gbc.gridy = 6;
        inverseParabolic.add(drawButton, gbc);

        gbc.gridy = 7;
        inverseParabolic.add(buttonToMainMenu, gbc);


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
                x[0] = inputX1.getText().matches("-?\\d+.?\\d*") ? Double.parseDouble(inputX1.getText()) : -2;
                x[1] = inputX2.getText().matches("-?\\d+.?\\d*") ? Double.parseDouble(inputX2.getText()) : 0;
                x[2] = inputX3.getText().matches("-?\\d+.?\\d*") ? Double.parseDouble(inputX3.getText()) : 2;
                double residual = inputResidual.getText().matches("\\d+.?\\d*") ? Double.parseDouble(inputResidual.getText()) : 0.01;

                rootOutput.setText(new ParabolicInterpolation().findRoots(x.clone(), residual) + "");
                //rootOutputMullerMethod.setText(new MullerMethod().findRoots(x.clone(), residual) + "");
            }
        });

        buttonToMainMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(mainMenu);
                SwingUtilities.updateComponentTreeUI(frame);
            }
        });
    }

    //Newton iteration page container
    {
        newton = new Container();

        JLabel      labelX          = new JLabel("Start x = ");
        JTextField  tfStartX        = new JTextField("2", 5);
        JLabel      labelH          = new JLabel("h = ");
        JTextField  tfH             = new JTextField("0.1", 5);
        JLabel      labelResidual   = new JLabel("Residual = ");
        JTextField  tfResidual      = new JTextField("0.1", 5);
        JLabel      labelRoot       = new JLabel("Root = ");
        JLabel      labelRootOutput = new JLabel("root");
        JButton     buttonCalculate = new JButton("Find root");
        JButton     buttonToMenu    = new JButton("To menu");
        JButton     drawButton      = new JButton("Draw plot");

        GridBagLayout defaultLayout = new GridBagLayout();
        newton.setLayout(defaultLayout);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        newton.add(labelX, gbc);
        gbc.gridx = 1;
        newton.add(tfStartX, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        newton.add(labelH, gbc);
        gbc.gridx = 1;
        newton.add(tfH, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        newton.add(labelResidual, gbc);
        gbc.gridx = 1;
        newton.add(tfResidual, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        newton.add(labelRoot, gbc);
        gbc.gridx = 1;
        newton.add(labelRootOutput, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        newton.add(buttonCalculate, gbc);

        gbc.gridy = 5;
        newton.add(drawButton, gbc);

        gbc.gridy = 6;
        newton.add(buttonToMenu, gbc);

        buttonCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double x = tfStartX.getText().matches("-?\\d+.?\\d*") ? Double.parseDouble(tfStartX.getText()) : -2;
                double h = tfH.getText().matches("-?\\d+.?\\d*") ? Double.parseDouble(tfH.getText()) : 0.1;
                double r = tfResidual.getText().matches("\\d+.?\\d*") ? Double.parseDouble(tfResidual.getText()) : 0.01;

                labelRootOutput.setText(new NewtonIterationMethod().findRoots(x, h, r) + "");

            }
        });

        buttonToMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(mainMenu);
                SwingUtilities.updateComponentTreeUI(frame);
            }
        });

        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int width = 300;
                int height = 600;

                PlotWindow window = new PlotWindow(width, height);
                window.draw();
            }
        });
    }

    //Muller method page container
    {
        muller = new Container();
        JTextField      inputWidth                  = new JTextField("200", 10);
        JTextField      inputHeight                 = new JTextField("600", 10);
        JButton         drawButton                  = new JButton("Draw plot");

        JTextField      inputX1                     = new JTextField("-2", 5);
        JTextField      inputX2                     = new JTextField("0", 5);
        JTextField      inputX3                     = new JTextField("2", 5);
        JTextField      inputResidual               = new JTextField("0.01", 5);
        JLabel          labelX1                     = new JLabel("X1 = ");
        JLabel          labelX2                     = new JLabel("X2 = ");
        JLabel          labelX3                     = new JLabel("X3 = ");
        JLabel          labelResidual               = new JLabel("Residual = ");
        JButton         findRoot                    = new JButton("Find Root");

        JLabel          rootOutput                  = new JLabel("Root");
        JLabel          labelRootMsg                = new JLabel("Root = ");

        JButton         buttonToMainMenu            = new JButton("To menu");

        GridBagLayout defaultLayout = new GridBagLayout();
        muller.setLayout(defaultLayout);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        muller.add(labelX1, gbc);

        gbc.gridx = 1;
        muller.add(inputX1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        muller.add(labelX2, gbc);
        gbc.gridx = 1;
        muller.add(inputX2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        muller.add(labelX3, gbc);
        gbc.gridx = 1;
        muller.add(inputX3, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        muller.add(labelResidual, gbc);
        gbc.gridx = 1;
        muller.add(inputResidual, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        muller.add(labelRootMsg, gbc);
        gbc.gridx = 1;
        muller.add(rootOutput, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        muller.add(findRoot, gbc);

        gbc.gridy = 6;
        muller.add(drawButton, gbc);

        gbc.gridy = 7;
        muller.add(buttonToMainMenu, gbc);


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
                x[0] = inputX1.getText().matches("-?\\d+.?\\d*") ? Double.parseDouble(inputX1.getText()) : -2;
                x[1] = inputX2.getText().matches("-?\\d+.?\\d*") ? Double.parseDouble(inputX2.getText()) : 0;
                x[2] = inputX3.getText().matches("-?\\d+.?\\d*") ? Double.parseDouble(inputX3.getText()) : 2;
                double residual = inputResidual.getText().matches("\\d+.?\\d*") ? Double.parseDouble(inputResidual.getText()) : 0.01;

                //rootOutput.setText(new ParabolicInterpolation().findRoots(x.clone(), residual) + "");
                rootOutput.setText(new MullerMethod().findRoots(x.clone(), residual) + "");
            }
        });

        buttonToMainMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(mainMenu);
                SwingUtilities.updateComponentTreeUI(frame);
            }
        });
    }

    {
        frame.setContentPane(mainMenu);
    }

    public MainWindow() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
