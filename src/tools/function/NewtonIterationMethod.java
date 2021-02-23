package tools.function;

public class NewtonIterationMethod extends Function {

    public double findRoots(double x, double h, double residual) {

        double newX = x - func(x) * h / (func(x + h) - func(x)) ;
        System.out.println(newX);

        if (Math.abs(func(newX)) > residual) {
            return findRoots(newX, h, residual);
        }
        return newX;
    }
}
