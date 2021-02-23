package tools.function;

public class ParabolicInterpolation extends Function {

    public double findRoots(double[] x, double residual) {
        double nextX = func(x[1]) * func(x[2]) * x[0] / ((func(x[0]) - func(x[1])) * (func(x[0]) - func(x[2]))) +
                func(x[0]) * func(x[2]) * x[1] / ((func(x[1]) - func(x[0])) * (func(x[1]) - func(x[2]))) +
                func(x[0]) * func(x[1]) * x[2] / ((func(x[2]) - func(x[0])) * (func(x[2]) - func(x[1])));

        System.out.println(nextX + "\n" +
                x[0] + "\n" +
                x[1] + "\n" +
                x[2] + "\n");

        if (Math.abs(func(nextX)) > residual || nextX < -2) {
            x[0] = x[1];
            x[1] = x[2];
            x[2] = nextX < -2 ? -nextX : nextX;
            return findRoots(x, residual);
        } else {
            return nextX;
        }
    }
}
