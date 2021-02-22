package tools;

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
}
