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

    public Complex sum(Complex num) {
        double real = this.real;
        double imaginary = this.imaginary;

        real += num.real;
        imaginary += num.imaginary;

        return new Complex(real, imaginary);
    }

    public Complex rSum(double num) {
        double real = this.real;
        double imaginary = this.imaginary;

        real += num;

        return new Complex(real, imaginary);
    }

    public Complex sub(Complex num) {
        double real = this.real;
        double imaginary = this.imaginary;

        real -= num.real;
        imaginary -= num.imaginary;

        return new Complex(real, imaginary);
    }

    public Complex rSub(double num) {
        double real = this.real;
        double imaginary = this.imaginary;

        real -= num;

        return new Complex(real, imaginary);
    }

    public Complex multiply(Complex num) {
        double real;
        double imaginary;

        real = this.real * num.real - this.imaginary * num.imaginary;
        imaginary = this.real * num.imaginary + num.real * this.imaginary;

        return new Complex(real, imaginary);
    }

    public Complex rMultiply(double num) {
        double real = this.real;
        double imaginary = this.imaginary;

        real *= num;
        imaginary *= num;

        return new Complex(real, imaginary);
    }

    public Complex divide(Complex num) {
        double real;
        double imaginary;

        double denominator = num.real * num.real + num.imaginary * num.imaginary;
        real = (this.real * num.real - this.imaginary * num.imaginary) / denominator;
        imaginary = (this.real * num.imaginary + num.real * this.imaginary) / denominator;

        return new Complex(real, imaginary);
    }

    public Complex rDivide(double num) {
        double real = this.real;
        double imaginary = this.imaginary;

        real /= num;
        imaginary /= num;

        return new Complex(real, imaginary);
    }

    public Complex intPow(int pow) {
        Complex num = this;

        double real = this.real;
        double imaginary = this.imaginary;

        for (int i = 0; i < pow; i++) {
            real = real * num.real - imaginary * num.imaginary;
            imaginary = real * num.imaginary + num.real * imaginary;
        }
        return (new Complex(real, imaginary));
    }

    public Complex sqrt(){
        double real;
        double imaginary;
        real = Math.sqrt((Math.sqrt(this.real * this.real + this.imaginary * this.imaginary) + this.real) / 2);
        imaginary = Math.sqrt((Math.sqrt(this.real * this.real + this.imaginary * this.imaginary) - this.real) / 2);
        return new Complex(real, imaginary);
    }
}
