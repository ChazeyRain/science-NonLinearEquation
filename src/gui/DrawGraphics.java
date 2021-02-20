package gui;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class DrawGraphics extends JPanel {

    private final int PLOT_WIDTH = 600;
    private final int PLOT_HEIGHT = 300;

    private int xShift;
    private int yShift;
    //private final int Y_AXIS;

    private int[] pixelsArrayX;
    private int[] pixelsArrayY;

    private void convertToPixels(double[][] points) {
        pixelsArrayX = new int[points[0].length];
        pixelsArrayY = new int[points[1].length];

        double maxXValue = Arrays.stream(points[0]).max().isPresent() ? Arrays.stream(points[0]).max().getAsDouble() : 0;
        double minXValue = Arrays.stream(points[0]).min().isPresent() ? Arrays.stream(points[0]).min().getAsDouble() : 0;

        double maxYValue = Arrays.stream(points[1]).max().isPresent() ? Arrays.stream(points[1]).max().getAsDouble() : 0;
        double minYValue = Arrays.stream(points[1]).min().isPresent() ? Arrays.stream(points[1]).min().getAsDouble() : 0;

        double weightsX = Math.abs(maxXValue - minXValue) / PLOT_WIDTH;
        double weightsY = Math.abs(maxYValue - minYValue) / PLOT_HEIGHT;

        xShift = (int) Math.round(minXValue / weightsX);
        yShift = (int) Math.round(minYValue / weightsY) + PLOT_HEIGHT;

        for (int i = 0; i < points[0].length; i++) {
            pixelsArrayX[i] = (int) Math.round(points[0][i] / weightsX) - xShift;
            pixelsArrayY[i] = (int) - Math.round(points[1][i] / weightsY) + yShift;
        }
    }

    public void drawing(double[][] points) {
        convertToPixels(points);
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.drawLine(xShift, 150 + yShift, 600 - xShift, 150 + yShift);
        g.drawLine(300 - xShift, yShift, 300 - xShift, 300 + yShift);
        for (int i = 1; i < pixelsArrayX.length; i++) {
            g.drawLine(pixelsArrayX[i - 1], pixelsArrayY[i - 1], pixelsArrayX[i], pixelsArrayY[i]);
        }
    }
}
