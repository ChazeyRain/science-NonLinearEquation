package tools.function;

import tools.types.Complex;

import java.util.Arrays;

//does not work
public class MullerMethod extends Function {

    private double residual = 0.1;

    public double findRoots(double[] x, double residual) {
        Complex x0 = new Complex(x[0], 0);
        Complex x1 = new Complex(x[1], 0);
        Complex x2 = new Complex(x[2], 0);

        this.residual = residual;
        Complex answer = iterate(x0, x1, x2);
        double real = answer.getReal();
        double imaginary = answer.getImaginary();
        return real;
    }

    public Complex iterate(Complex x0, Complex x1, Complex x2) {
        Complex w = Complex.subtract(Complex.sum(divDiff2Func(x2, x1), divDiff2Func(x2, x0)), divDiff2Func(x1, x0));
        Complex temp = divDiff3Func(x2, x1, x0);
        //Complex nextX = Complex.subtract(x2, Complex.divide(Complex.rMultiply(complexFunc(x2), 2), Complex.min(Complex.sum(w, squareRoot(w, temp, x2)), Complex.subtract(w, squareRoot(w, temp, x2)))));
        Complex nextX = Complex.subtract(x2, Complex.divide(Complex.rMultiply(complexFunc(x2), 2), Complex.subtract(w, squareRoot(w, temp, x2))));

        System.out.println("real: " + nextX.getReal());
        System.out.println("im: " + nextX.getImaginary());

        System.out.println("F(X): " + complexFunc(nextX).getReal());

        if (Math.abs(complexFunc(nextX).getReal()) > residual) {
            return iterate(x1, x2, nextX);
        }
        return nextX;
    }

    private Complex divDiff2Func(Complex x0, Complex x1) {
        return Complex.sum(Complex.divide(complexFunc(x1), Complex.subtract(x1, x0)), Complex.divide(complexFunc(x0), Complex.subtract(x0, x1)));
    }

    private Complex divDiff3Func(Complex x0, Complex x1, Complex x2) {
        return Complex.divide(Complex.subtract(divDiff2Func(x1, x2), divDiff2Func(x0, x1)), Complex.subtract(x2, x0));
    }

    private Complex squareRoot(Complex w, Complex temp, Complex x2) {
        return Complex.sqrt(Complex.subtract(Complex.intPow(w, 2), Complex.multiply(Complex.rMultiply(complexFunc(x2), 4), temp)));
    }
}
