public class TestRootSolver {
    private PolynomialRootFinder rootFinder;

    public TestRootSolver(PolynomialRootFinder rootFinder) {
        /* TODO */
        this.rootFinder = rootFinder;
    }

    private static double nextDouble(double min, double max) {
        return min + (max - min) * Math.random();
    }

    private static int nextInt(int min, int max) {
        return min + (int)(Math.random() * (max - min));
    }

    public static void main(String[] args) {
        /* TODO
         - Chạy demo các hàm test.
         - Lưu kết quả chạy chương trình vào file text có tên <Ten_MaSinhVien_RootSolver>.txt
           (ví dụ, NguyenVanA_123456_RootSolver.txt)
         - Nộp kết quả chạy chương trình (file text trên) cùng với các file source code.
         */
        TestRootSolver tester = new TestRootSolver(null);
        tester.testMyArrayPolynomial();
        tester.testMyListPolynomial();
        tester.testMyLinkedListPolynomial();
    }

    public void testMyArrayPolynomial() {
        /* TODO
         - Sinh ngẫu nhiên một số nguyên, lưu vào biến size. Sinh ngẫu nhiên size số thực.
           Tạo đa thức kiểu MyArrayPolynomial với các hệ số là các số thực vừa sinh ra.
         - Viết chương trình test các chức năng đa thức (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         - Xác định 2 số a và b sao cho giá trị của đa thức ban đầu tại a nhân với giá trị của đa thức ban đầu tại b nhỏ hơn 0.
               - Tạo các đối tượng RootSolver để tìm nghiệm của đa thức theo 3 phương pháp đã cho.
               - Tạo đối tượng PolynomialRootFinder, sử dụng các đối tượng kiểu RootSolver vừa tạo
                 để tìm nghiệm xấp xỉ của đa thức tạo ra ban đầu trong đoạn [a, b].
         - In ra terminal kết quả test các chức năng đa thức, nghiệm xấp xỉ của đa thức và phương pháp tìm nghiệm sử dụng.
         */
        int size = nextInt(3, 7);
        double[] coeffs = new double[size];
        for (int i = 0; i < size; i++) {
            coeffs[i] = nextDouble(-10, 10);
        }
        MyArrayPolynomial poly = new MyArrayPolynomial();
        for (double c : coeffs) poly.addAtEnd(c);

        System.out.println(poly);
        poly.addAtStart(5.0);
        System.out.println(poly);
        poly.addAtEnd(-3.0);
        System.out.println(poly);
        poly.set(1, 2.5);
        System.out.println(poly);

        MyArrayPolynomial poly2 = new MyArrayPolynomial();
        for (int i = 0; i < size; i++) poly2.addAtEnd(nextDouble(-5, 5));
        System.out.println(poly2);
        System.out.println(poly.plus(poly2));
        System.out.println(poly.minus(poly2));
        System.out.println(poly.multiply(poly2));

        double x = nextDouble(-5, 5);
        System.out.println("poly(" + x + ") = " + poly.evaluate(x));

        double a = -10, b = 10;
        int tries = 0;
        while (poly.evaluate(a) * poly.evaluate(b) > 0 && tries < 100) {
            a = nextDouble(-10, 0);
            b = nextDouble(0, 10);
            tries++;
        }
        System.out.println("Interval for root: [" + a + ", " + b + "]");

        RootSolver[] solvers = {
                new BisectionSolver(1e-6, 100),
                new SecantSolver(1e-6, 100),
                new NewtonRaphsonSolver(1e-6, 100)
        };
        String[] methods = {"Bisection", "Secant", "Newton-Raphson"};
        for (int i = 0; i < solvers.length; i++) {
            double root = solvers[i].solve(poly, a, b);
            System.out.println(methods[i] + " root: " + root);
        }
        System.out.println();
    }

    public void testMyListPolynomial() {
        /* TODO
         - Sinh ngẫu nhiên một số nguyên, lưu vào biến size. Sinh ngẫu nhiên size số thực.
           Tạo đa thức kiểu MyListPolynomial với các hệ số là các số thực vừa sinh ra.
         - Viết chương trình test các chức năng đa thức (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         - Xác định 2 số a và b sao cho giá trị của đa thức ban đầu tại a nhân với giá trị của đa thức đầu tại b nhỏ hơn 0.
               - Tạo các đối tượng RootSolver để tìm nghiệm của đa thức theo 3 phương pháp đã cho.
               - Tạo đối tượng PolynomialRootFinder, sử dụng các đối tượng kiểu RootSolver vừa tạo
                 để tìm nghiệm xấp xỉ của đa thức tạo ra ban đầu trong đoạn [a, b].
         - In ra terminal kết quả test các chức năng đa thức, nghiệm xấp xỉ của đa thức và phương pháp tìm nghiệm sử dụng.
         */
        int size = nextInt(3, 7);
        double[] coeffs = new double[size];
        for (int i = 0; i < size; i++) {
            coeffs[i] = nextDouble(-10, 10);
        }
        MyListPolynomial poly = new MyListPolynomial();
        for (double c : coeffs) poly.addAtEnd(c);

        System.out.println(poly);
        poly.addAtStart(4.0);
        System.out.println(poly);
        poly.addAtEnd(-2.0);
        System.out.println(poly);
        poly.set(2, 1.5);
        System.out.println(poly);

        MyListPolynomial poly2 = new MyListPolynomial();
        for (int i = 0; i < size; i++) poly2.addAtEnd(nextDouble(-5, 5));
        System.out.println(poly2);
        System.out.println(poly.plus(poly2));
        System.out.println(poly.minus(poly2));
        System.out.println(poly.multiply(poly2));

        double x = nextDouble(-5, 5);
        System.out.println("poly(" + x + ") = " + poly.evaluate(x));

        double a = -10, b = 10;
        int tries = 0;
        while (poly.evaluate(a) * poly.evaluate(b) > 0 && tries < 100) {
            a = nextDouble(-10, 0);
            b = nextDouble(0, 10);
            tries++;
        }
        System.out.println("Interval for root: [" + a + ", " + b + "]");

        RootSolver[] solvers = {
                new BisectionSolver(1e-6, 100),
                new SecantSolver(1e-6, 100),
                new NewtonRaphsonSolver(1e-6, 100)
        };
        String[] methods = {"Bisection", "Secant", "Newton-Raphson"};
        for (int i = 0; i < solvers.length; i++) {
            double root = solvers[i].solve(poly, a, b);
            System.out.println(methods[i] + " root: " + root);
        }
        System.out.println();
    }

    public void testMyLinkedListPolynomial() {
        /* TODO
         - Sinh ngẫu nhiên một số nguyên, lưu vào biến size. Sinh ngẫu nhiên size số thực.
           Tạo đa thức kiểu MyLinkedListPolynomial với các hệ số là các số thực vừa sinh ra.
         - Viết chương trình test các chức năng đa thức (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         - Xác định 2 số a và b sao cho giá trị của đa thức ban đầu tại a nhân với giá trị của đa thức ban đầu tại b nhỏ hơn 0.
               - Tạo các đối tượng RootSolver để tìm nghiệm của đa thức theo 3 phương pháp đã cho.
               - Tạo đối tượng PolynomialRootFinder, sử dụng các đối tượng kiểu RootSolver vừa tạo
                 để tìm nghiệm xấp xỉ của đa thức tạo ra ban đầu trong đoạn [a, b].
         - In ra terminal kết quả test các chức năng đa thức, nghiệm xấp xỉ của đa thức và phương pháp tìm nghiệm sử dụng.
         */
        int size = nextInt(3, 7);
        double[] coeffs = new double[size];
        for (int i = 0; i < size; i++) {
            coeffs[i] = nextDouble(-10, 10);
        }
        MyLinkedListPolynomial poly = new MyLinkedListPolynomial();
        for (double c : coeffs) poly.addAtEnd(c);

        System.out.println(poly);
        poly.addAtStart(3.0);
        System.out.println(poly);
        poly.addAtEnd(-1.0);
        System.out.println(poly);
        poly.set(0, 0.5);
        System.out.println(poly);

        MyLinkedListPolynomial poly2 = new MyLinkedListPolynomial();
        for (int i = 0; i < size; i++) poly2.addAtEnd(nextDouble(-5, 5));
        System.out.println(poly2);
        System.out.println(poly.plus(poly2));
        System.out.println(poly.minus(poly2));
        System.out.println(poly.multiply(poly2));

        double x = nextDouble(-5, 5);
        System.out.println("poly(" + x + ") = " + poly.evaluate(x));

        double a = -10, b = 10;
        int tries = 0;
        while (poly.evaluate(a) * poly.evaluate(b) > 0 && tries < 100) {
            a = nextDouble(-10, 0);
            b = nextDouble(0, 10);
            tries++;
        }
        System.out.println("Interval for root: [" + a + ", " + b + "]");

        RootSolver[] solvers = {
                new BisectionSolver(1e-6, 100),
                new SecantSolver(1e-6, 100),
                new NewtonRaphsonSolver(1e-6, 100)
        };
        String[] methods = {"Bisection", "Secant", "Newton-Raphson"};
        for (int i = 0; i < solvers.length; i++) {
            double root = solvers[i].solve(poly, a, b);
            System.out.println(methods[i] + " root: " + root);
        }
        System.out.println();
    }
}