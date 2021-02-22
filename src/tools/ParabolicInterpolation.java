package tools;

public class ParabolicInterpolation extends Function {

    public double findRoots(double[] x, double residual) {
        double tempX = func(x[1]) * func(x[2]) * x[0] / ((func(x[0]) - func(x[1])) * (func(x[0]) - func(x[2]))) +
                func(x[0]) * func(x[2]) * x[1] / ((func(x[1]) - func(x[0])) * (func(x[1]) - func(x[2]))) +
                func(x[0]) * func(x[1]) * x[2] / ((func(x[2]) - func(x[0]) * (func(x[2]) - func(x[1]))));

        if (func(tempX) > residual) {
            x[0] = x[1];
            x[1] = x[2];
            x[2] = tempX;
            return findRoots(x, residual);
        }
        return tempX;
    }
}
