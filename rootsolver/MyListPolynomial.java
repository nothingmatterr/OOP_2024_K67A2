import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyListPolynomial extends MyAbstractPolynomial {
    private List<Double> coefficients;

    public MyListPolynomial() {
        coefficients = new ArrayList<>();
        /* TODO */
    }

    @Override
    public double coefficientAt(int index) {
        if (index < 0 || index >= coefficients.size()) return 0.0;
        return coefficients.get(index);
        /* TODO */
    }

    @Override
    public double[] coefficients() {
        double[] arr = new double[coefficients.size()];
        for (int i = 0; i < coefficients.size(); i++) {
            arr[i] = coefficients.get(i);
        }
        return arr;
        /* TODO */
    }

    @Override
    public void addAtStart(double coefficient) {
        coefficients.add(0, coefficient);
        /* TODO */
    }

    @Override
    public void addAtEnd(double coefficient) {
        coefficients.add(coefficient);
        /* TODO */
    }

    @Override
    public void addAtPosition(int index, double coefficient) {
        if (index < 0) index = 0;
        if (index > coefficients.size()) index = coefficients.size();
        coefficients.add(index, coefficient);
        /* TODO */
    }

    @Override
    public void set(int index, double coefficient) {
        if (index >= 0 && index < coefficients.size()) {
            coefficients.set(index, coefficient);
        }
        /* TODO */
    }

    @Override
    public int degree() {
        int deg = coefficients.size() - 1;
        while (deg >= 0 && Math.abs(coefficients.get(deg)) < 1e-9) deg--;
        return deg;
        /* TODO */
    }

    @Override
    public double evaluate(double x) {
        double result = 0.0;
        for (int i = 0; i < coefficients.size(); i++) {
            result += coefficients.get(i) * Math.pow(x, i);
        }
        return result;
        /* TODO */
    }

    @Override
    public MyListPolynomial derivative() {
        MyListPolynomial der = new MyListPolynomial();
        for (int i = 1; i < coefficients.size(); i++) {
            der.addAtEnd(coefficients.get(i) * i);
        }
        return der;
        /* TODO */
    }

    @Override
    public MyListPolynomial plus(MyPolynomial another) {
        int maxDeg = Math.max(this.degree(), another.degree());
        MyListPolynomial result = new MyListPolynomial();
        for (int i = 0; i <= maxDeg; i++) {
            double sum = this.coefficientAt(i) + another.coefficientAt(i);
            result.addAtEnd(sum);
        }
        return result;
        /* TODO */
    }

    @Override
    public MyListPolynomial minus(MyPolynomial another) {
        int maxDeg = Math.max(this.degree(), another.degree());
        MyListPolynomial result = new MyListPolynomial();
        for (int i = 0; i <= maxDeg; i++) {
            double diff = this.coefficientAt(i) - another.coefficientAt(i);
            result.addAtEnd(diff);
        }
        return result;
        /* TODO */
    }

    @Override
    public MyListPolynomial multiply(MyPolynomial another) {
        int degA = this.degree();
        int degB = another.degree();
        MyListPolynomial result = new MyListPolynomial();
        for (int i = 0; i <= degA + degB; i++) {
            result.addAtEnd(0.0);
        }
        for (int i = 0; i <= degA; i++) {
            for (int j = 0; j <= degB; j++) {
                double val = result.coefficientAt(i + j) + this.coefficientAt(i) * another.coefficientAt(j);
                result.set(i + j, val);
            }
        }
        return result;
        /* TODO */
    }
}