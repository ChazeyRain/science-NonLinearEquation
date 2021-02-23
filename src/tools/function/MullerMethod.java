package tools.function;

import java.util.Arrays;

//does not work
public class MullerMethod extends Function {
    public double findRoots(double[] x, double residual) {
        System.out.println("Muller:" + "\n" +
                x[0] + "\n" +
                x[1] + "\n" +
                x[2] + "\n");
        double w = divDiff2Func(x[2], x[1]) + divDiff2Func(x[2], x[0]) - divDiff2Func(x[1], x[0]);
        return iterate(x, w, residual);
    }

    private double iterate(double[] x, double w, double residual) {
        double nextX = x[2] - 2 * func(x[2]) / (Math.max(w + squareRoot(w, x), w - squareRoot(w, x)));
        System.out.println("Muller:" + nextX + "\n" +
                x[0] + "\n" +
                x[1] + "\n" +
                x[2] + "\n");
        if (Math.abs(func(nextX)) > residual || nextX < -2) {
            x[0] = x[1];
            x[1] = x[2];
            if (nextX < -2) {
                x[2] = -nextX;
                Arrays.sort(x);
            } else {
                x[2] = nextX;
            }
            return iterate(x, w, residual);
        }
        return nextX;
    }

    private double squareRoot(double w, double[] x) {
        return Math.sqrt(w * w - 4 * func(2) * divDiff3Func(x[0], x[1], x[2]));
    }

    private double divDiff2Func(double x0, double x1) {
        return (func(x1) - func(x0)) / (x1 - x0);
    }

    private double divDiff3Func(double x0, double x1, double x2) {
        return (divDiff2Func(x1, x2) - divDiff2Func(x0, x1)) / (x2 - x0);
    }
}
