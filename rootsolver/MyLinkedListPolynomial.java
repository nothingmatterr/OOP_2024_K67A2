public class MyLinkedListPolynomial extends MyAbstractPolynomial {
    private MyLinkedList coefficients;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyLinkedListPolynomial() {
        // Khởi tạo danh sách liên kết rỗng để lưu hệ số
        this.coefficients = new MyLinkedList();
    }

    @Override
    public double coefficientAt(int index) {
        // Trả về hệ số tại vị trí index
        return coefficients.get(index);
    }

    @Override
    public double[] coefficients() {
        // Trả về mảng hệ số hiện tại
        int n = coefficients.size();
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = coefficients.get(i);
        }
        return arr;
    }

    @Override
    public void addAtStart(double coefficient) {
        // Thêm hệ số vào đầu danh sách
        coefficients.insert(coefficient, 0);
    }

    @Override
    public void addAtEnd(double coefficient) {
        // Thêm hệ số vào cuối danh sách
        coefficients.add(coefficient);
    }

    @Override
    public void addAtPosition(int index, double coefficient) {
        // Thêm hệ số vào vị trí index
        coefficients.insert(coefficient, index);
    }

    @Override
    public void set(int index, double coefficient) {
        // Gán giá trị hệ số tại vị trí index
        coefficients.set(coefficient, index);
    }

    @Override
    public int degree() {
        // Bậc của đa thức là số phần tử - 1
        return coefficients.size() - 1;
    }

    @Override
    public double evaluate(double x) {
        // Tính giá trị đa thức tại x
        double result = 0;
        for (int i = 0; i < coefficients.size(); i++) {
            result += coefficients.get(i) * Math.pow(x, i);
        }
        return result;
    }

    @Override
    public MyLinkedListPolynomial derivative() {
        // Tính đạo hàm đa thức
        MyLinkedListPolynomial result = new MyLinkedListPolynomial();
        for (int i = 1; i < coefficients.size(); i++) {
            result.addAtEnd(coefficients.get(i) * i);
        }
        return result;
    }

    @Override
    public MyLinkedListPolynomial plus(MyPolynomial another) {
        // Cộng hai đa thức
        int maxDegree = Math.max(this.degree(), another.degree());
        MyLinkedListPolynomial result = new MyLinkedListPolynomial();
        for (int i = 0; i <= maxDegree; i++) {
            double a = (i <= this.degree()) ? this.coefficientAt(i) : 0;
            double b = (i <= another.degree()) ? another.coefficientAt(i) : 0;
            result.addAtEnd(a + b);
        }
        return result;
    }

    @Override
    public MyLinkedListPolynomial minus(MyPolynomial another) {
        // Trừ hai đa thức
        int maxDegree = Math.max(this.degree(), another.degree());
        MyLinkedListPolynomial result = new MyLinkedListPolynomial();
        for (int i = 0; i <= maxDegree; i++) {
            double a = (i <= this.degree()) ? this.coefficientAt(i) : 0;
            double b = (i <= another.degree()) ? another.coefficientAt(i) : 0;
            result.addAtEnd(a - b);
        }
        return result;
    }

    @Override
    public MyLinkedListPolynomial multiply(MyPolynomial another) {
        // Nhân hai đa thức
        int newDegree = this.degree() + another.degree();
        MyLinkedListPolynomial result = new MyLinkedListPolynomial();
        for (int i = 0; i <= newDegree; i++) {
            result.addAtEnd(0);
        }
        for (int i = 0; i <= this.degree(); i++) {
            for (int j = 0; j <= another.degree(); j++) {
                double value = result.coefficientAt(i + j) + this.coefficientAt(i) * another.coefficientAt(j);
                result.set(i + j, value);
            }
        }
        return result;
    }
}