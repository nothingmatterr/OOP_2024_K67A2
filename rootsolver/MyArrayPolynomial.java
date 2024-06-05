public class MyArrayPolynomial extends MyAbstractPolynomial {
    private static final int DEFAULT_CAPACITY = 8;
    private double[] coefficents;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyArrayPolynomial() {
        coefficents = new double[DEFAULT_CAPACITY];
        size = 0;
        /* TODO */
    }

    @Override
    public double coefficientAt(int index) {
        if (index < 0 || index >= size) return 0.0;
        return coefficents[index];
        /* TODO */
    }

    @Override
    public double[] coefficients() {
        double[] arr = new double[size];
        System.arraycopy(coefficents, 0, arr, 0, size);
        return arr;
        /* TODO */
    }

    @Override
    public void addAtStart(double coefficient) {
        if (size == coefficents.length) allocateMore();
        System.arraycopy(coefficents, 0, coefficents, 1, size);
        coefficents[0] = coefficient;
        size++;
        /* TODO */
    }

    @Override
    public void addAtEnd(double coefficient) {
        if (size == coefficents.length) allocateMore();
        coefficents[size++] = coefficient;
        /* TODO */
    }

    @Override
    public void addAtPosition(int index, double coefficient) {
        if (index < 0) index = 0;
        if (index > size) index = size;
        if (size == coefficents.length) allocateMore();
        System.arraycopy(coefficents, index, coefficents, index + 1, size - index);
        coefficents[index] = coefficient;
        size++;
        /* TODO */
    }

    @Override
    public void set(int index, double coefficient) {
        if (index >= 0 && index < size) {
            coefficents[index] = coefficient;
        }
        /* TODO */
    }

    @Override
    public int degree() {
        int deg = size - 1;
        while (deg >= 0 && Math.abs(coefficents[deg]) < 1e-9) deg--;
        return deg;
        /* TODO */
    }

    @Override
    public double evaluate(double x) {
        double result = 0.0;
        for (int i = 0; i < size; i++) {
            result += coefficents[i] * Math.pow(x, i);
        }
        return result;
        /* TODO */
    }

    @Override
    public MyArrayPolynomial derivative() {
        MyArrayPolynomial der = new MyArrayPolynomial();
        for (int i = 1; i < size; i++) {
            der.addAtEnd(coefficents[i] * i);
        }
        return der;
        /* TODO */
    }

    @Override
    public MyArrayPolynomial plus(MyPolynomial another) {
        int maxDeg = Math.max(this.degree(), another.degree());
        MyArrayPolynomial result = new MyArrayPolynomial();
        for (int i = 0; i <= maxDeg; i++) {
            double sum = this.coefficientAt(i) + another.coefficientAt(i);
            result.addAtEnd(sum);
        }
        return result;
        /* TODO */
    }

    @Override
    public MyArrayPolynomial minus(MyPolynomial another) {
        int maxDeg = Math.max(this.degree(), another.degree());
        MyArrayPolynomial result = new MyArrayPolynomial();
        for (int i = 0; i <= maxDeg; i++) {
            double diff = this.coefficientAt(i) - another.coefficientAt(i);
            result.addAtEnd(diff);
        }
        return result;
        /* TODO */
    }

    @Override
    public MyArrayPolynomial multiply(MyPolynomial another) {
        int degA = this.degree();
        int degB = another.degree();
        MyArrayPolynomial result = new MyArrayPolynomial();
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

    /**
     * Thêm kích thước mảng gấp đôi để lưu đa thức khi cần thiết.
     */
    private void allocateMore() {
        double[] newArr = new double[coefficents.length * 2];
        System.arraycopy(coefficents, 0, newArr, 0, coefficents.length);
        coefficents = newArr;
        /* TODO */
    }
}