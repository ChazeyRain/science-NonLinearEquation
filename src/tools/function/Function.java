package tools.function;

import tools.types.Complex;

public class Function {
    public double func(double x) {
        try {
            //return x*x;
            return Math.sqrt(2 + x) + Math.sqrt(3 + x) - 5 * Math.pow(x * x - 2, 3);
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    public double[][] getFunctionValues(double startValue, double endValue, int dotQuantity) {
        double weight = (endValue - startValue) / dotQuantity;
        double[][] dots = new double[2][dotQuantity];

        for (int i = 0; i < dotQuantity; i++) {
            dots[0][i] = startValue + weight * i;
            dots[1][i] = func(dots[0][i]);
        }
        return dots;
    }

    public Complex complexFunc(Complex x) {
        return x.rSum(2).sqrt().sum(x.rSum(3).sqrt()).sub(x.intPow(2).rSub(2).intPow(3));
    }
}
