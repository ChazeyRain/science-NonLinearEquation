package gui;

import tools.function.Function;

import javax.swing.*;

public class PlotWindow {
    static private int plotNumber = 1;
    JFrame plot;
    DrawGraphics drawPlot;


    public PlotWindow(int width, int height) {
        this.plot = new JFrame("Plot " + plotNumber);

        drawPlot = new DrawGraphics(width, height);

        this.plot.setSize(width + 17, height + 40);
        this.plot.setVisible(true);
        this.plot.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.plot.add(drawPlot);

        plotNumber++;
    }

    public void draw() {
        //drawPlot.drawing(new double[][] {{0, 0.15, 0.1, 0.02},{3, 4, 5, 6}});
        drawPlot.drawing(new Function().getFunctionValues(-2, 2, 600));
    }
}
