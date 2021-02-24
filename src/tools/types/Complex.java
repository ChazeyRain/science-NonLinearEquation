package tools.types;

public class Complex {
    private double real;
    private double imaginary;


    public double getReal() {
        return this.real;
    }

    public double getImaginary() {
        return this.imaginary;
    }

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    //sum
    public static Complex sum(Complex x1, Complex x2) {
        return new Complex(x1.getReal() + x2.getReal(), x1.getImaginary() + x2.getImaginary());
    }
    //realSum
    public static Complex rSum(Complex x1, double x2) {
        return new Complex(x1.getReal() + x2, x1.getImaginary());
    }

    //subtract
    public static Complex subtract(Complex x1, Complex x2) {
        return new Complex(x1.getReal() - x2.getReal(), x1.getImaginary() - x2.getImaginary());
    }
    //reverse
    public static Complex negate(Complex x1) {
        return new Complex(-x1.getReal(), -x1.getImaginary());
    }

    //multiply
    public static Complex multiply(Complex x1, Complex x2) {
        double real = x1.getReal() * x2.getReal() - x1.getImaginary() * x2.getImaginary();
        double imaginary = x1.getReal() * x2.getImaginary() + x2.getReal() * x1.getImaginary();

        return new Complex(real, imaginary);
    }
    //real multiply
    public static Complex rMultiply(Complex x1, double x2) {
        return new Complex(x1.getReal() * x2, x1.getImaginary() * x2);
    }

    //divide
    public static Complex divide(Complex x1, Complex x2) {
        double denominator = x2.getReal() * x2.getReal() + x2.getImaginary() * x2.getImaginary();
        double real = (x1.getReal() * x2.getReal() + x1.getImaginary() * x2.getImaginary()) / denominator;
        double imaginary = (-x1.getReal() * x2.getImaginary() + x2.getReal() * x1.getImaginary()) / denominator;

        return new Complex(real, imaginary);
    }

    //intPow
    public static Complex intPow(Complex x1, int pow) {
        Complex result = x1;
        for (int i = 1; i < pow; i++){
            result = Complex.multiply(result, x1);
        }
        return result;
    }

    //sqrt
    public static Complex sqrt(Complex x1) {
        double real = x1.getReal();
        double imaginary = x1.getImaginary();
        double angle;
        if (real == 0) {
            angle = Math.PI / 2;
        } else {
            angle = Math.atan(imaginary / real);
        }
        double abs = abs(x1);
        return new Complex(Math.sqrt(abs) * Math.cos(angle / 2), Math.sqrt(abs) * Math.sin(angle / 2));
    }

    //abs
    public static double abs(Complex x1) {
        return Math.sqrt(x1.getReal() * x1.getReal() + x1.getImaginary() * x1.getImaginary());
    }

    //max
    public static Complex max(Complex x1, Complex x2) {
        if (x1.getReal() > x2.getReal() || (x1.getReal() == x2.getReal() && x1.getImaginary() > x2.getImaginary())) {
            return x1;
        } else {
            return x2;
        }
    }

    //min
    public static Complex min(Complex x1, Complex x2) {
        if (x1.getReal() > x2.getReal() || (x1.getReal() == x2.getReal() && x1.getImaginary() > x2.getImaginary())) {
            return x2;
        } else {
            return x1;
        }
    }
}
